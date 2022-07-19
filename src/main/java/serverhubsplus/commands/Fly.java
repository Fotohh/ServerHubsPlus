package serverhubsplus.commands;

import serverhubsplus.ServerHubsPlus;
import serverhubsplus.utils.Utils;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class Fly implements CommandExecutor {
    Plugin plugin = ServerHubsPlus.getPlugin(ServerHubsPlus.class);
    private ArrayList<Player> Flying_Players = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
            if (sender instanceof Player) {
                if (player.hasPermission("fly.use")) {
                    flyMethod(player);
                } else {
                    player.sendMessage(Utils.chat(plugin.getConfig().getString("Messages.no-permission")));
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, .3f, 1.7f);
                }
            }


        return true;
        }


    private void flyMethod(Player player){
            if (Flying_Players.contains(player)) {
                Flying_Players.remove(player);
                player.setAllowFlight(false);
                player.sendMessage(Utils.chat(plugin.getConfig().getString("Messages.fly-disabled")));
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, .3f, 1.7f);
            } else if (!Flying_Players.contains(player)) {
                Flying_Players.add(player);
                player.setAllowFlight(true);
                player.sendMessage(Utils.chat(plugin.getConfig().getString("Messages.on-fly")));
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, .3f, 1.7f);
            }

        }

}
