package fr.sandro642.github.yml;

public class Makefile {

    public static void launchFile() {
        // Créer un dossier pour stocker les fichiers YAML
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }
        
        // Charger les données YAML pour chaque joueur
        for (Player joueur : getServer().getOnlinePlayers()) {
            String nomJoueur = joueur.getName();
            File fichierJoueur = new File(getDataFolder(), nomJoueur + ".yml");
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
                configJoueur.save(new File(getDataFolder(), configJoueur.getString("nom") + ".yml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}