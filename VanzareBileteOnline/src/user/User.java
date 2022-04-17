package user;

import java.util.ArrayList;
import java.util.List;

public class User {

    public String name;
    public List<Ticket> tickets;

    public User(String name, List<Ticket> tickets) {
        this.name = name;
        this.tickets = tickets;
    }

    public User(){
        this.name = "John Doe";
        this.tickets = new ArrayList<Ticket>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", tickets=" + tickets +
                '}';
    }
    public void addTicket(Ticket ticket){
        this.tickets.add(ticket);
    }
}
