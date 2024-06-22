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
import org.bukkit.Location;
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
                
                if (Bukkit.getPlayerExact(clickedmeta.getOwner()) == Bukkit.getPlayerExact("tzoofe")){
                    player.openInventory(ItemGui.getFastTravel());
                }
            }
            event.setCancelled(true);
        }

        if ( event.getView().getTitle().equals("Fast Travel") && event.getSlotType() != SlotType.OUTSIDE) {
            
            
            ItemStack clicked = event.getCurrentItem();
            Material clickedtype = clicked.getType();

            if ( clickedtype == Material.NETHER_STAR) {
                ItemMeta clickedmeta = clicked.getItemMeta();
                if (clickedmeta.getDisplayName().equals(ChatColor.BOLD + "Spawn")) {
                    player.closeInventory();
                    player.teleport(new Location(Bukkit.getWorld("MAP MAKING FUNTIME4"), 18, 65, -5));
                }
            }
            event.setCancelled(true);
        }

        if ( event.getCurrentItem().getType() == Material.NETHER_STAR) {
            //event.getWhoClicked().sendMessage("null");
            ItemMeta itemmeta = event.getCurrentItem().getItemMeta();
            if (itemmeta.getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Menu")) {
                //event.getWhoClicked().sendMessage("null2");
                event.setCancelled(true);
            }

        }

    }
}
