package me.xaxis.serverhubsplus.commands;

import me.xaxis.serverhubsplus.ServerHubsPlus;
import me.xaxis.serverhubsplus.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Heal implements CommandExecutor {

    private final ServerHubsPlus instance;

    public Heal(ServerHubsPlus instance){
        this.instance = instance;


    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player player){

        }else{
            sender.sendMessage(Utils.chat(instance.getConfig().getString("")));
        }


        return true;
    }
}
