package me.xaxis.serverhubsplus;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class VanishManager {

    private final ServerHubsPlus instance;

    private final Player player;

    private boolean vanished = false;

    private static final List<Player> vanishList = new ArrayList<>();

    private static final Map<UUID, VanishManager> managerMap = new HashMap<>();

    public VanishManager(ServerHubsPlus instance, @NotNull Player player){
        this.instance = instance;
        this.player = player;
        managerMap.put(player.getUniqueId(), this);
    }

    public static List<Player> getVanishList(){
        return vanishList;
    }

    public static boolean containsPlayer(UUID playerUUID){
        return managerMap.containsKey(playerUUID);
    }

    public static VanishManager getPlayerClass(UUID playerUUID){
        return managerMap.get(playerUUID);
    }

    public boolean playerVanished(){
        return vanished;
    }

    public void hideFromPlayer(@NotNull Player target){
        target.hidePlayer(instance, player);
    }

    public void showPlayer(){
        for(Player others : Bukkit.getServer().getOnlinePlayers()){

            if(others.hasPermission(Perms.VANISH_SEE.ToString())) return;

            others.showPlayer(instance, player);
        }

        player.setCanPickupItems(true);
        vanished = false;
        vanishList.remove(player);
    }

    public void hidePlayer(){
        for(Player others : Bukkit.getServer().getOnlinePlayers()){

            if(others.hasPermission(Perms.VANISH_SEE.ToString())) return;

            others.hidePlayer(instance, player);
        }

        player.setCanPickupItems(false);
        vanished = true;
        vanishList.add(player);
    }


}
