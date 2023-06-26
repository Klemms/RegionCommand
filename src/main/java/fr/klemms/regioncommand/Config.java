package fr.klemms.regioncommand;

import org.bukkit.plugin.java.JavaPlugin;

public class Config {

	public static volatile int pluginVersion = 1;

	public static void registerConfig(JavaPlugin plugin) {
		plugin.getConfig().addDefault("pluginVersion", pluginVersion);

		plugin.getConfig().options().copyDefaults(true);
		plugin.saveConfig();
	}

	public static void readConfig(JavaPlugin plugin) {
		for(int a = 0; a < RegionCommand.pl.getConfig().getInt("regionsN"); a++) {
			Region region = new Region(
					RegionCommand.pl.getConfig().getString("regions." + a + ".regionName"),
					EventType.getEventTypeByName(RegionCommand.pl.getConfig().getString("regions." + a + ".eventType")),
					RegionCommand.pl.getConfig().getString("regions." + a + ".command"),
					RegionCommand.nextCommandID++);
			RegionCommand.commandForRegion.add(region);
		}
		RegionCommand.saveToDisk();
	}
}
