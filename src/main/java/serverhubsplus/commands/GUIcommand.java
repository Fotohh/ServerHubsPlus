package serverhubsplus.commands;

import serverhubsplus.ServerHubsPlus;
import serverhubsplus.utils.Chat;
import serverhubsplus.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class GUIcommand implements CommandExecutor {

    Plugin plugin = ServerHubsPlus.getPlugin(ServerHubsPlus.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("gui.use")) {

                Inventory gui = Bukkit.createInventory(player, 9, Utils.chat("&4&lPunish Menu"));

                ItemStack suicide = new ItemStack(Material.TNT, 1);
                ItemStack feed = new ItemStack(Material.ANVIL, 1);
                ItemStack godmode = new ItemStack(Material.COAL, 1);

                ItemMeta meta = suicide.getItemMeta();
                meta.setDisplayName(Utils.chat("&4Ban"));
                ArrayList<String> lore = new ArrayList<>();
                lore.add(Utils.chat("&aThis command &4bans &bthe player"));
                meta.setLore(lore);

                suicide.setItemMeta(meta);


                ItemMeta meta1 = feed.getItemMeta();
                meta1.setDisplayName(Utils.chat("&7Kick"));
                ArrayList<String> lore1 = new ArrayList<>();
                lore1.add(Utils.chat("&bThis command &7kicks&a you"));
                meta1.setLore(lore1);

                feed.setItemMeta(meta1);

                ItemMeta meta2 = godmode.getItemMeta();
                meta2.setDisplayName(Utils.chat("&4Mute"));
                ArrayList<String> lore2 = new ArrayList<>();
                lore2.add(Utils.chat("&dThis command &4mutes&a you"));
                meta2.setLore(lore2);

                godmode.setItemMeta(meta2);

                gui.setItem(0, suicide);
                gui.setItem(1, feed);
                gui.setItem(2, godmode);

                player.openInventory(gui);
            }else {
                player.sendMessage(Utils.chat("&4&lYou do not have the required permissions " + player.getDisplayName() + "&4&l!"));
            }

        }else{
            String noConsole = plugin.getConfig().getString("Messages.no-console");
            Bukkit.getConsoleSender().sendMessage(Chat.colorRaw(noConsole));
        }

        return true;
    }
}
