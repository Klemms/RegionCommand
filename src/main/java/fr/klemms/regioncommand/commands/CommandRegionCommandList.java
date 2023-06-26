package fr.klemms.regioncommand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.klemms.regioncommand.ChatContent;
import fr.klemms.regioncommand.Region;
import fr.klemms.regioncommand.RegionCommand;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class CommandRegionCommandList implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg2, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player)sender;
			player.sendMessage(ChatContent.GOLD + ChatContent.BOLD + "----- RegionCommand -----");
			
			for(Region region : RegionCommand.commandForRegion) {
				if(!region.isRemoved()) {
					TextComponent t1 = new TextComponent("| Command : ");
					t1.setColor(ChatColor.GOLD);
					
					TextComponent t2 = new TextComponent(region.getCommand());
					t2.setColor(ChatColor.LIGHT_PURPLE);
					
					t1.addExtra(t2);
					player.spigot().sendMessage(t1);
					
					TextComponent t3 = new TextComponent("| Region Name : " + ChatContent.PINK + region.getRegionName() +  ChatContent.GOLD + " -- Type : " +  ChatContent.PINK + region.getEventType().toString().toLowerCase() +  ChatContent.GOLD + " -- ");
					t3.setColor(ChatColor.GOLD);
					
					TextComponent t4 = new TextComponent("[Remove]");
					t4.setColor(ChatColor.DARK_PURPLE);
					t4.setBold(true);
					t4.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/removeregioncommand " + region.getRegionName() + " " + region.getEventType().toString().toLowerCase() + " " + region.getCommand()));
					t4.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to remove this command").color(ChatColor.GOLD).create()));
					
					t3.addExtra(t4);
					player.spigot().sendMessage(t3);
					
					player.sendMessage(ChatContent.GOLD + "|----");
				}
			}
		}
		return true;
	}
}
