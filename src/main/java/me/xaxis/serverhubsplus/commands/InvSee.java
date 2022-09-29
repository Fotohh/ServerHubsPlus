package me.xaxis.serverhubsplus.commands;

import me.xaxis.serverhubsplus.Lang;
import me.xaxis.serverhubsplus.Perms;
import me.xaxis.serverhubsplus.ServerHubsPlus;
import me.xaxis.serverhubsplus.managers.InvSeeManager;
import me.xaxis.serverhubsplus.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class InvSee implements CommandExecutor {

    private final ServerHubsPlus plugin;

    public InvSee(@NotNull ServerHubsPlus plugin) {
        this.plugin = plugin;
        plugin.getCommand("invsee").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String string, @NotNull String[] args) {

        if(sender instanceof Player) {

            Player player = (Player) sender;

            if(!player.hasPermission(Perms.INVSEE.ToString())){
                player.sendMessage(Utils.chat(Lang.NO_PERMISSION.toString(plugin)));
                return true;
            }

            if (args.length == 1) {

                Player target = Bukkit.getPlayer(args[0]);

                if (target == null || !target.isOnline()) {

                    player.sendMessage(Utils.chat(Lang.PREFIX.toString(plugin) + Lang.INVALID_PLAYER.toString(plugin)));
                    return true;
                }

                openInventory(target, player);

            }else{
                player.sendMessage(Utils.chat(Lang.PREFIX.toString(plugin) + Lang.NOT_ENOUGH_ARGS.toString(plugin)));
                return true;
            }

        }else{
            sender.sendMessage(Utils.chat(Lang.PREFIX.toString(plugin) + Lang.SENDER_NOT_PLAYER.toString(plugin)));
            return true;
        }

        return true;
    }

    private void openInventory(@NotNull Player target, @NotNull Player player){

        Inventory i = Bukkit.createInventory(target, target.getInventory().getStorageContents().length, player.getName());

        i.setContents(target.getInventory().getStorageContents());

        player.openInventory(i);

        InvSeeManager invSeeManager = new InvSeeManager(player, target);

    }
}
