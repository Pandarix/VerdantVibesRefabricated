package net.pandarix.verdantvibes.worldgen.tree;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.pandarix.verdantvibes.worldgen.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class OakIvyGrower extends SaplingGenerator {
    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(net.minecraft.util.math.random.Random random, boolean bees) {
        return ModConfiguredFeatures.OAK_IVY_KEY;
    }
}
