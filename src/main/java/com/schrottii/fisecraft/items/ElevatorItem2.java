package com.schrottii.fisecraft.items;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ElevatorItem2 extends Item {
    public ElevatorItem2(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
            player.setPos(player.getX(), -54, player.getZ());

            player.fallDistance = 0F;
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 9));
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 9));
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 40, 0));
            player.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);

            ItemStack stack = player.getItemInHand(hand);
            stack.setCount(0);

            return super.use(world, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(new TextComponent("Want to get deep? Use at your own risk!"));

        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}