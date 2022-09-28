package me.xaxis.serverhubsplus.listeners;

import me.xaxis.serverhubsplus.ServerHubsPlus;
import me.xaxis.serverhubsplus.managers.InvSeeManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class OnInventoryClick implements Listener {

    private final ServerHubsPlus plugin;

    public OnInventoryClick(@NotNull ServerHubsPlus plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){

        if(!(event.getWhoClicked() instanceof Player)) return;

        Player player = (Player) event.getWhoClicked();

        Inventory i = event.getClickedInventory();

        String title = event.getView().getTitle();

        Player target = Bukkit.getPlayer(title);

        if(target == null || !target.isOnline()) return;

        if(!InvSeeManager.isPlayerInList(target)) return;

        if (event.getClickedInventory().getType() != InventoryType.CHEST) return;

        

    }
}
