package fr.klemms.regioncommand.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.raidstone.wgevents.events.RegionEnteredEvent;
import net.raidstone.wgevents.events.RegionLeftEvent;

import fr.klemms.regioncommand.EventType;
import fr.klemms.regioncommand.RegionCommand;
import fr.klemms.regioncommand.ThreadExecuteCommand;
import fr.klemms.regioncommand.Variable;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;

public class PluginListener implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		if(event.getPlayer().isOp() && RegionCommand.VERSION < RegionCommand.webVersion) {
			event.getPlayer().spigot().sendMessage(new ComponentBuilder("An update for " + RegionCommand.PLUGIN_NAME + " is available for this version of minecraft, click here to go to the download page! (Recommended)").color(ChatColor.AQUA).bold(true).event(new ClickEvent(ClickEvent.Action.OPEN_URL, RegionCommand.webURL)).create());
		}
	}

	@EventHandler
	public void onRegionEntered(RegionEnteredEvent event) {
		for(int a = 0; a < RegionCommand.commandForRegion.size(); a++) {
			if(!RegionCommand.commandForRegion.get(a).isRemoved() && event.getRegionName().equalsIgnoreCase(RegionCommand.commandForRegion.get(a).getRegionName()) && RegionCommand.commandForRegion.get(a).getEventType() == EventType.ENTER) {
				Bukkit.getScheduler().scheduleSyncDelayedTask(RegionCommand.pl, new ThreadExecuteCommand(Variable.replaceVariable(RegionCommand.commandForRegion.get(a), event.getPlayer(), RegionCommand.commandForRegion.get(a).getCommand())));
			}
		}
	}

	@EventHandler
	public void onRegionLeave(RegionLeftEvent event) {
		for(int a = 0; a < RegionCommand.commandForRegion.size(); a++) {
			if(!RegionCommand.commandForRegion.get(a).isRemoved() && event.getRegionName().equalsIgnoreCase(RegionCommand.commandForRegion.get(a).getRegionName()) && RegionCommand.commandForRegion.get(a).getEventType() == EventType.LEAVE) {
				Bukkit.getScheduler().scheduleSyncDelayedTask(RegionCommand.pl, new ThreadExecuteCommand(Variable.replaceVariable(RegionCommand.commandForRegion.get(a), event.getPlayer(), RegionCommand.commandForRegion.get(a).getCommand())));
			}
		}
	}
}
