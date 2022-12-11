package ml.treecaptcha.uwuify.spigot.commands;

import ml.treecaptcha.uwuify.core.Configuration;
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
        if(Configuration.ALLOW_TOGGLE && sender instanceof Player p) {
            if(!p.hasPermission("uwuify.toggle")) {
                p.sendMessage(Component.text("You do not have permission to use this command!"));
                return true;
            }
            if(strings.length ==  0) {
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
                    case "names" -> {
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
        if(!p.getPersistentDataContainer().has(key, PersistentDataType.BYTE)) {
            if(!p.getPersistentDataContainer().has(Uwuify.UWUIFY_KEY, PersistentDataType.BYTE)) {
                return true;
            } else {
                return p.getPersistentDataContainer().get(Uwuify.UWUIFY_KEY, PersistentDataType.BYTE) == 1;
            }
        }
        return p.getPersistentDataContainer().get(key, PersistentDataType.BYTE) == 1 && p.getPersistentDataContainer().get(Uwuify.UWUIFY_KEY, PersistentDataType.BYTE) == 1;
    }

    public static boolean togglePlayerUwUify(Player p, NamespacedKey key) {
        if(p.getPersistentDataContainer().has(key, PersistentDataType.BYTE)) {
            p.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) (isEnabled(p, key) ? 0 : 1));
        } else {
            p.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 0);
        }
        p.sendMessage(Component.text("UwUify " + (isEnabled(p, key) ? "enabled" : "disabled") + " for " + key.getKey()));
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (Configuration.ALLOW_TOGGLE && commandSender instanceof Player p) {
            return TAB_COMPLETE;
        }
        return null;
    }
}