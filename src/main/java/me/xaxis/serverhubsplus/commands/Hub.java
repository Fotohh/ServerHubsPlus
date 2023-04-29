package me.xaxis.serverhubsplus.commands;

import me.xaxis.serverhubsplus.Lang;
import me.xaxis.serverhubsplus.ServerHubsPlus;
import me.xaxis.serverhubsplus.utils.Utils;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Hub extends Utils implements CommandExecutor {

    private final ServerHubsPlus instance;

    public Hub(ServerHubsPlus instance){
        super(instance);
        this.instance = instance;
        instance.getCommand("hub").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(isValid(sender)){

            Player player = (Player) sender;

            Location location = instance.getConfig().getLocation("Locations.Hub");

            if(location == null){

                message(player, Lang.NO_HUB_LOCATION);
                return true;

            }

            if(location.getWorld() == null) return true;

            player.teleport(location);

            location.getWorld().spawnEntity(location, EntityType.FIREWORK);

            message(player, Lang.TELEPORTED_TO_HUB);

        }
        return true;
    }
}
