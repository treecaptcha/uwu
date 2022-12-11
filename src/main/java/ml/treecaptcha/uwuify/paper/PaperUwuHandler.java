package ml.treecaptcha.uwuify.paper;

import io.github.ran.uwu.client.Uwuifier;
import io.papermc.paper.event.player.PlayerNameEntityEvent;
import ml.treecaptcha.uwuify.core.AdventureChat;
import ml.treecaptcha.uwuify.core.Configuration;
import ml.treecaptcha.uwuify.spigot.KeyHolder;
import ml.treecaptcha.uwuify.spigot.commands.UwUCommands;
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
        if (!Configuration.SIGNS_UWUIFY) return;
        if(!UwUCommands.isEnabled(e.getPlayer(), KeyHolder.UWUIFY_SIGNS)) return;
        PlainTextComponentSerializer serializer = PlainTextComponentSerializer.plainText();
        for (int i = 0; i < e.lines().size(); i++) {
            if ("".equals(serializer.serialize(e.lines().get(i)))) continue;
            e.line(i, Component.text(Uwuifier.uwuify(serializer.serialize(e.lines().get(i)))));
        }
    }

    @EventHandler
    public void onBook(PlayerEditBookEvent e) {
        if (!Configuration.BOOKS_UWUIFY) return;
        if(!UwUCommands.isEnabled(e.getPlayer(), KeyHolder.UWUIFY_BOOKS)) return;
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
        if (!Configuration.ANIMALS_UWUIFY) return;
        if(!UwUCommands.isEnabled(e.getPlayer(), KeyHolder.UWUIFY_ANIMALS)) return;
        e.setName(Component.text(Uwuifier.uwuify(AdventureChat.twoString(e.getName()))));
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if(!UwUCommands.isEnabled(event.getPlayer(), KeyHolder.UWUIFY_JOIN_MESSAGES)) return;
        if (Configuration.PLAYER_NAMES_UWUIFY) {
            event.getPlayer().displayName(Component.text(Uwuifier.uwuifyName(AdventureChat.twoString(event.getPlayer().displayName()))));
            event.getPlayer().customName(Component.text(Uwuifier.uwuifyName(AdventureChat.twoString(event.getPlayer().displayName()))));
            event.getPlayer().playerListName(Component.text(Uwuifier.uwuifyName(AdventureChat.twoString(event.getPlayer().displayName()))));
            event.getPlayer().setCustomNameVisible(true);
        }
        if (Configuration.JOIN_MESSAGES_UWUIFY) {
            event.joinMessage(Component.text(Uwuifier.uwuify(AdventureChat.twoString(event.joinMessage()))));
        }
    }
}