package net.pandarix.verdantvibes.worldgen;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.pandarix.verdantvibes.VerdantVibes;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> BIRCH_IVY_PLACED_KEY = registerKey("birch_ivy_placed");
    public static final RegistryKey<PlacedFeature> OAK_IVY_PLACED_KEY = registerKey("oak_ivy_placed");
    public static final RegistryKey<PlacedFeature> CANDY_TUFT_PLACED_KEY = registerKey("candy_tuft_placed");
    public static final RegistryKey<PlacedFeature> CANDY_TUFT_HIGH_PLACED_KEY = registerKey("candy_tuft_high_placed");
    public static final RegistryKey<PlacedFeature> PERIWINKLE_PLACED_KEY = registerKey("periwinkle_placed");
    public static final RegistryKey<PlacedFeature> DRAGON_TREE_PLACED_KEY = registerKey("dragon_tree_placed");
    public static final RegistryKey<PlacedFeature> LOBELIA_PLACED_KEY = registerKey("lobelia_placed");
    public static final RegistryKey<PlacedFeature> MONEY_TREE_KEY = registerKey("money_tree_placed");
    public static final RegistryKey<PlacedFeature> MONSTERA_KEY = registerKey("monstera_placed");
    public static final RegistryKey<PlacedFeature> PARLOUR_PALM_KEY = registerKey("parlour_palm_placed");
    public static final RegistryKey<PlacedFeature> SNAKE_PLANT_KEY = registerKey("snake_plant_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, BIRCH_IVY_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BIRCH_IVY_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(2), Blocks.BIRCH_SAPLING));

        register(context, OAK_IVY_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.OAK_IVY_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(2), Blocks.OAK_SAPLING));

        register(context, CANDY_TUFT_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CANDY_TUFT_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, CANDY_TUFT_HIGH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CANDY_TUFT_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of(),
                HeightRangePlacementModifier.uniform(YOffset.fixed(125), YOffset.TOP));

        register(context, PERIWINKLE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PERIWINKLE_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, DRAGON_TREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DRAGON_TREE_KEY), RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, LOBELIA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LOBELIA_KEY), RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, MONEY_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MONEY_TREE_KEY), RarityFilterPlacementModifier.of(8), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, MONSTERA_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MONSTERA_KEY), RarityFilterPlacementModifier.of(6), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, PARLOUR_PALM_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PARLOUR_PALM_KEY), RarityFilterPlacementModifier.of(6), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, SNAKE_PLANT_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SNAKE_PLANT_KEY), RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
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
