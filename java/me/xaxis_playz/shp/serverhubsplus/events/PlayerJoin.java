package me.xaxis_playz.shp.serverhubsplus.events;

import me.xaxis_playz.shp.serverhubsplus.ServerHubsPlus;
import me.xaxis_playz.shp.serverhubsplus.commands.Vanish;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    ServerHubsPlus plugin;

    public PlayerJoin(ServerHubsPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    void onPlayerJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();
        if(player.hasPlayedBefore()) {
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', "&6&lWelcome back " + ChatColor.AQUA + player.getDisplayName() + "&6&l!"));

        }else if(!player.hasPlayedBefore()){
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', "&6&lWelcome to the server " + ChatColor.AQUA + player.getDisplayName() + "&6&l!"));
        }
        for(int i =0; i < plugin.invisible_list.size(); i++){

            player.hidePlayer(plugin, plugin.invisible_list.get(i));

        }





        }



    }













