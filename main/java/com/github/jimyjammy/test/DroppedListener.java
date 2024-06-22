package com.github.jimyjammy.test;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DroppedListener implements Listener{
    @SuppressWarnings("static-access")
    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        //event.getPlayer().sendMessage("drop1");
        if (event.getItemDrop().getItemStack().getType() == Material.NETHER_STAR) {
            //event.getPlayer().sendMessage("drop2");
            if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Menu")){
                //event.getPlayer().sendMessage("drop3");
                event.setCancelled(true);

                ItemGui gui = new ItemGui();
                gui.openGui(event.getPlayer());
            }
        }
    }
}
