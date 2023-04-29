package me.xaxis.serverhubsplus.commands;

import me.xaxis.serverhubsplus.*;
import me.xaxis.serverhubsplus.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Vanish extends Utils implements CommandExecutor {

    private final ServerHubsPlus instance;

    public Vanish(@NotNull ServerHubsPlus instance){
        super(instance);
        this.instance = instance;
        instance.getCommand("vanish").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(isValid(sender)) {

            Player player = (Player) sender;

            if(args.length == 0) {

                if (checkPermission(player, Perms.VANISH)) {

                    vanishPlayer(player);

                    return true;

                }
                return true;

            }else if(args.length == 1) {

                if (checkPermission(player, Perms.VANISH_OTHERS)) {

                    Player target = Bukkit.getPlayer(args[0]);

                    if (!isTargetValid(player, target)) return true;

                    vanishPlayer(target);

                    message(player, Lang.VANISHED_OTHER, target.getDisplayName());

                    return true;

                }

                return true;

            }else{
                message(player, Lang.VANISH_INCORRECT_USAGE);
                return true;
            }

        }

        return true;
    }

    private void vanishPlayer(@NotNull Player player) {

        VanishManager vanishManager;

        if (!VanishManager.containsPlayer(player.getUniqueId())) {
            vanishManager = new VanishManager(instance, player);
        } else {
            vanishManager = VanishManager.getPlayerClass(player.getUniqueId());
        }

        if (!vanishManager.playerVanished()) {
            vanishManager.showPlayer();
            message(player, Lang.UNVANISHED);
        } else {
            vanishManager.hidePlayer();
            message(player, Lang.VANISHED);
        }

    }
}
