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
                Uwuify.USE_PREVIEW = true;
            }
            else{
                uwu.getLogger().log(Level.WARNING, Uwuifier.uwuify("use-chat-preview is set to true, but previews-chat is not enabled in server.properties!"));
                uwu.getLogger().log(Level.WARNING, Uwuifier.uwuify("To stop this warn please either set use-chat-preview to false or set previews-chat to True."));
                uwu.getLogger().log(Level.WARNING, Uwuifier.uwuify("Not enabling chat preview!"));
            }
        }
        Uwuify.SIGNS_UWUIFY = uwu.getConfig().getBoolean("signs-uwuify");
        Uwuify.BOOKS_UWUIFY = uwu.getConfig().getBoolean("books-uwuify");
    }
}
