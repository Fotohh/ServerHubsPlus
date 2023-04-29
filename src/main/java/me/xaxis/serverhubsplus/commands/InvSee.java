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
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class InvSee extends Utils implements CommandExecutor {

    private final ServerHubsPlus plugin;

    private final LangConfig lang;

    public InvSee(@NotNull ServerHubsPlus plugin) {
        super(plugin);
        this.plugin = plugin;
        plugin.getCommand("invsee").setExecutor(this);
        lang = plugin.getLangConfig();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String string, @NotNull String[] args) {

        if(isValid(sender, Perms.INVSEE)) {

            Player player = (Player) sender;

            if (args.length == 1) {

                Player target = Bukkit.getPlayer(args[0]);

                if(!isTargetValid(player,target)) return true;

                openInventory(target, player);

            }else{
                message(player,Lang.NOT_ENOUGH_ARGS);
                return true;
            }
        }
        return true;
    }

    private void openInventory(@NotNull Player target, @NotNull Player player){

        Inventory i = Bukkit.createInventory(target, target.getInventory().getStorageContents().length, player.getName());

        i.setContents(target.getInventory().getStorageContents());

        player.openInventory(i);

        new InvSeeManager(player, target);

    }
}
