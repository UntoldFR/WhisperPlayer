package com.github.UntoldFR.WhisperPlayer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
		if (alias.equalsIgnoreCase("whisper")) {
			if (sender instanceof Player) {
				Player emitter = (Player) sender;
				if (args.length >= 2) {
					Player receiver = Bukkit.getPlayerExact(args[0]);
					if (receiver != null) {
						int arg = 2;
						int totalArgs = args.length;
						String message = args[1];
						while (arg < totalArgs) {
							message = message + " " + args[arg];
							arg++;
						}
						messagePlayer(emitter, "LIGHT_PURPLE", "/w to " + receiver.getName().toUpperCase() + " : " + message);
						messagePlayer(receiver, "LIGHT_PURPLE", "/w from " + emitter.getName().toUpperCase() + " : " + message);
						return true;
					}
					messagePlayer(emitter, "RED", "Player name invalid or player OFFLINE.");
					return false;
				}
				if (args.length < 2 || args[0].equals("help")) {
					messagePlayer(emitter, "RED", "How to use the command :");
					messagePlayer(emitter, "RED", "/whisper [PLAYERNAME] [MESSAGE]");
					return false;
				}
				return false;
			}
			return false;
		}
		return false;
	}
	
	public boolean messagePlayer(Player player, String color, String message) {
		if (player instanceof Player) {
			ChatColor colorCode = ChatColor.valueOf(color);
			player.sendMessage(colorCode + message);
			return true;
		}
		return false;
	}

}
