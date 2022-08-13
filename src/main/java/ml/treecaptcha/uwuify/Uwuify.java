package ml.treecaptcha.uwuify;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

import io.github.ran.uwu.client.Uwuifier;
public final class Uwuify extends JavaPlugin {
    public static Uwuify uwu;
    @Override
    public void onEnable() {
        uwu = this;
        getLogger().log(Level.INFO, Uwuifier.uwuify("give uwu sound effects cause idk where to get them"));
        new uwuHandler(this);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static final boolean USE_PREVIEW = uwu.getConfig().getBoolean("use-chat-preview");
    public static final boolean SIGNS_UWUIFY = uwu.getConfig().getBoolean("signs-uwuify");
    public static final boolean BOOKS_UWUIFY = uwu.getConfig().getBoolean("books-uwuify");
}
