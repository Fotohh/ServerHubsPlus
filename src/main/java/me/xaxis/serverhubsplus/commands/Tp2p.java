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

public class Tp2p extends Utils implements CommandExecutor {

    private final ServerHubsPlus instance;

    public Tp2p(@NotNull ServerHubsPlus instance) {
        super(instance);
        this.instance = instance;
        instance.getCommand("tp2p").setExecutor(this);
    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (isValid(sender, Perms.TP2P)) {

            Player player = (Player) sender;

            if (args.length != 1) {
                message(player, Lang.TP2P_INCORRECT_USAGE);
                return true;
            }

            Player target = Bukkit.getPlayer(args[0]);

            if (!isTargetValid(player, target)) return true;

            player.teleport(target.getLocation());

            message(player, Lang.TP2P_MESSAGE, target.getDisplayName());

            return true;

        }
        return true;
    }
}
