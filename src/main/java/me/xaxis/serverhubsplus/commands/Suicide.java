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

public class Suicide extends Utils implements CommandExecutor {

    private final ServerHubsPlus instance;

    public Suicide(@NotNull ServerHubsPlus instance){
        super(instance);

        this.instance = instance;
        instance.getCommand("suicide").setExecutor(this);

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(isValid(sender, Perms.SUICIDE)) {

            Player player = (Player) sender;

            if (args.length != 0) {
                message(player, Lang.SUICIDE_MESSAGE);
                return true;
            }

            message(player, Lang.SUICIDE_INCORRECT_USAGE);
            Bukkit.getScheduler().runTaskLater(instance, () -> player.setHealth(0), 60L);
        }
        return true;
    }
}
