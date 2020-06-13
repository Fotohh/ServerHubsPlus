package me.xaxis_playz.shp.serverhubsplus.commands;

import me.xaxis_playz.shp.serverhubsplus.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Godmode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {

            Player p = (Player) sender;
            if (p.hasPermission("godmode.use")) {
                if (!p.isInvulnerable()) {
                    p.setInvulnerable(true);
                    p.sendMessage(Utils.chat("&6&lYou are now Invulnerable"));
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, .3f, 1.7f);
                } else {
                    p.setInvulnerable(false);
                    p.sendMessage(Utils.chat("&6&lYou are no longer Invulnerable"));
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, .3f, 1.7f);

                }


            }else{
                p.sendMessage(Utils.chat("&4&lYou don't have the required permissions!"));
            }
        }

        return true;
    }
}
