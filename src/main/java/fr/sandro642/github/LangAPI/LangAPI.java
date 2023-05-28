package fr.sandro642.github.LangAPI;

import fr.sandro642.github.Messages.Messages;
import fr.sandro642.github.misc.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

import static fr.sandro642.github.Messages.Messages.getMessageConfig;

public class LangAPI {
    private static LangAPI lang;

    private Plugin plugin;
    public LangAPI(Plugin plugin) {
        this.plugin = plugin;
        new Messages(plugin);
    }

    private String langSet;

    // Set language

    private final static String en = "en";
    private final static String fr = "fr";
    private final static String de = "de";
    private final static String es = "es";
    private final static String it = "it";
    private final static String nl = "nl";
    private final static String pl = "pl";
    private final static String ru = "ru";

    public void en () {
       langSet = en;
    }
    public void fr() {
        langSet = fr;
    }
    public void de() {
        langSet = de;
    }
    public void es() {
        langSet = es;
    }
    public void it() {
        langSet = it;
    }
    public void nl() {
        langSet = nl;
    }
    public void pl() {
        langSet = pl;
    }
    public void ru() {
        langSet = ru;
    }

    // Get language
    private static LangAPI setuplang;

    // Get the string from /messages/file.yml and format it with color codes (hex for 1.16+)
    public String getMessage(String path) {

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
