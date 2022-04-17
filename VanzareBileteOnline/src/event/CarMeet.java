package event;

import java.util.List;

public class CarMeet extends Event {

    public Double enteryFee;
    public Integer ticketsLeft;
    public String prize;

    public CarMeet(String eventName, Location eventLocation, Double enteryFee, Integer ticketsLeft, String prize) {
        super(eventName, eventLocation);
        this.enteryFee = enteryFee;
        this.ticketsLeft = ticketsLeft;
        this.prize = prize;
    }

    public Double getEnteryFee() {
        return enteryFee;
    }

    public Integer getticketsLeft() {
        return ticketsLeft;
    }

    public String getPrize() {
        return prize;
    }

    public void setEnteryFee(Double enteryFee) {
        this.enteryFee = enteryFee;
    }

    public void setticketsLeft(Integer ticketsLeft) {
        this.ticketsLeft = ticketsLeft;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return "CarMeet{" +
                "enteryFee=" + enteryFee +
                ", ticketsLeft=" + ticketsLeft +
                ", prize='" + prize + '\'' +
                ", eventName='" + eventName + '\'' +
                ", eventLocation=" + eventLocation +
                '}';
    }
}
