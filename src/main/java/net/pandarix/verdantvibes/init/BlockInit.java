package net.pandarix.verdantvibes.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PlaceableOnWaterItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.pandarix.verdantvibes.VerdantVibes;
import net.pandarix.verdantvibes.block.custom.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlockInit {
    // -----------BLOCKS--------------------------------------------------------------------------//
    // -----------Gardening Table
    public static final Block GARDENING_TABLE = registerBlock("gardening_table", new Block(FabricBlockSettings.copy(Blocks.CRAFTING_TABLE)), ItemGroupInit.VERDANTVIBES_ITEMGROUP);

    // -----------Plants
    public static final Block MONSTERA = registerBlock("monstera",
            new VerdantPlantBlock(FabricBlockSettings.create().mapColor(MapColor.GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.CHERRY_SAPLING).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY), List.of(), Block.createCuboidShape(3, 0, 3, 13, 15, 13)), ItemGroupInit.VERDANTVIBES_ITEMGROUP);

    public static final Block SNAKE_PLANT = registerBlock("snake_plant",
            new VerdantPlantBlock(FabricBlockSettings.copy(MONSTERA), List.of(Blocks.SAND, Blocks.RED_SAND), Block.createCuboidShape(2, 0, 2, 14, 16, 14)), ItemGroupInit.VERDANTVIBES_ITEMGROUP);

    public static final Block PARLOUR_PALM = registerBlock("parlour_palm",
            new VerdantPlantBlock(FabricBlockSettings.copy(MONSTERA), List.of(Blocks.SAND), Block.createCuboidShape(2, 0, 2, 14, 22, 14)), ItemGroupInit.VERDANTVIBES_ITEMGROUP);

    public static final Block MONEY_TREE = registerBlock("money_tree",
            new VerdantPlantBlock(FabricBlockSettings.copy(MONSTERA), List.of(Blocks.MUD), Block.createCuboidShape(3, 0, 3, 13, 10, 13)), ItemGroupInit.VERDANTVIBES_ITEMGROUP);

    public static final Block LOBELIA = registerBlock("lobelia",
            new VerdantPlantBlock(FabricBlockSettings.copy(MONSTERA), List.of(), Block.createCuboidShape(3, 0, 3, 13, 14, 13)), ItemGroupInit.VERDANTVIBES_ITEMGROUP);

    public static final Block TALL_DRAGON_TREE = registerBlockWithoutItem("tall_dragon_tree",
            new VerdantTallPlantBlock(FabricBlockSettings.copy(MONSTERA).sounds(BlockSoundGroup.GRASS).strength(0.2f), List.of(Blocks.SAND), Block.createCuboidShape(2, 0, 3, 13, 16, 13)));

    public static final Block DRAGON_TREE = registerBlock("dragon_tree",
            new VerdantGrowablePlantBlock(FabricBlockSettings.copy(TALL_DRAGON_TREE), List.of(Blocks.SAND), Block.createCuboidShape(2, 0, 3, 13, 23, 13), (VerdantTallPlantBlock) TALL_DRAGON_TREE), ItemGroupInit.VERDANTVIBES_ITEMGROUP);

    public static final Block CANDY_TUFT = registerBlock("candy_tuft",
            new VerdantPetalPlantBlock(FabricBlockSettings.copy(Blocks.PINK_PETALS), List.of(Blocks.GRAVEL, Blocks.COARSE_DIRT), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D)), ItemGroupInit.VERDANTVIBES_ITEMGROUP);

    public static final Block PERIWINKLE = registerBlock("periwinkle",
            new VerdantPetalPlantBlock(FabricBlockSettings.copy(Blocks.PINK_PETALS), List.of(), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D)), ItemGroupInit.VERDANTVIBES_ITEMGROUP);

    public static final Block IVY = registerBlock("ivy",
            new VerdantVineBlock(FabricBlockSettings.copy(Blocks.VINE)), ItemGroupInit.VERDANTVIBES_ITEMGROUP);

    // -----------Potted
    public static final Block POTTED_MONSTERA = registerBlock("potted_monstera", new TurnableFlowerPotBlock(MONSTERA, FabricBlockSettings.copy(Blocks.POTTED_CORNFLOWER)), null);

    public static final Block POTTED_SNAKE_PLANT = registerBlock("potted_snake_plant", new TurnableFlowerPotBlock(SNAKE_PLANT, FabricBlockSettings.copy(Blocks.POTTED_CORNFLOWER)), null);

    public static final Block POTTED_PARLOUR_PALM = registerBlock("potted_parlour_palm", new TurnableFlowerPotBlock(PARLOUR_PALM, FabricBlockSettings.copy(Blocks.POTTED_CORNFLOWER)), null);

    public static final Block POTTED_MONEY_TREE = registerBlock("potted_money_tree", new TurnableFlowerPotBlock(MONEY_TREE, FabricBlockSettings.copy(Blocks.POTTED_CORNFLOWER)), null);

    public static final Block POTTED_DRAGON_TREE = registerBlock("potted_dragon_tree", new TurnableFlowerPotBlock(DRAGON_TREE, FabricBlockSettings.copy(Blocks.POTTED_CORNFLOWER)), null);

    public static final Block POTTED_LOBELIA = registerBlock("potted_lobelia", new TurnableFlowerPotBlock(LOBELIA, FabricBlockSettings.copy(Blocks.POTTED_CORNFLOWER)), null);

    public static final Block POTTED_IVY = registerBlock("potted_ivy", new TurnableFlowerPotBlock(IVY, FabricBlockSettings.copy(Blocks.POTTED_CORNFLOWER)), null);

    // -----------REGISTRATION--------------------------------------------------------------------------//
    //Registers Block and calls registerBlockItem to add it as an Item as well
    private static Block registerBlock(String name, Block block, @Nullable RegistryKey<ItemGroup> group) {
        if(group == null){
            registerBlockItem(name, block);
        } else {
            registerBlockItemToGroup(name, block, group);
        }
        return Registry.register(Registries.BLOCK, new Identifier(VerdantVibes.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(VerdantVibes.MOD_ID, name), block);
    }

    //Registers given Block as an BlockItem and adds it to an ItemGroup
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(VerdantVibes.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    //Registers given Block as an BlockItem and adds it to an ItemGroup
    private static Item registerBlockItemToGroup(String name, Block block, RegistryKey<ItemGroup> group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(VerdantVibes.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));

        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks() {
        VerdantVibes.LOGGER.info("Registering Blocks from " + VerdantVibes.MOD_ID);
    }
}
