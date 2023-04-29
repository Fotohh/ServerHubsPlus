package me.xaxis.serverhubsplus.commands;

import me.xaxis.serverhubsplus.Lang;
import me.xaxis.serverhubsplus.Perms;
import me.xaxis.serverhubsplus.ServerHubsPlus;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class UnlockChat implements CommandExecutor {

    private final ServerHubsPlus plugin;

    public UnlockChat(ServerHubsPlus plugin) {
        this.plugin = plugin;
        plugin.getCommand("unlockchat").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(plugin.getLangConfig().getString(Lang.SENDER_NOT_PLAYER));
            return false;
        }

        Player player = (Player) commandSender;

        if (!player.hasPermission(Perms.LOCK_CHAT.get())) {
            player.sendMessage(plugin.getLangConfig().getString(Lang.NO_PERMISSION));
            return false;
        }

        if (!plugin.getLockChatManager().isChatLocked()) {
            //chat already unlocked
            player.sendMessage(plugin.getLangConfig().getString(Lang.CHAT_ALREADY_UNLOCKED));
            return false;
        } else {
            //chat unlock message
            plugin.getLockChatManager().unlockChat();
            Bukkit.broadcastMessage(plugin.getLangConfig().getString(Lang.CHAT_UNLOCKED, player.getDisplayName()));
            return true;
        }
    }
}
