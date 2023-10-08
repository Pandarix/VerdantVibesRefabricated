package net.pandarix.verdantvibes.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.gen.GenerationStep;

public class ModPlantGeneration {
    public static void generatePlants() {
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_MOUNTAIN),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PERIWINKLE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PERIWINKLE_PLACED_KEY);
    }
}
