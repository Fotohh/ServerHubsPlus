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

public class GodMode implements CommandExecutor {

    private final ServerHubsPlus instance;

    public GodMode(@NotNull ServerHubsPlus instance){

        this.instance = instance;
        instance.getCommand("godmode").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(args.length == 0) {

                if (!player.hasPermission(Perms.FLY.ToString())) {

                    player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) + Lang.NO_PERMISSION.toString(instance)));

                    return true;

                }

                if(player.isInvulnerable()){

                    player.setInvulnerable(false);

                    player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) + "&4You are now vulnerable!"));

                }else {

                    player.setInvulnerable(true);

                    player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) + "&4You are now invulnerable!"));

                }

                return true;

            }else if(args.length == 1){

                if (!player.hasPermission(Perms.FLY_OTHERS.ToString())) {

                    player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) + Lang.NO_PERMISSION.toString(instance)));

                    return true;

                }

                Player target = Bukkit.getPlayer(args[0]);

                if(target == null || !target.isOnline()){

                    player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) +Lang.INVALID_PLAYER.toString(instance)));

                    return true;

                }

                if(target.isInvulnerable()){

                    target.setInvulnerable(false);

                    player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) + "&4Set " + player.getDisplayName() + " to vulnerable!"));

                    target.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) + "&4You are now vulnerable!"));

                }else{

                    target.setInvulnerable(true);

                    player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) + "&4Set " + player.getDisplayName() + " to invulnerable!"));

                    target.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) + "&4You are now invulnerable!"));

                }

                return true;

            }

        } else{

            sender.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) +Lang.SENDER_NOT_PLAYER.toString(instance)));

            return true;

        }

        return true;
    }
}
