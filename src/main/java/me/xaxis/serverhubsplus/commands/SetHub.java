package me.xaxis.serverhubsplus.commands;

import me.xaxis.serverhubsplus.Lang;
import me.xaxis.serverhubsplus.Perms;
import me.xaxis.serverhubsplus.ServerHubsPlus;
import me.xaxis.serverhubsplus.utils.Utils;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetHub implements CommandExecutor {

    private final ServerHubsPlus instance;

    public SetHub(ServerHubsPlus instance){
        this.instance = instance;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            if (!player.hasPermission(Perms.SET_HUB.ToString())) {

                player.hasPermission(Utils.chat(Lang.PREFIX.toString(instance) + Lang.NO_PERMISSION.toString(instance)));

                return true;

            }

            if(args.length == 0) {

                instance.getConfig().getConfigurationSection("Locations").set("Hub", player.getLocation());

                instance.saveConfig();

                player.sendMessage(Utils.chat("&aSuccessfully set hub location!"));

            } else if(args.length == 3){

                double x = Double.parseDouble(args[0]);

                double y = Double.parseDouble(args[1]);

                double z = Double.parseDouble(args[2]);

                World world = player.getWorld();

                Location location = new Location(world, x, y, z);

                instance.getConfig().getConfigurationSection("Locations").set("Hub", location);

                instance.saveConfig();

                player.sendMessage(Utils.chat("&aSuccessfully set hub location!"));

            } else if(args.length == 2 || args.length > 3){

                player.sendMessage(Utils.chat("&4Incorrect Usage! /sethub x y z"));

            }

        }else{

            sender.sendMessage(Utils.chat(Lang.SENDER_NOT_PLAYER.toString(instance)));

            return true;

        }

        return true;
    }

}
