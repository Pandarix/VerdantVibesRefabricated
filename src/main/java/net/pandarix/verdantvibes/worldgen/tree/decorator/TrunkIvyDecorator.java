package net.pandarix.verdantvibes.worldgen.tree.decorator;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.pandarix.verdantvibes.block.custom.VerdantVineBlock;
import net.pandarix.verdantvibes.init.BlockInit;
import net.pandarix.verdantvibes.init.TreeDecoratorInit;

public class TrunkIvyDecorator extends TreeDecorator {
    public static final TrunkIvyDecorator INSTANCE = new TrunkIvyDecorator();
    public static final Codec<TrunkIvyDecorator> CODEC = Codec.unit(() -> {
        return INSTANCE;
    });

    public TrunkIvyDecorator() {
    }

    protected TreeDecoratorType<?> getType() {
        return TreeDecoratorInit.TRUNK_IVY;
    }

    public void generate(TreeDecorator.Generator generator) {
        Random random = generator.getRandom();
        generator.getLogPositions().forEach((pos) -> {
            BlockPos blockPos;
            if (random.nextInt(3) > 0) {
                blockPos = pos.west();
                if (generator.isAir(blockPos)) {
                    generator.replace(blockPos, BlockInit.IVY.getDefaultState().with(VerdantVineBlock.EAST, Boolean.valueOf(true)));
                }
            }

            if (random.nextInt(3) > 0) {
                blockPos = pos.east();
                if (generator.isAir(blockPos)) {
                    generator.replace(blockPos, BlockInit.IVY.getDefaultState().with(VerdantVineBlock.WEST, Boolean.valueOf(true)));
                }
            }

            if (random.nextInt(3) > 0) {
                blockPos = pos.north();
                if (generator.isAir(blockPos)) {
                    generator.replace(blockPos, BlockInit.IVY.getDefaultState().with(VerdantVineBlock.SOUTH, Boolean.valueOf(true)));
                }
            }

            if (random.nextInt(3) > 0) {
                blockPos = pos.south();
                if (generator.isAir(blockPos)) {
                    generator.replace(blockPos, BlockInit.IVY.getDefaultState().with(VerdantVineBlock.NORTH, Boolean.valueOf(true)));
                }
            }
        });
    }
}
