package me.xaxis_playz.shp.serverhubsplus.events;

import me.xaxis_playz.shp.serverhubsplus.ServerHubsPlus;
import me.xaxis_playz.shp.serverhubsplus.utils.Utils;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Date;

public class banInventoryEvents implements Listener {


    ServerHubsPlus plugin;


    public banInventoryEvents(ServerHubsPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        Player whoToBan = player.getServer().getPlayer(e.getCurrentItem().getItemMeta().getDisplayName());


        if (e.getView().getTitle().equalsIgnoreCase(Utils.chat("&dPlayer List"))){
            if(e.getCurrentItem().getType() == Material.PLAYER_HEAD){
                plugin.openConfirmMenu(player, whoToBan);



            }

        }else if(e.getView().getTitle().equalsIgnoreCase(Utils.chat("&4Punish This Player?"))){
            switch (e.getCurrentItem().getType()){
                case WOODEN_AXE:
                    String name = e.getClickedInventory().getItem(4).getItemMeta().getDisplayName();
                    player.getServer().getBanList(BanList.Type.NAME).addBan(name, Utils.chat("&4You have been struck by the ban hammer " + "&aBan Time: &4&oPermanently" ), null, player.getDisplayName());
                    player.sendMessage(Utils.chat("&2You successfully banned: &4" + name));
                    player.closeInventory();
                    Bukkit.getServer().broadcastMessage(Utils.chat(name + "&4&lHas been struck by the ban hammer"));
                break;

                case BARRIER:
                    plugin.openGUI(player);
                break;
                case PLAYER_HEAD:
                    plugin.openConfirmMenu(player, whoToBan);
                case COAL:
                    String Name = e.getClickedInventory().getItem(4).getItemMeta().getDisplayName();
                    Bukkit.getPlayer(Name).kickPlayer(Utils.chat("&a&l" + Name + " &4&lHas been kicked!"));
                    Bukkit.getServer().broadcastMessage(Utils.chat(Name + "&4&l Was kicked from the game " ));

                break;

            }
        }



    }

}
