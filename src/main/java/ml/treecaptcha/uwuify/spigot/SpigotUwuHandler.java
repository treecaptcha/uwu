package ml.treecaptcha.uwuify.spigot;

import io.github.ran.uwu.client.Uwuifier;

import ml.treecaptcha.uwuify.core.AdventureChat;
import net.kyori.adventure.text.Component;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
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
    public void onInvClick(InventoryClickEvent e) {
        if(!Uwuify.ITEM_NAMES_UWUIFY) return;
        if(e.getCurrentItem() == null) return;
        if(e.getClickedInventory() instanceof AnvilInventory) return;
        if(e.getSlot() != 2) return;
        if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName()) {
            ItemMeta meta = e.getCurrentItem().getItemMeta();
            meta.setDisplayName(Uwuifier.uwuify(meta.getDisplayName()));
            e.getCurrentItem().setItemMeta(meta);
        }
    }


}
