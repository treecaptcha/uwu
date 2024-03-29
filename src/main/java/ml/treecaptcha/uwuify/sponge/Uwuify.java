package ml.treecaptcha.uwuify.sponge;

import com.google.inject.Inject;
import io.github.ran.uwu.client.Uwuifier;
import org.apache.logging.log4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.Server;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.lifecycle.StartedEngineEvent;
import org.spongepowered.plugin.PluginContainer;

public class Uwuify {

    public static Logger lagger;
    @Inject
    private Logger logger;
    @Inject
    private PluginContainer plugin;
    @Inject
    private Game game;

    @Listener
    public void onServerStart(final StartedEngineEvent<Server> event) {
        logger.info(Uwuifier.uwuify("give uwu sound effects cause idk where to get them"));
        logger.info(Uwuifier.uwuify("Loading Sponge version of uwuify!"));
        lagger = logger;
        Sponge.eventManager().registerListeners(plugin, new SpongeUwuHandler());

    }

}
