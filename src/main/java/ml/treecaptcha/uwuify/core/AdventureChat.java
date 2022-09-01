package ml.treecaptcha.uwuify.core;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;

/**
 * Contains methods for converting back and forth between adventure.text.Component and String
 */
public class AdventureChat {
    private static final PlainTextComponentSerializer serializer = PlainTextComponentSerializer.plainText();
    public static String twoString(Component component){
        return serializer.serialize(component);
    }
    public static Component twoComponent(String string){
        return Component.text(string);
    }
}
