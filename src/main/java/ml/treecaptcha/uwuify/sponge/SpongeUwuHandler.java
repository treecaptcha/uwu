package ml.treecaptcha.uwuify.sponge;

import io.github.ran.uwu.client.Uwuifier;

import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.message.MessageEvent;

public class SpongeUwuHandler {
    @Listener
    public void onMessage(MessageEvent event) {
        Uwuify.lagger.info(Uwuifier.uwuify("Got message!"));
    }
}
