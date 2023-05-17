package fr.sandro642.github.Messages;

import fr.sandro642.github.LangAPI.LangAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Messages {

    private static final String path = LangAPI.getInstance().getDataFolder() + "/messages";

    public static void load() {

        List<String> languages = getLanguages();

        for (String name : languages) {

            File file = new File(path, name);

            if (!file.exists()) {

                file.getParentFile().mkdirs();

                InputStream stream = LangAPI.getInstance().getResource(file.getName());

                try {

                    if (stream != null) {
                        if (!(new File(LangAPI.getInstance().getDataFolder() + File.separator + "messages" + File.separator + file.getName()).exists())) {
                            Files.copy(stream, new File(LangAPI.getInstance().getDataFolder() + File.separator + "messages" + File.separator + file.getName()).toPath());
                        }
                    } else {
                        return;
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

    }

    public static FileConfiguration getMessageConfig(String name) {
        File file = new File(path, name + ".yml");
        if (file.exists()) {
            return YamlConfiguration.loadConfiguration(new File(path, name + ".yml"));
        }
        return null;
    }

    public static List<String> getLanguages() { // returns a list of file names that don't contain a / in the path

        // loop through all files in recourses folder
        // if it has 2 chars as the name (excluding .yml)
        // treat it as a language file

        List<String> list = new ArrayList<>();

        try {

            String s = new File(LangAPI.getInstance().getClass().getProtectionDomain().getCodeSource().getLocation()
                    .toURI()).getPath();

            JarFile jarFile = new JarFile(s);
            Enumeration<? extends JarEntry> entries = jarFile.entries();

            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                String name = entry.getName();
                if (!name.contains("/") && name.contains(".yml") && name.length() == 6) {
                    list.add(name);
                }
            }

            return list;

        } catch (IOException ex) {
            ex.printStackTrace();
            Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[EconomyPlus] Error loading languages!");
        } catch (URISyntaxException e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[EconomyPlus] Error loading languages!");
            throw new RuntimeException(e);
        }

        return list;

    }

}