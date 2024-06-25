package com.schrottii.fisecraft.items.custom;

import com.schrottii.fisecraft.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class RootSwordItem extends SwordItem {
    public RootSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity target, LivingEntity attacker) {
        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 2), attacker);

        if (Math.random() < 0.25 && !attacker.level.isClientSide) {
            ItemStack itemStack = new ItemStack(ModItems.ROOT.get());
            BlockPos playerPos = attacker.blockPosition();
            ItemEntity itemEntity = new ItemEntity(attacker.level, playerPos.getX(), playerPos.getY() + 5, playerPos.getZ(), itemStack);
            attacker.level.addFreshEntity(itemEntity);
        }

        return super.hurtEnemy(pStack, target, attacker);
    }
}