package ml.treecaptcha.uwuify.spigot;
import io.github.ran.uwu.client.Uwuifier;
import ml.treecaptcha.uwuify.core.Configuration;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.AsyncPlayerChatPreviewEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.meta.BookMeta;

public class SpigotUwuHandler implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        event.setMessage(Uwuifier.uwuifyMessage(event.getMessage()));
    }

    @EventHandler
    public void onPlayerPreview(AsyncPlayerChatPreviewEvent event) {
        if(!Configuration.USE_PREVIEW) return;
        event.setMessage(Uwuifier.uwuifyMessage(event.getMessage()));
    }

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

    public SpigotUwuHandler(Uwuify plugin){
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
}
