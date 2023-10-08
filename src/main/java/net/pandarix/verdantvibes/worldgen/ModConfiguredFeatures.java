package net.pandarix.verdantvibes.worldgen;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerbedBlock;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.NoiseThresholdBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.pandarix.verdantvibes.VerdantVibes;
import net.pandarix.verdantvibes.init.BlockInit;
import net.pandarix.verdantvibes.worldgen.tree.decorator.TrunkIvyDecorator;

import java.util.List;

import static net.minecraft.world.gen.feature.TreeConfiguredFeatures.birch;
import static net.minecraft.world.gen.feature.TreeConfiguredFeatures.oak;

public class ModConfiguredFeatures {
    //TREES
    public static final RegistryKey<ConfiguredFeature<?, ?>> BIRCH_IVY_KEY = registerKey("birch_ivy");
    public static final RegistryKey<ConfiguredFeature<?, ?>> OAK_IVY_KEY = registerKey("oak_ivy");

    //PLANTS
    public static final RegistryKey<ConfiguredFeature<?, ?>> CANDY_TUFT_KEY = registerKey("candy_tuft");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PERIWINKLE_KEY = registerKey("periwinkle");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, BIRCH_IVY_KEY, Feature.TREE, birch().decorators(ImmutableList.of(TrunkIvyDecorator.INSTANCE)).build());

        register(context, OAK_IVY_KEY, Feature.TREE, oak().decorators(ImmutableList.of(TrunkIvyDecorator.INSTANCE)).build());

        register(context, CANDY_TUFT_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(80, 6, 5, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                                .add(BlockInit.CANDY_TUFT.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.NORTH).with(FlowerbedBlock.FLOWER_AMOUNT, 1), 1)
                                .add(BlockInit.CANDY_TUFT.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.SOUTH).with(FlowerbedBlock.FLOWER_AMOUNT, 1), 1)
                                .add(BlockInit.CANDY_TUFT.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.EAST).with(FlowerbedBlock.FLOWER_AMOUNT, 1), 1)
                                .add(BlockInit.CANDY_TUFT.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.WEST).with(FlowerbedBlock.FLOWER_AMOUNT, 1), 1)
                                .add(BlockInit.CANDY_TUFT.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.NORTH).with(FlowerbedBlock.FLOWER_AMOUNT, 2), 1)
                                .add(BlockInit.CANDY_TUFT.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.SOUTH).with(FlowerbedBlock.FLOWER_AMOUNT, 2), 1)
                                .add(BlockInit.CANDY_TUFT.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.EAST).with(FlowerbedBlock.FLOWER_AMOUNT, 2), 1)
                                .add(BlockInit.CANDY_TUFT.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.WEST).with(FlowerbedBlock.FLOWER_AMOUNT, 2), 1)
                                .add(BlockInit.CANDY_TUFT.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.NORTH).with(FlowerbedBlock.FLOWER_AMOUNT, 3), 1)
                                .add(BlockInit.CANDY_TUFT.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.SOUTH).with(FlowerbedBlock.FLOWER_AMOUNT, 3), 1)
                                .add(BlockInit.CANDY_TUFT.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.EAST).with(FlowerbedBlock.FLOWER_AMOUNT, 3), 1)
                                .add(BlockInit.CANDY_TUFT.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.WEST).with(FlowerbedBlock.FLOWER_AMOUNT, 3), 1)
                                .add(BlockInit.CANDY_TUFT.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.NORTH).with(FlowerbedBlock.FLOWER_AMOUNT, 4), 1)
                                .add(BlockInit.CANDY_TUFT.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.SOUTH).with(FlowerbedBlock.FLOWER_AMOUNT, 4), 1)
                                .add(BlockInit.CANDY_TUFT.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.EAST).with(FlowerbedBlock.FLOWER_AMOUNT, 4), 1)
                                .add(BlockInit.CANDY_TUFT.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.WEST).with(FlowerbedBlock.FLOWER_AMOUNT, 4), 1)
                                .build())), BlockPredicate.IS_AIR))
        );

        register(context, PERIWINKLE_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(80, 6, 5, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                                .add(BlockInit.PERIWINKLE.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.NORTH).with(FlowerbedBlock.FLOWER_AMOUNT, 1), 1)
                                .add(BlockInit.PERIWINKLE.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.SOUTH).with(FlowerbedBlock.FLOWER_AMOUNT, 1), 1)
                                .add(BlockInit.PERIWINKLE.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.EAST).with(FlowerbedBlock.FLOWER_AMOUNT, 1), 1)
                                .add(BlockInit.PERIWINKLE.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.WEST).with(FlowerbedBlock.FLOWER_AMOUNT, 1), 1)
                                .add(BlockInit.PERIWINKLE.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.NORTH).with(FlowerbedBlock.FLOWER_AMOUNT, 2), 1)
                                .add(BlockInit.PERIWINKLE.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.SOUTH).with(FlowerbedBlock.FLOWER_AMOUNT, 2), 1)
                                .add(BlockInit.PERIWINKLE.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.EAST).with(FlowerbedBlock.FLOWER_AMOUNT, 2), 1)
                                .add(BlockInit.PERIWINKLE.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.WEST).with(FlowerbedBlock.FLOWER_AMOUNT, 2), 1)
                                .add(BlockInit.PERIWINKLE.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.NORTH).with(FlowerbedBlock.FLOWER_AMOUNT, 3), 1)
                                .add(BlockInit.PERIWINKLE.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.SOUTH).with(FlowerbedBlock.FLOWER_AMOUNT, 3), 1)
                                .add(BlockInit.PERIWINKLE.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.EAST).with(FlowerbedBlock.FLOWER_AMOUNT, 3), 1)
                                .add(BlockInit.PERIWINKLE.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.WEST).with(FlowerbedBlock.FLOWER_AMOUNT, 3), 1)
                                .add(BlockInit.PERIWINKLE.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.NORTH).with(FlowerbedBlock.FLOWER_AMOUNT, 4), 1)
                                .add(BlockInit.PERIWINKLE.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.SOUTH).with(FlowerbedBlock.FLOWER_AMOUNT, 4), 1)
                                .add(BlockInit.PERIWINKLE.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.EAST).with(FlowerbedBlock.FLOWER_AMOUNT, 4), 1)
                                .add(BlockInit.PERIWINKLE.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.WEST).with(FlowerbedBlock.FLOWER_AMOUNT, 4), 1)
                                .build())), BlockPredicate.IS_AIR))
        );
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(VerdantVibes.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
