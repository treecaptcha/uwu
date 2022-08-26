package ml.treecaptcha.uwuify.paper;

import io.github.ran.uwu.client.Uwuifier;
import io.papermc.paper.event.player.PlayerNameEntityEvent;
import ml.treecaptcha.uwuify.core.AdventureChat;
import ml.treecaptcha.uwuify.spigot.SpigotUwuHandler;
import ml.treecaptcha.uwuify.spigot.Uwuify;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;

public class PaperUwuHandler extends SpigotUwuHandler{


    @EventHandler
    public void onEntityName(PlayerNameEntityEvent e) {
        if(!Uwuify.ANIMALS_UWUIFY) return;
        e.setName(Component.text(Uwuifier.uwuifyMessage(AdventureChat.twoString(e.getName()))));
    }

}