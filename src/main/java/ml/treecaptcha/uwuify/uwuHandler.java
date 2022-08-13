package ml.treecaptcha.uwuify;
import io.github.ran.uwu.client.Uwuifier;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.AsyncPlayerChatPreviewEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.meta.BookMeta;

public class uwuHandler implements Listener{
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        event.setMessage(Uwuifier.uwuify(event.getMessage()));
    }

    @EventHandler
    public void onPlayerPreview(AsyncPlayerChatPreviewEvent event) {
        if(!Uwuify.USE_PREVIEW) return;
        event.setMessage(Uwuifier.uwuify(event.getMessage()));
    }

    @EventHandler
    public void onPlayerSign(SignChangeEvent event) {
        if(!Uwuify.SIGNS_UWUIFY) return;
        for(int i = 0; i < event.getLines().length; i++) {
            if(event.getLine(i) == null) continue;
            event.setLine(i, Uwuifier.uwuify(event.getLine(i)));
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

    public uwuHandler(Uwuify plugin){
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
}
