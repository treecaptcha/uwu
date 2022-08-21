package ml.treecaptcha.uwuify.sponge;

import io.github.ran.uwu.client.Uwuifier;
import ml.treecaptcha.uwuify.core.AdventureChat;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.message.PlayerChatEvent;

public class SpongeUwuHandler {
    @Listener
    public void onMessage(PlayerChatEvent event) {

        event.setMessage(
                AdventureChat.twoComponent(
                        Uwuifier.uwuifyMessage(
                                AdventureChat.twoString(
                                        event.message()
                                )
                        )
                )
        );
    }
}
