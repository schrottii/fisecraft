package com.schrottii.fisecraft;

import com.schrottii.fisecraft.items.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab extends CreativeModeTab {
    private ModCreativeTab(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ModItems.TELEPORT_FRUIT.get());
    }

    public static final ModCreativeTab fisecraft = new ModCreativeTab(CreativeModeTab.TABS.length, "fisecraft");
}