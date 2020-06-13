package me.xaxis_playz.shp.serverhubsplus.RTPsupport;

import me.xaxis_playz.shp.serverhubsplus.ServerHubsPlus;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Random;


public class TeleportUtils {

    static ServerHubsPlus plugin;

    public TeleportUtils( ServerHubsPlus plugin) {
        TeleportUtils.plugin = plugin;
    }

    public static HashSet<Material> bad_blocks = new HashSet<>();

    static{
        bad_blocks.add(Material.LAVA);
    }


    public static Location generateLocation(Player player){


        Random random = new Random();

        int x = random.nextInt(25000);
        int y = 150;
        int z = random.nextInt(25000);

        Location randomLocation = new Location(player.getWorld(), x, y, z);

        y = randomLocation.getWorld().getHighestBlockYAt(randomLocation);

        randomLocation.setY(y);

        if(isLocationSafe(randomLocation)){
            return randomLocation;
        }else{
            while (!isLocationSafe(randomLocation)){
                randomLocation = generateLocation(player);
            }
            return randomLocation;
        }



    }


    public static boolean isLocationSafe(Location location){

        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();


        Block block = location.getWorld().getBlockAt(x, y, z);
        Block below = location.getWorld().getBlockAt(x, y - 1, z);
        Block above = location.getWorld().getBlockAt(x, y +1, z);

        return !(bad_blocks.contains(below.getType()) || (block.getType().isSolid()) || (above.getType().isSolid()));

    }

















































}
