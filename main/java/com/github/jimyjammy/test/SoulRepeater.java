package com.github.jimyjammy.test;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SoulRepeater extends BaseWeapon{
    public SoulRepeater(String name, ArrayList<String> lore, Material m) {
        super(name, lore, m);
    }

    public void use(PlayerInteractEvent event){
        //event.getPlayer().sendMessage("1");
        Location loc = event.getPlayer().getLocation();
        loc.add(0, 1, 0);
        Arrow shot = Bukkit.getWorld("MAP MAKING FUNTIME4").spawnArrow(loc, event.getPlayer().getLocation().getDirection(), 5, 0);
        shot.setShooter(event.getPlayer());
        shot.setBounce(true);
        if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK){
            //event.getPlayer().sendMessage("2");
            for (int i = 0; i < 10; i++){
                //event.getPlayer().sendMessage("3");
                Arrow shoted = Bukkit.getWorld("MAP MAKING FUNTIME4").spawnArrow(loc, event.getPlayer().getLocation().getDirection(), 5, 4);
                shoted.setShooter(event.getPlayer());
                shoted.setBounce(true);
            }
        }
    }
}
