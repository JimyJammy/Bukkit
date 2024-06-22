package com.github.jimyjammy.test;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Villager;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

public class Npc {
    Villager villager;
    Snowball clickme;
    List<String> lines;
    List<Long> linetime;
    String nameOfVillager;
    int i;
    public Npc(Location loc, String name, String[] voiceLines, Long[] linetimes, Float rotation){
        if ((voiceLines).length == (linetimes).length){
            int a = 0;
            for (Entity en: Radius.getNearbyEntities(loc, 3)){
                if (en.getCustomName() != null && en instanceof Villager){
                    a++;
                    villager = (Villager)en;
                }
            }

            if (a==0){
                villager = (Villager) loc.getWorld().spawnEntity(loc, EntityType.VILLAGER);
            }
            villager.teleport(loc);
            villager.setAI(false);
            villager.setInvulnerable(true);
            villager.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(2048);
            villager.setCollidable(false);
            villager.setCustomNameVisible(true);
            villager.setCustomName(name);
            villager.addScoreboardTag("npc");
            villager.setSilent(true);
            villager.setRotation(rotation, 0);
            int b = 0;
            for (Entity en: Radius.getNearbyEntities(loc, 2)){
                if (en.getCustomName() != null && en.getCustomName().equals(ChatColor.YELLOW + "CLICK ME")){
                    b++;
                    clickme = (Snowball)en;
                }
            }
            loc.setY(loc.getY()+1.5);
            if (b==0){
                clickme = (Snowball) loc.getWorld().spawnEntity(loc, EntityType.SNOWBALL);
            }
            clickme.teleport(loc);
            clickme.setInvulnerable(true);
            clickme.setCustomName(ChatColor.BOLD + "" + ChatColor.YELLOW + "CLICK ME");
            clickme.setCustomNameVisible(true);
            clickme.setVelocity(new Vector(0,0,0));
            clickme.setGravity(false);
            clickme.addScoreboardTag("npc");
            clickme.setRotation(0f, 90f);
            lines = Arrays.asList(voiceLines);
            linetime = Arrays.asList(linetimes);
            nameOfVillager = name;
        }
    }

    public Villager getEntity(){
        return villager;
    }

    public void doVoiceLines(Player p, Plugin p2){
        for (Integer i = 0; i < lines.size(); i+=1){
            this.i = i;
            //p.sendMessage(Integer.toString(i));
            BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
            scheduler.scheduleSyncDelayedTask(p2, new Runnable() {
                @Override
                public void run() {
                    //p.sendMessage(Integer.toString(i));
                    voiceLine(p);
                }
            }, 20*linetime.get(i));
        }
        this.i = 0;
    }

    public void voiceLine(Player p){
        p.sendMessage("\n" + nameOfVillager + "\n" + ChatColor.GRAY + "" + ChatColor.BOLD + "---------------------------------------------" + "\n" + ChatColor.RESET + lines.get(this.i) + "\n" + ChatColor.GRAY + "" + ChatColor.BOLD + "---------------------------------------------" + "\n");
        i++;
        p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 1, 1);
    }
    
}





