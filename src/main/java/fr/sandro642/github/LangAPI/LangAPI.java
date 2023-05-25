package fr.sandro642.github.LangAPI;

import fr.sandro642.github.Messages.Messages;
import fr.sandro642.github.misc.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import static fr.sandro642.github.Messages.Messages.getMessageConfig;

public class LangAPI extends JavaPlugin {

    private static LangAPI setuplang;

    private static String langSet;

    public static LangAPI getInstance() {
        return setuplang;
    }

    public static void setLangPlugin() {
        String en = "EN";
        String fr = "FR";
        String de = "DE";
        String es = "ES";
        String it = "IT";
        String nl = "NL";
        String pl = "PL";
        String ru = "RU";

        en = langSet;
        fr = langSet;
        de = langSet;
        es = langSet;
        it = langSet;
        nl = langSet;
        pl = langSet;
        ru = langSet;
    }

    // Get the string from /messages/file.yml and format it with color codes (hex for 1.16+)
    public static String getMessage(String path) {

        if (getMessageConfig(langSet).get(path) == null) {
            return path;
        }

        String rawMessage = getMessageConfig(langSet).getString(path);

        assert rawMessage != null;

        //TODO Keep this only for implementing #isMessageEnabled
        if (rawMessage.equalsIgnoreCase("none")) {
            return "";
        }

        if (Utils.supportRGBColors()) {
            String hexMessage = Utils.hexColor(rawMessage);
            return ChatColor.translateAlternateColorCodes('&', hexMessage);
        }

        return ChatColor.translateAlternateColorCodes('&', rawMessage);
    }



    public void setupMessages(Boolean setup) {
        /**
         * Set up the LangAPI
         */

        if (setup.equals(true)) {

            Messages.load();

            String messages = LangAPI.getInstance().getConfig().getString("Language");
            if (!(getMessageConfig(messages.toUpperCase()) == null)) {
                langSet = messages.toUpperCase();
                Bukkit.getConsoleSender().sendMessage("   - §fMessages: §a" + langSet);
            } else {
                Bukkit.getConsoleSender().sendMessage("   - §fMessages: §cInvalid file! (" + messages + "), using EN");
            }
        }
    }

    ///

}
