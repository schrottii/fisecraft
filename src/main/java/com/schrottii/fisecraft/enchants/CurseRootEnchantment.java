package com.schrottii.fisecraft.enchants;

import com.schrottii.fisecraft.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class CurseRootEnchantment extends Enchantment {
    public CurseRootEnchantment() {
        super(Rarity.RARE, EnchantmentCategory.ARMOR, new EquipmentSlot[]{EquipmentSlot.HEAD});
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    @Override
    public void doPostHurt(LivingEntity target, Entity attacker, int level) {
        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1000));

        if (Math.random() * 10 < level && !target.level.isClientSide) {
            target.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2000));

            ItemStack itemStack = new ItemStack(ModItems.ROOT.get()); // Change this to the item you want to spawn
            BlockPos playerPos = target.blockPosition();
            ItemEntity itemEntity = new ItemEntity(target.level, playerPos.getX(), playerPos.getY() + 5, playerPos.getZ(), itemStack);
            target.level.addFreshEntity(itemEntity);
        }
        else {
            target.addEffect(new MobEffectInstance(MobEffects.POISON, 1000));
        }
    }
}