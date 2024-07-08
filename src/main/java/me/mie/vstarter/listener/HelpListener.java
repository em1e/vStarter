package me.mie.vstarter.listener;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Set;

public class HelpListener implements Listener {

    private final Set<String> callForHelp;

    public HelpListener(Set<String> callForHelp) {
        this.callForHelp = callForHelp;
    }

    @EventHandler
    public void onPlayerWrite(AsyncPlayerChatEvent event) {

        String message = event.getMessage();

        for (String word : callForHelp) {
            if (message.toLowerCase().contains(word.toLowerCase())) {

                TextComponent msg = new TextComponent("Click here for help, or run the command /starter");
                msg.setColor(ChatColor.GOLD);
                msg.setBold(true);

                msg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/starter"));
                msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click to open the help menu")));

                event.getPlayer().spigot().sendMessage(msg);
                return;
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        // did the player click our inv: check title. Look into making a menu manager if needed?
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Player Information")) {

            event.setCancelled(true);
            if (event.isRightClick()) return;

            Player p = (Player) event.getWhoClicked();

            switch (event.getCurrentItem().getType()) {
                case BARRIER: // close
                    p.closeInventory();
                    break;
                case BOOK: // player wiki
                    Bukkit.dispatchCommand(p, "wiki");
                    p.closeInventory();
                    break;
                case PAPER: // socials
                    p.closeInventory();
                    Bukkit.dispatchCommand(p, "media");
                    break;
                case GOLDEN_SHOVEL: // kit claim
                    Bukkit.dispatchCommand(p, "kit claim");
                    p.sendMessage(ChatColor.LIGHT_PURPLE + "Run /wiki for more information on claiming");
                    p.closeInventory();
                    break;
                case GRASS_BLOCK: // rtp
                    Bukkit.dispatchCommand(p, "tp 12 111 12"); // change to rtp, I don't have it on my test server
                    p.closeInventory();
                    break;
//                case PLAYER_HEAD: // if you come up with what the player head item could do
//                    break;
            }
        }

        // - - - - - Media links /media menu - - - - -
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Media links")) {

            event.setCancelled(true);
            if (event.isRightClick()) return;

            Player p = (Player) event.getWhoClicked();

            switch (event.getCurrentItem().getType()) {
                case BARRIER: // close
                    p.closeInventory();
                    break;
                case CORNFLOWER: // player wiki
                    Bukkit.dispatchCommand(p, "links");
                    p.closeInventory();
                    break;
                case POPPY: // socials
                    Bukkit.dispatchCommand(p, "socials");
                    p.closeInventory();
                    break;
            }
        }
    }
}
