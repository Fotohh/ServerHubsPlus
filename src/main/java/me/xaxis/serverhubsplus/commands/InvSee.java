package me.xaxis.serverhubsplus.commands;

import me.xaxis.serverhubsplus.Lang;
import me.xaxis.serverhubsplus.Perms;
import me.xaxis.serverhubsplus.ServerHubsPlus;
import me.xaxis.serverhubsplus.file.LangConfig;
import me.xaxis.serverhubsplus.managers.InvSeeManager;
import me.xaxis.serverhubsplus.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class InvSee implements CommandExecutor {

    private final ServerHubsPlus plugin;

    private final LangConfig lang;

    public InvSee(@NotNull ServerHubsPlus plugin) {
        this.plugin = plugin;
        plugin.getCommand("invsee").setExecutor(this);
        lang = plugin.getLangConfig();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String string, @NotNull String[] args) {

        if(sender instanceof Player) {

            Player player = (Player) sender;

            if(!player.hasPermission(Perms.INVSEE.get())){
                player.sendMessage(Utils.chat(lang.getString(Lang.NO_PERMISSION)));
                return true;
            }

            if (args.length == 1) {

                Player target = Bukkit.getPlayer(args[0]);

                if (target == null || !target.isOnline()) {

                    player.sendMessage(Utils.chat(lang.getString(Lang.PREFIX) + lang.getString(Lang.INVALID_PLAYER)));
                    return true;
                }

                openInventory(target, player);

            }else{
                player.sendMessage(Utils.chat(lang.getString(Lang.PREFIX) + lang.getString(Lang.NOT_ENOUGH_ARGS)));
                return true;
            }

        }else{
            sender.sendMessage(Utils.chat(lang.getString(Lang.PREFIX) + lang.getString(Lang.SENDER_NOT_PLAYER)));
            return true;
        }

        return true;
    }

    private void openInventory(@NotNull Player target, @NotNull Player player){

        Inventory i = Bukkit.createInventory(null, InventoryType.CHEST, player.getName());

        i.setContents(target.getInventory().getContents());

        player.openInventory(i);

        InvSeeManager.addPlayer(target);

    }
}
