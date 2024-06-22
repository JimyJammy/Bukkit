package com.github.jimyjammy.test;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Villager;

public class NpcClickDetector implements Listener  {
  public Plugin p;
  public NpcClickDetector(Plugin plugin)
  {
    p = plugin;
  }

  @EventHandler
  public void onClick(PlayerInteractEntityEvent event)
  {
    Entity entity  = event.getRightClicked();
    //event.getPlayer().sendMessage("1");
    if (entity instanceof Villager) {
      //event.getPlayer().sendMessage("2");
      for (Npc n: p.getNpcs())
      {
        //event.getPlayer().sendMessage("3");
        //event.getPlayer().sendMessage(n.getEntity().getCustomName());
        //event.getPlayer().sendMessage(entity.getCustomName());
        if (n.getEntity().getCustomName().equals(entity.getCustomName())){
          //event.getPlayer().sendMessage("4");
          n.doVoiceLines(event.getPlayer(), p);
          event.setCancelled(true);
        }
      }
    } 
  }
}