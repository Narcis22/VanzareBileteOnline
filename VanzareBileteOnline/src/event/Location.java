package event;


import java.time.LocalDateTime;

public class Location {

    public String name;
    public String address;
    public LocalDateTime dateTime;
    public Boolean isOutside;

    public Location(String name, String address, LocalDateTime dateTime, Boolean isOutside) {
        this.name = name;
        this.address = address;
        this.dateTime = dateTime;
        this.isOutside = isOutside;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Boolean getOutside() {
        return isOutside;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setOutside(Boolean outside) {
        isOutside = outside;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", dateTime=" + dateTime +
                ", isOutside=" + isOutside +
                '}';
    }
}
