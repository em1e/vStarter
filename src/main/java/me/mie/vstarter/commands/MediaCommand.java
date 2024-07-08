package me.mie.vstarter.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class MediaCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (label.equalsIgnoreCase("media")){
            // if command is run in console
            if (!(sender instanceof Player)){
                sender.sendMessage("Cannot open GUI");
                return true;
            }

            Player p = (Player) sender;

            // doesn't take any args
            if (args.length == 0) {
                // - - - - - create inventory - - - - -
                Inventory menu = Bukkit.createInventory(p, 45, ChatColor.AQUA + "Media links");

                //  - - - - - create items - - - - -
                ItemStack socials = new ItemStack(Material.POPPY);
                ItemStack links = new ItemStack(Material.CORNFLOWER);
                ItemStack close = new ItemStack(Material.BARRIER, 1);

                //  - - - - - socials meta - - - - -
                ItemMeta sMeta = socials.getItemMeta();
                sMeta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "/socials");

                List<String> sLore = new ArrayList<>();
                sLore.add(ChatColor.GRAY + "Click here to view all of our socials!");
                sLore.add("");
                sLore.add(org.bukkit.ChatColor.BOLD + "e.g. discord, instagram, tiktok & youtube");
                sMeta.setLore(sLore);
                socials.setItemMeta(sMeta);

                //  - - - - - links meta - - - - -
                ItemMeta lMeta = links.getItemMeta();
                lMeta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "/links");

                List<String> lLore = new ArrayList<>();
                lLore.add(ChatColor.GRAY + "Click here to view our other useful links!");
                lLore.add("");
                lLore.add(org.bukkit.ChatColor.BOLD + "e.g. our website, voting & player wiki");
                lMeta.setLore(lLore);
                links.setItemMeta(lMeta);

                //  - - - - - close meta - - - - -
                ItemMeta cMeta = close.getItemMeta();
                cMeta.setDisplayName(org.bukkit.ChatColor.RED + "" + org.bukkit.ChatColor.BOLD + "Close menu");
                close.setItemMeta(cMeta);

                menu.setItem(21, socials);
                menu.setItem(23, links);
                menu.setItem(8, close);

                // / - - - - - open the gui - - - - -
                p.openInventory(menu);
                return true;
            }
        }
        return true;
    }
}
