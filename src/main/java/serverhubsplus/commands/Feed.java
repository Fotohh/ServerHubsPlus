package serverhubsplus.commands;

import serverhubsplus.utils.Utils;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {

            Player p = (Player) sender;
            if (p.hasPermission("feed.use")) {
                p.setFoodLevel(20);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, .3f, 1.7f);
                p.sendMessage(Utils.chat("&2&lFood Level Succesfully Filled"));
            }else {
                p.sendMessage(Utils.chat("&4&lYou don't have the required permissions!"));
            }
            } else {
                System.out.println("Only players may execute this command");
            }
        return true;
        }









    }

