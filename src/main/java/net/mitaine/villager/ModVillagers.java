package net.mitaine.villager;

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
import net.mitaine.Mitaine;
import net.mitaine.block.ModBlocks;

public class ModVillagers {
    public static final RegistryKey<PointOfInterestType> TEST_POI_KEY = poiKey("testpoi");
    public static final PointOfInterestType TEST_POI = registerPoi("testpoi", ModBlocks.TEST_BLOCK);

    public static final VillagerProfession TEST_VENDOR = registerProfession("testvendor", TEST_POI_KEY);


    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(Mitaine.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_SHEPHERD));
    }

    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(Mitaine.MOD_ID, name), 1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(Mitaine.MOD_ID, name));
    }

    public static void registerVillagers() {
        Mitaine.LOGGER.info("Registering Villagers " + Mitaine.MOD_ID);
    }
}
