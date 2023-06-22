package fr.sandro642.github.LangAPI;

import fr.sandro642.github.Messages.Messages;
import fr.sandro642.github.misc.Utils;
import fr.sandro642.github.yml.Makefile;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

import static fr.sandro642.github.Messages.Messages.getMessageConfig;

public class LangAPI {
    private static LangAPI lang;
    private Plugin plugin;
    public LangAPI(Plugin plugin) {
        this.plugin = plugin;
        Messages.setPlugin(plugin);
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
        }
    }

    ///



    public static ItemStack getHead(String value) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        UUID hashAsId = new UUID(value.hashCode(), value.hashCode());
        return Bukkit.getUnsafe().modifyItemStack(skull,
                "{SkullOwner:{Id:\"" + hashAsId + "\",Properties:{textures:[{Value:\"" + value + "\"}]}}}"
        );
    }

    public static void initGuiSystem(Player player, String title) {
        Makefile.launchFile();

        Inventory inv = Bukkit.createInventory(null, 54, title);

        ItemStack fr = getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjkwMzM0OWZhNDViZGQ4NzEyNmQ5Y2QzYzZjMGFiYmE3ZGJkNmY1NmZiOGQ3ODcwMTg3M2ExZTdjOGVlMzNjZiJ9fX0=");
        ItemStack de = getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjU2MTQ2Y2NkMWQwZTI4MmIwY2Y5ODAwYjcxYTZjZTdkNTI1MzlkMmY0NmU3OGMzMmNlMjk1NTY2MDc3NDA2ZSJ9fX0=");
        ItemStack it = getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODVjZTg5MjIzZmE0MmZlMDZhZDY1ZDhkNDRjYTQxMmFlODk5YzgzMTMwOWQ2ODkyNGRmZTBkMTQyZmRiZWVhNCJ9fX0=");
        ItemStack es = getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzJkNzMwYjZkZGExNmI1ODQ3ODNiNjNkMDgyYTgwMDQ5YjVmYTcwMjI4YWJhNGFlODg0YzJjMWZjMGMzYThiYyJ9fX0=");
        ItemStack nl = getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWVlMWU4NmZkMWQzZGJlNWM3ODYxNTkzMGY1NjNiZmVkN2Q5Y2MyNjljZDU3MDFkNjk4MDFlZWJjN2ZkYjRjNyJ9fX0=");
        ItemStack pl = getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2ZhMjY5YjhhNjYzZjUyZDYzMjNkY2Q5MmVkY2M4M2Q1ZjkxZDUwOGFmYTgxOTg4MmRlZGExNTM3NWYwM2QifX19");
        ItemStack ru = getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTZlYWZlZjk4MGQ2MTE3ZGFiZTg5ODJhYzRiNDUwOTg4N2UyYzQ2MjFmNmE4ZmU1YzliNzM1YTgzZDc3NWFkIn19fQ==");
        ItemStack en = getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2Q5MTQ1Njg3N2Y1NGJmMWFjZTI1MWU0Y2VlNDBkYmE1OTdkMmNjNDAzNjJjYjhmNGVkNzExZTUwYjBiZTViMyJ9fX0=");

        inv.setItem(20, fr);
        inv.setItem(21, de);
        inv.setItem(23, it);
        inv.setItem(24, es);
        inv.setItem(29, nl);
        inv.setItem(30, pl);
        inv.setItem(32, ru);
        inv.setItem(33, en);

    }


}
