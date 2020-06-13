package me.xaxis_playz.shp.serverhubsplus.commands;

import me.xaxis_playz.shp.serverhubsplus.utils.Utils;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Help implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, .3f, 1.7f);
            p.sendMessage(Utils.chat("&l&m&7I-----------I---------I"));
            p.sendMessage(Utils.chat("       &6Commands:    "));
            p.sendMessage(Utils.chat("        &4/suicide    "));
            p.sendMessage(Utils.chat("        &2/godmode    "));
            p.sendMessage(Utils.chat("        &2/gui        "));
            p.sendMessage(Utils.chat("        &2/help       "));
            p.sendMessage(Utils.chat("        &2/heal       "));
            p.sendMessage(Utils.chat("        &1/discord    "));
            p.sendMessage(Utils.chat("        &2/fly        "));
            p.sendMessage(Utils.chat("        &2/feed       "));
            p.sendMessage(Utils.chat("     &4/punishGUI     "));
            p.sendMessage(Utils.chat("     &6/shvanish      "));
            p.sendMessage(Utils.chat("     &2/shreload      "));
            p.sendMessage(Utils.chat("        &b/rtp        "));
            p.sendMessage(Utils.chat("&l&m&7I----------I---------I"));






        }





        return true;
    }
}
