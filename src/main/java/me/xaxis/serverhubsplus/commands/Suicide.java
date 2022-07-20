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

public class Suicide implements CommandExecutor {

    private final ServerHubsPlus instance;

    public Suicide(@NotNull ServerHubsPlus instance){

        this.instance = instance;
        instance.getCommand("suicide").setExecutor(this);

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(args.length != 0){

                player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance)+"&4Incorrect Usage! /suicide"));

                return true;

            }

            if(player.hasPermission(Perms.SUICIDE.toString())){

                player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance)+"&4You will die in 3 seconds..."));

                Bukkit.getScheduler().runTaskLater(instance, ()-> player.setHealth(0), 60L);

            } else{

                player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance)+Lang.NO_PERMISSION.toString(instance)));

                return true;

            }


        } else{

            sender.sendMessage(Utils.chat(Lang.PREFIX.toString(instance)+Lang.SENDER_NOT_PLAYER.toString(instance)));

            return true;

        }

        return true;
    }
}
