package net.mitaine.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mitaine.Mitaine;
import net.mitaine.block.custom.SellPoint;

public class ModBlocks {

    public static final Block TEST_BLOCK = registerBlock("test_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block WOODSMAN_SELL_POINT = registerBlock("woodsman_sell_point",
            new SellPoint(FabricBlockSettings.copyOf(Blocks.BEDROCK)));
    public static final Block FORGE_SELL_POINT = registerBlock("forge_sell_point",
            new SellPoint(FabricBlockSettings.copyOf(Blocks.BEDROCK)));
    public static final Block ENGINEER_SELL_POINT = registerBlock("engineer_sell_point",
            new SellPoint(FabricBlockSettings.copyOf(Blocks.BEDROCK)));
    public static final Block CHEF_SELL_POINT = registerBlock("chef_sell_point",
            new SellPoint(FabricBlockSettings.copyOf(Blocks.BEDROCK)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Mitaine.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Mitaine.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Mitaine.LOGGER.info("Registering Mod Blocks : " + Mitaine.MOD_ID);
    }
}
