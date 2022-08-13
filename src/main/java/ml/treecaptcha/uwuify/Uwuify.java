package ml.treecaptcha.uwuify;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

import io.github.ran.uwu.client.Uwuifier;
public final class Uwuify extends JavaPlugin {
    public static Uwuify uwu;
    public static boolean USE_PREVIEW;
    public static boolean SIGNS_UWUIFY;
    public static boolean BOOKS_UWUIFY;
    @Override
    public void onEnable() {
        uwu = this;
        getLogger().log(Level.INFO, Uwuifier.uwuify("give uwu sound effects cause idk where to get them"));
        new uwuHandler(this);
        saveDefaultConfig();
        initializeVariables();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private static void initializeVariables() {
        Uwuify.USE_PREVIEW = uwu.getConfig().getBoolean("use-chat-preview");
        Uwuify.SIGNS_UWUIFY = uwu.getConfig().getBoolean("signs-uwuify");
        Uwuify.BOOKS_UWUIFY = uwu.getConfig().getBoolean("books-uwuify");
    }
}
