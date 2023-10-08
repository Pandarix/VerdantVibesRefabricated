package net.pandarix.verdantvibes.worldgen.tree;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.pandarix.verdantvibes.worldgen.ModPlacedFeatures;

public class ModTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_FOREST).and(BiomeSelectors.includeByKey(BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST)),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BIRCH_IVY_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.OAK_IVY_PLACED_KEY);
    }
}
