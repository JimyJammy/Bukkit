package com.github.jimyjammy.test;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.entity.Player;

public class ItemGui {
    
    public ItemGui() {

    }

    @SuppressWarnings({ "deprecation", "static-access" })
    public static boolean openGui(Player player) {
        Inventory itemGui = Bukkit.createInventory(null, 27, "Main Menu");
        ItemForge forge = new ItemForge();

        ItemStack Players_head = new ItemStack(Material.PLAYER_HEAD,1);
        SkullMeta meta = (SkullMeta) Players_head.getItemMeta();

        meta.setOwner(player.getName());
        meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Player Info");

        ArrayList<String> lore = new ArrayList<String>();
        lore.add("Don't forget this one");

        meta.setLore(lore);

        Players_head.setItemMeta(meta);


        ItemStack Players_potion = new ItemStack(Material.SPLASH_POTION,1);
        ItemMeta meta2 = Players_potion.getItemMeta();

        meta2.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Mage Skill");
        ArrayList<String> lore2 = new ArrayList<String>();
        lore2.add("Don't forget this either");
        meta2.setLore(lore2);

        Players_potion.setItemMeta(meta2);

        itemGui.setItem(0, forge.makeGlass());
        itemGui.setItem(1, forge.makeGlass());
        itemGui.setItem(2, forge.makePotion());
        itemGui.setItem(3, new ItemStack(Material.IRON_SWORD, 1));
        itemGui.setItem(4, Players_head);
        itemGui.setItem(5, new ItemStack(Material.STONE_HOE, 1));
        itemGui.setItem(6, new ItemStack(Material.GOLDEN_AXE, 1));
        itemGui.setItem(7, forge.makeGlass());
        itemGui.setItem(8, forge.makeGlass());

        itemGui.setItem(9, forge.makeGlass());
        itemGui.setItem(10, forge.makeGlass());
        itemGui.setItem(11, forge.makeGlass());
        itemGui.setItem(12, forge.makeGlass());
        itemGui.setItem(13, forge.makeMenu2());
        itemGui.setItem(14, forge.makeGlass());
        itemGui.setItem(15, forge.makeGlass());
        itemGui.setItem(16, forge.makeGlass());
        itemGui.setItem(17, forge.makeGlass());

        itemGui.setItem(18, forge.makeGlass());
        itemGui.setItem(19, forge.makeGlass());
        itemGui.setItem(20, forge.makeGlass());
        itemGui.setItem(21, forge.makeGlass());
        itemGui.setItem(22, forge.makeFastTravel());
        itemGui.setItem(23, forge.makeGlass());
        itemGui.setItem(24, forge.makeGlass());
        itemGui.setItem(25, forge.makeGlass());
        itemGui.setItem(26, forge.makeGlass());

        player.openInventory(itemGui);

        return true;
    }

    public static Inventory getFastTravel(){
        Inventory inventory;
        inventory = Bukkit.createInventory(null, 36, "Fast Travel");
        inventory.setItem(0, ItemForge.makeGlass());
        inventory.setItem(1, ItemForge.makeGlass());
        inventory.setItem(2, ItemForge.makeGlass());
        inventory.setItem(3, ItemForge.makeGlass());
        inventory.setItem(4, ItemForge.makeGlass());
        inventory.setItem(5, ItemForge.makeGlass());
        inventory.setItem(6, ItemForge.makeGlass());
        inventory.setItem(7, ItemForge.makeGlass());
        inventory.setItem(8, ItemForge.makeGlass());

        inventory.setItem(9, ItemForge.makeGlass());
        inventory.setItem(10, ItemForge.makeSpawn());
        inventory.setItem(11, ItemForge.makeGlass());
        inventory.setItem(12, ItemForge.makeGlass());
        inventory.setItem(13, ItemForge.makeGlass());
        inventory.setItem(14, ItemForge.makeGlass());
        inventory.setItem(15, ItemForge.makeGlass());
        inventory.setItem(16, ItemForge.makeGlass());
        inventory.setItem(17, ItemForge.makeGlass());

        inventory.setItem(18, ItemForge.makeGlass());
        inventory.setItem(19, ItemForge.makeGlass());
        inventory.setItem(20, ItemForge.makeGlass());
        inventory.setItem(21, ItemForge.makeGlass());
        inventory.setItem(22, ItemForge.makeGlass());
        inventory.setItem(23, ItemForge.makeGlass());
        inventory.setItem(24, ItemForge.makeGlass());
        inventory.setItem(25, ItemForge.makeGlass());
        inventory.setItem(26, ItemForge.makeGlass());

        inventory.setItem(27, ItemForge.makeGlass());
        inventory.setItem(28, ItemForge.makeGlass());
        inventory.setItem(29, ItemForge.makeGlass());
        inventory.setItem(30, ItemForge.makeGlass());
        inventory.setItem(31, ItemForge.makeGlass());
        inventory.setItem(32, ItemForge.makeGlass());
        inventory.setItem(33, ItemForge.makeGlass());
        inventory.setItem(34, ItemForge.makeGlass());
        inventory.setItem(35, ItemForge.makeGlass());
        return inventory;
    }
}
