package me.xaxis_playz.shp.serverhubsplus.commands;

import me.xaxis_playz.shp.serverhubsplus.ServerHubsPlus;
import me.xaxis_playz.shp.serverhubsplus.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Vanish implements CommandExecutor {


    ServerHubsPlus plugin;

    public Vanish(ServerHubsPlus plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("shvanish.use")) {
                if (plugin.invisible_list.contains(player)) {
                    for (Player people : Bukkit.getOnlinePlayers()) {
                        people.showPlayer(plugin, player);
                    }
                    plugin.invisible_list.remove(player);
                    Bukkit.getServer().broadcastMessage(player + "Joined the server");
                    player.sendMessage(Utils.chat("&4&lYou are now visible to other players"));
                } else if (!plugin.invisible_list.contains(player)) {
                    for (Player people : Bukkit.getOnlinePlayers()) {
                        people.hidePlayer(plugin, player);
                    }
                    plugin.invisible_list.add(player);
                    Bukkit.getServer().broadcastMessage(player + "Left the server");
                    player.sendMessage(Utils.chat("&2&lYou are now invisible!"));
                }
            }
        }
        return true;
    }

}


