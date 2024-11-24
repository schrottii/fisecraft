package com.schrottii.fisecraft.items.custom;

import com.google.common.collect.Sets;
import com.schrottii.fisecraft.util.ModTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraftforge.common.ToolAction;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirererItem extends DiggerItem {
    public static final ToolAction DIRERER_DIG = ToolAction.get("direrer_dig");
    public static final Set<ToolAction> DEFAULT_DIRERER_ACTIONS = of(DIRERER_DIG);

    public DirererItem(Tier p_42961_, int p_42962_, float p_42963_, Item.Properties p_42964_) {
        super((float)p_42962_, p_42963_, p_42961_, ModTags.Blocks.MINEABLE_WITH_DIRERER, p_42964_);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
        return DEFAULT_DIRERER_ACTIONS.contains(toolAction);
    }

    private static Set<ToolAction> of(ToolAction... actions) {
        return Stream.of(actions).collect(Collectors.toCollection(Sets::newIdentityHashSet));
    }
}
