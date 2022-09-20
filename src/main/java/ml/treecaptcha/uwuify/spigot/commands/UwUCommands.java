package ml.treecaptcha.uwuify.spigot.commands;

import ml.treecaptcha.uwuify.spigot.KeyHolder;
import ml.treecaptcha.uwuify.spigot.Uwuify;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class UwUCommands implements CommandExecutor, TabCompleter {
    private static final List<String> TAB_COMPLETE = List.of("chat", "signs", "books", "names", "join", "all", "animal_names");

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(Uwuify.ALLOW_TOGGLE && sender instanceof Player p) {
            if(strings.length == 0) {
                return togglePlayerUwUify(p, Uwuify.UWUIFY_KEY);
            } else {
                switch (strings[0]) {
                    case "chat" -> {
                        return togglePlayerUwUify(p, KeyHolder.UWUIFY_CHAT);
                    }
                    case "books" -> {
                        return togglePlayerUwUify(p, KeyHolder.UWUIFY_BOOKS);
                    }
                    case "signs" -> {
                        return togglePlayerUwUify(p, KeyHolder.UWUIFY_SIGNS);
                    }
                    case "animal_names" -> {
                        return togglePlayerUwUify(p, KeyHolder.UWUIFY_ANIMALS);
                    }
                    case "join_message" -> {
                        return togglePlayerUwUify(p, KeyHolder.UWUIFY_JOIN_MESSAGES);
                    }
                    case "player_name" -> {
                        return togglePlayerUwUify(p, KeyHolder.UWUIFY_PLAYER_NAME);
                    }
                    case "all" -> {
                        return togglePlayerUwUify(p, Uwuify.UWUIFY_KEY);
                    }
                }
            }
            return false;
        }
        return false;
    }

    public static boolean isEnabled(Player p, NamespacedKey key) {
        return p.getPersistentDataContainer().has(key, BooleanPersistentDataType.INSTANCE) || p.getPersistentDataContainer().get(key, BooleanPersistentDataType.INSTANCE) == Boolean.TRUE;
    }

    public static boolean togglePlayerUwUify(Player p, NamespacedKey key) {
        Uwuify.uwu.getLogger().info(p.getName() + " currently has " + (isEnabled(p, key) ? "enabled" : "disabled") + " for " + key.getKey());
        p.getPersistentDataContainer().set(key, BooleanPersistentDataType.INSTANCE, !isEnabled(p, key));
        p.sendMessage(Component.text("UwUify " + (isEnabled(p, key) ? "enabled" : "disabled") + " for " + key.getKey()));
        Uwuify.uwu.getLogger().info(p.getName() + " toggled UwUify " + (isEnabled(p, key) ? "enabled" : "disabled") + " for " + key.getKey());
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (Uwuify.ALLOW_TOGGLE && commandSender instanceof Player p) {
            return TAB_COMPLETE;
        }
        return null;
    }
}