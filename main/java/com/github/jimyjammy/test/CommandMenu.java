package com.github.jimyjammy.test;

import org.bukkit.command.CommandExecutor;
import org.bukkit.Bukkit;
//import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
//import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
//import org.bukkit.inventory.ItemStack;
//import org.bukkit.inventory.meta.ItemMeta;

public class CommandMenu implements CommandExecutor {
    ItemGui gui = new ItemGui();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player && args.length == 0) {
            ItemGui.openGui(Bukkit.getPlayerExact(sender.getName()));
            //if (sender.getName().equals("JimmaJammagsgsgsadgasdg")){
                //ItemStack item = ItemForge.makeItem2(Material.ALLIUM, "hi", "there?", 1);
                //ItemMeta im = item.getItemMeta();
                //im.addEnchant(Enchantment.DAMAGE_ALL, 257, true);
                //item.setItemMeta(im);
                //Player player = (Player)sender;
                //player.getInventory().addItem(item);
            //}
            return true;
            }
        return false;
    }
}