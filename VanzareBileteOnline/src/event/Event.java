package event;

import java.util.List;

public abstract class Event {

    public String eventName;
    public Location eventLocation;

    public Event(String eventName, Location eventLocation) {
        this.eventName = eventName;
        this.eventLocation = eventLocation;
    }

    public String getEventName() {
        return eventName;
    }

    public Location getEventLocation() {
        return eventLocation;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventLocations(Location eventLocation) {
        this.eventLocation = eventLocation;
    }
}
