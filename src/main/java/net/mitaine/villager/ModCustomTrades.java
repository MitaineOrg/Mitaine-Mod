package net.mitaine.villager;

import dev.ithundxr.createnumismatics.content.backend.Coin;
import dev.ithundxr.createnumismatics.registry.NumismaticsItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.mitaine.item.ModItems;

public class ModCustomTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(ModVillagers.TEST_VENDOR, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(NumismaticsItems.COINS.get(Coin.COG), 3),
                            new ItemStack(ModItems.TEST, 12),
                            10, 5, 0.05f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.TEST_VENDOR, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(NumismaticsItems.COINS.get(Coin.SPUR), 5),
                            new ItemStack(ModItems.TEST, 24),
                            10, 5, 0.05f));
                });
    }
}
