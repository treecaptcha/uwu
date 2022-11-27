package ml.treecaptcha.uwuify.spigot.commands;

import io.github.ran.uwu.client.Uwuifier;
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
            if(Uwuify.REQUIRE_PERMISSION && !p.hasPermission("uwuify.toggle")) {
                p.sendMessage(Component.text("You do not have permission to use this command!"));
                return true;
            }
            if(strings.length ==  0) {
                return togglePlayerUwUify(p, Uwuify.UWUIFY_KEY);
            } else {
                switch (strings[0]) {
                    case "chat" -> {
                        if(Uwuify.ALLOW_TOGGLE_CHAT) {
                            return togglePlayerUwUify(p, KeyHolder.UWUIFY_CHAT);
                        } else {
                            p.sendMessage(Component.text("Chat uwuification is not toggleable!"));
                            return true;
                        }
                    }
                    case "books" -> {
                        if(Uwuify.ALLOW_TOGGLE_BOOKS) {
                            return togglePlayerUwUify(p, KeyHolder.UWUIFY_BOOKS);
                        } else {
                            p.sendMessage(Component.text("Book uwuification is not toggleable!"));
                            return true;
                        }
                    }
                    case "signs" -> {
                        if(Uwuify.ALLOW_TOGGLE_SIGNS) {
                            return togglePlayerUwUify(p, KeyHolder.UWUIFY_SIGNS);
                        } else {
                            p.sendMessage(Component.text("Sign uwuification is not toggleable!"));
                            return true;
                        }
                    }
                    case "animal_names" -> {
                        if(Uwuify.ALLOW_TOGGLE_ANIMALS) {
                            return togglePlayerUwUify(p, KeyHolder.UWUIFY_ANIMALS);
                        } else {
                            p.sendMessage(Component.text("Animal name uwuification is not toggleable!"));
                            return true;
                        }
                    }
                    case "join_message" -> {
                        if(Uwuify.ALLOW_TOGGLE_JOIN_MESSAGES) {
                            return togglePlayerUwUify(p, KeyHolder.UWUIFY_JOIN_MESSAGES);
                        } else {
                            p.sendMessage(Component.text("Join message uwuification is not toggleable!"));
                            return true;
                        }
                    }
                    case "names" -> {
                        if(isEnabled(p, KeyHolder.UWUIFY_PLAYER_NAME)){
                            p.displayName(p.name());
                            p.playerListName(p.name());
                        }
                        else{
                            p.displayName(Component.text(Uwuifier.uwuify(p.getName())));
                            p.playerListName(Component.text(Uwuifier.uwuify(p.getName())));
                        }
                        if (Uwuify.ALLOW_TOGGLE_PLAYER_NAME) {
                            return togglePlayerUwUify(p, KeyHolder.UWUIFY_PLAYER_NAME);
                        } else {
                            p.sendMessage(Component.text("Player name uwuification is not toggleable!"));
                            return true;
                        }
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
        if (Uwuify.ALLOW_TOGGLE && commandSender instanceof Player p) {
            return TAB_COMPLETE;
        }
        return null;
    }
}