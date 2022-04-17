package event;

import java.util.List;

public class MusicConcert extends Event{

    public List<String> artists;
    public Double price;
    public Integer ticketsLeft;

    public MusicConcert(String eventName, Location eventLocation, List<String> artists, Double price, Integer ticketsLeft) {
        super(eventName, eventLocation);
        this.artists = artists;
        this.price = price;
        this.ticketsLeft = ticketsLeft;
    }

    public List<String> getArtists() {
        return artists;
    }

    public void setArtists(List<String> artists) {
        this.artists = artists;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getticketsLeft() {
        return ticketsLeft;
    }

    public void setticketsLeft(Integer ticketsLeft) {
        this.ticketsLeft = ticketsLeft;
    }

    @Override
    public String toString() {
        return "MusicConcert{" +
                "eventName='" + eventName + '\'' +
                ", eventLocation=" + eventLocation +
                ", artists=" + artists +
                ", price=" + price +
                ", ticketsLeft=" + ticketsLeft +
                '}';
    }
}
