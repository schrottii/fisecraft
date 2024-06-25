package com.schrottii.fisecraft.items.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public class TeleportStaff extends Item {
    public TeleportStaff(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        ItemStack itemstack = super.finishUsingItem(stack, world, entity);

        // Check if the entity is a player
        if (entity instanceof Player) {
            Player player = (Player) entity;

            BlockHitResult ray = getPlayerPOVHitResult(world, player, ClipContext.Fluid.ANY);
            BlockPos lookPos = ray.getBlockPos().relative(ray.getDirection());
            player.setPos((lookPos.getX() - player.getX()) * 10 + player.getX(), player.getY() + 4, (lookPos.getZ() - player.getZ()) * 10 + player.getZ());

            player.fallDistance = 0F;
            player.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
        }

        return itemstack;
    }
}