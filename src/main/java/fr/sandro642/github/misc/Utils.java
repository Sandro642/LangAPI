package fr.sandro642.github.misc;

import fr.sandro642.github.LangAPI.LangAPI;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    // No Perms
    public static boolean hasPerm(CommandSender sender, String permission) {

        if (sender.hasPermission(permission)) {
            return true;
        }

        sender.sendMessage(LangAPI.getMessage("NoPerms"));
        Utils.playErrorSound(sender);

        return false;
    }

    // Error sound played to player
    public static void playErrorSound(CommandSender sender) {

        if (!LangAPI.getInstance().getConfig().getBoolean("Sounds.Use")) {
            return;
        }

        if (sender instanceof ConsoleCommandSender) {
            return;
        }

        Player player = (Player) sender;

        try {
            Sound x = Sound.valueOf(LangAPI.getInstance().getConfig().getString("Sounds.Error", "ENTITY_VILLAGER_NO"));
            player.playSound(player.getPlayer().getLocation(), x, 1, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Success sound played to player
    public static void playSuccessSound(CommandSender sender) {

        if (!LangAPI.getInstance().getConfig().getBoolean("Sounds.Use")) {
            return;
        }

        if (sender instanceof ConsoleCommandSender) {
            return;
        }

        Player player = (Player) sender;

        try {
            Sound x = Sound.valueOf(LangAPI.getInstance().getConfig().getString("Sounds.Success", "ENTITY_PLAYER_LEVELUP"));
            player.playSound(player.getPlayer().getLocation(), x, 1, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String hexColor(String text) {
        Pattern pattern = Pattern.compile("#[a-fA-f0-9]{6}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String color = text.substring(matcher.start(), matcher.end());
            text = text.replace(color, net.md_5.bungee.api.ChatColor.of(color) + "");
        }
        return net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', text);
    }

    public static boolean supportRGBColors() {
        return Bukkit.getVersion().contains("16")
                || Bukkit.getVersion().contains("17")
                || Bukkit.getVersion().contains("18")
                || Bukkit.getVersion().contains("19");
    }

    public String format(Double d) {

        DecimalFormat df = new DecimalFormat("#.##"); //NUMBER CANNOT GO ABOVE BILLION DUE TO IT BEING A DOUBLE
        if (LangAPI.getInstance().getConfig().getBoolean("Pattern.Enabled")) {
            df = new DecimalFormat(LangAPI.getInstance().getConfig().getString("Pattern.Value", "###,###.##"));
        }

        if (LangAPI.getInstance().getConfig().getBoolean("Formatting.Round-Decimals", false)) {
            df.setRoundingMode(RoundingMode.HALF_UP);
        } else {
            df.setRoundingMode(RoundingMode.DOWN);
        }

        String value = df.format(d);

        if (!(value.contains("."))) {
            value = value + "." + 00;
        }

        if (LangAPI.getInstance().getConfig().getBoolean("Formatting.Use-Decimals", true)) {

            if (value.split("\\.")[1].length() == 1) {
                value = value + "0";
            }

            if (!LangAPI.getInstance().getConfig().getBoolean("Formatting.Have-Excessive-Zeros", false)) {

                if (value.split("\\.")[1].matches("00")) {
                    value = value.split("\\.")[0];
                }

            } else {

                if (!(value.contains("."))) {
                    value = value + ".00";
                }

            }

        } else {
            value = new DecimalFormat("#").format(d);
        }

        return value;

    }

}
