package me.xaxis.serverhubsplus.commands;

import me.xaxis.serverhubsplus.Lang;
import me.xaxis.serverhubsplus.Perms;
import me.xaxis.serverhubsplus.ServerHubsPlus;
import me.xaxis.serverhubsplus.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Fly implements CommandExecutor {

    private final ServerHubsPlus instance;

    public Fly(@NotNull ServerHubsPlus instance){

        this.instance = instance;
        instance.getCommand("fly").setExecutor(this);

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

                if(args.length == 0){

                    if(!player.hasPermission(Perms.FLY.ToString())){

                        player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) +Lang.NO_PERMISSION));

                        return true;

                    }

                    if(player.getAllowFlight()){

                        player.setAllowFlight(false);

                        player.setFlying(false);

                        player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) +"&4Flight mode was disabled!"));

                        return true;

                    }

                    player.setAllowFlight(true);

                    player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) +"&aFlight mode was enabled!"));

                    return true;

                }else if(args.length == 1){

                    if(!player.hasPermission(Perms.FLY_OTHERS.ToString())){

                        player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) +Lang.NO_PERMISSION));

                        return true;

                    }

                    Player target = Bukkit.getPlayer(args[0]);

                    if(target == null || !target.isOnline()){

                        player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) +Lang.INVALID_PLAYER.toString(instance)));

                        return true;

                    }

                    if(target.getAllowFlight()){

                        player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) +"&4Disabled flight mode for " + target.getDisplayName() +"!"));

                        target.setAllowFlight(false);

                        target.setFlying(false);

                        target.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) +"&4Flight mode was disabled!"));

                        return true;
                    }

                    player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) +"&aSuccessfully enabled flight mode for "+target.getDisplayName()+"!"));

                    target.setAllowFlight(true);

                    target.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) +"&aFlight mode was enabled!"));

                    return true;

                }else{

                    player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) +"&4Invalid Usage! /fly or /fly <player>"));

                    return true;

                }

        }else{

            sender.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) +Lang.SENDER_NOT_PLAYER.toString(instance)));

            return true;

        }
    }
}
