package net.mitaine.command;

public class ModCommands {

    public ModCommands() { throw new AssertionError(); }

    public static void registerCommands() {
        BraodcastCommand.register();
        PlayerNameCommand.register();
    }
}
