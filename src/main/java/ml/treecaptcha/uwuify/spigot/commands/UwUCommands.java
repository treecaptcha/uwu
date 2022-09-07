package ml.treecaptcha.uwuify.spigot.commands;

import ml.treecaptcha.uwuify.spigot.Uwuify;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public class UwUCommands implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(Uwuify.ALLOW_TOGGLE && sender instanceof Player p) {
            Uwuify.uwu.getLogger().info("uwuify: " + p.getPersistentDataContainer().get(Uwuify.UWUIFY_KEY, PersistentDataType.STRING));
            p.getPersistentDataContainer().set(Uwuify.UWUIFY_KEY, PersistentDataType.STRING,
                    (Boolean.parseBoolean(p.getPersistentDataContainer().get(Uwuify.UWUIFY_KEY, PersistentDataType.STRING))) ? "false" : "true");
            p.sendMessage("UwUify " + (Boolean.parseBoolean(p.getPersistentDataContainer().get(Uwuify.UWUIFY_KEY, PersistentDataType.STRING)) ? "disabled" : "enabled"));
            Uwuify.uwu.getLogger().info("uwuify: " + p.getPersistentDataContainer().get(Uwuify.UWUIFY_KEY, PersistentDataType.STRING));
            return false;
        }
        return false;
    }

    public static boolean isEnabled(Player p){
        return Boolean.parseBoolean(p.getPersistentDataContainer().getOrDefault(Uwuify.UWUIFY_KEY, PersistentDataType.STRING, "true"));
    }
}