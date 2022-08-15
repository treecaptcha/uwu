package ml.treecaptcha.uwuify.spigot;

import ml.treecaptcha.uwuify.core.Configuration;
import ml.treecaptcha.uwuify.paper.PaperUwuHandler;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

import io.github.ran.uwu.client.Uwuifier;
public final class Uwuify extends JavaPlugin {
    public static Uwuify uwu;
    /**
     * Should signs be uwuified?
     */
    public static boolean SIGNS_UWUIFY;
    public static boolean BOOKS_UWUIFY;

    @Override
    public void onEnable() {
        uwu = this;
        getLogger().log(Level.INFO, Uwuifier.uwuify("give uwu sound effects cause idk where to get them"));
        saveDefaultConfig();
        initializeVariables();
        new uwuHandler(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private static void initializeVariables() {
        if (uwu.getConfig().getBoolean("use-chat-preview")){
            if (uwu.getServer().shouldSendChatPreviews()){
                Configuration.USE_PREVIEW = true;
            }
            else{
                uwu.getLogger().log(Level.WARNING, Uwuifier.uwuify("use-chat-preview is set to true, but previews-chat is not enabled in server.properties!"));
                uwu.getLogger().log(Level.WARNING, Uwuifier.uwuify("To stop this warn please either set use-chat-preview to false or set previews-chat to true."));
                uwu.getLogger().log(Level.WARNING, Uwuifier.uwuify("Not enabling chat preview!"));
            }
        }
        SIGNS_UWUIFY = uwu.getConfig().getBoolean("signs-uwuify");
        BOOKS_UWUIFY = uwu.getConfig().getBoolean("books-uwuify");
    }

    public static void checkPaper() {
        try {
            Class.forName("io.papermc.paper.event.entity.WardenAngerChangeEvent");
        } catch (ClassNotFoundException e) {
            uwu.getLogger().log(Level.WARNING, Uwuifier.uwuify("You are not using Paper! We highly recommend you do so!"));
            loadSpigot();
            return;
        }
        loadPaper();
    }

    private static void loadSpigot() {
        uwu.getLogger().log(Level.INFO, Uwuifier.uwuify("Loading Spigot version of uwuify!"));
        new uwuHandler(uwu);
    }

    public static void loadPaper() {
        uwu.getLogger().log(Level.INFO, Uwuifier.uwuify("Loading Paper version of uwuify!"));
        new PaperUwuHandler(uwu);
    }
}
