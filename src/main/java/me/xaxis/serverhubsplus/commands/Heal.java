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

public class Heal extends Utils implements CommandExecutor {

    private final ServerHubsPlus instance;

    public Heal(@NotNull ServerHubsPlus instance){
        super(instance);
        this.instance = instance;
        instance.getCommand("heal").setExecutor(this);
    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(args.length == 1){

                if(isTargetValid(Bukkit.getPlayer(args[0]),player) && checkPermission(player, Perms.SHP_HEAL_OTHERS)){

                    Player other = Bukkit.getPlayer(args[0]);

                    double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();

                    if (other.getHealth() == maxHealth) {
                        message(player, Lang.HEALTH_OTHER_MAX, other.getDisplayName());
                        return false;
                    }

                    other.setHealth(maxHealth);
                    message(other, Lang.HEAL);
                    message(player, Lang.HEAL_OTHER, other.getDisplayName());

                    return true;

                }

            }else if(args.length == 0){

                if(isValid(player, Perms.SHP_HEAL)) {

                    double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();

                    if(player.getHealth() == maxHealth) {
                        message(player, Lang.HEALTH_MAX);
                        return false;
                    }

                    player.setHealth(maxHealth);

                    message(player, Lang.HEAL);

                    return true;

                }

            } else{
                message(player, Lang.HEAL_INCORRECT_USAGE);
            }


        }else{
            message(sender, Lang.SENDER_NOT_PLAYER);
        }
        return true;
    }

}
