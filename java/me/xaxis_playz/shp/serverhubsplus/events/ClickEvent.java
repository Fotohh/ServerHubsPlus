package me.xaxis_playz.shp.serverhubsplus.events;

import me.xaxis_playz.shp.serverhubsplus.ServerHubsPlus;
import me.xaxis_playz.shp.serverhubsplus.utils.Utils;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import sun.nio.ch.Util;

public class ClickEvent implements Listener {
    ServerHubsPlus plugin;
    public ClickEvent(ServerHubsPlus plugin) {
        this.plugin = plugin;
    }

    public ClickEvent() {
        return;
    }

    @EventHandler
    public void ClickEvent(InventoryClickEvent e){

            Player player = (Player) e.getWhoClicked();
            if(e.getView().getTitle().equalsIgnoreCase(Utils.chat("&4&lPunish Menu"))) {

                switch (e.getCurrentItem().getType()){
                    case TNT:
                     plugin.openGUI(player);
                        break;
                    case ANVIL:
                        player.closeInventory();
                    player.kickPlayer(Utils.chat("&4&lYou have been Kicked!"));
                        break;
                    case COAL:
                        String mute = plugin.getConfig().getString("Messages.mute");
                        player.sendMessage(Utils.chat(mute));
                        break;






                }


                e.setCancelled(true);
            }
        }
}
