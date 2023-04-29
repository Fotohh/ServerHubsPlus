package me.xaxis.serverhubsplus.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.SneakyThrows;
import me.xaxis.serverhubsplus.Options;
import me.xaxis.serverhubsplus.ServerHubsPlus;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;

public class UpdateChecker {

    private final ServerHubsPlus plugin;
    private static final String API_URL = "https://api.spigotmc.org/legacy/update.php?resource=78072";
    private static final URI API_DOWNLOAD_LINK = URI.create("https://api.spiget.org/v2/resources/78072/download");

    @SneakyThrows
    public UpdateChecker(ServerHubsPlus plugin){

        this.plugin = plugin;

        System.out.println(plugin.getDataFolder());

        if(!Options.UPDATE_CHECKER_ENABLED.toBoolean(plugin)){
            return;
        }

        update();

    }

    private double getWebVersion(){
        int resourceId = 78072;
        String apiUrl = "https://api.spiget.org/v2/resources/" + resourceId + "/versions/latest";

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                JsonObject response = JsonParser.parseReader(in).getAsJsonObject();
                String version = response.get("name").getAsString();
                return Double.parseDouble(version);
            }

        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Failed to retrieve website version: " + e.getMessage());
            return 0;
        }
    }

    private void update(){

        plugin.getServer().getScheduler().runTaskAsynchronously(plugin, ()->{

                double webVersion = getWebVersion();

                double pluginVersion;

                try{
                    pluginVersion = Double.parseDouble(plugin.getDescription().getVersion());
                }catch (Exception e){
                    plugin.getLogger().log(Level.SEVERE, "Failed to convert plugin version to a double! Please report this error to the developer! #CNCSTD");
                    return;
                }

                if(webVersion >= pluginVersion){

                    plugin.getLogger().log(Level.FINE,"No new updates found! You are running the latest version!");
                    return;
                }

                if(!Options.AUTO_UPDATE_ENABLED.toBoolean(plugin)){
                    plugin.getLogger().log(Level.WARNING,"New update found! \nPlease download the new version here:" +
                            " https://www.spigotmc.org/resources/serverhubsplus-great-hub-plugin-download-now.78072/");
                    return;
                }

                plugin.getLogger().log(Level.FINE,"Downloading file...");
                downloadFile();
                plugin.getLogger().log(Level.FINE,"Installation Complete! \nPlease reload/restart the server for changes to take effect.");

        });
    }

    @SneakyThrows
    private void downloadFile(){

        File file = new File("./plugins", "ServerHubsPlus-0.jar");

        HttpURLConnection http = (HttpURLConnection) API_DOWNLOAD_LINK.toURL().openConnection();
        if (http.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new IOException("Server returned HTTP response code: " + http.getResponseCode());
        }

        InputStream in = http.getInputStream();
        OutputStream out = new FileOutputStream(file);

        byte[] buffer = new byte[1024];
        int length;

        while ((length = in.read(buffer)) != -1) {
            out.write(buffer, 0, length);
        }

        in.close();
        out.close();

        plugin.getLogger().log(Level.FINE,"Installation Complete! \nPlease reload/restart the server for changes to take effect.");
    }

}
