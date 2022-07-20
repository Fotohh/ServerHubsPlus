package me.xaxis.serverhubsplus.listeners;

import me.xaxis.serverhubsplus.Options;
import me.xaxis.serverhubsplus.ServerHubsPlus;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

public class OnJoin implements Listener {

    private final ServerHubsPlus instance;

    public OnJoin(@NotNull ServerHubsPlus instance) {
        this.instance = instance;
        instance.getServer().getPluginManager().registerEvents(this, instance);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        if(!Options.AUTO_TELEPORT_ON_JOIN.toBoolean(instance)) return;

        Location location = instance.getConfig().getLocation("Locations.Hub");

        Player player = e.getPlayer();

        player.teleport(location);

        location.getWorld().spawnEntity(location, EntityType.FIREWORK);


    }

}
