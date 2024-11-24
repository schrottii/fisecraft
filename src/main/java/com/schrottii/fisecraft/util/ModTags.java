package com.schrottii.fisecraft.util;

import com.schrottii.fisecraft.Fisecraft;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> ROOTGLASS_SPAWNABLE_ON = tag("rootglass_spawnable_on");
        public static final TagKey<Block> MINEABLE_WITH_DIRERER = tag("mineable/direrer");

        static {
            // Static block to ensure tags are registered
            // This block gets executed when the class is loaded
            ROOTGLASS_SPAWNABLE_ON.getClass();
        }

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Fisecraft.MODID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Fisecraft.MODID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}