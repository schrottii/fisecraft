package com.schrottii.fisecraft.items;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ElevatorItem extends Item {
    public ElevatorItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
            player.setPos(player.getX(), 200, player.getZ());

            player.fallDistance = 0F;
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 9));
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 40, 9));
            player.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);

            ItemStack stack = player.getItemInHand(hand);
            stack.setCount(0);

            return super.use(world, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(new TextComponent("Stuck in a cave? This jetpack gets you out of there!"));

        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}