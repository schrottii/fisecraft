package com.schrottii.fisecraft.items.custom;

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

public class HourglassFunnyItem extends Item {
    public HourglassFunnyItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
            player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 30, 1));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 3));
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 3));

            player.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
            player.getCooldowns().addCooldown(this, 120);

            return super.use(world, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(new TextComponent("Use to manipulate time - not consumed"));

        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}