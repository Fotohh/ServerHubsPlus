package me.xaxis.serverhubsplus;

import me.xaxis.serverhubsplus.commands.Heal;
import me.xaxis.serverhubsplus.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class ServerHubsPlus extends JavaPlugin{

    Heal heal = new Heal(this);

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(Utils.chat("&a&l&m-------------------------------------"));
        Bukkit.getConsoleSender().sendMessage(Utils.chat("                                     "));
        Bukkit.getConsoleSender().sendMessage(Utils.chat("          &d&lServerHubs+&r &aEnabled        "));
        Bukkit.getConsoleSender().sendMessage(Utils.chat("              &7&lMade By &6&rXaxis          "));
        Bukkit.getConsoleSender().sendMessage(Utils.chat("                                     "));
        Bukkit.getConsoleSender().sendMessage(Utils.chat("&a&l&m-------------------------------------"));
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Utils.chat("&4&l&m-------------------------------------"));
        Bukkit.getConsoleSender().sendMessage(Utils.chat("                                     "));
        Bukkit.getConsoleSender().sendMessage(Utils.chat("         &d&lServerHubs+&r &a&lDisabled        "));
        Bukkit.getConsoleSender().sendMessage(Utils.chat("&7&l             Made By &6&rXaxis           "));
        Bukkit.getConsoleSender().sendMessage(Utils.chat("                                     "));
        Bukkit.getConsoleSender().sendMessage(Utils.chat("&4&l&m-------------------------------------"));
    }

}
