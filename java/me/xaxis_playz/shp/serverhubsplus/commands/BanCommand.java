package me.xaxis_playz.shp.serverhubsplus.commands;

import me.xaxis_playz.shp.serverhubsplus.ServerHubsPlus;
import me.xaxis_playz.shp.serverhubsplus.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanCommand implements CommandExecutor {

    ServerHubsPlus plugin;

    public BanCommand(ServerHubsPlus plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof  Player) {
        Player player = (Player) sender;
        if(player.hasPermission("bangui.use")) {
            plugin.openGUI(player);
        }else{
            player.sendMessage(Utils.chat("&4&lYou do not have the required permissions!"));
        }


    }
        return true;
}








































}
