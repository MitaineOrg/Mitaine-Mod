package net.mitaine.command;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;

import java.util.Objects;

public class BraodcastCommand {

    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("broadcast")
                    .requires(serverCommandSource -> serverCommandSource.hasPermissionLevel(2))
                        .then(CommandManager.argument("message", StringArgumentType.greedyString())
                            .executes(context -> {
                                String msg = "------ §6[§2Mitaine§6]§r ------\n" + StringArgumentType.getString(context, "message") + "\n---------------------";
                                msg = msg.replace("£", "§");
                                msg = msg.replace("<br>", "\n");
                                for (PlayerEntity player : context.getSource().getServer().getPlayerManager().getPlayerList()) {
                                    player.sendMessage(Text.literal(msg));
                                }
                                return 1;
                            }))
                    .executes(context -> {
                        context.getSource().sendMessage(Text.literal("§cusing : /broadcast <message> §r(replacing £ to paragraph char and <br> to a new line"));
                        return 1;
                    }));
        });
    }
}
