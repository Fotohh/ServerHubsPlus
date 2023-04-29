package me.xaxis.serverhubsplus.commands;

import me.xaxis.serverhubsplus.Lang;
import me.xaxis.serverhubsplus.Perms;
import me.xaxis.serverhubsplus.ServerHubsPlus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class LockChat implements CommandExecutor {

    private final ServerHubsPlus plugin;

    public LockChat(ServerHubsPlus plugin) {
        this.plugin = plugin;
        plugin.getCommand("lockchat").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (!(commandSender instanceof Player)) {
            //sender not player
            commandSender.sendMessage(plugin.getLangConfig().getString(Lang.SENDER_NOT_PLAYER));
            return false;
        }

        Player player = (Player) commandSender;

        if(!player.hasPermission(Perms.LOCK_CHAT.get())){
            //no perms
            player.sendMessage(plugin.getLangConfig().getString(Lang.SENDER_NOT_PLAYER));
            return false;
        }

        if (plugin.getLockChatManager().isChatLocked()) {
            //chat already locked
            player.sendMessage(plugin.getLangConfig().getString(Lang.CHAT_ALREADY_LOCKED));
            return false;
        } else {
            //chat lock message
            Bukkit.broadcastMessage(plugin.getLangConfig().getString(Lang.CHAT_LOCKED,player.getDisplayName()));
            plugin.getLockChatManager().lockChat();
            return true;
        }

    }
}
