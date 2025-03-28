package net.mitaine.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.argument.ColorArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;

public class PlayerNameCommand {

    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("setPlayerRole")
                    .then(CommandManager.argument("color", ColorArgumentType.color())
                            .executes(context -> {
                                context.getSource().sendMessage(Text.literal("test"));
                                return 1;
                            })));
        });
    }
}
