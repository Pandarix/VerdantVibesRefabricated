package net.pandarix.verdantvibes.worldgen;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.pandarix.verdantvibes.VerdantVibes;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> BIRCH_IVY_PLACED_KEY = registerKey("birch_ivy_placed");
    public static final RegistryKey<PlacedFeature> OAK_IVY_PLACED_KEY = registerKey("oak_ivy_placed");
    public static final RegistryKey<PlacedFeature> CANDY_TUFT_KEY = registerKey("candy_tuft_placed");
    public static final RegistryKey<PlacedFeature> PERIWINKLE_PLACED_KEY = registerKey("periwinkle_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, BIRCH_IVY_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BIRCH_IVY_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(4), Blocks.BIRCH_SAPLING));

        register(context, OAK_IVY_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.OAK_IVY_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(4), Blocks.OAK_SAPLING));

        register(context, CANDY_TUFT_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CANDY_TUFT_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, PERIWINKLE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PERIWINKLE_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(VerdantVibes.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
