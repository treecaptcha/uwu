package ml.treecaptcha.uwuify.spigot;

import io.github.ran.uwu.client.Uwuifier;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class SpigotUwuHandler implements Listener {


    @EventHandler
    public void onPlayerSign(SignChangeEvent event) {
        if(!Uwuify.SIGNS_UWUIFY) return;
        for(int i = 0; i < event.getLines().length; i++) {
            if("".equals(event.getLine(i))) continue;

            event.setLine(i, Uwuifier.uwuifyMessage(event.getLine(i)));
        }
    }

    @EventHandler
    public void onPlayerBookEdit(PlayerEditBookEvent event) {
        if(!Uwuify.BOOKS_UWUIFY) return;
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
        if(Uwuify.PLAYER_NAMES_UWUIFY) {
            e.getPlayer().setDisplayName(Uwuifier.uwuifyName(e.getPlayer().getDisplayName()));
            e.getPlayer().setCustomName(Uwuifier.uwuifyName(e.getPlayer().getDisplayName()));
            e.getPlayer().setPlayerListName(Uwuifier.uwuifyName(e.getPlayer().getDisplayName()));
            e.getPlayer().setCustomNameVisible(true);
        }
        if(Uwuify.JOIN_MESSAGES_UWUIFY) {
            e.setJoinMessage(Uwuifier.uwuify(e.getJoinMessage()));
        }
    }


}
