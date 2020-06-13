package me.xaxis_playz.shp.serverhubsplus.utils;

import org.bukkit.ChatColor;

public class Chat {

    public static String colorRaw(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
