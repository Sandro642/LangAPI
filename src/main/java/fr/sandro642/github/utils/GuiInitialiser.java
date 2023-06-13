package fr.sandro642.github.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class GuiInitialiser {

    public static ItemStack getHead(String value) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        UUID hashAsId = new UUID(value.hashCode(), value.hashCode());
        return Bukkit.getUnsafe().modifyItemStack(skull,
                "{SkullOwner:{Id:\"" + hashAsId + "\",Properties:{textures:[{Value:\"" + value + "\"}]}}}"
        );
    }

    public static void initGui(Player player, String title) {

        Inventory inv = Bukkit.createInventory(null, 54, title);

        ItemStack france = getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjkwMzM0OWZhNDViZGQ4NzEyNmQ5Y2QzYzZjMGFiYmE3ZGJkNmY1NmZiOGQ3ODcwMTg3M2ExZTdjOGVlMzNjZiJ9fX0=");
        ItemStack deutsch = getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjU2MTQ2Y2NkMWQwZTI4MmIwY2Y5ODAwYjcxYTZjZTdkNTI1MzlkMmY0NmU3OGMzMmNlMjk1NTY2MDc3NDA2ZSJ9fX0=");
        ItemStack italy = getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODVjZTg5MjIzZmE0MmZlMDZhZDY1ZDhkNDRjYTQxMmFlODk5YzgzMTMwOWQ2ODkyNGRmZTBkMTQyZmRiZWVhNCJ9fX0=");
        ItemStack spain = getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzJkNzMwYjZkZGExNmI1ODQ3ODNiNjNkMDgyYTgwMDQ5YjVmYTcwMjI4YWJhNGFlODg0YzJjMWZjMGMzYThiYyJ9fX0=");
        ItemStack Dutch = getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWVlMWU4NmZkMWQzZGJlNWM3ODYxNTkzMGY1NjNiZmVkN2Q5Y2MyNjljZDU3MDFkNjk4MDFlZWJjN2ZkYjRjNyJ9fX0=");
        ItemStack Polish = getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2ZhMjY5YjhhNjYzZjUyZDYzMjNkY2Q5MmVkY2M4M2Q1ZjkxZDUwOGFmYTgxOTg4MmRlZGExNTM3NWYwM2QifX19");
        ItemStack russia = getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTZlYWZlZjk4MGQ2MTE3ZGFiZTg5ODJhYzRiNDUwOTg4N2UyYzQ2MjFmNmE4ZmU1YzliNzM1YTgzZDc3NWFkIn19fQ==");
        ItemStack england = getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2Q5MTQ1Njg3N2Y1NGJmMWFjZTI1MWU0Y2VlNDBkYmE1OTdkMmNjNDAzNjJjYjhmNGVkNzExZTUwYjBiZTViMyJ9fX0=");

        inv.setItem(20, france);
        inv.setItem(21, deutsch);
        inv.setItem(23, italy);
        inv.setItem(24, spain);
        inv.setItem(29, Dutch);
        inv.setItem(30, Polish);
        inv.setItem(32, russia);
        inv.setItem(33, england);

    }

}
