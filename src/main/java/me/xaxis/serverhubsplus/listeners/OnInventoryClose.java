package me.xaxis.serverhubsplus.listeners;

import me.xaxis.serverhubsplus.ServerHubsPlus;
import me.xaxis.serverhubsplus.managers.InvSeeManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class OnInventoryClose implements Listener {

    private final ServerHubsPlus plugin;

    public OnInventoryClose(@NotNull ServerHubsPlus plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerInventoryClose(InventoryCloseEvent event){

        if(!(event.getPlayer() instanceof Player)) return;

        Player player = (Player) event.getPlayer();

        Inventory inventory = event.getInventory();

        String title = event.getView().getTitle();

        Player target = Bukkit.getPlayer(title);

        if(target == null || !target.isOnline()) return;

        if(!InvSeeManager.isPlayerInList(target)) return;

        if (inventory.getType() != InventoryType.CHEST) return;

        target.getInventory().setContents(inventory.getContents());

    }
}
