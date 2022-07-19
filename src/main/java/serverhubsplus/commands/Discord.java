package serverhubsplus.commands;

import serverhubsplus.ServerHubsPlus;
import serverhubsplus.files.CustomConfig;
import serverhubsplus.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Discord implements CommandExecutor {
    Plugin plugin = ServerHubsPlus.getPlugin(ServerHubsPlus.class);
    boolean DB = CustomConfig.get().getBoolean("DiscordBoolean");
    String cmdd = CustomConfig.get().getString(" cmdDisabled");
    String discord = plugin.getConfig().getString("Messages.discord");
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
               if(CustomConfig.get().getBoolean(String.valueOf(DB), true)) {

            p.sendMessage(Utils.chat(discord));

         }else if(!CustomConfig.get().getBoolean(String.valueOf(DB), true)){

            p.sendMessage(Utils.chat(cmdd));

                   }


        return true;
    }


}
