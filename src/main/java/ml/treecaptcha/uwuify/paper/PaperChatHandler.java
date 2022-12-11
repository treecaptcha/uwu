package ml.treecaptcha.uwuify.paper;

import io.github.ran.uwu.client.Uwuifier;
import io.papermc.paper.event.player.AsyncChatDecorateEvent;
import ml.treecaptcha.uwuify.spigot.KeyHolder;
import ml.treecaptcha.uwuify.spigot.commands.UwUCommands;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PaperChatHandler implements Listener {
    @SuppressWarnings("UnstableApiUsage")
    @EventHandler
    public void onPlayerPreview(AsyncChatDecorateEvent event) {
        if(!UwUCommands.isEnabled(event.player(), KeyHolder.UWUIFY_CHAT)) return;
        PlainTextComponentSerializer serializer = PlainTextComponentSerializer.plainText();
        event.result(Component.text(Uwuifier.uwuifyMessage(serializer.serialize(event.result()))));
    }
}
