package net.pandarix.verdantvibes.init;

import com.mojang.serialization.Codec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.pandarix.verdantvibes.VerdantVibes;
import net.pandarix.verdantvibes.worldgen.tree.decorator.TrunkIvyDecorator;

public class TreeDecoratorInit<P extends TreeDecorator> {
    public static final TreeDecoratorType<TrunkIvyDecorator> TRUNK_IVY = register("trunk_ivy", TrunkIvyDecorator.CODEC);

    private static <P extends TreeDecorator> TreeDecoratorType<P> register(String name, Codec<P> pCodec) {
        return Registry.register(Registries.TREE_DECORATOR_TYPE, name, new TreeDecoratorType<>(pCodec));
    }

    private final Codec<P> codec;

    public TreeDecoratorInit(Codec<P> pCodec) {
        this.codec = pCodec;
    }

    public Codec<P> codec() {
        return this.codec;
    }

    public static void registerModDecorators() {
        VerdantVibes.LOGGER.info("Registering TreeDecorators from " + VerdantVibes.MOD_ID);
    }
}
