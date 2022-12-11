package ml.treecaptcha.uwuify.spigot;

import io.github.ran.uwu.client.Uwuifier;
import ml.treecaptcha.uwuify.core.Configuration;
import ml.treecaptcha.uwuify.spigot.commands.UwUCommands;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.AsyncPlayerChatPreviewEvent;

public class SpigotChatHandler implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if(!UwUCommands.isEnabled(event.getPlayer(), KeyHolder.UWUIFY_CHAT)) return;
        event.setMessage(Uwuifier.uwuifyMessage(event.getMessage()));
    }
}
