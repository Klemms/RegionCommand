package fr.klemms.regioncommand.commands;

import fr.klemms.regioncommand.ChatContent;
import fr.klemms.regioncommand.EventType;
import fr.klemms.regioncommand.Region;
import fr.klemms.regioncommand.RegionCommand;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.apache.commons.lang3.math.NumberUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandChangeRegionCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg2, String[] args) {
		if (args.length >= 3 && NumberUtils.isNumber(args[0])) {
			String s1 = "";
			for (int a = 0; a < args.length - 3; a++) {
				s1 = s1 + args[a + 3] + " ";
			}

			for (Region region : RegionCommand.commandForRegion) {
				if (region.getId() == Integer.parseInt(args[0])) {
					region.setCommand(s1);
					region.setEventType(EventType.getEventTypeByName(args[2]));
					region.setRegionName(args[1]);
					sender.sendMessage("Command successfully changed");
					RegionCommand.saveToDisk();
					return true;
				}
			}
		}
		return false;
	}
}
