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

public class Hub implements CommandExecutor {

    private final ServerHubsPlus instance;

    public Hub(ServerHubsPlus instance){
        this.instance = instance;
        instance.getCommand("hub").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            Location location = instance.getConfig().getLocation("Locations.Hub");

            if(location == null){

                player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) + "&4Huh... that's odd... no hub location was set!"));

                return true;

            }

            player.teleport(location);

            if(location.getWorld() == null) return true;

            location.getWorld().spawnEntity(location, EntityType.FIREWORK);

            player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) + "&aSuccessfully teleported to hub!"));


        }else{
            sender.sendMessage(Utils.chat(Lang.SENDER_NOT_PLAYER.toString(instance)));
        }

        return true;
    }
}
