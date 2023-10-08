package net.pandarix.verdantvibes;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.render.RenderLayer;
import net.pandarix.verdantvibes.init.BlockInit;

@Environment(EnvType.CLIENT)
public class VerdantVibesClient implements ClientModInitializer {
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.TALL_DRAGON_TREE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.DRAGON_TREE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.POTTED_DRAGON_TREE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.MONEY_TREE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.POTTED_MONEY_TREE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.MONSTERA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.POTTED_MONSTERA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.IVY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.POTTED_IVY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.LOBELIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.POTTED_LOBELIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.PARLOUR_PALM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.POTTED_PARLOUR_PALM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.PERIWINKLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.CANDY_TUFT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.SNAKE_PLANT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.POTTED_SNAKE_PLANT, RenderLayer.getCutout());

        ColorProviderRegistry.BLOCK.register(
                (BlockColorProvider) (state, world, pos, tintIndex) -> {
                    return world == null || pos == null ? FoliageColors.getDefaultColor() : BiomeColors.getFoliageColor(world, pos);
                },
                BlockInit.PARLOUR_PALM, BlockInit.DRAGON_TREE, BlockInit.MONSTERA, BlockInit.CANDY_TUFT, BlockInit.PERIWINKLE, BlockInit.LOBELIA, BlockInit.IVY, BlockInit.MONEY_TREE, BlockInit.TALL_DRAGON_TREE
        );
    }
}