package net.mitaine.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mitaine.Mitaine;
import net.mitaine.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup MITAINE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Mitaine.MOD_ID, "mitaine"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.mitaine"))
                    .icon(() -> new ItemStack(ModItems.TEST)).entries((displayContext, entries) -> {
                        entries.add(ModItems.TEST);
                        entries.add(ModBlocks.TEST_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        Mitaine.LOGGER.info("Registering Mod Item Groups : " + Mitaine.MOD_ID);
    }
}
