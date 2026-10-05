package com.deepocean.registry;

import com.deepocean.DeepOceanMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DeepOceanMod.MOD_ID);

    public static final RegistryObject<Item> GIANT_SQUID_SPAWN_EGG = ITEMS.register("giant_squid_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.GIANT_SQUID, 0x0b1d3a, 0x44f2d8, new Item.Properties()));
}
