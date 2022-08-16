package ml.treecaptcha.uwuify.paper;

import com.google.gson.Gson;
import io.github.ran.uwu.client.Uwuifier;
import io.papermc.paper.event.player.AsyncChatDecorateEvent;
import io.papermc.paper.event.player.AsyncChatEvent;
import ml.treecaptcha.uwuify.core.Configuration;
import ml.treecaptcha.uwuify.spigot.Uwuify;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.meta.BookMeta;

import java.util.logging.Level;

public class PaperUwuHandler implements Listener {

    public PaperUwuHandler(Uwuify uwuify) {
        uwuify.getServer().getPluginManager().registerEvents(this, uwuify);
    }

    //Workaround for if the player uses DiscordSRV but doesn't have the DiscordSRV config set to use Paper's chat event.
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if(Uwuify.DISCORDSRV_PAPER) return;
        event.setMessage(Uwuifier.uwuifyMessage(event.getMessage()));
        Uwuify.uwu.getLogger().log(Level.WARNING, Uwuifier.uwuify("DiscordSRV is not set to use Paper's chat event."));
        Uwuify.uwu.getLogger().log(Level.WARNING, Uwuifier.uwuify("Please set DiscordSRV's config to use Paper's chat event."));
    }

    @EventHandler
    public void onPlayerPreview(AsyncChatDecorateEvent event) {
        if(!Configuration.USE_PREVIEW) return;
        PlainTextComponentSerializer serializer = PlainTextComponentSerializer.plainText();
        event.result(Component.text(Uwuifier.uwuifyMessage(serializer.serialize(event.result()))));
    }

    @EventHandler
    public void onSignChange(org.bukkit.event.block.SignChangeEvent e) {
        if(!Uwuify.SIGNS_UWUIFY) return;
        PlainTextComponentSerializer serializer = PlainTextComponentSerializer.plainText();
        for(int i = 0; i < e.lines().size(); i++) {
            if("".equals(serializer.serialize(e.lines().get(i)))) continue;

            e.line(i, Component.text(Uwuifier.uwuifyMessage(serializer.serialize(e.lines().get(i)))));
        }
    }

    @EventHandler
    public void onBook(PlayerEditBookEvent e) {
        if(!Uwuify.BOOKS_UWUIFY) return;

        PlainTextComponentSerializer serializer = PlainTextComponentSerializer.plainText();
        BookMeta meta = e.getNewBookMeta();

        for(int i = 0; i < meta.getPageCount(); i++) {
            meta.page(i+1, Component.text(Uwuifier.uwuify(serializer.serialize(meta.page(i+1)))));
        }

        if(meta.title() != null) {
            meta.title(Component.text(Uwuifier.uwuify(serializer.serialize(meta.title()))));
        }
        e.setNewBookMeta(meta);
    }
}