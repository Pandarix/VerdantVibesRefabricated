package net.pandarix.verdantvibes;

import net.fabricmc.api.ModInitializer;

import net.pandarix.verdantvibes.init.BlockInit;
import net.pandarix.verdantvibes.init.ItemGroupInit;
import net.pandarix.verdantvibes.init.TreeDecoratorInit;
import net.pandarix.verdantvibes.villager.ModTrades;
import net.pandarix.verdantvibes.villager.VillagerInit;
import net.pandarix.verdantvibes.worldgen.ModWorldGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerdantVibes implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("verdantvibes");
	// Define mod id in a common place for everything to reference
	public static final String MOD_ID = "verdantvibes";

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ItemGroupInit.registerTab();
		BlockInit.registerModBlocks();

		VillagerInit.registerVillagers();
		ModTrades.registerCustomTrades();

		TreeDecoratorInit.registerModDecorators();
		ModWorldGenerator.generateModWorldGen();

		LOGGER.info("Hello Fabric world!");
	}
}