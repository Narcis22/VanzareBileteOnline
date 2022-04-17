package event;

import java.util.List;

public class Play extends Event{

    public String groupName;
    public Double price;
    public Integer ticketsLeft;
    public List<String> listOfPlays;

    public Play(String eventName, Location eventLocation, String groupName, Double price, Integer ticketsLeft, List<String> listOfPlays) {
        super(eventName, eventLocation);
        this.groupName = groupName;
        this.price = price;
        this.ticketsLeft = ticketsLeft;
        this.listOfPlays = listOfPlays;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    public List<String> getlistOfPlays() {
        return listOfPlays;
    }

    public void setlistOfPlays(List<String> listOfPlays) {
        this.listOfPlays = listOfPlays;
    }

    @Override
    public String toString() {
        return "Play{" +
                "eventName='" + eventName + '\'' +
                ", eventLocation=" + eventLocation +
                ", groupName='" + groupName + '\'' +
                ", price=" + price +
                ", ticketsLeft=" + ticketsLeft +
                ", listOfPlays=" + listOfPlays +
                '}';
    }
}
