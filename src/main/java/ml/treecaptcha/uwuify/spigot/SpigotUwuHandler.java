package ml.treecaptcha.uwuify.spigot;

import io.github.ran.uwu.client.Uwuifier;
import ml.treecaptcha.uwuify.core.Configuration;
import ml.treecaptcha.uwuify.spigot.commands.UwUCommands;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.BookMeta;

public class SpigotUwuHandler implements Listener {


    @EventHandler
    public void onPlayerSign(SignChangeEvent event) {
        if(!Configuration.SIGNS_UWUIFY) return;
        if(!UwUCommands.isEnabled(event.getPlayer(), KeyHolder.UWUIFY_SIGNS)) return;
        for(int i = 0; i < event.getLines().length; i++) {
            if("".equals(event.getLine(i))) continue;

            event.setLine(i, Uwuifier.uwuifyMessage(event.getLine(i)));
        }
    }

    @EventHandler
    public void onPlayerBookEdit(PlayerEditBookEvent event) {
        if(!Configuration.BOOKS_UWUIFY) return;
        if(!UwUCommands.isEnabled(event.getPlayer(), KeyHolder.UWUIFY_BOOKS)) return;
        BookMeta meta = event.getNewBookMeta();
        for(int i = 0; i < meta.getPageCount(); i++) {
            meta.setPage(i+1, Uwuifier.uwuify(meta.getPage(i+1)));
        }
        if(meta.getTitle() != null) {
            meta.setTitle(Uwuifier.uwuify(meta.getTitle()));
        }
        event.setNewBookMeta(meta);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if(!UwUCommands.isEnabled(e.getPlayer(), KeyHolder.UWUIFY_PLAYER_NAME)) return;
        if(Configuration.PLAYER_NAMES_UWUIFY) {
            e.getPlayer().setDisplayName(Uwuifier.uwuifyName(e.getPlayer().getDisplayName()));
            e.getPlayer().setCustomName(Uwuifier.uwuifyName(e.getPlayer().getDisplayName()));
            e.getPlayer().setPlayerListName(Uwuifier.uwuifyName(e.getPlayer().getDisplayName()));
            e.getPlayer().setCustomNameVisible(true);
        }
        if(Configuration.JOIN_MESSAGES_UWUIFY) {
            e.setJoinMessage(Uwuifier.uwuify(e.getJoinMessage()));
        }
    }


}
