package user;

import java.time.LocalDateTime;

public class Ticket {

    public String eventName;
    public Double eventPrice;
    public String location;
    public LocalDateTime time;

    public Ticket(String eventName, Double eventPrice, String location, LocalDateTime time) {
        this.eventName = eventName;
        this.eventPrice = eventPrice;
        this.location = location;
        this.time = time;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Double getEventPrice() {
        return eventPrice;
    }

    public void setEventPrice(Double eventPrice) {
        this.eventPrice = eventPrice;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "eventName='" + eventName + '\'' +
                ", eventPrice=" + eventPrice +
                ", location='" + location + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
