package net.mitaine;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item register(Item item, String id) {
        // Create the identifier for the item.
        Identifier itemID = new Identifier(main.MOD_ID, id);

        // Register the item.
        Item aledItem = Registry.register(Registries.ITEM, itemID, item);

        // Return the registered item!
        return aledItem;
    }
}
