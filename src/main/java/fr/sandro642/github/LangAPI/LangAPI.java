package fr.sandro642.github.LangAPI;

import fr.sandro642.github.Messages.Messages;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class LangAPI extends JavaPlugin {

    private static LangAPI instance;
    public static String lang = "EN"; // Language

    public static LangAPI getInstance() {
        return instance;
    }

    ///

    public void setupMessages(Boolean setup) {
        /**
         * Set up the LangAPI
         */

        if (setup.equals(true)) {


            Messages.load();

            String messages = getConfig().getString("Language");
            if (!(Messages.getMessageConfig(messages.toUpperCase()) == null)) {
                lang = messages.toUpperCase();
                Bukkit.getConsoleSender().sendMessage("   - §fMessages: §a" + lang);
            } else {
                Bukkit.getConsoleSender().sendMessage("   - §fMessages: §cInvalid file! (" + messages + "), using EN");
            }
        }
    }

    ///

    ///

    public void setupLang() {
        /**
         * Set up the LangAPI
         */


    }

}
