package me.xaxis_playz.shp.serverhubsplus.commands;

import me.xaxis_playz.shp.serverhubsplus.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("heal")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("heal.use")) {
                    if (p.getHealth() == 20.0) {
                        p.sendMessage(Utils.chat("&4&lYou already have full health!"));

                    } else {
                        p.sendMessage(Utils.chat("&a&lYou are going to be healed..."));
                        p.setHealth(20);
                    }
                }else{
                    p.sendMessage(Utils.chat("&4&lYou don't have the required permissions!"));
                }
            }
            } else {
                System.out.println("&4&lOnly players can execute this command!");

            }
            return true;
        }
}
