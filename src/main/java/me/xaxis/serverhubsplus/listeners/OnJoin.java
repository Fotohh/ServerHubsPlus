package me.xaxis.serverhubsplus.listeners;

import me.xaxis.serverhubsplus.*;
import me.xaxis.serverhubsplus.utils.Utils;
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
    public void customJoinMsg(PlayerJoinEvent e) {

        if (!Options.custom_join_messages.toBoolean(instance)) return;

        Player player = e.getPlayer();

        String message = instance.getLangConfig().getString(Lang.CUSTOM_JOIN_MESSAGE, player.getDisplayName());

        e.setJoinMessage(message);

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        if(Options.AUTO_TELEPORT_ON_JOIN.toBoolean(instance)) {

            Location location = instance.getConfig().getLocation("Locations.Hub");

            if (location == null) return;

            Player player = e.getPlayer();

            player.teleport(location);

            location.getWorld().spawnEntity(location, EntityType.FIREWORK);

        }

        if(Options.Vanish.toBoolean(instance)) {

            Player other = e.getPlayer();

            if(other.hasPermission(Perms.VANISH_SEE.get())) return;

            for(Player player : VanishManager.getVanishList()){

                VanishManager manager = VanishManager.getPlayerClass(player.getUniqueId());

                manager.hideFromPlayer(other);

            }

        }

    }

}
