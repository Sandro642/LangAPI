package fr.sandro642.github.LangAPI;

import fr.sandro642.github.Messages.Messages;
import fr.sandro642.github.misc.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

import static fr.sandro642.github.Messages.Messages.getMessageConfig;

public class LangAPI {

    private static Plugin plugin;
    public LangAPI(Plugin plugin) {
        this.plugin = plugin;
    }

    private static String langSet;

    // Set language

    // With instance

    private static LangAPI lang;

    public static LangAPI setLang() {
        return lang;
    }

    private static String en = "en";
    private static String fr = "fr";
    private static String de = "de";
    private static String es = "es";
    private static String it = "it";
    private static String nl = "nl";
    private static String pl = "pl";
    private static String ru = "ru";

    public void en () {
        en = langSet;
    }
    public void fr() {
        langSet = fr;
    }
    public void de() {
        de = langSet;
    }
    public void es() {
        es = langSet;
    }
    public void it() {
        it = langSet;
    }
    public void nl() {
        nl = langSet;
    }
    public void pl() {
        pl = langSet;
    }
    public void ru() {
        ru = langSet;
    }

    // Get language
    private static LangAPI setuplang;

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



    public static void setupMessages(Boolean setup) {
        /**
         * Set up the LangAPI
         */

        if (setup.equals(true)) {

            Messages.load();

            String messages = plugin.getConfig().getString("Language");
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
