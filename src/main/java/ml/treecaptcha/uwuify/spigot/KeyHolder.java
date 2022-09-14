package ml.treecaptcha.uwuify.spigot;

import org.bukkit.NamespacedKey;

public class KeyHolder {
    public static NamespacedKey UWUIFY_CHAT;
    public static NamespacedKey UWUIFY_BOOKS;
    public static NamespacedKey UWUIFY_SIGNS;
    public static NamespacedKey UWUIFY_ANIMALS;
    public static NamespacedKey UWUIFY_PLAYER_NAME;
    public static NamespacedKey UWUIFY_JOIN_MESSAGES;

    public static void init() {
        UWUIFY_CHAT = new NamespacedKey(Uwuify.uwu, "uwuify_chat");
        UWUIFY_BOOKS = new NamespacedKey(Uwuify.uwu, "uwuify_books");
        UWUIFY_SIGNS = new NamespacedKey(Uwuify.uwu, "uwuify_signs");
        UWUIFY_ANIMALS = new NamespacedKey(Uwuify.uwu, "uwuify_animals");
        UWUIFY_PLAYER_NAME = new NamespacedKey(Uwuify.uwu, "uwuify_player_name");
        UWUIFY_JOIN_MESSAGES = new NamespacedKey(Uwuify.uwu, "uwuify_join_messages");
    }
}
