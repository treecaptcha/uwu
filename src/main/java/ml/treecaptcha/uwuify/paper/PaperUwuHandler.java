package ml.treecaptcha.uwuify.paper;

import io.github.ran.uwu.client.Uwuifier;
import io.papermc.paper.event.player.AsyncChatDecorateEvent;
import io.papermc.paper.event.player.AsyncChatEvent;
import ml.treecaptcha.uwuify.Uwuify;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PaperUwuHandler implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncChatEvent event) {
        PlainTextComponentSerializer serializer = PlainTextComponentSerializer.plainText();
        event.message(Component.text(Uwuifier.uwuifyMessage(serializer.serialize(event.message()))));
    }

}