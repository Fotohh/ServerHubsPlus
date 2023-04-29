package me.xaxis.serverhubsplus.utils;

import me.xaxis.serverhubsplus.Lang;
import me.xaxis.serverhubsplus.Perms;
import me.xaxis.serverhubsplus.ServerHubsPlus;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Utils {

    private final ServerHubsPlus plugin;

    public Utils(ServerHubsPlus plugin){
        this.plugin = plugin;
    }

    public static String chat(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    /**
     * Send message with prefix
     * @param player the target to send the message to
     * @param path the message path from the lang config
     */
    public void message(Player player, Lang path){
        player.sendMessage(plugin.getLangConfig().getString(Lang.PREFIX)+plugin.getLangConfig().getString(path));
    }

    /**
     * Send message with prefix
     * @param player the target to send the message to
     * @param path the message path from the lang config
     * @param placeholders the placeholders you want to set
     */
    public void message(Player player, Lang path, Object... placeholders){
        player.sendMessage(plugin.getLangConfig().getString(Lang.PREFIX)+plugin.getLangConfig().getString(path, placeholders));
    }

    /**
     * Send a message without the prefix added before the message
     * @param path the path to the message
     * @param player the player to send the message to
     */
    public void message(Lang path, Player player){
        player.sendMessage(plugin.getLangConfig().getString(path));
    }

    /**
     *
     * @param player the target to check
     * @param perms perms to check
     * @return true if player has perms, false if not
     */
    public boolean checkPermission(@NotNull Player player, Perms... perms) {
        if(perms != null && perms.length > 0) {
            for (Perms perm : perms) {
                if (perm != null && !player.hasPermission(perm.get())) {
                    message(player, Lang.NO_PERMISSION);
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *
     * @param sender the target to check
     * @return true if sender is valid, false if not
     */
    public boolean isValid(@NotNull CommandSender sender){

        if(!(sender instanceof Player)){
            message(sender, Lang.SENDER_NOT_PLAYER);
            return false;
        }

        return true;
    }

    /**
     *
     * @param sender the target to check
     * @param perms perms to check
     * @return true if sender is valid, false if not
     */
    public boolean isValid(@NotNull CommandSender sender, Perms... perms){

        if(!(sender instanceof Player)){
            message(sender, Lang.SENDER_NOT_PLAYER);
            return false;
        }

        Player player = (Player) sender;

        return checkPermission(player, perms);
    }

    /**
     * Checks if target is valid
     * @param player the player to send a message to if the player is invalid
     * @param target the target to check
     * @return true if valid, false if not
     */
    public boolean isTargetValid(Player player,Player target){

        if(target == null || !target.isOnline()){
            message(player, Lang.INVALID_PLAYER);
            return false;
        }
        return true;
    }

    /**
     * Same thing as {@link #isTargetValid(Player, Player)} except for the fact that
     * it does not send a message.
     * @param target the target to check
     * @return true if valid, false if not
     */
    public boolean isTargetValid(Player target){
        return target != null && target.isOnline();
    }

    /**
     * Send message with prefix
     * @param sender the target to send the message to
     * @param path the message path from the lang config
     * @return the message with the prefix in front of it
     */
    public void message(CommandSender sender, Lang path){
        sender.sendMessage(plugin.getLangConfig().getString(Lang.PREFIX)+plugin.getLangConfig().getString(path));
    }

}
