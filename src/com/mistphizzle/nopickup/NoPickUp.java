package com.mistphizzle.nopickup;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NoPickUp extends JavaPlugin implements Listener {
	
	// Commands
	Commands cmd;
	
	// Events
	// None yet.
	
	@Override
	public void onEnable() {
		cmd = new Commands(this);
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onPlayerPickupItem(PlayerPickupItemEvent e) {
		if (Commands.nopickup(e.getPlayer())) e.setCancelled(true);
	}

}
