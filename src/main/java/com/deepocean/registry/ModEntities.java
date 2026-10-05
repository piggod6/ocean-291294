package com.deepocean.registry;

import com.deepocean.DeepOceanMod;
import com.deepocean.entity.GiantDeepSquid;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DeepOceanMod.MOD_ID);

    public static final RegistryObject<EntityType<GiantDeepSquid>> GIANT_SQUID = ENTITIES.register("giant_squid",
            () -> EntityType.Builder.of(GiantDeepSquid::new, MobCategory.WATER_CREATURE)
                    .sized(3.2F, 3.2F)
                    .clientTrackingRange(10)
                    .build(new ResourceLocation(DeepOceanMod.MOD_ID, "giant_squid").toString()));
}
