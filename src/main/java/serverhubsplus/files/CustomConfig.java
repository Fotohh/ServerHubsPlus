package serverhubsplus.files;

import serverhubsplus.utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CustomConfig {

    private static File file;
    private  static FileConfiguration customFile;

    public static void setup(){

    file = new File(Bukkit.getServer().getPluginManager().getPlugin("ServerHubsPlus").getDataFolder(), "customconfig.yml");

    if(!file.exists()){
        try{
            file.createNewFile();
            Bukkit.getConsoleSender().sendMessage(Chat.colorRaw("&4&l(!) WARNING: PLUGIN FOUND NO CUSTOM CONFIG "));
            Bukkit.getConsoleSender().sendMessage(Chat.colorRaw("&4&l>-----=GENERATING A NEW CONFIG FILE=------<"));
            Bukkit.getConsoleSender().sendMessage(Chat.colorRaw("&4&l>----------=PROCESS COMMENCING=-----------<"));
        }catch (IOException e){
            //obaksahsjfak
             }
        }
    customFile = YamlConfiguration.loadConfiguration(file);


        }

       public static FileConfiguration get(){
        return customFile;
       }

       public static void save(){
       try{
           customFile.save(file);
       }catch (IOException e){
           Bukkit.getConsoleSender().sendMessage(Chat.colorRaw("&4&l&m------------"));
           Bukkit.getConsoleSender().sendMessage(Chat.colorRaw("   &4Couldn't "));
           Bukkit.getConsoleSender().sendMessage(Chat.colorRaw("   &6Save     "));
           Bukkit.getConsoleSender().sendMessage(Chat.colorRaw("   &4File     "));
           Bukkit.getConsoleSender().sendMessage(Chat.colorRaw("&4&l&m------------"));
           }


       }


       public static void reload(){
        customFile = YamlConfiguration.loadConfiguration(file);
       }















}