package me.xaxis.serverhubsplus.listeners;

import me.xaxis.serverhubsplus.Lang;
import me.xaxis.serverhubsplus.Options;
import me.xaxis.serverhubsplus.ServerHubsPlus;
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
    public void customJoinMsg(PlayerJoinEvent e){

        if(!Options.custom_join_messages.toBoolean(instance)) return;

        Player player = e.getPlayer();

        String message = Lang.CUSTOM_JOIN_MESSAGE.toString(instance);

        StringBuilder msg = new StringBuilder(message);

        for(int i = 0; i < message.toCharArray().length; i++){

            char c = message.charAt(i);

            if(c == '%' && message.charAt(i +1) == 'p'){

                msg.deleteCharAt(i + 1);

                msg.deleteCharAt(i);

                msg.insert(i, player.getDisplayName());

                message = msg.toString();

                System.out.println(message);

                e.setJoinMessage(Utils.chat(message));

                return;

            }

        }

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        if(!Options.AUTO_TELEPORT_ON_JOIN.toBoolean(instance)) return;

        Location location = instance.getConfig().getLocation("Locations.Hub");

        if(location == null) return;

        Player player = e.getPlayer();

        player.teleport(location);

        location.getWorld().spawnEntity(location, EntityType.FIREWORK);


    }

}
