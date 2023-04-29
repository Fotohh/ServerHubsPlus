package me.xaxis.serverhubsplus.managers;

import me.xaxis.serverhubsplus.Lang;
import me.xaxis.serverhubsplus.Perms;
import me.xaxis.serverhubsplus.ServerHubsPlus;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class LockChatManager implements Listener {
    private final ServerHubsPlus plugin;

    public LockChatManager(ServerHubsPlus plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    private boolean chatLocked;

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if(event.getPlayer().hasPermission(Perms.CHATLOCK_BYPASS.get())){
            return;
        }
        if (chatLocked) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(plugin.getLangConfig().getString(Lang.CANT_CHAT_IS_LOCKED));
        }
    }

    public boolean isChatLocked() {
        return chatLocked;
    }

    public void lockChat(){
        chatLocked = true;
    }
    public void unlockChat(){
        chatLocked = false;
    }
}
