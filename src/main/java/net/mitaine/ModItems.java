package net.mitaine;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item TEST = register("test", new Item(new FabricItemSettings()));

    private static void addItemToIngredientTab(FabricItemGroupEntries entries) {
        entries.add(TEST);
    }

    public static Item register(String name, Item item) {

        Identifier itemName = new Identifier(mitaine.MOD_ID, name);
        return Registry.register(Registries.ITEM, itemName, item);
    }

    public static void registerModItems() {
        mitaine.LOGGER.info("Registering Mod Items : " + mitaine.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIngredientTab);
    }
}
