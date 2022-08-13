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
        USE_PREVIEW = getConfig().getBoolean("use-preview");
        SIGNS_UWUIFY = getConfig().getBoolean("signs-uwuify");
        BOOKS_UWUIFY = getConfig().getBoolean("books-uwuify");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
