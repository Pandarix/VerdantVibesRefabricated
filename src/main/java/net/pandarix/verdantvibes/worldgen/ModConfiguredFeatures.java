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

import java.util.Iterator;
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
    public static final RegistryKey<ConfiguredFeature<?, ?>> DRAGON_TREE_KEY = registerKey("dragon_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LOBELIA_KEY = registerKey("lobelia");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MONEY_TREE_KEY = registerKey("money_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MONSTERA_KEY = registerKey("monstera");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PARLOUR_PALM_KEY = registerKey("parlour_palm");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SNAKE_PLANT_KEY = registerKey("snake_plant");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, BIRCH_IVY_KEY, Feature.TREE, birch().decorators(ImmutableList.of(TrunkIvyDecorator.INSTANCE)).build());

        register(context, OAK_IVY_KEY, Feature.TREE, oak().decorators(ImmutableList.of(TrunkIvyDecorator.INSTANCE)).build());

        //Candy Tuft--------------
        DataPool.Builder<BlockState> candytuftBuilder = DataPool.builder();
        for(int i = 1; i <= 4; ++i) {
            Iterator dir = Direction.Type.HORIZONTAL.iterator();

            while(dir.hasNext()) {
                Direction direction = (Direction)dir.next();
                candytuftBuilder.add((BlockState)((BlockState)BlockInit.CANDY_TUFT.getDefaultState().with(FlowerbedBlock.FLOWER_AMOUNT, i)).with(FlowerbedBlock.FACING, direction), 1);
            }
        }
        register(context, CANDY_TUFT_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(80, 6, 5, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(candytuftBuilder)), BlockPredicate.IS_AIR))
        );

        //Periwinkle--------------
        DataPool.Builder<BlockState> periwinkleBuilder = DataPool.builder();
        for(int i = 1; i <= 4; ++i) {
            Iterator dir = Direction.Type.HORIZONTAL.iterator();

            while(dir.hasNext()) {
                Direction direction = (Direction)dir.next();
                periwinkleBuilder.add((BlockState)((BlockState)BlockInit.PERIWINKLE.getDefaultState().with(FlowerbedBlock.FLOWER_AMOUNT, i)).with(FlowerbedBlock.FACING, direction), 1);
            }
        }
        register(context, PERIWINKLE_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(80, 6, 5, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(periwinkleBuilder)), BlockPredicate.IS_AIR))
        );

        //DragonTree--------------
        DataPool.Builder<BlockState> dragonTreeBuilder = DataPool.builder();
        for(int i = 1; i <= 4; ++i) {
            Iterator dir = Direction.Type.HORIZONTAL.iterator();

            while(dir.hasNext()) {
                Direction direction = (Direction)dir.next();
                dragonTreeBuilder.add((BlockState)((BlockState)BlockInit.DRAGON_TREE.getDefaultState()).with(HorizontalFacingBlock.FACING, direction), 1);
            }
        }
        register(context, DRAGON_TREE_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(32, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(dragonTreeBuilder)), BlockPredicate.IS_AIR))
        );

        //LOBELIA--------------
        DataPool.Builder<BlockState> lobeliaBuilder = DataPool.builder();
        for(int i = 1; i <= 4; ++i) {
            Iterator dir = Direction.Type.HORIZONTAL.iterator();

            while(dir.hasNext()) {
                Direction direction = (Direction)dir.next();
                lobeliaBuilder.add((BlockState)((BlockState)BlockInit.LOBELIA.getDefaultState()).with(HorizontalFacingBlock.FACING, direction), 1);
            }
        }
        register(context, LOBELIA_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(32, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(lobeliaBuilder)), BlockPredicate.IS_AIR))
        );

        //MONEY_TREE------------
        DataPool.Builder<BlockState> moneyTreeBuilder = DataPool.builder();
        for(int i = 1; i <= 4; ++i) {
            Iterator dir = Direction.Type.HORIZONTAL.iterator();

            while(dir.hasNext()) {
                Direction direction = (Direction)dir.next();
                moneyTreeBuilder.add((BlockState)((BlockState)BlockInit.MONEY_TREE.getDefaultState()).with(HorizontalFacingBlock.FACING, direction), 1);
            }
        }
        register(context, MONEY_TREE_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(16, 5, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(moneyTreeBuilder)), BlockPredicate.IS_AIR))
        );

        //MONSTERA------------
        DataPool.Builder<BlockState> monsteraBuilder = DataPool.builder();
        for(int i = 1; i <= 4; ++i) {
            Iterator dir = Direction.Type.HORIZONTAL.iterator();

            while(dir.hasNext()) {
                Direction direction = (Direction)dir.next();
                monsteraBuilder.add((BlockState)((BlockState)BlockInit.MONSTERA.getDefaultState()).with(HorizontalFacingBlock.FACING, direction), 1);
            }
        }
        register(context, MONSTERA_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(32, 5, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(monsteraBuilder)), BlockPredicate.matchingBlocks(Blocks.GRASS, Blocks.FERN, Blocks.AIR, Blocks.VINE)))
        );

        //ParlourPalm------------
        DataPool.Builder<BlockState> parlourPalmBuilder = DataPool.builder();
        for(int i = 1; i <= 4; ++i) {
            Iterator dir = Direction.Type.HORIZONTAL.iterator();

            while(dir.hasNext()) {
                Direction direction = (Direction)dir.next();
                parlourPalmBuilder.add((BlockState)((BlockState)BlockInit.PARLOUR_PALM.getDefaultState()).with(HorizontalFacingBlock.FACING, direction), 1);
            }
        }
        register(context, PARLOUR_PALM_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(32, 5, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(parlourPalmBuilder)), BlockPredicate.matchingBlocks(Blocks.GRASS, Blocks.FERN, Blocks.AIR, Blocks.VINE)))
        );

        //SnakePlant------------
        DataPool.Builder<BlockState> snakePlantBuilder = DataPool.builder();
        for(int i = 1; i <= 4; ++i) {
            Iterator dir = Direction.Type.HORIZONTAL.iterator();

            while(dir.hasNext()) {
                Direction direction = (Direction)dir.next();
                snakePlantBuilder.add((BlockState)((BlockState)BlockInit.SNAKE_PLANT.getDefaultState()).with(HorizontalFacingBlock.FACING, direction), 1);
            }
        }
        register(context, SNAKE_PLANT_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(32, 5, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(snakePlantBuilder)), BlockPredicate.IS_AIR))
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
