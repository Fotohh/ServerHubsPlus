package me.xaxis.serverhubsplus.commands;

import me.xaxis.serverhubsplus.Lang;
import me.xaxis.serverhubsplus.Perms;
import me.xaxis.serverhubsplus.ServerHubsPlus;
import me.xaxis.serverhubsplus.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Heal implements CommandExecutor {

    private final ServerHubsPlus instance;

    public Heal(@NotNull ServerHubsPlus instance){
        this.instance = instance;
        instance.getCommand("heal").setExecutor(this);
    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(args.length == 1){

                if(isValid(Bukkit.getPlayer(args[0]), Perms.SHP_HEAL_OTHERS)){

                    Player other = Bukkit.getPlayer(args[0]);

                    double maxHealth = other.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();

                    other.setHealth(maxHealth);

                }

            }else if(args.length == 0){

                if(isValid(player, Perms.SHP_HEAL)) {

                    double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();

                    player.setHealth(maxHealth);

                    player.sendMessage(Lang.PREFIX.toString(instance) + "&aSuccessfully reset your health!");

                }

            }


        }else{

            sender.sendMessage(Utils.chat(instance.getConfig().getString(Lang.SENDER_NOT_PLAYER.toString(instance))));

        }


        return true;
    }

    public boolean isValid(@NotNull Player player, @NotNull Perms perms){

        if(!player.isOnline()){

            player.sendMessage(Utils.chat(Lang.INVALID_PLAYER.toString(instance)));

            return false;

        }

        if (!player.hasPermission(perms.ToString())) {

            player.sendMessage(Lang.NO_PERMISSION.toString(instance));

            return false;

        }

        double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();

        if (player.getHealth() == maxHealth) {

            if(perms.equals(Perms.SHP_HEAL)) {
                player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) + "&4You are already at max health!"));
            } else if (perms.equals(Perms.SHP_HEAL_OTHERS)) {
                player.sendMessage(Utils.chat(Lang.PREFIX.toString(instance) + String.format("&6%s &4is already at max health!", player.getDisplayName())));
            }

            return true;

        }

        return true;

    }

}
