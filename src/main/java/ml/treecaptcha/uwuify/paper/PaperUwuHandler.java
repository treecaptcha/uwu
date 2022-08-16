package ml.treecaptcha.uwuify.paper;

import io.github.ran.uwu.client.Uwuifier;

import io.papermc.paper.event.player.AsyncChatDecorateEvent;

import ml.treecaptcha.uwuify.core.AdventureChat;
import ml.treecaptcha.uwuify.core.Configuration;
import ml.treecaptcha.uwuify.spigot.Uwuify;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.meta.BookMeta;


public class PaperUwuHandler implements Listener {

    public PaperUwuHandler(Uwuify uwuify) {
        uwuify.getServer().getPluginManager().registerEvents(this, uwuify);
    }

    @EventHandler
    public void onPlayerPreview(AsyncChatDecorateEvent event) {
        if(!Configuration.USE_PREVIEW) return;
        event.result(AdventureChat.twoComponent(Uwuifier.uwuifyMessage(AdventureChat.twoString(event.result()))));
    }

    @EventHandler
    public void onSignChange(org.bukkit.event.block.SignChangeEvent e) {
        if(!Uwuify.SIGNS_UWUIFY) return;
        PlainTextComponentSerializer serializer = PlainTextComponentSerializer.plainText();
        for(int i = 0; i < e.lines().size(); i++) {
            if("".equals(AdventureChat.twoString(e.lines().get(i)))) continue;

            e.line(i, AdventureChat.twoComponent(Uwuifier.uwuifyMessage(AdventureChat.twoString(e.lines().get(i)))));
        }
    }

    @EventHandler
    public void onBook(PlayerEditBookEvent e) {
        if(!Uwuify.BOOKS_UWUIFY) return;

        PlainTextComponentSerializer serializer = PlainTextComponentSerializer.plainText();
        BookMeta meta = e.getNewBookMeta();

        for(int i = 0; i < meta.getPageCount(); i++) {
            meta.page(i+1, AdventureChat.twoComponent(Uwuifier.uwuify(AdventureChat.twoString(meta.page(i+1)))));
        }

        if(meta.title() != null) {
            meta.title(AdventureChat.twoComponent(Uwuifier.uwuify(AdventureChat.twoString(meta.title()))));
        }
        e.setNewBookMeta(meta);
    }
}