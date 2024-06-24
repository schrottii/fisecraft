package com.schrottii.fisecraft.enchants;

import com.schrottii.fisecraft.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class ElmendingEnchantment extends Enchantment {
    public ElmendingEnchantment() {
        super(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    public void doPostAttack(LivingEntity attacker, Entity target, int level) {
            if (Math.random() * 10 < level && !attacker.level.isClientSide) {
                ItemStack itemStack = new ItemStack(ModItems.ROOT.get()); // Change this to the item you want to spawn
                BlockPos playerPos = attacker.blockPosition();
                ItemEntity itemEntity = new ItemEntity(attacker.level, playerPos.getX(), playerPos.getY() + 5, playerPos.getZ(), itemStack);
                attacker.level.addFreshEntity(itemEntity);
            }
    }
}