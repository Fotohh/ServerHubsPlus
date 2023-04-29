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

public class Fly implements CommandExecutor {

    private final ServerHubsPlus instance;
    private final LangConfig lang;

    public Fly(@NotNull ServerHubsPlus instance){

        this.instance = instance;
        instance.getCommand("fly").setExecutor(this);
        this.lang = instance.getLangConfig();

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

                if(args.length == 0){

                    if(!player.hasPermission(Perms.FLY.get())){

                        player.sendMessage(Utils.chat(lang.getString(Lang.PREFIX) + lang.getString(Lang.NO_PERMISSION)));

                        return true;

                    }

                    if(player.getAllowFlight()){

                        player.setAllowFlight(false);

                        player.setFlying(false);

                        player.sendMessage(Utils.chat(lang.getString(Lang.PREFIX) + lang.getString(Lang.FLY_DISABLED)));

                        return true;

                    }

                    player.setAllowFlight(true);

                    player.sendMessage(Utils.chat(lang.getString(Lang.PREFIX) + lang.getString(Lang.FLY_ENABLED)));

                    return true;

                }else if(args.length == 1){

                    if(!player.hasPermission(Perms.FLY_OTHERS.get())){

                        player.sendMessage(Utils.chat(lang.getString(Lang.PREFIX) + lang.getString(Lang.NO_PERMISSION)));

                        return true;

                    }

                    Player target = Bukkit.getPlayer(args[0]);

                    if(target == null || !target.isOnline()){

                        player.sendMessage(Utils.chat(lang.getString(Lang.PREFIX) + lang.getString(Lang.INVALID_PLAYER)));

                        return true;

                    }

                    if(target.getAllowFlight()){

                        player.sendMessage(Utils.chat(lang.getString(Lang.PREFIX) + lang.getString(Lang.FLY_DISABLED_OTHER, target.getDisplayName())));

                        target.setAllowFlight(false);

                        target.setFlying(false);

                        target.sendMessage(Utils.chat(lang.getString(Lang.PREFIX) + lang.getString(Lang.FLY_DISABLED)));

                        return true;
                    }

                    player.sendMessage(Utils.chat(lang.getString(Lang.PREFIX) + lang.getString(Lang.FLY_ENABLED_OTHER, target.getDisplayName())));

                    target.setAllowFlight(true);

                    target.sendMessage(Utils.chat(lang.getString(Lang.PREFIX) + lang.getString(Lang.FLY_ENABLED)));

                    return true;

                }else{

                    player.sendMessage(Utils.chat(lang.getString(Lang.PREFIX) +lang.getString(Lang.FLY_INCORRECT_USAGE)));

                    return true;

                }

        }else{

            sender.sendMessage(Utils.chat(lang.getString(Lang.PREFIX) + lang.getString(Lang.SENDER_NOT_PLAYER)));

            return true;

        }
    }
}
