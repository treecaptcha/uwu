package ml.treecaptcha.uwuify.spigot;

import io.github.ran.uwu.client.Uwuifier;
import ml.treecaptcha.uwuify.core.Configuration;
import ml.treecaptcha.uwuify.paper.PaperChatHandler;
import ml.treecaptcha.uwuify.paper.PaperUwuHandler;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.logging.Level;

public final class Uwuify extends JavaPlugin {
    public static Uwuify uwu;
    /**
     * Should signs be uwuified?
     */
    public static boolean SIGNS_UWUIFY;
    public static boolean BOOKS_UWUIFY;

    public static String CHAT_HANDLER;

    public static String PLATFORM;

    private List<Listener> listeners;

    private static void initializeVariables() {
        if (uwu.getConfig().getBoolean("use-chat-preview")) {
            if (uwu.getServer().shouldSendChatPreviews()) {
                Configuration.USE_PREVIEW = true;
            } else {
                uwu.getLogger().log(Level.WARNING, Uwuifier.uwuify("use-chat-preview is set to true, but previews-chat is not enabled in server.properties!"));
                uwu.getLogger().log(Level.WARNING, Uwuifier.uwuify("To stop this warn please either set use-chat-preview to false or set previews-chat to true."));
                uwu.getLogger().log(Level.WARNING, Uwuifier.uwuify("Not enabling chat preview!"));
            }
        }
        SIGNS_UWUIFY = uwu.getConfig().getBoolean("signs-uwuify");
        BOOKS_UWUIFY = uwu.getConfig().getBoolean("books-uwuify");
        CHAT_HANDLER = uwu.getConfig().getString("chat-handler");
        PLATFORM = getPlatform();
        String rec = getDiscordSRVRecommendation();
        if (CHAT_HANDLER.equals("auto")) {
            CHAT_HANDLER = rec;
        }
    }

    public static String getPlatform() {
        try {
            Class.forName("io.papermc.paper.event.entity.WardenAngerChangeEvent");
            return "paper";
        } catch (ClassNotFoundException e) {
            uwu.getLogger().log(Level.INFO, Uwuifier.uwuify("You are not using Paper! We highly recommend you do so!"));
            return "spigot";
        }
    }

    private static void registerListeners(JavaPlugin plugin, List<Listener> listenerList) {
        for (Listener l : listenerList) {
            plugin.getServer().getPluginManager().registerEvents(l, plugin);
        }
    }

    private static Listener getUwuHandler() {
        if (PLATFORM.equals("paper")) {
            return new PaperUwuHandler();
        }
        if (PLATFORM.equals("spigot")) {
            return new SpigotUwuHandler();
        }
        throw new InputMismatchException("THE PLATFORM WAS UNKNOWN!" +
                "\nPLATFORM: " + PLATFORM);
    }

    private static Listener getChatHandler() {
        if (CHAT_HANDLER.equals("paper") && PLATFORM.equals("paper")) {
            return new PaperChatHandler();
        } else if (CHAT_HANDLER.equals("spigot")) {
            return new SpigotChatHandler();
        } else if (CHAT_HANDLER.equals("paper") && PLATFORM.equals("spigot")) {
            uwu.getLogger().log(Level.SEVERE, "THE PLATFORM DOES NOT APPEAR TO BE PAPER YET \"paper\" WAS CHOSEN AS THE CHAT HANDLER!");
            return new PaperChatHandler();
        } else {
            throw new InputMismatchException("THE CHAT HANDLER WAS UNKNOWN NOT ENABLING THE CHAT HANDLER!" +
                    "\nHANDLER: " + CHAT_HANDLER + " SERVER: " + PLATFORM);
        }
    }

    private static String getDiscordSRVRecommendation() {
        if (uwu.getServer().getPluginManager().isPluginEnabled("DiscordSRV")) {
            //get DiscordSRV's Config
            Plugin discordSRV = uwu.getServer().getPluginManager().getPlugin("DiscordSRV");
            //get the config file the annoying way.
            YamlConfiguration discordSRVConfig = YamlConfiguration.loadConfiguration(new File(discordSRV.getDataFolder(), "config.yml"));
            if (!discordSRVConfig.getBoolean("UseModernPaperChatEvent")) {
                uwu.getLogger().log(Level.WARNING, Uwuifier.uwuify("UseModernPaperChatEvent is not set to true in DiscordSRV config!"));
                uwu.getLogger().log(Level.WARNING, Uwuifier.uwuify("Will initialise chat handler as a spigot server!"));
                return "spigot";
            }
        }
        if (PLATFORM.equals("paper")) {
            return "paper";
        }
        return "spigot";
    }

    @Override
    public void onEnable() {
        uwu = this;
        getLogger().log(Level.INFO, Uwuifier.uwuify("give uwu sound effects cause idk where to get them"));
        saveDefaultConfig();
        initializeVariables();
        listeners = new ArrayList<>();
        listeners.add(getChatHandler());
        listeners.add(getUwuHandler());
        registerListeners(this, listeners);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
