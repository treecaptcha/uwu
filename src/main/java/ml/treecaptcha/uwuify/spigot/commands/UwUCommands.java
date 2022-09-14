package ml.treecaptcha.uwuify.spigot.commands;

import ml.treecaptcha.uwuify.spigot.KeyHolder;
import ml.treecaptcha.uwuify.spigot.Uwuify;
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

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(Uwuify.ALLOW_TOGGLE && sender instanceof Player p) {
            if(strings == null) {
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

    public static boolean isEnabled(Player p){
        return Boolean.parseBoolean(p.getPersistentDataContainer().getOrDefault(Uwuify.UWUIFY_KEY, PersistentDataType.STRING, "true"));
    }

    public static boolean togglePlayerUwUify(Player p, NamespacedKey key) {
        Uwuify.uwu.getLogger().info("uwuify: " + p.getPersistentDataContainer().get(key, PersistentDataType.STRING));
        p.getPersistentDataContainer().set(key, PersistentDataType.STRING,
                (Boolean.parseBoolean(p.getPersistentDataContainer().get(key, PersistentDataType.STRING))) ? "false" : "true");
        p.sendMessage("UwUify " + (Boolean.parseBoolean(p.getPersistentDataContainer().get(key, PersistentDataType.STRING)) ? "disabled" : "enabled"));
        Uwuify.uwu.getLogger().info("uwuify: " + p.getPersistentDataContainer().get(key, PersistentDataType.STRING));
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (Uwuify.ALLOW_TOGGLE && commandSender instanceof Player p) {
            return List.of("chat", "signs", "books", "names", "join", "all", "animal_names");
        }
        return null;
    }
}