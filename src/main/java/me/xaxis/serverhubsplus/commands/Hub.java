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
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            Location location = instance.getConfig().getLocation("Locations.Hub");

            player.teleport(location);

            location.getWorld().spawnEntity(location, EntityType.FIREWORK);


        }else{
            sender.sendMessage(Utils.chat(Lang.SENDER_NOT_PLAYER.toString(instance)));
        }

        return true;
    }
}
