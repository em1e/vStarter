package me.mie.vstarter.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class HelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (label.equalsIgnoreCase("starter")) {
                // if sender is not player
            if (!(sender instanceof Player)) {
                sender.sendMessage("Cannot open GUI");
                return true;
            }
            Player p = (Player) sender;

            if (args.length == 0) {
                // - - - - - create inventory - - - - -
                Inventory menu = Bukkit.createInventory(p, 45, ChatColor.AQUA + "Player Information");

                // - - - - - create player item - - - - -
                ItemStack playerItem = new ItemStack(Material.PLAYER_HEAD, 1);

                SkullMeta pMeta = (SkullMeta) playerItem.getItemMeta();
                pMeta.setOwningPlayer(p);
                String displayName = ChatColor.stripColor(p.getDisplayName());
                pMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + displayName);

                    // Get joindate
                Date joinDate = new Date(p.getFirstPlayed());
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String formattedJoinDate = dateFormat.format(joinDate);

                    // get playtime
                long playtimeMillis = p.getStatistic(org.bukkit.Statistic.PLAY_ONE_MINUTE) * 50L;
                long days = playtimeMillis / (1000 * 60 * 60 * 24);
                long hours = (playtimeMillis / (1000 * 60 * 60)) % 24;
                long minutes = (playtimeMillis / (1000 * 60)) % 60;
                String formattedPlaytime = String.format("%d days, %d hours, %d minutes", days, hours, minutes);

                    // Create player lore
                List<String> pLore = new ArrayList<>();
                pLore.add("");
                pLore.add(ChatColor.DARK_PURPLE + "Joindate: " + ChatColor.GRAY + formattedJoinDate);
                pLore.add(ChatColor.DARK_PURPLE + "Playtime: " + ChatColor.GRAY + formattedPlaytime);
                pMeta.setLore(pLore);
                playerItem.setItemMeta(pMeta);

                // - - - - - create /kit claim item - - - - -
                ItemStack claimItem = new ItemStack(Material.GOLDEN_SHOVEL, 1);
                ItemMeta cMeta = claimItem.getItemMeta();

                    // disable basic stats of tools
                cMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,
                        new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 0, AttributeModifier.Operation.ADD_NUMBER));
                cMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED,
                        new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", 0, AttributeModifier.Operation.ADD_NUMBER));
                cMeta.addItemFlags(org.bukkit.inventory.ItemFlag.HIDE_ATTRIBUTES);

                    // add lore and display name
                cMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "/kit claim");
                List<String> cLore = new ArrayList<>();
                cLore.add(ChatColor.GRAY + "Click here to get");
                cLore.add(ChatColor.GRAY + "a golden shovel for claiming");
                cLore.add("");
                cLore.add(ChatColor.BOLD + "To keep your area safe!");
                cMeta.setLore(cLore);
                claimItem.setItemMeta(cMeta);

                // - - - - - create /socials item - - - - -
                ItemStack socialItem = new ItemStack(Material.PAPER, 1);
                ItemMeta sMeta = socialItem.getItemMeta();
                sMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "/media");
                List<String> sLore = new ArrayList<>();
                sLore.add(ChatColor.GRAY + "Click here to view a list");
                sLore.add(ChatColor.GRAY + "of socials and other useful links!");
                sLore.add("");
                sLore.add(ChatColor.BOLD + "e.g. discord, website, ig, tiktok, voting,..");
                sMeta.setLore(sLore);
                socialItem.setItemMeta(sMeta);

                // - - - - - create /rtp item - - - - -
                ItemStack rtpItem = new ItemStack(Material.GRASS_BLOCK, 1);
                ItemMeta rMeta = rtpItem.getItemMeta();
                rMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "/rtp");
                List<String> rLore = new ArrayList<>();
                rLore.add(ChatColor.GRAY + "Click here to teleport randomly");
                rLore.add(ChatColor.GRAY + "to the wild, and start your adventure!");
                rLore.add("");
                rLore.add(ChatColor.BOLD + "Good luck on your journey!");
                rMeta.setLore(rLore);
                rtpItem.setItemMeta(rMeta);

                // - - - - - create /wiki - - - - -
                ItemStack wikiItem = new ItemStack(Material.BOOK, 1);
                ItemMeta wMeta = wikiItem.getItemMeta();
                wMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "/wiki");
                List<String> wLore = new ArrayList<>();
                wLore.add(ChatColor.GRAY + "Click here view the player wiki on all");
                wLore.add(ChatColor.GRAY + "of the unique features found here at violets!");
                wMeta.setLore(wLore);
                wikiItem.setItemMeta(wMeta);

                // - - - - - create close - - - - -
                ItemStack closeItem = new ItemStack(Material.BARRIER, 1);
                ItemMeta xMeta = closeItem.getItemMeta();
                xMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Close menu");
                closeItem.setItemMeta(xMeta);

                // - - - - - set items into inv - - - - -
                menu.setItem(12, playerItem);
                menu.setItem(31, claimItem);
                menu.setItem(33, socialItem);
                menu.setItem(29, rtpItem);
                menu.setItem(14, wikiItem);
                menu.setItem(8, closeItem);

                // - - - - - make player open the custom inv - - - - -
                p.openInventory(menu);
            }
        }
        return true;
    }
}
