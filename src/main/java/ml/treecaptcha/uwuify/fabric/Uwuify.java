package ml.treecaptcha.uwuify.fabric;

import io.github.ran.uwu.client.Uwuifier;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Uwuify implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("uwuify");

    @Override
    public void onInitialize() {
        LOGGER.info(Uwuifier.uwuify("give uwu sound effects cause idk where to get them"));
    }
}
