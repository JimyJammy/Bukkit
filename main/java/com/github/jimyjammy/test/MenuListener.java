package com.github.jimyjammy.test;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.Material;

public class MenuListener implements Listener{
    @SuppressWarnings("static-access")
    @EventHandler()
    public void onPlayerUse(PlayerInteractEvent event){
        Player p = event.getPlayer();
        //p.sendMessage("interacted");
 
        if(p.getInventory().getItemInMainHand().getType() == Material.NETHER_STAR ){
            //p.sendMessage("interacted2");
            if (p.getInventory().getHeldItemSlot() == 8){
                if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_BLOCK){
                    //p.sendMessage("interacted3");
                    ItemGui item = new ItemGui();
                    item.openGui(p);
                }
            }
        }
}
}
