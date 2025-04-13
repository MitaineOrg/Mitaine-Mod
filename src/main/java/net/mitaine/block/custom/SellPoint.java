package net.mitaine.block.custom;

import dev.ithundxr.createnumismatics.content.backend.Coin;
import dev.ithundxr.createnumismatics.registry.NumismaticsItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SellPoint extends Block {

    public SellPoint(Settings settings) {
        super(settings);
    }

    private void GiveMoneyToPlayer(PlayerEntity player, Integer count) {
        player.giveItemStack(new ItemStack(NumismaticsItems.COINS.get(Coin.SPUR), count));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        switch(this.getTranslationKey().substring(this.getTranslationKey().lastIndexOf('.') + 1)) {
            case "woodsman_sell_point": // Wood
                GiveMoneyToPlayer(player, 10);
                break;
            case "forge_sell_point": // Ores
                GiveMoneyToPlayer(player, 16);
                break;
            case "engineer_sell_point": // Create items
                GiveMoneyToPlayer(player, 70);
                break;
            case "chef_sell_point": // Foods
                GiveMoneyToPlayer(player, 32);
                break;
        }
        return ActionResult.SUCCESS;
    }
}
