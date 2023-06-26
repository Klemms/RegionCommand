package fr.klemms.regioncommand.commands;

import fr.klemms.regioncommand.ChatContent;
import fr.klemms.regioncommand.Region;
import org.apache.commons.lang3.math.NumberUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.klemms.regioncommand.EventType;
import fr.klemms.regioncommand.RegionCommand;

import java.util.Iterator;

public class CommandRemoveRegionCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg2, String[] args) {
		if(args.length == 1 && NumberUtils.isNumber(args[0])) {
			Iterator<Region> regionIterator = RegionCommand.commandForRegion.iterator();

			while (regionIterator.hasNext()) {
				Region region = regionIterator.next();

				if (region.getId() == Integer.parseInt(args[0])) {
					regionIterator.remove();
					sender.sendMessage("This command has been removed");
					RegionCommand.saveToDisk();
					return true;
				}
			}

			sender.sendMessage(ChatContent.RED + "Couldn't find a command with this command ID");
			return false;
		}
		return false;
	}
}
