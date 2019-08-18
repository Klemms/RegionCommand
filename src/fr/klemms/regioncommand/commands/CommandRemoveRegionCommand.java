package fr.klemms.regioncommand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.klemms.regioncommand.EventType;
import fr.klemms.regioncommand.RegionCommand;

public class CommandRemoveRegionCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg2, String[] args) {
		if(args.length >= 3) {
			String s1 = "";
			for(int a = 0; a < args.length - 2; a++) {
				s1 += args[a + 2] + " ";
			}
			for(int a = 0; a < RegionCommand.commandForRegion.size(); a++) {
				if(RegionCommand.commandForRegion.get(a).getRegionName().equalsIgnoreCase(args[0]) && RegionCommand.commandForRegion.get(a).getEventType() == EventType.getEventTypeByName(args[1]) && RegionCommand.commandForRegion.get(a).getCommand().equalsIgnoreCase(s1)) {
					RegionCommand.commandForRegion.get(a).setRemoved(true);
				}
			}
			sender.sendMessage("This command has been removed");
			RegionCommand.saveToDisk();
			return true;
		}
		return false;
	}
}
