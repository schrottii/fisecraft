package com.schrottii.fisecraft.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;

import java.util.function.Supplier;

public class CustomFlowerBlock extends FlowerBlock {

    public CustomFlowerBlock(MobEffect effect, int duration, Properties properties) {
        super((Supplier<MobEffect>) null, 0, properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldItem = player.getItemInHand(hand);

        if (heldItem.getItem() == Items.BONE_MEAL) {
            if (!world.isClientSide) {
                // Drop the flower item
                ItemStack dropStack = new ItemStack(this);
                popResource(world, pos, dropStack);
                // Reduce the bone meal stack size by 1
                if (!player.isCreative()) {
                    heldItem.shrink(1);
                }
                // Play the bone meal use sound (optional)
                world.levelEvent(2005, pos, 0);
            }
            return InteractionResult.SUCCESS;
        }
        return super.use(state, world, pos, player, hand, hit);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return super.getStateForPlacement(context);
    }
}