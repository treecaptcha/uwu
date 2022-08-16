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