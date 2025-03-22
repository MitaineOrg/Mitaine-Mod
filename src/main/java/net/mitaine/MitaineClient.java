package net.mitaine;

import net.fabricmc.api.ClientModInitializer;
import net.mitaine.item.ModItemGroups;
import net.mitaine.item.ModItems;

public class MitaineClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
    }
}
