package me.xaxis.serverhubsplus.commands;

import me.xaxis.serverhubsplus.Lang;
import me.xaxis.serverhubsplus.ServerHubsPlus;
import me.xaxis.serverhubsplus.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Discord implements CommandExecutor {

    private final ServerHubsPlus plugin;

    public Discord(@NotNull ServerHubsPlus plugin) {
        this.plugin = plugin;
        plugin.getCommand("discord").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(commandSender instanceof Player){

            Player player = (Player) commandSender;

            player.sendMessage(Utils.chat(plugin.getLangConfig().getString(Lang.DISCORD)));

        }else{
            commandSender.sendMessage(Utils.chat(plugin.getLangConfig().getString(Lang.SENDER_NOT_PLAYER)));
        }

        return true;
    }
}
