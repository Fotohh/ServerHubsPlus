package me.xaxis.serverhubsplus.managers;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InvSeeManager {

    private static List<UUID> uuidList = new ArrayList<>();

    public static boolean isPlayerInList(@NotNull Player player){
        return uuidList.contains(player.getUniqueId());
    }
    public static void addPlayer(@NotNull Player player){
        uuidList.add(player.getUniqueId());
    }
    public static void removePlayer(@NotNull Player player){
        uuidList.remove(player.getUniqueId());
    }
}
