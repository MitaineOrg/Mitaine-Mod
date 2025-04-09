package net.mitaine;

import net.fabricmc.api.ModInitializer;
import net.mitaine.block.ModBlocks;
import net.mitaine.command.ModCommands;
import net.mitaine.item.ModItemGroups;
import net.mitaine.item.ModItems;
import net.mitaine.villager.ModCustomTrades;
import net.mitaine.villager.ModVillagers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mitaine implements ModInitializer {
    public static final String MOD_ID = "mitaine";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Test loading");

        ModItemGroups.registerItemGroups();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        ModCustomTrades.registerCustomTrades();
        ModVillagers.registerVillagers();

        ModCommands.registerCommands();
    }
}
