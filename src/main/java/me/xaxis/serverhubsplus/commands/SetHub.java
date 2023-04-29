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

public class SetHub extends Utils implements CommandExecutor {

    private final ServerHubsPlus instance;

    public SetHub(ServerHubsPlus instance){
        super(instance);
        this.instance = instance;
        instance.getCommand("sethub").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(isValid(sender, Perms.SET_HUB)){

            Player player = (Player) sender;

            if(args.length == 0) {

                instance.getConfig().getConfigurationSection("Locations").set("Hub", player.getLocation());

                instance.saveConfig();

                message(player, Lang.SET_HUB_LOCATION);
                //"&aSuccessfully set hub location!"

            } else if(args.length == 3){

                double x = Double.parseDouble(args[0]);

                double y = Double.parseDouble(args[1]);

                double z = Double.parseDouble(args[2]);

                World world = player.getWorld();

                Location location = new Location(world, x, y, z);

                instance.getConfig().getConfigurationSection("Locations").set("Hub", location);

                instance.saveConfig();

                message(player, Lang.SET_HUB_LOCATION);

            } else {

                message(player, Lang.SET_HUB_INCORRECT_USAGE);
                return true;

            }

        }

        return true;
    }

}
