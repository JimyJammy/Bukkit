package com.github.jimyjammy.test;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Material;

public class InventoryListener implements Listener{

    public InventoryListener(Plugin plugin){

    }


    @SuppressWarnings({ "deprecation", "static-access" })
    @EventHandler
    public void openInventoryClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if ( event.getView().getTitle().equals("Main Menu") && event.getSlotType() != SlotType.OUTSIDE) {
            
            
            ItemStack clicked = event.getCurrentItem();
            Material clickedtype = clicked.getType();

            if ( clickedtype == Material.PLAYER_HEAD) {
                SkullMeta clickedmeta = (SkullMeta) clicked.getItemMeta();
                if (Bukkit.getPlayerExact(clickedmeta.getOwner()) == player && clickedmeta.getDisplayName().equals(ChatColor.BLUE + "" + ChatColor.BOLD + "Player Info")) {
                    player.closeInventory();
                    player.sendMessage("Your stats are:\n" + ChatColor.GRAY + "" + ChatColor.BOLD + "COMING SOON");
                }

                
            }
            
            event.setCancelled(true);
        }

        if ( event.getCurrentItem().getType() == Material.NETHER_STAR) {
            //event.getWhoClicked().sendMessage("null");
            ItemMeta itemmeta = event.getCurrentItem().getItemMeta();
            if (itemmeta.getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Menu")) {
                //event.getWhoClicked().sendMessage("null2");
                ItemGui gui = new ItemGui();
                gui.openGui(player);
                event.setCancelled(true);
            }

        }

    }
}
