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

public class CurseSpontaneousCombustionEnchantment extends Enchantment {
    public CurseSpontaneousCombustionEnchantment() {
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
        if (Math.random() < 0.1 * level && !target.level.isClientSide) {
            target.setSecondsOnFire((int) Math.ceil(Math.random() * 15 * level));
        }
    }
}