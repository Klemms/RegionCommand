package fr.klemms.regioncommand;

public class Region {
	
	private String regionName;
	private EventType eventType;
	private String command;
	private boolean removed;

	public Region(String regionName, EventType eventType, String command) {
		this.regionName = regionName;
		this.eventType = eventType;
		this.command = command;
		this.removed = false;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void setRemoved(boolean removed) {
		this.removed = removed;
	}
}
