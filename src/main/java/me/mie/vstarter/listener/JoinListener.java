package me.mie.vstarter.listener;

import me.mie.vstarter.main;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private final main plugin;

    public JoinListener(main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // grab config msg
        String msg = this.plugin.getConfig().getString("join-msg");
        if (msg != null) {
            msg = msg.replace("%player%", event.getPlayer().getDisplayName());
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
            // send /starter msg in chat to the player if they joined for the first time??
        }

        Player p = event.getPlayer();

        // Player has not joined before
        if (!p.hasPlayedBefore()) {
            TextComponent msg2 = new TextComponent("Click here for help, or run the command /starter");
            msg2.setColor(net.md_5.bungee.api.ChatColor.GOLD);
            msg2.setBold(true);

            msg2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/starter"));
            msg2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click to open the help menu")));

            event.getPlayer().spigot().sendMessage(msg2);
        }
    }
}
