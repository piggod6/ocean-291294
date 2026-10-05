package com.deepocean.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.GlowSquid;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

/** A huge, glowing squid that only lives in very deep water. */
public class GiantDeepSquid extends GlowSquid {

    public GiantDeepSquid(EntityType<? extends GiantDeepSquid> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createGiantAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 60.0D);
    }

    /** Spawns only in water that is more than 500 blocks below sea level. */
    public static boolean checkDeepSpawnRules(EntityType<GiantDeepSquid> type, ServerLevelAccessor level,
                                              MobSpawnType reason, BlockPos pos, RandomSource random) {
        return pos.getY() < level.getSeaLevel() - 500
                && level.getFluidState(pos).is(FluidTags.WATER)
                && level.getFluidState(pos.above()).is(FluidTags.WATER);
    }
}
