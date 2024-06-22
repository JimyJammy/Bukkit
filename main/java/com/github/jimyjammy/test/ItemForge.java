package com.github.jimyjammy.test;


import java.util.ArrayList;
import org.bukkit.inventory.meta.*;

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
}
