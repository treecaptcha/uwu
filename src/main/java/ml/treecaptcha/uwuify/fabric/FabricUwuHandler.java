package ml.treecaptcha.uwuify.fabric;

import io.github.ran.uwu.client.Uwuifier;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.message.v1.ServerMessageEvents;
public class FabricUwuHandler {
    public static void register(){
        ServerMessageEvents.CHAT_MESSAGE.register(new ServerMessageEvents.ChatMessage() {
            @Override
            public void onChatMessage(net.minecraft.class_7471 class_7471, net.minecraft.class_3222 class_3222, net.minecraft.class_2556.class_7602 class_7602) {
                Uwuify.LOGGER.info(Uwuifier.uwuify("Got messsage!"));
            }
        });

    }
}
