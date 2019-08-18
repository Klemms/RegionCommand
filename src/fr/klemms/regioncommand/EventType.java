package fr.klemms.regioncommand;

public enum EventType {

	ENTER("enter"),
	LEAVE("leave");
	
	public static EventType getEventTypeByName(String eventType) {
		if(eventType.equalsIgnoreCase("enter")) {
			return EventType.ENTER;
		}
		return EventType.LEAVE;
	}
	
	private String eventName;
	
	private EventType(String eventName) {
		this.eventName = eventName;
	}

	public String getEventName() {
		return eventName;
	}
}
