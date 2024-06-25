package com.schrottii.fisecraft;

import com.schrottii.fisecraft.enchants.CurseRootEnchantment;
import com.schrottii.fisecraft.enchants.CurseSpontaneousCombustionEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.schrottii.fisecraft.enchants.ElmendingEnchantment;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Fisecraft.MODID);

    public static final RegistryObject<Enchantment> ELMENDING = ENCHANTMENTS.register("elmending", ElmendingEnchantment::new);
    public static final RegistryObject<Enchantment> CURSEROOT = ENCHANTMENTS.register("curseroot", CurseRootEnchantment::new);
    public static final RegistryObject<Enchantment> CURSESPONTANEOUSCOMBUSTION = ENCHANTMENTS.register("cursespontaneouscombustion", CurseSpontaneousCombustionEnchantment::new);
}