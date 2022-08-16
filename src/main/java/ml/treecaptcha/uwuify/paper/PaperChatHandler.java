package ml.treecaptcha.uwuify.paper;

import io.github.ran.uwu.client.Uwuifier;
import io.papermc.paper.event.player.AsyncChatDecorateEvent;
import ml.treecaptcha.uwuify.core.Configuration;
import ml.treecaptcha.uwuify.spigot.Uwuify;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PaperChatHandler implements Listener {
    @EventHandler
    public void onPlayerPreview(AsyncChatDecorateEvent event) {
        if(event.isPreview() && !Configuration.USE_PREVIEW) return;
        PlainTextComponentSerializer serializer = PlainTextComponentSerializer.plainText();
        event.result(Component.text(Uwuifier.uwuifyMessage(serializer.serialize(event.result()))));
    }
    public PaperChatHandler(Uwuify uwuify) {
        uwuify.getServer().getPluginManager().registerEvents(this, uwuify);
    }
}
