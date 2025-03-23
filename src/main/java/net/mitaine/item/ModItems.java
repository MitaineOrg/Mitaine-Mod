package net.mitaine.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mitaine.Mitaine;

public class ModItems {
    public static final Item TEST = registerItem("test", new Item(new FabricItemSettings()));

    private static void addItemToIngredientTab(FabricItemGroupEntries entries) {
        entries.add(TEST);
    }

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Mitaine.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Mitaine.LOGGER.info("Registering Mod Items : " + Mitaine.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIngredientTab);
    }
}
