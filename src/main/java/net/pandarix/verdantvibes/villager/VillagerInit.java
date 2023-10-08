package net.pandarix.verdantvibes.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import net.pandarix.verdantvibes.VerdantVibes;
import net.pandarix.verdantvibes.init.BlockInit;

public class VillagerInit {
    public static final RegistryKey<PointOfInterestType> GARDENING_POI_KEY = poiKey("gardening_poi");
    public static final PointOfInterestType SOUND_POI = registerPoi("gardening_poi", BlockInit.GARDENING_TABLE);

    public static final VillagerProfession GARDENER = registerProfession("gardener", GARDENING_POI_KEY);


    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(VerdantVibes.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.BLOCK_FLOWERING_AZALEA_HIT));
    }

    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(VerdantVibes.MOD_ID, name), 1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(VerdantVibes.MOD_ID, name));
    }

    public static void registerVillagers() {
        VerdantVibes.LOGGER.info("Registering Villagers " + VerdantVibes.MOD_ID);
    }
}
