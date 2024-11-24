package com.schrottii.fisecraft.items.custom;

import com.schrottii.fisecraft.entity.ModEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class HourglassIdolItem extends Item {

    public HourglassIdolItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            // Perform a ray trace to find where the player is looking
            HitResult hitResult = player.pick(5.0D, 0.0F, false);
            if (hitResult.getType() == HitResult.Type.BLOCK) {
                BlockHitResult blockHitResult = (BlockHitResult) hitResult;
                BlockPos spawnPos = blockHitResult.getBlockPos().relative(blockHitResult.getDirection());

                ServerLevel serverLevel = (ServerLevel) level;
                ModEntityTypes.ROOTGUARDIAN.get().spawn(serverLevel, itemstack, player, spawnPos, MobSpawnType.TRIGGERED, true, false);

                level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.GHAST_AMBIENT, SoundSource.PLAYERS, 1.0F, 1.0F);

                itemstack.shrink(1);
            }
        }

        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide);
    }
}