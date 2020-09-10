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
						int totalArgs = args.length - 1;
						String message = args[1];
						while (arg < totalArgs) {
							message = message + " " + args[arg];
							arg++;
						}
						receiver.sendMessage(ChatColor.LIGHT_PURPLE + "Message de " + emitter.getName() + " : " + message);
						emitter.sendMessage(ChatColor.LIGHT_PURPLE + "Message pour " + receiver.getName() + " : " + message);
						return true;
					}
					emitter.sendMessage(ChatColor.DARK_RED + "Nom de joueur invalide, ou joueur OFFLINE.");
					return false;
				}
				if (args.length < 2 || args[0].equals("help")) {
					emitter.sendMessage(ChatColor.DARK_RED + "/whisper NOM MESSAGE");
					return false;
				}
				return false;
			}
			return false;
		}
		return false;
	}

}
