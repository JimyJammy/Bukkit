package com.github.jimyjammy.test;


import java.util.ArrayList;
import org.bukkit.inventory.meta.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

public class ItemForge {
    public static ItemStack makeItem(Material m, String name, ArrayList<String> desc, int ammount){
        ItemStack item = new ItemStack (m, ammount);

        ItemMeta im = item.getItemMeta();

        im.setLore(desc);
        im.setDisplayName(name);

        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(im);

        return item;
    }

    public static ItemStack makeItem2(Material m, String name, String desc, int ammount){
        ItemStack item = new ItemStack (m, ammount);

        ItemMeta im = item.getItemMeta();

        ArrayList<String> lore = new ArrayList<String>();
        lore.add(desc);
        if (desc != ""){
        im.setLore(lore);
        }
        im.setDisplayName(name);

        //im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        //im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(im);

        return item;
    }
    public static ItemStack makeGlass(){
        Material m = Material.WHITE_STAINED_GLASS_PANE;
        String name = (" ");
        String desc = ("");

        ArrayList<String> lore = new ArrayList<String>();
        lore.add(desc);

        return makeItem(m, name, lore, 1);
    }

    public static ItemStack buildMenu(int ammount){

        Material m = Material.NETHER_STAR;
        String name = (ChatColor.GOLD + "" + ChatColor.BOLD + "Menu");
        String desc = (ChatColor.AQUA + "" + ChatColor.BOLD + "Click to open the menu");

        ArrayList<String> lore = new ArrayList<String>();
        lore.add(desc);

        return makeItem(m, name, lore, ammount);
    }

    public static ItemStack makeSpawn(){

        Material m = Material.NETHER_STAR;
        String name = (ChatColor.BOLD + "Spawn");
        String desc = (ChatColor.GRAY + "" + ChatColor.BOLD + "Click to go to spawn");

        ArrayList<String> lore = new ArrayList<String>();
        lore.add(desc);

        return makeItem(m, name, lore, 1);
    }

    public static ItemStack makeMenu2(){

        Material m = Material.NETHER_STAR;
        String name = (ChatColor.GOLD + "" + ChatColor.BOLD + "Menu");

        return makeItem(m, name, new ArrayList<String>(), 1);
    }

    public static ItemStack makePotion(){

        Material m = Material.SPLASH_POTION;
        String name = (ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Mage Skill");
        String desc = ("Don't forget this either");

        ArrayList<String> lore = new ArrayList<String>();
        lore.add(desc);
    
        return makeItem(m, name, lore, 1);
    }

    @SuppressWarnings("deprecation")
    public static ItemStack makeFastTravel(){
        Material m = Material.PLAYER_HEAD;
        String name = (ChatColor.BLUE + "" + ChatColor.BOLD + "Fast Travel");

        ArrayList<String> lore = new ArrayList<String>();
    
        ItemStack item = makeItem(m, name, lore, 1);
        SkullMeta im = (SkullMeta)item.getItemMeta();
        im.setOwningPlayer(Bukkit.getOfflinePlayer("tzoofe"));
        item.setItemMeta(im);
        return item;
    }
}
