package com.schrottii.fisecraft.entity.custom;

import com.schrottii.fisecraft.config.FisecraftCommonConfigs;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.EnumSet;
import java.util.Random;

public class EndeyeEntity extends FlyingMob implements IAnimatable {
    private static final EntityDataAccessor<Boolean> DATA_IS_CHARGING = SynchedEntityData.defineId(Ghast.class, EntityDataSerializers.BOOLEAN);
    private AnimationFactory factory = new AnimationFactory(this);

    public EndeyeEntity(EntityType<? extends FlyingMob> entityType, Level level) {
        super(entityType, level);
        this.xpReward = 5;
        this.moveControl = new EndeyeEntity.EndeyeMoveControl(this);
    }

    @Override
    protected boolean shouldDespawnInPeaceful() {
        return true;
    }

    public static AttributeSupplier setAttributes() {
        return FlyingMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.ATTACK_DAMAGE, 4.0f)
                .add(Attributes.ATTACK_SPEED, 0.2f)
                .add(Attributes.MOVEMENT_SPEED, 0.01f).build();
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new EndeyeEntity.RandomFloatAroundGoal(this));
        this.goalSelector.addGoal(2, new EndeyeEntity.EndeyeLookGoal(this));
        this.goalSelector.addGoal(3, new EndeyeEntity.EndeyeShoot(this));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static boolean checkEndeyeSpawnRules(EntityType<? extends FlyingMob> p_27578_, LevelAccessor p_27579_, MobSpawnType p_27580_, BlockPos p_27581_, Random p_27582_) {
        return p_27579_.getDifficulty() != Difficulty.PEACEFUL && !p_27579_.getBlockState(p_27581_.below()).is(Blocks.AIR);
    }


    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.endeye.walking", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.endeye.idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.WITHER_SKELETON_STEP, 0.15F, 1.0F);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ARMOR_EQUIP_CHAIN;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.METAL_BREAK;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.GOAT_SCREAMING_DEATH;
    }

    protected float getSoundVolume() {
        return 0.5F;
    }

    static class EndeyeShoot extends Goal {
        private final EndeyeEntity eye;
        public int chargeTime;

        public EndeyeShoot(EndeyeEntity p_32776_) {
            this.eye = p_32776_;
        }

        public boolean canUse() {
            return this.eye.getTarget() != null && FisecraftCommonConfigs.ENDEYE_SHOOT.get() == true;
        }

        public void start() {
            this.chargeTime = 0;
        }

        public void stop() {

        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity livingentity = this.eye.getTarget();
            if (livingentity != null) {
                double d0 = 64.0D;
                if (livingentity.distanceToSqr(this.eye) < 4096.0D && this.eye.hasLineOfSight(livingentity)) {
                    Level level = this.eye.level;
                    ++this.chargeTime;
                    if (this.chargeTime == 5 && !this.eye.isSilent()) {
                        level.levelEvent((Player) null, 1015, this.eye.blockPosition(), 0);
                    }

                    if (this.chargeTime == 10) {
                        double d1 = 4.0D;
                        Vec3 vec3 = this.eye.getViewVector(1.0F);
                        double d2 = livingentity.getX() - (this.eye.getX() + vec3.x * 4.0D);
                        double d3 = livingentity.getY(0.5D) - (0.5D + this.eye.getY(0.5D));
                        double d4 = livingentity.getZ() - (this.eye.getZ() + vec3.z * 4.0D);

                        LargeFireball largefireball = new LargeFireball(level, this.eye, d2, d3, d4, 0);
                        largefireball.setPos(this.eye.getX() + vec3.x * 4.0D, this.eye.getY(0.5D) + 0.5D, largefireball.getZ() + vec3.z * 4.0D);
                        level.addFreshEntity(largefireball);
                        this.chargeTime = -20;
                    }
                } else if (this.chargeTime > 0) {
                    --this.chargeTime;
                }
            }
        }
    }

    static class EndeyeLookGoal extends Goal {
        private final EndeyeEntity eye;

        public EndeyeLookGoal(EndeyeEntity p_32762_) {
            this.eye = p_32762_;
            this.setFlags(EnumSet.of(Goal.Flag.LOOK));
        }

        public boolean canUse() {
            return true;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            if (this.eye.getTarget() == null) {
                Vec3 vec3 = this.eye.getDeltaMovement();
                this.eye.setYRot(-((float) Mth.atan2(vec3.x, vec3.z)) * (180F / (float)Math.PI));
                this.eye.yBodyRot = this.eye.getYRot();
            } else {
                LivingEntity livingentity = this.eye.getTarget();
                double d0 = 64.0D;
                if (livingentity.distanceToSqr(this.eye) < 4096.0D) {
                    double d1 = livingentity.getX() - this.eye.getX();
                    double d2 = livingentity.getZ() - this.eye.getZ();
                    this.eye.setYRot(-((float)Mth.atan2(d1, d2)) * (180F / (float)Math.PI));
                    this.eye.yBodyRot = this.eye.getYRot();
                }
            }

        }
    }

    static class EndeyeMoveControl extends MoveControl {
        private final EndeyeEntity eye;
        private int floatDuration;

        public EndeyeMoveControl(EndeyeEntity p_32768_) {
            super(p_32768_);
            this.eye = p_32768_;
        }

        public void tick() {
            if (this.operation == MoveControl.Operation.MOVE_TO) {
                if (this.floatDuration-- <= 0) {
                    this.floatDuration += this.eye.getRandom().nextInt(5) + 2;
                    Vec3 vec3 = new Vec3(this.wantedX - this.eye.getX(), this.wantedY - this.eye.getY(), this.wantedZ - this.eye.getZ());
                    double d0 = vec3.length();
                    vec3 = vec3.normalize();
                    if (this.canReach(vec3, Mth.ceil(d0))) {
                        this.eye.setDeltaMovement(this.eye.getDeltaMovement().add(vec3.scale(0.02D)));
                    } else {
                        this.operation = MoveControl.Operation.WAIT;
                    }
                }

            }
        }

        private boolean canReach(Vec3 p_32771_, int p_32772_) {
            AABB aabb = this.eye.getBoundingBox();

            for(int i = 1; i < p_32772_; ++i) {
                aabb = aabb.move(p_32771_);
                if (!this.eye.level.noCollision(this.eye, aabb)) {
                    return false;
                }
            }

            return true;
        }
    }

        static class RandomFloatAroundGoal extends Goal {
            private final EndeyeEntity eye;

            public RandomFloatAroundGoal(EndeyeEntity p_32783_) {
                this.eye = p_32783_;
                this.setFlags(EnumSet.of(Goal.Flag.MOVE));
            }

            public boolean canUse() {
                MoveControl movecontrol = this.eye.getMoveControl();
                if (!movecontrol.hasWanted()) {
                    return true;
                } else {
                    double d0 = movecontrol.getWantedX() - this.eye.getX();
                    double d1 = movecontrol.getWantedY() - this.eye.getY();
                    double d2 = movecontrol.getWantedZ() - this.eye.getZ();
                    double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                    return d3 < 1.0D || d3 > 3600.0D;
                }
            }

            public boolean canContinueToUse() {
                return false;
            }

            public void start() {
                Random random = this.eye.getRandom();
                double d0 = this.eye.getX() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
                double d1 = this.eye.getY() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
                double d2 = this.eye.getZ() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
                this.eye.getMoveControl().setWantedPosition(d0, d1, d2, 0.2D);
            }
        }
}