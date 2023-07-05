package fr.sandro642.github.yml;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.bukkit.Bukkit.getServer;

public class Makefile {

    private static Plugin plugin;

    public static void setPlugin(Plugin plugin) {
        Makefile.plugin = plugin;
    }

    private static final Map<String, YamlConfiguration> joueurs = new HashMap<>();

    public static void launchFile() {
        // Créer un dossier pour stocker les fichiers YAML
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }
        
        // Charger les données YAML pour chaque joueur
        for (Player joueur : getServer().getOnlinePlayers()) {
            String nomJoueur = joueur.getName();
            File fichierJoueur = new File(plugin.getDataFolder(), nomJoueur + ".yml");
            YamlConfiguration configJoueur = YamlConfiguration.loadConfiguration(fichierJoueur);
            joueurs.put(nomJoueur, configJoueur);
        }
        
        // Ajouter des données pour chaque joueur
        for (Map.Entry<String, YamlConfiguration> entry : joueurs.entrySet()) {
            String nomJoueur = entry.getKey();
            YamlConfiguration configJoueur = entry.getValue();
            configJoueur.set("nom", nomJoueur);
            configJoueur.set("argent", 1000);
        }
        
        // Sauvegarder les données YAML pour chaque joueur
        for (YamlConfiguration configJoueur : joueurs.values()) {
            try {
                configJoueur.save(new File(plugin.getDataFolder(), configJoueur.getString("nom") + ".yml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}