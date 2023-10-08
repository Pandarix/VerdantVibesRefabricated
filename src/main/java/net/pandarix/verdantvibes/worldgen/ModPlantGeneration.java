package net.pandarix.verdantvibes.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModPlantGeneration {
    public static void generatePlants() {
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PERIWINKLE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_MOUNTAIN),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CANDY_TUFT_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.MINESHAFT_HAS_STRUCTURE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CANDY_TUFT_HIGH_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_SAVANNA),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DRAGON_TREE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_SAVANNA),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LOBELIA_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.SWAMP_HUT_HAS_STRUCTURE).and(BiomeSelectors.includeByKey(BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP)),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MONEY_TREE_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_JUNGLE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MONSTERA_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_JUNGLE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PARLOUR_PALM_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE).and(BiomeSelectors.includeByKey(BiomeKeys.DESERT)),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SNAKE_PLANT_KEY);
    }
}
