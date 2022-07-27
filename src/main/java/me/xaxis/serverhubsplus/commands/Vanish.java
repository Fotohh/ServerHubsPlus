package me.xaxis.serverhubsplus.commands;

import me.xaxis.serverhubsplus.*;
import me.xaxis.serverhubsplus.utils.Utils;
import org.bukkit.Bukkit;
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

        if(sender instanceof Player) {

            Player player = (Player) sender;

            if(args.length == 0) {

                if (player.hasPermission(Perms.VANISH.ToString())) {

                    vanishPlayer(player);

                    return true;

                }

                player.sendMessage(Utils.chat(Lang.NO_PERMISSION.toString(instance)));

                return true;

            }else if(args.length == 1) {

                if (player.hasPermission(Perms.VANISH_OTHERS.ToString())) {


                    Player target = Bukkit.getPlayer(args[0]);

                    if (target != null && target.isOnline()) {

                        vanishPlayer(player);

                        return true;
                    }

                    player.sendMessage(Utils.chat(Lang.INVALID_PLAYER.toString(instance)));

                    return true;

                }

                player.sendMessage(Utils.chat(Lang.NO_PERMISSION.toString(instance)));

                return true;

            }else{
                player.sendMessage(Utils.chat("&4Invalid Usage! /vanish or /vanish <player>"));
                return true;
            }

        }
            sender.sendMessage(Utils.chat(Lang.SENDER_NOT_PLAYER.toString(instance)));

        return true;
    }

    private void vanishPlayer(@NotNull Player player) {

        VanishManager vanishManager;

        if (!VanishManager.containsPlayer(player.getUniqueId())) {
            vanishManager = new VanishManager(instance, player);
        } else {
            vanishManager = VanishManager.getPlayerClass(player.getUniqueId());
        }

        if (vanishManager.playerVanished()) {
            vanishManager.showPlayer();
            player.sendMessage(Utils.chat(Lang.UNVANISHED.toString(instance)));
        } else {
            vanishManager.hidePlayer();
            player.sendMessage(Utils.chat(Lang.VANISHED.toString(instance)));
        }

    }
}
