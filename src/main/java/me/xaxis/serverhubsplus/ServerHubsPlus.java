package me.xaxis.serverhubsplus;

import me.xaxis.serverhubsplus.commands.*;
import me.xaxis.serverhubsplus.file.LangConfig;
import me.xaxis.serverhubsplus.listeners.OnInventoryClose;
import me.xaxis.serverhubsplus.listeners.OnJoin;
import me.xaxis.serverhubsplus.managers.LockChatManager;
import me.xaxis.serverhubsplus.utils.UpdateChecker;
import me.xaxis.serverhubsplus.utils.Utils;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class ServerHubsPlus extends JavaPlugin{

    private LockChatManager lockChatManager;
    private LangConfig langConfig;

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(Utils.chat("&a&l&m-------------------------------------"));
        Bukkit.getConsoleSender().sendMessage(Utils.chat("                                     "));
        Bukkit.getConsoleSender().sendMessage(Utils.chat("          &d&lServerHubs+&r &aEnabled        "));
        Bukkit.getConsoleSender().sendMessage(Utils.chat("              &7&lMade By &6&rXaxis          "));
        Bukkit.getConsoleSender().sendMessage(Utils.chat("                                     "));
        Bukkit.getConsoleSender().sendMessage(Utils.chat("&a&l&m-------------------------------------"));

        saveDefaultConfig();

        new UpdateChecker(this);

        //Instantiate classes
        new Metrics(this, 15846);
        new Heal(this);
        new SetHub(this);
        new Hub(this);
        new OnJoin(this);
        new Tphere(this);
        new Tp2p(this);
        new Suicide(this);
        new Fly(this);
        new GodMode(this);
        new Discord(this);
        new InvSee(this);
        new OnInventoryClose(this);
        new LockChat(this);
        new UnlockChat(this);
        lockChatManager = new LockChatManager(this);
        langConfig = new LangConfig(this, "Lang.yml");

        if(Options.Vanish.toBoolean(this)) {
            new Vanish(this);
        }

    }

    public LockChatManager getLockChatManager() {
        return lockChatManager;
    }

    public LangConfig getLangConfig() {
        return langConfig;
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
