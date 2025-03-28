package net.mitaine;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.mitaine.block.ModBlocks;
import net.mitaine.command.ModCommands;
import net.mitaine.item.ModItemGroups;
import net.mitaine.item.ModItems;

public class MitaineClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        ModCommands.registerCommands();
    }
}
