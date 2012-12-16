package com.mistphizzle.nopickup;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;

public class Commands {

	public static Set<String> npudb = new HashSet<String>();
	NoPickUp plugin;

	public Commands(NoPickUp instance) {
		this.plugin = instance;
		init();
	}

	private void init() {
		PluginCommand nopickup = plugin.getCommand("nopickup");
		CommandExecutor exe;

		exe = new CommandExecutor() {
			@Override
			public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
				final Player p = (Player) s;
				if (!(s instanceof Player)) {
					s.sendMessage("§cThis command is only available to players.");
				}
				if (!s.hasPermission("nopickup.command")) {
					s.sendMessage("§cYou don't have permission to use that command.");
				} if (!(npudb.contains(s.getName()))) {
					npudb.add(s.getName());
					s.sendMessage("§aNoPickUp toggled on.");
				} else if (npudb.contains(s.getName())) {
					npudb.remove(s.getName());
					s.sendMessage("§aNoPickUp toggled off.");
				}
				return true;
			}

		}; nopickup.setExecutor(exe);

	}
	public static void setnopickup(Player p, boolean state) {
		if (state) npudb.add(p.getName());
		else npudb.remove(p.getName());
	}
	public static boolean nopickup(Player p) {
		return npudb.contains(p.getName());
	}
}
