package ml.treecaptcha.uwuify;
import io.github.ran.uwu.client.Uwuifier;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.AsyncPlayerChatPreviewEvent;

public class uwuHandler implements Listener{
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        event.setMessage(Uwuifier.uwuify(event.getMessage()));
    }

    @EventHandler
    public void onPlayerPreview(AsyncPlayerChatPreviewEvent event) {
        if(!Uwuify.uwu.getConfig().getBoolean("use-chat-preview")) return;
        event.setMessage(Uwuifier.uwuify(event.getMessage()));
    }

    @EventHandler
    public void onPlayerSign(SignChangeEvent ev) {
        if(!Uwuify.uwu.getConfig().getBoolean("signs-uwuify")) return;
        for(int i = 0; i < ev.getLines().length; i++) {
            if(ev.getLine(i) == null) continue;
            ev.setLine(i, Uwuifier.uwuify(ev.getLine(i)));
        }
    }

    public uwuHandler(Uwuify plugin){
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
}
