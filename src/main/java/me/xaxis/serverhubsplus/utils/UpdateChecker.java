package me.xaxis.serverhubsplus.utils;

import lombok.SneakyThrows;
import me.xaxis.serverhubsplus.Options;
import me.xaxis.serverhubsplus.ServerHubsPlus;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class UpdateChecker {


    private final ServerHubsPlus plugin;
    private static final String API_URL = "https://api.spigotmc.org/legacy/update.php?resource=78072";
    private static final String API_DOWNLOAD_LINK = "https://api.spiget.org/v2/resources/78072/download";
    private String version;

    @SneakyThrows
    public UpdateChecker(ServerHubsPlus plugin){

        this.plugin = plugin;

        if(Options.UPDATE_CHECKER_ENABLED.toBoolean(plugin)){
            return;
        }

       update();

    }

    private void update(){

        plugin.getServer().getScheduler().runTaskAsynchronously(plugin, ()->{

            InputStream versionStream;
            try {
                versionStream = new URL(API_URL).openStream();
            } catch (IOException e) {
                plugin.getServer().getConsoleSender().sendMessage(Utils.chat("Error whilst checking for update: &4Failed to open URL stream."));
                return;
            }

            Scanner scanner = new Scanner(versionStream);

            if(scanner.hasNext()){
                version = scanner.next();
            }

            if(plugin.getDescription().getVersion().equals(version)){

                plugin.getServer().getConsoleSender().sendMessage(Utils.chat("&aNo new updates found! You are running the latest version!"));
                return;
            }

            if(!Options.AUTO_UPDATE_ENABLED.toBoolean(plugin)){

                plugin.getServer().getConsoleSender().sendMessage(Utils.chat("&aNew update found! \nPlease download the new version here: https://www.spigotmc.org/resources/serverhubsplus-great-hub-plugin-download-now.78072/"));

                return;
            }


            plugin.getServer().getConsoleSender().sendMessage(Utils.chat("&aDownloading file..."));
            downloadFile();
            plugin.getServer().getConsoleSender().sendMessage(Utils.chat("&aInstallation Complete! \nPlease reload/restart the server for changes to take effect."));

        });

    }

    @SneakyThrows
    private void downloadFile(){

        File file = new File(".\\ServerHubsPlus-0.jar");

        URL url = new URL(API_DOWNLOAD_LINK);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        BufferedInputStream in = new BufferedInputStream(http.getInputStream());
        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream bout = new BufferedOutputStream(fos, 1024);
        byte[] buffer = new byte[1024];
        int read;

        while((read = in.read(buffer, 0, 1024)) >= 0){
            bout.write(buffer, 0, read);
        }

        bout.close();
        in.close();
        fos.close();

    }



}
