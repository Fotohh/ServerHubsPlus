package me.xaxis_playz.shp.serverhubsplus;


import me.xaxis_playz.shp.serverhubsplus.commands.*;
import me.xaxis_playz.shp.serverhubsplus.events.*;
import me.xaxis_playz.shp.serverhubsplus.files.CustomConfig;
import me.xaxis_playz.shp.serverhubsplus.utils.Chat;
import me.xaxis_playz.shp.serverhubsplus.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.Objects;


public class ServerHubsPlus extends JavaPlugin implements Listener {
//remeber this Player target = Bukkit.getPlayerExact(args[0]);
    /*
      p.sendMessage(Utils.chat("&7&l&m--------------------I-------------------"));
      p.sendMessage(Utils.chat("&4You must specify more than one argument!"));
      p.sendMessage(Utils.chat("        &2/<command> <particle>           "));
      p.sendMessage(Utils.chat("&7&l&m--------------------I-------------------"));
    * */

    public ArrayList<Player> invisible_list = new ArrayList<>();

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(Chat.colorRaw("&b-------------------------------------"));
        Bukkit.getConsoleSender().sendMessage(Chat.colorRaw("                                     "));
        Bukkit.getConsoleSender().sendMessage(Chat.colorRaw("          &d&lServerHubs+ &aEnabled        "));
        Bukkit.getConsoleSender().sendMessage(Chat.colorRaw("              &a&lMade By Xaxis          "));
        Bukkit.getConsoleSender().sendMessage(Chat.colorRaw("                                     "));
        Bukkit.getConsoleSender().sendMessage(Chat.colorRaw("&b-------------------------------------"));
        getServer().getPluginManager().registerEvents(new OnDeath(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
        getCommand("godmode").setExecutor(new Godmode());
        getCommand("heal").setExecutor(new Heal());
        getCommand("suicide").setExecutor(new Suicide());
        getCommand("feed").setExecutor(new Feed());
        getCommand("discord").setExecutor(new Discord());
        getCommand("fly").setExecutor(new Fly());
        getCommand("gui").setExecutor(new GUIcommand());
        getCommand("Phelp").setExecutor(new Help());
        getCommand("shReload").setExecutor(new Reload());
        getCommand("randomTP").setExecutor(new RandomTP());
        getCommand("SHvanish").setExecutor(new Vanish(this));
        getCommand("punishGUI").setExecutor(new BanCommand(this));
        getServer().getPluginManager().registerEvents(new banInventoryEvents(this), this);
        getServer().getPluginManager().registerEvents(new ClickEvent(), this);
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        CustomConfig.setup();
        CustomConfig.get().addDefault("DiscordBoolean", true);
        CustomConfig.get().addDefault("cmdDisabled", "&4&lThis command is not enabled!");
        CustomConfig.get().options().copyDefaults(true);
        CustomConfig.save();
    }

    public void openGUI(Player player){
        ArrayList<Player> player_list = new ArrayList<>(player.getServer().getOnlinePlayers());

        Inventory bangui = Bukkit.createInventory(player, 45, Utils.chat("&dPlayer List"));

        for (Player value : player_list) {

            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);

            ItemMeta meta = playerHead.getItemMeta();
            meta.setDisplayName(value.getDisplayName());
            ArrayList<String> lore = new ArrayList<>();
            lore.add(Utils.chat("&6Player Health: " + value.getHealth()));
            lore.add(Utils.chat("&6Player EXP: " + value.getExp()));
            meta.setLore(lore);
            playerHead.setItemMeta(meta);

            bangui.addItem(playerHead);

        }

        player.openInventory(bangui);
    }

    public void openConfirmMenu(Player player, Player playerToBan){

        Inventory banPlayerMenu = Bukkit.createInventory(player, 9, Utils.chat("&4Punish This Player?"));

        //Ban Options
        ItemStack ban = new ItemStack(Material.WOODEN_AXE, 1);
        ItemMeta ban_meta = ban.getItemMeta();
        ban_meta.setDisplayName(Utils.chat("&4&lBan"));
        ban.setItemMeta(ban_meta);
        banPlayerMenu.setItem(0, ban);

        ItemStack kick = new ItemStack(Material.COAL, 1);
        ItemMeta kick_meta = kick.getItemMeta();
        kick_meta.setDisplayName(Utils.chat("&4&lKick"));
        kick.setItemMeta(kick_meta);
        banPlayerMenu.setItem(1, kick);

        //Add Player
        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD,1);
        ItemMeta player_meta = playerHead.getItemMeta();
        player_meta.setDisplayName(playerToBan.getDisplayName());
        playerHead.setItemMeta(player_meta);
        banPlayerMenu.setItem(4, playerHead);

        //Cancel Option
        ItemStack cancel = new ItemStack(Material.BARRIER, 1);
        ItemMeta cancel_meta = cancel.getItemMeta();
        cancel_meta.setDisplayName(Utils.chat("&4Go Back"));
        cancel.setItemMeta(cancel_meta);
        banPlayerMenu.setItem(8, cancel);

        player.openInventory(banPlayerMenu);

    }


    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Chat.colorRaw("&b&l&m-------------------------------------"));
        Bukkit.getConsoleSender().sendMessage(Chat.colorRaw("                                     "));
        Bukkit.getConsoleSender().sendMessage(Chat.colorRaw("         &dServerHubs+ &4&lDisabled        "));
        Bukkit.getConsoleSender().sendMessage(Chat.colorRaw("&a             Made By Xaxis           "));
        Bukkit.getConsoleSender().sendMessage(Chat.colorRaw("                                     "));
        Bukkit.getConsoleSender().sendMessage(Chat.colorRaw("&b&l&m-------------------------------------"));
    }











}
