package me.xaxis_playz.shp.serverhubsplus.events;

import me.xaxis_playz.shp.serverhubsplus.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class OnDeath implements Listener {
        @EventHandler
        public void onDeath (PlayerDeathEvent e){
            e.setDeathMessage(null);
        }



}
