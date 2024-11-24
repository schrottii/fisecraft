package com.schrottii.fisecraft.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class PainBlock extends Block {
    public PainBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level world, BlockPos pos, BlockState state, Entity entity) {
        // Check if the entity is alive and not in creative mode
        if (entity instanceof LivingEntity && !entity.isInvulnerableTo(DamageSource.WITHER)) {
            entity.hurt(DamageSource.WITHER, 2.0F);
        }
        super.stepOn(world, pos, state, entity);
    }
}