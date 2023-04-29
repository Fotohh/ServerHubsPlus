package me.xaxis.serverhubsplus.commands;

import me.xaxis.serverhubsplus.Lang;
import me.xaxis.serverhubsplus.Perms;
import me.xaxis.serverhubsplus.ServerHubsPlus;
import me.xaxis.serverhubsplus.file.LangConfig;
import me.xaxis.serverhubsplus.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GodMode extends Utils implements CommandExecutor{

    public GodMode(@NotNull ServerHubsPlus instance){
        super(instance);

        instance.getCommand("godmode").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(args.length == 0) {

                if (!player.hasPermission(Perms.FLY.get())) {

                    message(player, Lang.NO_PERMISSION);

                    return true;

                }

                if(player.isInvulnerable()){

                    player.setInvulnerable(false);

                    message(player, Lang.VULNERABLE);
                    //"&4You are now vulnerable!"

                }else {

                    player.setInvulnerable(true);

                    message(player, Lang.INVULNERABLE);
                    //"&4You are now invulnerable!"

                }

                return true;

            }else if(args.length == 1){

                if (!player.hasPermission(Perms.FLY_OTHERS.get())) {

                    message(player, Lang.NO_PERMISSION);

                    return true;

                }

                Player target = Bukkit.getPlayer(args[0]);

                if(target == null || !target.isOnline()){

                    message(player, Lang.INVALID_PLAYER);

                    return true;

                }

                if(target.isInvulnerable()){

                    target.setInvulnerable(false);

                    message(player, Lang.OTHER_VULNERABLE, target.getDisplayName());
                    //"&4Set " + player.getDisplayName() + " to vulnerable!"

                    message(target, Lang.VULNERABLE);
                    //"&4You are now vulnerable!"

                }else{

                    target.setInvulnerable(true);

                    message(player, Lang.OTHER_INVULNERABLE, target.getDisplayName());

                    message(target, Lang.INVULNERABLE);

                }

                return true;

            }

        } else{

            message(sender, Lang.SENDER_NOT_PLAYER);

            return true;

        }

        return true;
    }
}
