package me.xaxis_playz.shp.serverhubsplus.commands;

import me.xaxis_playz.shp.serverhubsplus.RTPsupport.TeleportUtils;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class RandomTP implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            if(sender instanceof Player){
                Player p = (Player) sender;


                p.teleport(TeleportUtils.generateLocation(p));


            }





        return true;
    }
}

