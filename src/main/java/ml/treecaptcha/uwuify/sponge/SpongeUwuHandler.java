package ml.treecaptcha.uwuify.sponge;

import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.message.MessageEvent;
import io.github.ran.uwu.client.Uwuifier;
public class SpongeUwuHandler {
    @Listener
    public void onMessage(MessageEvent event){
        Uwuify.lagger.info(Uwuifier.uwuify("Got message!"));
    }
}
