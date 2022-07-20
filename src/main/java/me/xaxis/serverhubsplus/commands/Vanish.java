package me.xaxis.serverhubsplus.commands;

import me.xaxis.serverhubsplus.Lang;
import me.xaxis.serverhubsplus.ServerHubsPlus;
import me.xaxis.serverhubsplus.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Vanish implements CommandExecutor {

    private final ServerHubsPlus instance;

    public Vanish(@NotNull ServerHubsPlus instance){
        this.instance = instance;
        instance.getCommand("vanish").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

        } else {
            sender.sendMessage(Utils.chat(Lang.SENDER_NOT_PLAYER.toString(instance)));
            return true;
        }

        return true;
    }
}
