package fr.sandro642.github.Languages;

import fr.sandro642.github.LangAPI.LangAPI;
import fr.sandro642.github.Messages.Messages;
import org.bukkit.Bukkit;

public class Languages {

    public static String lang = "EN"; // Language

    public void setupMessages(Boolean setup) {
        /**
         * Set up the LangAPI
         */

        if (setup.equals(true)) {

            Messages.load();

            String messages = LangAPI.getInstance().getConfig().getString("Language");
            if (!(Messages.getMessageConfig(messages.toUpperCase()) == null)) {
                lang = messages.toUpperCase();
                Bukkit.getConsoleSender().sendMessage("   - §fMessages: §a" + lang);
            } else {
                Bukkit.getConsoleSender().sendMessage("   - §fMessages: §cInvalid file! (" + messages + "), using EN");
            }
        }
    }
}
