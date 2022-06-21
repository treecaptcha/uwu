package ml.treecaptcha.uwuify;
import io.github.ran.uwu.client.Uwuifier;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

public class uwuHandler implements Listener{
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        event.setMessage(Uwuifier.uwuify(event.getMessage()));
    }
    public uwuHandler(Uwuify plugin){
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
}
