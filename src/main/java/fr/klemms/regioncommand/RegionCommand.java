package fr.klemms.regioncommand;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bstats.bukkit.Metrics;

import fr.klemms.regioncommand.commands.CommandAddRegionCommand;
import fr.klemms.regioncommand.commands.CommandRegionCommandList;
import fr.klemms.regioncommand.commands.CommandRemoveRegionCommand;
import fr.klemms.regioncommand.events.PluginListener;

public class RegionCommand extends JavaPlugin {

	public static Plugin pl;
	public static Metrics metrics;
	public static List<Region> commandForRegion = new ArrayList<Region>();
	public static final int VERSION = 3;
	public static final String PLUGIN_NAME = "RegionCommand";
	public static int webVersion = 0;
	public static String webURL = "https://www.spigotmc.org/resources/free-regioncommand.22012/";

	@Override
	public void onEnable() {
		pl = this;
		Config.registerConfig(this);
		Config.readConfig(this);
		getCommand("addregioncommand").setExecutor(new CommandAddRegionCommand());
		getCommand("removeregioncommand").setExecutor(new CommandRemoveRegionCommand());
		getCommand("regioncommandlist").setExecutor(new CommandRegionCommandList());
		this.getServer().getPluginManager().registerEvents(new PluginListener(), this);

		Bukkit.getScheduler().runTaskTimerAsynchronously(this, new ThreadCheckUpdate(), 5, 56000);

		metrics = new Metrics(this, 1068);
	}

	@Override
	public void onDisable() {

	}

	public static void saveToDisk() {
		int num = 0;
		for(int a = 0; a < RegionCommand.commandForRegion.size(); a++) {
			if(!RegionCommand.commandForRegion.get(a).isRemoved()) {
				num++;
			}
		}
		RegionCommand.pl.getConfig().set("regionsN", num);
		RegionCommand.pl.getConfig().set("regions", "");
		num = 0;
		for(int a = 0; a < RegionCommand.commandForRegion.size(); a++) {
			if(!RegionCommand.commandForRegion.get(a).isRemoved()) {
				RegionCommand.pl.getConfig().set("regions." + num + ".regionName", RegionCommand.commandForRegion.get(a).getRegionName());
				RegionCommand.pl.getConfig().set("regions." + num + ".eventType", RegionCommand.commandForRegion.get(a).getEventType().getEventName());
				RegionCommand.pl.getConfig().set("regions." + num + ".command", RegionCommand.commandForRegion.get(a).getCommand());
				num++;
			}
		}
		RegionCommand.pl.saveConfig();
	}
}
