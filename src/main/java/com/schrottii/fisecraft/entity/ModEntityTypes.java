package com.schrottii.fisecraft.entity;

import com.schrottii.fisecraft.Fisecraft;
import com.schrottii.fisecraft.entity.custom.DireKnightEntity;
import com.schrottii.fisecraft.entity.custom.EndeyeEntity;
import com.schrottii.fisecraft.entity.custom.RootglassEntity;
import com.schrottii.fisecraft.entity.custom.RootguardianEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, Fisecraft.MODID);

    // updateWhenNewEntity
    public static final RegistryObject<EntityType<RootglassEntity>> ROOTGLASS =
            ENTITY_TYPES.register("rootglass",
                    () -> EntityType.Builder.of(RootglassEntity::new, MobCategory.CREATURE)
                            .sized(1.0f, 1.0f)
                            .build(new ResourceLocation(Fisecraft.MODID, "rootglass").toString()));

    public static final RegistryObject<EntityType<DireKnightEntity>> DIREKNIGHT =
            ENTITY_TYPES.register("direknight",
                    () -> EntityType.Builder.of(DireKnightEntity::new, MobCategory.MONSTER)
                            .sized(1.5f, 3f)
                            .build(new ResourceLocation(Fisecraft.MODID, "direknight").toString()));

    public static final RegistryObject<EntityType<EndeyeEntity>> ENDEYE =
            ENTITY_TYPES.register("endeye",
                    () -> EntityType.Builder.of(EndeyeEntity::new, MobCategory.MONSTER)
                            .sized(2.0f, 2.0f)
                            .build(new ResourceLocation(Fisecraft.MODID, "endeye").toString()));

    public static final RegistryObject<EntityType<RootguardianEntity>> ROOTGUARDIAN =
            ENTITY_TYPES.register("rootguardian",
                    () -> EntityType.Builder.of(RootguardianEntity::new, MobCategory.MONSTER)
                            .sized(2.4f, 4f)
                            .build(new ResourceLocation(Fisecraft.MODID, "rootguardian").toString()));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

    public static void placeSpawns(){
    }
}