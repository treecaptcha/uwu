package ml.treecaptcha.uwuify.paper;

import io.github.ran.uwu.client.Uwuifier;
import io.papermc.paper.event.player.PlayerNameEntityEvent;
import ml.treecaptcha.uwuify.core.AdventureChat;
import ml.treecaptcha.uwuify.spigot.Uwuify;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.BookMeta;

public class PaperUwuHandler implements Listener {


    @EventHandler
    public void onSignChange(org.bukkit.event.block.SignChangeEvent e) {
        if (!Uwuify.SIGNS_UWUIFY) return;
        PlainTextComponentSerializer serializer = PlainTextComponentSerializer.plainText();
        for (int i = 0; i < e.lines().size(); i++) {
            if ("".equals(serializer.serialize(e.lines().get(i)))) continue;

            e.line(i, Component.text(Uwuifier.uwuifyMessage(serializer.serialize(e.lines().get(i)))));
        }
    }

    @EventHandler
    public void onBook(PlayerEditBookEvent e) {
        if (!Uwuify.BOOKS_UWUIFY) return;
        BookMeta meta = e.getNewBookMeta();

        for (int i = 0; i < meta.getPageCount(); i++) {
            meta.page(i + 1, Component.text(Uwuifier.uwuify(AdventureChat.twoString(meta.page(i + 1)))));
        }

        if (meta.title() != null) {
            meta.title(Component.text(Uwuifier.uwuify(AdventureChat.twoString(meta.title()))));
        }
        e.setNewBookMeta(meta);
    }

    @EventHandler
    public void onEntityName(PlayerNameEntityEvent e) {
        if (!Uwuify.ANIMALS_UWUIFY) return;
        e.setName(Component.text(Uwuifier.uwuifyMessage(AdventureChat.twoString(e.getName()))));
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (Uwuify.PLAYER_NAMES_UWUIFY) {
            event.getPlayer().displayName(Component.text(Uwuifier.uwuifyName(AdventureChat.twoString(event.getPlayer().displayName()))));
            event.getPlayer().customName(Component.text(Uwuifier.uwuifyName(AdventureChat.twoString(event.getPlayer().displayName()))));
            event.getPlayer().playerListName(Component.text(Uwuifier.uwuifyName(AdventureChat.twoString(event.getPlayer().displayName()))));
            event.getPlayer().setCustomNameVisible(true);
        }
        if (Uwuify.JOIN_MESSAGES_UWUIFY) {
            event.joinMessage(Component.text(Uwuifier.uwuifyMessage(AdventureChat.twoString(event.joinMessage()))));
        }
    }
}