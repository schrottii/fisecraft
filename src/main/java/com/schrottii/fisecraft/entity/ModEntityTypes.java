package com.schrottii.fisecraft.entity;

import com.schrottii.fisecraft.Fisecraft;
import com.schrottii.fisecraft.entity.custom.RootglassEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, Fisecraft.MODID);

    public static final RegistryObject<EntityType<RootglassEntity>> ROOTGLASS =
            ENTITY_TYPES.register("rootglass",
                    () -> EntityType.Builder.of(RootglassEntity::new, MobCategory.CREATURE)
                            .sized(0.8f, 0.6f)
                            .build(new ResourceLocation(Fisecraft.MODID, "rootglass").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}