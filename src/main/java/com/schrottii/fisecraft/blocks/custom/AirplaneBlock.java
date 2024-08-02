package com.schrottii.fisecraft.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;

import static java.lang.Thread.sleep;

public class AirplaneBlock extends Block {
    public AirplaneBlock(Block.Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack held = player.getItemInHand(hand);

        if (!world.isClientSide() && held.getItem() == Items.PAPER) {
            Direction facing = state.getValue(FACING);
            double x = player.getX();
            double z = player.getZ();
            String actualDirection = "";

            switch (facing) {
                case NORTH:
                    z += 10000;
                    actualDirection = "SOUTH";
                    break;
                case SOUTH:
                    z -= 10000;
                    actualDirection = "NORTH";
                    break;
                case WEST:
                    x += 10000;
                    actualDirection = "EAST";
                    break;
                case EAST:
                    x -= 10000;
                    actualDirection = "WEST";
                    break;
                default:
                    break;
            }

            try {
                player.setPos(x, player.getY(), z);
                Thread.sleep(1000);  // 1 second delay
            }
            catch (InterruptedException interruptedException) {

            }

            if (player.getX() == x && player.getZ() == z) {
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 9));
                player.sendMessage(new TextComponent("Taking off! Direction: " + actualDirection), player.getUUID());

                player.setPos(x, player.getY(), z);
                held.shrink(1);
            }
            else {
                player.sendMessage(new TextComponent("Teleportation failed. Please try again."), player.getUUID());
            }

            return InteractionResult.CONSUME;
        }
        else if (!world.isClientSide()) {
            player.sendMessage(new TextComponent("Papers please!"), player.getUUID());
        }

        return super.use(state, world, pos, player, hand, hit);
    }

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
}
