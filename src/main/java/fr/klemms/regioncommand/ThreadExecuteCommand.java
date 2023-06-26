package fr.klemms.regioncommand;

import org.bukkit.Bukkit;

public class ThreadExecuteCommand extends Thread {
	
	private String command;

	public ThreadExecuteCommand(String command) {
		this.command = command;
	}
	
	@Override
	public void run() {
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), this.command);
	}
}
