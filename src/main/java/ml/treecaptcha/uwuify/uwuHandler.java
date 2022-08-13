package ml.treecaptcha.uwuify;
import io.github.ran.uwu.client.Uwuifier;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.AsyncPlayerChatPreviewEvent;

public class uwuHandler implements Listener{
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        event.setMessage(Uwuifier.uwuify(event.getMessage()));
    }

    @EventHandler
    public void onPlayerPreview(AsyncPlayerChatPreviewEvent event) {
        if(!Uwuify.uwu.getConfig().getBoolean("use-chat-preview")) return;
        event.setMessage(Uwuifier.uwuify(event.getMessage()));
    }

    public uwuHandler(Uwuify plugin){
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
}
