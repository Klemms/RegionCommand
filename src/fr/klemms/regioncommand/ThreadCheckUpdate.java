package fr.klemms.regioncommand;

import java.util.logging.Level;

import org.bukkit.Bukkit;

public class ThreadCheckUpdate extends Thread {

	public ThreadCheckUpdate() {
		
	}
	
	@Override
	public void run() {
		RegionCommand.webVersion = Requests.getVersion("regioncommand");
		RegionCommand.webURL = Requests.getVersionURL("regioncommand");
		if(RegionCommand.VERSION < RegionCommand.webVersion) {
			Bukkit.getLogger().log(Level.WARNING, "An update for " + RegionCommand.PLUGIN_NAME + " is available at " + RegionCommand.webURL);
		}
	}
}
