package com.schrottii.fisecraft.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class FisecraftCommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> ENDEYE_SHOOT;
    public static final ForgeConfigSpec.ConfigValue<Boolean> RANDOM_ROOTGUARDIAN_SPAWN;
    public static final ForgeConfigSpec.ConfigValue<Integer> RANDOM_ROOTGUARDIAN_CHANCE;
    public static final ForgeConfigSpec.ConfigValue<Integer> AIRPLANE_BLOCK_DISTANCE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> AIRPLANE_BLOCK_DESTRUCTION;
    public static final ForgeConfigSpec.ConfigValue<Boolean> PAIN_BLOCK_DAMAGE;

    static {
        BUILDER.push("Configs for Fisecraft:");

        ENDEYE_SHOOT = BUILDER.comment("Toggle Endeye shooting, when turned on they shoot Ghast-like fireballs, when turned off they don't attack at all (default: true)")
                .define("Toggle Shooting", true);
        RANDOM_ROOTGUARDIAN_SPAWN = BUILDER.comment("Toggle Rootguardian spawning when killing a Rootglass with an 1% (default) chance (default: true)")
                .define("Random Rootguardian Spawns", true);
        RANDOM_ROOTGUARDIAN_CHANCE = BUILDER.comment("Chance of a random Rootguardian spawning when killing a Rootglass (default: 1)")
                .defineInRange("Random Rootguardian Chance", 1, 1, 100);
        AIRPLANE_BLOCK_DISTANCE = BUILDER.comment("Distance teleported by using an Airplane Block (default: 10000)")
                .defineInRange("Teleport Distance", 10000, 10, 1000000);
        AIRPLANE_BLOCK_DESTRUCTION = BUILDER.comment("Toggle Airplane Block destroying the blocks where it teleports the player to (default: false)")
                .define("Teleport Destruction", false);
        PAIN_BLOCK_DAMAGE = BUILDER.comment("Toggle Pain Block and Hate Block dealing damage when stepping on them (default: true)")
                .define("Toggle Damage", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}