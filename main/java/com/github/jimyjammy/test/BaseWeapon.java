package com.github.jimyjammy.test;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class BaseWeapon implements Listener{
    ItemStack weapon;
    String wname;
    ArrayList<String> wlore;
    Material wmaterial;

    public BaseWeapon(String name, ArrayList<String> lore , Material m){
        wname = name;
        wlore = lore;
        wmaterial = m;
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event){
        use(event);
    }

    public void use(PlayerInteractEvent event){

    }

    @EventHandler
    public void onClick2(EntityDamageByEntityEvent event){
        use2(event);
    }

    public void use2(EntityDamageByEntityEvent event){
        
    }

    public ItemStack createWeapon(){
        weapon = ItemForge.makeItem(wmaterial, wname, wlore, 1);
        return weapon;
    }
}
