package fr.klemms.regioncommand.commands;

import net.md_5.bungee.api.chat.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.klemms.regioncommand.ChatContent;
import fr.klemms.regioncommand.Region;
import fr.klemms.regioncommand.RegionCommand;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent.Action;

public class CommandRegionCommandList implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg2, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player)sender;
			player.sendMessage(ChatContent.GOLD + "|---- RegionCommand -- " + RegionCommand.commandForRegion.size() + " commands ----");

			for (int i = 0; i < RegionCommand.commandForRegion.size(); i++) {
				Region region = RegionCommand.commandForRegion.get(i);

				if (!region.isRemoved()) {
					TextComponent t0 = new TextComponent("| Command ID : ");
					t0.setColor(ChatColor.GOLD);
					t0.addExtra((new ComponentBuilder(String.valueOf(region.getId()))).color(ChatColor.LIGHT_PURPLE).create()[0]);
					player.spigot().sendMessage(t0);

					TextComponent t1 = new TextComponent("| Command : ");
					t1.setColor(ChatColor.GOLD);

					TextComponent t2 = new TextComponent(region.getCommand());
					t2.setColor(ChatColor.LIGHT_PURPLE);

					t1.addExtra(t2);

					player.spigot().sendMessage(t1);

					TextComponent t3 = new TextComponent("| Region Name : " + ChatContent.PINK + region.getRegionName() + ChatContent.GOLD + " - Type : " + ChatContent.PINK + region.getEventType().toString().toLowerCase() + " - ");
					t3.setColor(ChatColor.GOLD);

					TextComponent t4 = new TextComponent("[Remove] ");
					t4.setColor(ChatColor.DARK_PURPLE);
					t4.setBold(true);
					t4.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/removeregioncommand " + region.getId()));
					t4.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder("Click to remove this command")).color(ChatColor.GOLD).create()));

					t3.addExtra(t4);

					TextComponent t5 = new TextComponent("[Change]");
					t5.setColor(ChatColor.DARK_PURPLE);
					t5.setBold(true);
					t5.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/rcchange " + region.getId() + " " + region.getRegionName() + " " + region.getEventType().toString().toLowerCase() + " " + region.getCommand()));
					t5.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder("Click to edit this command")).color(ChatColor.GOLD).create()));

					t4.addExtra(t5);

					player.spigot().sendMessage(t3);

					player.sendMessage("§6|---------------");
				}
			}
		}
		return true;
	}
}
