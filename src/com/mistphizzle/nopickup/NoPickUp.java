package com.mistphizzle.nopickup;

import org.bukkit.entity.Entity;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownExpBottle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
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
		Entity en = e.getItem();
		if (Commands.nopickup(e.getPlayer())) {
			e.setCancelled(true);
			}	
		}
	@EventHandler
	public void onPlayerEXPChange(PlayerExpChangeEvent e) {
		if (Commands.nopickup(e.getPlayer())) {
			e.setAmount(0);
		}
	}
	
	@EventHandler
	public void onPlayerDropItemEvent(PlayerDropItemEvent e) {
		Player player = e.getPlayer();
		if (Commands.nopickup(e.getPlayer())) {
			e.setCancelled(true);
			player.sendMessage("§cYou can't drop items while NoPickUp is enabled.");
		}
	}

}
