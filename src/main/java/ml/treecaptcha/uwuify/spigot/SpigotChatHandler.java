package ml.treecaptcha.uwuify.spigot;

import io.github.ran.uwu.client.Uwuifier;
import ml.treecaptcha.uwuify.core.Configuration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.AsyncPlayerChatPreviewEvent;

public class SpigotChatHandler implements Listener {
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        event.setMessage(Uwuifier.uwuifyMessage(event.getMessage()));
    }

    @EventHandler
    public void onPlayerPreview(AsyncPlayerChatPreviewEvent event) {
        if(!Configuration.USE_PREVIEW) return;
        event.setMessage(Uwuifier.uwuifyMessage(event.getMessage()));
    }

}
