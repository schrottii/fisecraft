package com.schrottii.fisecraft.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class FisecraftCommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> RECIPE_ENCHANTED_GOLDEN_APPLE;

    static {
        BUILDER.push("Configs for Fisecraft:");

        RECIPE_ENCHANTED_GOLDEN_APPLE = BUILDER.comment("Toggle Enchanted Golden Apple recipe, if enabled it can be crafted with one apple and eight gold blocks (false ~ true)")
                .define("Toggle Recipe", true);
        //CITRINE_ORE_VEIN_SIZE = BUILDER.comment("How many Citrine Ore Blocks spawn in one Vein!")
        //        .defineInRange("Vein Size", 9, 4, 20);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}