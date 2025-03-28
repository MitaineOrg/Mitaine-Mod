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
                                String msg = "§6[§2Mitaine§6] §r" + StringArgumentType.getString(context, "message");
                                msg = msg.replace("/##", "§r");
                                msg = msg.replace("##", "§l§3");
                                if (Objects.equals(msg, "§6[§2Mitaine] §r")) {
                                    context.getSource().sendMessage(Text.literal("§c using : /broadcast <message>"));
                                } else {
                                    for (PlayerEntity player : context.getSource().getServer().getPlayerManager().getPlayerList()) {
                                        player.sendMessage(Text.literal(msg));
                                    }
                                }
                                return 1;
                            })));
        });
    }
}
