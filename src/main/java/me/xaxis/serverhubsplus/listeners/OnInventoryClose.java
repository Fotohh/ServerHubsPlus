package me.xaxis.serverhubsplus.listeners;

import me.xaxis.serverhubsplus.ServerHubsPlus;
import me.xaxis.serverhubsplus.managers.InvSeeManager;
import me.xaxis.serverhubsplus.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class OnInventoryClose extends Utils implements Listener {


    public OnInventoryClose(@NotNull ServerHubsPlus plugin) {
        super(plugin);
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerInventoryClose(InventoryCloseEvent event){

        if(!(event.getPlayer() instanceof Player)) return;

        Player player = (Player) event.getPlayer();

        Inventory inventory = event.getInventory();

        if(!InvSeeManager.isPlayerInList(player)) return;

        InvSeeManager manager = InvSeeManager.getManager(player);

        manager.getTargetInventory().setContents(inventory.getContents());

        manager.delete(player);

    }
}
