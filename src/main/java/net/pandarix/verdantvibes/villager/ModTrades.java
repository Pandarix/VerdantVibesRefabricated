package net.pandarix.verdantvibes.villager;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.pandarix.verdantvibes.init.BlockInit;

public class ModTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerInit.GARDENER, 1,
                factories -> {
                    factories.add((pTrader, pRandom) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 4),
                            new ItemStack(BlockInit.MONSTERA, 1),
                            8, 4, 0.02f));

                    factories.add((pTrader, pRandom) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 4),
                            new ItemStack(BlockInit.IVY, 4),
                            16, 4, 0.02f));

                    factories.add((pTrader, pRandom) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 4),
                            new ItemStack(BlockInit.LOBELIA, 1),
                            8, 4, 0.02f));

                    factories.add((pTrader, pRandom) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 4),
                            new ItemStack(BlockInit.SNAKE_PLANT, 1),
                            8, 4, 0.02f));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerInit.GARDENER, 2,
                factories -> {
                    factories.add((pTrader, pRandom) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 4),
                            new ItemStack(BlockInit.DRAGON_TREE, 1),
                            8, 8, 0.02f));

                    factories.add((pTrader, pRandom) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 4),
                            new ItemStack(BlockInit.PARLOUR_PALM, 1),
                            8, 8, 0.02f));

                    factories.add((pTrader, pRandom) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 4),
                            new ItemStack(BlockInit.MONEY_TREE, 1),
                            8, 8, 0.02f));

                    factories.add((pTrader, pRandom) -> new TradeOffer(
                            new ItemStack(Items.BONE, 16),
                            new ItemStack(Items.EMERALD, 1),
                            8, 4, 0.02f));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerInit.GARDENER, 3,
                factories -> {
                    factories.add((pTrader, pRandom) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 4),
                            new ItemStack(Blocks.PODZOL, 2),
                            16, 8, 0.02f));

                    factories.add((pTrader, pRandom) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            new ItemStack(Blocks.LILY_PAD, 4),
                            16, 4, 0.02f));

                    factories.add((pTrader, pRandom) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            new ItemStack(Blocks.VINE, 4),
                            16, 4, 0.02f));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerInit.GARDENER, 4,
                factories -> {
                    factories.add((pTrader, pRandom) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            new ItemStack(Blocks.FLOWER_POT, 2),
                            8, 8, 0.02f));

                    factories.add((pTrader, pRandom) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 4),
                            new ItemStack(Blocks.MOSS_BLOCK, 1),
                            16, 4, 0.02f));

                    factories.add((pTrader, pRandom) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 4),
                            new ItemStack(Blocks.SMALL_DRIPLEAF, 2),
                            8, 4, 0.02f));
                });
    }
}
