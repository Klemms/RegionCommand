package fr.klemms.regioncommand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.klemms.regioncommand.EventType;
import fr.klemms.regioncommand.Region;
import fr.klemms.regioncommand.RegionCommand;

public class CommandAddRegionCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg2, String[] args) {
		if(args.length >= 3) {
			String s1 = "";
			for(int a = 0; a < args.length - 2; a++) {
				s1 += args[a + 2] + " ";
			}
			Region region = new Region(args[0], EventType.getEventTypeByName(args[1]), s1);
			RegionCommand.commandForRegion.add(region);
			sender.sendMessage("This command will be executed when a player enters/leaves the region '" + args[0] + "' : /" + s1);
			RegionCommand.saveToDisk();
			return true;
		}
		return false;
	}
}
