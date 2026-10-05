package com.deepocean;

import com.deepocean.entity.GiantDeepSquid;
import com.deepocean.registry.ModEntities;
import com.deepocean.registry.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(DeepOceanMod.MOD_ID)
public class DeepOceanMod {
    public static final String MOD_ID = "deepocean";
    public static final Logger LOGGER = LogUtils.getLogger();

    public DeepOceanMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModEntities.ENTITIES.register(bus);
        ModItems.ITEMS.register(bus);
        bus.addListener(this::onAttributes);
        bus.addListener(this::onSpawnPlacements);
        bus.addListener(this::onCreativeTab);
        LOGGER.info("Deep Ocean mod loaded");
    }

    private void onAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GIANT_SQUID.get(), GiantDeepSquid.createGiantAttributes().build());
    }

    private void onSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(
                ModEntities.GIANT_SQUID.get(),
                SpawnPlacements.Type.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                GiantDeepSquid::checkDeepSpawnRules,
                SpawnPlacementRegisterEvent.Operation.OR);
    }

    private void onCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.GIANT_SQUID_SPAWN_EGG);
        }
    }
}
