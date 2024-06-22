package com.github.jimyjammy.test;

import java.util.ArrayList;
import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/*
 * rpgpack java plugin
 */
public class Plugin extends JavaPlugin
{
  public static Logger LOGGER=Logger.getLogger("rpgpack");

  int sched;
  int sched2;
  int time_total_seconds = 600;
  public int time_minecraft_minuites = 0;
  public int time_minecraft_hours = 0;
  static ScoreBoard scoreboard;
  double counter = 0.0;
  public ItemForge forge = new ItemForge();
  public ItemStack menu = ItemForge.buildMenu(1);
  Npc[] npcs = new Npc[1];

  public void onEnable()
  {
    LOGGER.info("rpgpack enabled");
    String[] ericlines = new String[5];
    Long[] ericltimes = new Long[5];
    ericlines[0] = "Hello, my name is Eric the " + ChatColor.AQUA + "CLERIC" + ChatColor.RESET + "!";
    ericlines[1] = "I do all of the clericy things round here.";
    ericlines[2] = "I helped create the art of " + ChatColor.AQUA + "" + ChatColor.BOLD + "" + ChatColor.MAGIC +"HI" + ChatColor.RESET + "" + ChatColor.AQUA + "" + ChatColor.BOLD + "LIFE CRAFTING" + ChatColor.AQUA + "" + ChatColor.BOLD + "" + ChatColor.MAGIC +"HI" + ChatColor.RESET + ".";
    ericlines[3] = "Wait, do you not know what" + ChatColor.AQUA + "" + ChatColor.BOLD + "" + ChatColor.MAGIC +"HI" + ChatColor.RESET + "" + ChatColor.AQUA + "" + ChatColor.BOLD + "LIFE CRAFTING" + ChatColor.AQUA + "" + ChatColor.BOLD + "" + ChatColor.MAGIC +"HI" + ChatColor.RESET + " is?";
    ericlines[4] = "I do all of the clericy things round here.";

    ericltimes[0] = 0L;
    ericltimes[1] = 2L;
    ericltimes[2] = 4l;
    ericltimes[3] = 6l;
    ericltimes[4] = 8l;

    Npc eric = new Npc(new Location(Bukkit.getWorlds().get(0), 111, 69, -404), "Eric the " + ChatColor.BOLD + "" + ChatColor.AQUA + "CLERIC" ,ericlines , ericltimes, 40f);
    npcs[0] = eric;
    this.getCommand("time").setExecutor(new CommandTime(this));
    this.getCommand("mn").setExecutor(new CommandMenu());
    this.getCommand("health").setExecutor(new CommandHp());
    Bukkit.getServer().getPluginManager().registerEvents(new InventoryListener(this), this);
    Bukkit.getServer().getPluginManager().registerEvents(new NpcClickDetector(this), this);
    Bukkit.getServer().getPluginManager().registerEvents(new MenuListener(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new DroppedListener(), this);

    
    ArrayList<String> flamelore = new ArrayList<String>();
    flamelore.add(ChatColor.GREEN + "Uncommon Weapon");
    FlameSword flame = new FlameSword(ChatColor.GREEN + "" + ChatColor.BOLD + "FLAME SWORD" , flamelore , Material.GOLDEN_SWORD);
    Bukkit.getServer().getPluginManager().registerEvents(flame, this);
    scoreboard = new ScoreBoard();

    ArrayList<String> soullore = new ArrayList<String>();
    soullore.add(ChatColor.GREEN + "Uncommon Weapon");
    SoulRepeater soul = new SoulRepeater(ChatColor.GREEN + "" + ChatColor.BOLD + "SOULD REPEATER" , soullore , Material.GOLDEN_SWORD);
    Bukkit.getServer().getPluginManager().registerEvents(soul, this);
    scoreboard = new ScoreBoard();

    for (Player p: Bukkit.getOnlinePlayers()){
      //  p.sendMessage(Integer.toString(time_total_seconds));
        p.getInventory().addItem(flame.createWeapon());
        p.getInventory().addItem(soul.createWeapon());
      }
    
      

    if(!Bukkit.getScheduler().isCurrentlyRunning(sched)) {
      sched = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
          @Override
          public void run() {
              load();
          }
      }, 0, 1);
    }
  }
  public void load() {
    if (time_total_seconds < 270 || time_total_seconds > 930){
      time_total_seconds+=3;
    }
    counter+=0.05;
    if (counter > 1.0){
      time_total_seconds++;
      counter--;
    }
    while (time_total_seconds >= 1200){
      time_total_seconds-=1200;
    }
    time_minecraft_minuites = time_total_seconds % 60;
    time_minecraft_hours = Math.floorDiv(time_total_seconds,60);
    for (World w: Bukkit.getServer().getWorlds()) {
      w.setTime((time_total_seconds+900)*20);
    }
    scoreboard.refresh(time_minecraft_minuites, time_minecraft_hours);
    for (Player p: Bukkit.getOnlinePlayers()){
    //  p.sendMessage(Integer.toString(time_total_seconds));
      p.getInventory().setItem(8, menu);
      p.setHealthScale(20);
    }
  }

  public void onDisable()
  {
    LOGGER.info("rpgpack disabled");
  }

  public int mins(){
    return time_minecraft_minuites;
  }

  public int hrs(){
    return time_minecraft_hours;
  }

  public void changetime(int time){
    time_total_seconds = time;
  }

  public Npc[] getNpcs(){
    return npcs;
  }
}