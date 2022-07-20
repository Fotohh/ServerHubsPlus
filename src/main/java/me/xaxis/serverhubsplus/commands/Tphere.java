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

public class Tphere implements CommandExecutor {

    private final ServerHubsPlus instance;

    public Tphere(ServerHubsPlus instance){

        this.instance = instance;
        instance.getCommand("tphere").setExecutor(this);

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(!player.hasPermission(Perms.TPHERE.ToString())){

                player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance)+Lang.NO_PERMISSION.toString(instance)));

                return true;

            }

            if(args.length != 1){

                player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance)+"&4Incorrect Usage! /tphere <player>"));

                return true;

            }

            Player target = Bukkit.getPlayer(args[0]);

            if (target == null || !target.isOnline()) {

                player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance)+Lang.INVALID_PLAYER.toString(instance)));

                return true;

            }

            target.teleport(player.getLocation());

            player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance)+"&aSuccessfully teleported "+target.getDisplayName()+" to your location!"));


        } else {

            sender.sendMessage(Utils.chat(Lang.PREFIX.toString(instance)+Lang.SENDER_NOT_PLAYER.toString(instance)));

            return true;

        }

        return true;
    }
}
