package com.github.jimyjammy.test;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class FlameSword extends BaseWeapon {
    public FlameSword(String name, ArrayList<String> lore, Material m) {
        super(name, lore, m);
    }
    
    public void use2(EntityDamageByEntityEvent event){
        if (event.getDamager() instanceof Player){
            if (((Player)event.getDamager()).getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(weapon.getItemMeta().getDisplayName())){
                Entity e = event.getEntity();
                if (e.getScoreboardTags().contains("npc") == false){
                    for (Entity en: Radius.getNearbyEntities(e.getLocation(), 4)){
                        if (en instanceof Player == false && en.getScoreboardTags().contains("npc") == false){
                            en.setFireTicks(20);
                            LivingEntity en2 = ((LivingEntity)en);
                            en2.damage(event.getDamage()/2);
                        }
                        e.setFireTicks(40);
                    }
                }
            }
        }
    }
}
