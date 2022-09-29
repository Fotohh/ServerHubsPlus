package me.xaxis.serverhubsplus.listeners;

import me.xaxis.serverhubsplus.ServerHubsPlus;
import me.xaxis.serverhubsplus.managers.InvSeeManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class OnInventoryClick implements Listener {

    private final ServerHubsPlus plugin;

    public OnInventoryClick(@NotNull ServerHubsPlus plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event){

        if(!(event.getPlayer() instanceof Player)) return;

        Player player = (Player) event.getPlayer();

        Inventory inventory = event.getInventory();

        if(!InvSeeManager.isPlayerInList(player)) return;

        InvSeeManager invSeeManager = InvSeeManager.getManager(player);

        if(invSeeManager == null) return;

        Player target = invSeeManager.getTarget();

        if(!invSeeManager.getTargetInventory().equals(inventory)){
            target.getInventory().clear();
            target.getInventory().setStorageContents(inventory.getStorageContents());
        }

        invSeeManager.delete(player);
    }

   /* @EventHandler
    public void onInventoryClick(InventoryClickEvent event){

        if(!(event.getWhoClicked() instanceof Player)) return;

        Player player = (Player) event.getWhoClicked();

        if(!InvSeeManager.isPlayerInList(player)) return;

        Inventory i = event.getClickedInventory();

        if(i == null) return;

        if(!InvSeeManager.isPlayerInList(player)) return;

        InvSeeManager invSeeManager = InvSeeManager.getManager(player);

        if(invSeeManager == null) return;

        Player target = invSeeManager.getTarget();

        if(target == null || !target.isOnline()) return;

        if(!invSeeManager.holderEqualsHolder(i.getHolder())) return;

        int slot = event.getSlot();

        ItemStack item = i.getItem(slot);

        if(item == null || item.getType() == Material.AIR) return;

        if(slot < 55){

            //action is putting item into slot

        }else if(slot > 55){

            //action is remove item from slot???

        }


    }*/
}
