package ml.treecaptcha.uwuify.spigot.commands;

import ml.treecaptcha.uwuify.spigot.KeyHolder;
import ml.treecaptcha.uwuify.spigot.Uwuify;
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
                Uwuify.uwu.getLogger().info("uwuify: " + p.getPersistentDataContainer().get(Uwuify.UWUIFY_KEY, PersistentDataType.STRING));
                p.getPersistentDataContainer().set(Uwuify.UWUIFY_KEY, PersistentDataType.STRING,
                        (Boolean.parseBoolean(p.getPersistentDataContainer().get(Uwuify.UWUIFY_KEY, PersistentDataType.STRING))) ? "false" : "true");
                p.sendMessage("UwUify " + (Boolean.parseBoolean(p.getPersistentDataContainer().get(Uwuify.UWUIFY_KEY, PersistentDataType.STRING)) ? "disabled" : "enabled"));
                Uwuify.uwu.getLogger().info("uwuify: " + p.getPersistentDataContainer().get(Uwuify.UWUIFY_KEY, PersistentDataType.STRING));
            } else {
                switch (strings[0]) {
                    case "chat" -> {
                        Uwuify.uwu.getLogger().info("uwuify: " + p.getPersistentDataContainer().get(KeyHolder.UWUIFY_CHAT, PersistentDataType.STRING));
                        p.getPersistentDataContainer().set(KeyHolder.UWUIFY_CHAT, PersistentDataType.STRING,
                                (Boolean.parseBoolean(p.getPersistentDataContainer().get(KeyHolder.UWUIFY_CHAT, PersistentDataType.STRING))) ? "false" : "true");
                        p.sendMessage("UwUify " + (Boolean.parseBoolean(p.getPersistentDataContainer().get(KeyHolder.UWUIFY_CHAT, PersistentDataType.STRING)) ? "disabled" : "enabled"));
                        Uwuify.uwu.getLogger().info("uwuify: " + p.getPersistentDataContainer().get(KeyHolder.UWUIFY_CHAT, PersistentDataType.STRING));
                    }
                    case "books" -> {
                        Uwuify.uwu.getLogger().info("uwuify: " + p.getPersistentDataContainer().get(KeyHolder.UWUIFY_BOOKS, PersistentDataType.STRING));
                        p.getPersistentDataContainer().set(KeyHolder.UWUIFY_BOOKS, PersistentDataType.STRING,
                                (Boolean.parseBoolean(p.getPersistentDataContainer().get(KeyHolder.UWUIFY_BOOKS, PersistentDataType.STRING))) ? "false" : "true");
                        p.sendMessage("UwUify " + (Boolean.parseBoolean(p.getPersistentDataContainer().get(KeyHolder.UWUIFY_BOOKS, PersistentDataType.STRING)) ? "disabled" : "enabled"));
                        Uwuify.uwu.getLogger().info("uwuify: " + p.getPersistentDataContainer().get(KeyHolder.UWUIFY_BOOKS, PersistentDataType.STRING));
                    }
                    case "signs" -> {
                        Uwuify.uwu.getLogger().info("uwuify: " + p.getPersistentDataContainer().get(KeyHolder.UWUIFY_SIGNS, PersistentDataType.STRING));
                        p.getPersistentDataContainer().set(KeyHolder.UWUIFY_SIGNS, PersistentDataType.STRING,
                                (Boolean.parseBoolean(p.getPersistentDataContainer().get(KeyHolder.UWUIFY_SIGNS, PersistentDataType.STRING))) ? "false" : "true");
                        p.sendMessage("UwUify " + (Boolean.parseBoolean(p.getPersistentDataContainer().get(KeyHolder.UWUIFY_SIGNS, PersistentDataType.STRING)) ? "disabled" : "enabled"));
                        Uwuify.uwu.getLogger().info("uwuify: " + p.getPersistentDataContainer().get(KeyHolder.UWUIFY_SIGNS, PersistentDataType.STRING));
                    }
                    case "animal_names" -> {
                        Uwuify.uwu.getLogger().info("uwuify: " + p.getPersistentDataContainer().get(KeyHolder.UWUIFY_ANIMALS, PersistentDataType.STRING));
                        p.getPersistentDataContainer().set(KeyHolder.UWUIFY_ANIMALS, PersistentDataType.STRING,
                                (Boolean.parseBoolean(p.getPersistentDataContainer().get(KeyHolder.UWUIFY_ANIMALS, PersistentDataType.STRING))) ? "false" : "true");
                        p.sendMessage("UwUify " + (Boolean.parseBoolean(p.getPersistentDataContainer().get(KeyHolder.UWUIFY_ANIMALS, PersistentDataType.STRING)) ? "disabled" : "enabled"));
                        Uwuify.uwu.getLogger().info("uwuify: " + p.getPersistentDataContainer().get(KeyHolder.UWUIFY_ANIMALS, PersistentDataType.STRING));
                    }
                    case "join_message" -> {
                        Uwuify.uwu.getLogger().info("uwuify: " + p.getPersistentDataContainer().get(KeyHolder.UWUIFY_JOIN_MESSAGES, PersistentDataType.STRING));
                        p.getPersistentDataContainer().set(KeyHolder.UWUIFY_JOIN_MESSAGES, PersistentDataType.STRING,
                                (Boolean.parseBoolean(p.getPersistentDataContainer().get(KeyHolder.UWUIFY_JOIN_MESSAGES, PersistentDataType.STRING))) ? "false" : "true");
                        p.sendMessage("UwUify " + (Boolean.parseBoolean(p.getPersistentDataContainer().get(KeyHolder.UWUIFY_JOIN_MESSAGES, PersistentDataType.STRING)) ? "disabled" : "enabled"));
                        Uwuify.uwu.getLogger().info("uwuify: " + p.getPersistentDataContainer().get(KeyHolder.UWUIFY_JOIN_MESSAGES, PersistentDataType.STRING));
                    }
                    case "player_name" -> {
                        Uwuify.uwu.getLogger().info("uwuify: " + p.getPersistentDataContainer().get(KeyHolder.UWUIFY_PLAYER_NAME, PersistentDataType.STRING));
                        p.getPersistentDataContainer().set(KeyHolder.UWUIFY_PLAYER_NAME, PersistentDataType.STRING,
                                (Boolean.parseBoolean(p.getPersistentDataContainer().get(KeyHolder.UWUIFY_PLAYER_NAME, PersistentDataType.STRING))) ? "false" : "true");
                        p.sendMessage("UwUify " + (Boolean.parseBoolean(p.getPersistentDataContainer().get(KeyHolder.UWUIFY_PLAYER_NAME, PersistentDataType.STRING)) ? "disabled" : "enabled"));
                        Uwuify.uwu.getLogger().info("uwuify: " + p.getPersistentDataContainer().get(KeyHolder.UWUIFY_PLAYER_NAME, PersistentDataType.STRING));
                    }
                    case "all" -> {
                        Uwuify.uwu.getLogger().info("uwuify: " + p.getPersistentDataContainer().get(Uwuify.UWUIFY_KEY, PersistentDataType.STRING));
                        p.getPersistentDataContainer().set(Uwuify.UWUIFY_KEY, PersistentDataType.STRING,
                                (Boolean.parseBoolean(p.getPersistentDataContainer().get(Uwuify.UWUIFY_KEY, PersistentDataType.STRING))) ? "false" : "true");
                        p.sendMessage("UwUify " + (Boolean.parseBoolean(p.getPersistentDataContainer().get(Uwuify.UWUIFY_KEY, PersistentDataType.STRING)) ? "disabled" : "enabled"));
                        Uwuify.uwu.getLogger().info("uwuify: " + p.getPersistentDataContainer().get(Uwuify.UWUIFY_KEY, PersistentDataType.STRING));
                        Uwuify.uwu.getLogger().info("uwuify: " + p.getPersistentDataContainer().get(KeyHolder.UWUIFY_CHAT, PersistentDataType.STRING));
                        p.getPersistentDataContainer().set(KeyHolder.UWUIFY_CHAT, PersistentDataType.STRING,
                                (Boolean.parseBoolean(p.getPersistentDataContainer().get(KeyHolder.UWUIFY_CHAT, PersistentDataType.STRING))) ? "false" : "true");
                        p.sendMessage("UwUify " + (Boolean.parseBoolean(p.getPersistentDataContainer().get(KeyHolder.UWUIFY_CHAT, PersistentDataType.STRING)) ? "disabled" : "enabled"));
                        Uwuify.uwu.getLogger().info("uwuify: " + p.getPersistentDataContainer().get(KeyHolder.UWUIFY_CHAT, PersistentDataType.STRING));
                        Uwuify.uwu.getLogger().info("uwuify: " + p.getPersistentDataContainer().get(KeyHolder.UWUIFY_BOOKS, PersistentDataType.STRING));
                        p.getPersistentDataContainer().set(KeyHolder.UWUIFY_BOOKS, PersistentDataType.STRING,
                                (Boolean.parseBoolean(p.getPersistentDataContainer().get(KeyHolder.UWUIFY_BOOKS, PersistentDataType.STRING))) ? "false" : "true");
                        p.sendMessage("UwUify " + (Boolean.parseBoolean(p.getPersistentDataContainer().get(KeyHolder.UWUIFY_BOOKS, PersistentDataType.STRING)) ? "disabled" : "enabled"));
                        Uwuify.uwu.getLogger().info("uwuify: " + p.getPersistentDataContainer().get(KeyHolder.UWUIFY_BOOKS, PersistentDataType.STRING));
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

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (Uwuify.ALLOW_TOGGLE && commandSender instanceof Player p) {
            return List.of("chat", "signs", "books", "names", "join", "all", "animal_names");
        }
        return null;
    }

    //TODO: Make tab complete for the command, allowing the player to choose which features to toggle


}