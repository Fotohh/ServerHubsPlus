package me.xaxis.serverhubsplus.managers;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class InvSeeManager {

    private static final Map<UUID, InvSeeManager> uuidList = new HashMap<>();
    private final Inventory playerInventory, targetInventory;
    private final Player target, player;
    private final InventoryHolder targetInventoryHolder;

    public InventoryHolder getTargetInventoryHolder(){
        return this.targetInventoryHolder;
    }

    public Inventory getPlayerInventory() {
        return playerInventory;
    }

    public Player getTarget() {
        return target;
    }

    public Player getViewer() {
        return player;
    }

    public Inventory getTargetInventory() {
        return targetInventory;
    }

    public static InvSeeManager getManager(@NotNull Player player){
        return uuidList.get(player.getUniqueId());
    }

    public boolean holderEqualsHolder(InventoryHolder holder){
        return this.targetInventoryHolder.equals(holder);
    }

    public static boolean isPlayerInList(@NotNull Player player){
        return uuidList.containsKey(player.getUniqueId());
    }

    public InvSeeManager(@NotNull Player player, @NotNull Player target){
        uuidList.put(player.getUniqueId(), this);
        this.player = player;
        this.target = target;
        this.playerInventory = player.getInventory();
        this.targetInventory = target.getInventory();
        this.targetInventoryHolder = target.getInventory().getHolder();
    }

    public void delete(@NotNull Player player){
        uuidList.remove(player.getUniqueId());
    }

}
