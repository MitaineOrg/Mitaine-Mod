package net.mitaine.command;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.argument.ColorArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.Objects;

public class PlayerNameCommand {

    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("setPlayerRole")
                    .then(CommandManager.argument("role", StringArgumentType.string())
                        .then(CommandManager.argument("color", StringArgumentType.string())
                            .executes(context -> {
                                String role = StringArgumentType.getString(context, "role");
                                String color = StringArgumentType.getString(context, "color");
                                try {
                                    color = Formatting.valueOf(color.toUpperCase()).toString();
                                    Objects.requireNonNull(context.getSource().getPlayer()).setCustomName(Text.literal(color + "[" + role + "] §r" + context.getSource().getPlayer().getName()));
                                    Objects.requireNonNull(context.getSource().getPlayer()).setCustomNameVisible(true);
                                    context.getSource().sendFeedback(() -> Text.literal("Player role set"), false);
                                } catch (IllegalArgumentException e) {
                                    context.getSource().sendMessage(Text.literal("Unknown color"));
                                }
                                return 1;
                            }))));
        });
    }
}
