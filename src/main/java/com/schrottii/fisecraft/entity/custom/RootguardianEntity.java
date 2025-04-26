package com.schrottii.fisecraft.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.Random;

public class RootguardianEntity extends Monster implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    private final ServerBossEvent bossEvent;

    private int specialCooldown = 0;
    private final Random random = new Random();

    public RootguardianEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.bossEvent = new ServerBossEvent(
                new TextComponent("Rootguardian"),
                BossEvent.BossBarColor.GREEN,
                BossEvent.BossBarOverlay.PROGRESS
        );
        this.bossEvent.setVisible(true);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 226D)
                .add(Attributes.ATTACK_DAMAGE, 9.0f)
                .add(Attributes.ATTACK_SPEED, 0.45f)
                .add(Attributes.MOVEMENT_SPEED, 0.3f).build();
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1D, true));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 20.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static boolean checkRootguardianSpawnRules(EntityType<? extends Animal> p_27578_, LevelAccessor p_27579_, MobSpawnType p_27580_, BlockPos p_27581_, Random p_27582_) {
        return !p_27579_.getBlockState(p_27581_.below()).is(Blocks.AIR);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.rootguardian.walking", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.rootguardian.idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());

        if (!this.level.isClientSide && specialCooldown-- <= 0) {
            specialCooldown = 20; // roughly 1 second delay

            float randy = random.nextFloat();
            Player target = this.level.getNearestPlayer(this, 16);

            if (randy < 0.10f) { // 10% chance
                // Falling Sand Attack
                if (target != null && target.isAlive()) {
                    target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15, 5));

                    BlockPos above = target.blockPosition().above(3);
                    FallingBlockEntity sand = FallingBlockEntity.fall(
                            this.level, above, Blocks.SAND.defaultBlockState()
                    );
                    sand.setHurtsEntities(5, 20);
                    sand.time = 1;
                    this.level.addFreshEntity(sand);
                }
            }
            else if (randy < 0.20f) { // 10% chance
                // Lightning Attack
                if (target != null) {
                    target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 2));

                    BlockPos playerPosition = target.blockPosition();
                    LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(level);
                    if (lightning != null) {
                        lightning.moveTo(Vec3.atCenterOf(playerPosition));

                        lightning.setVisualOnly(false);
                        lightning.setDamage(5.0f);
                        lightning.setSecondsOnFire(0);

                        level.addFreshEntity(lightning);
                    }
                }
            }
        }
    }

    @Override
    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossEvent.addPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossEvent.removePlayer(player);
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
        this.playSound(SoundEvents.GLASS_BREAK, 0.15F, 1.0F);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENDERMAN_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.GHAST_SCREAM;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENDERMAN_SCREAM;
    }

    protected float getSoundVolume() {
        return 0.4F;
    }

}