import event.*;
import service.EventService;
import user.User;

import javax.swing.*;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Event> allEvents = new ArrayList<Event>();

        LocalDateTime Now = LocalDateTime.now();

        //For testing purposes i have no databaase yet so i ahave these here
        allEvents.add(new CarMeet("CarMeet_1", new Location("Location_meet_1", "address_meet_1", Now, true), 20.0, 100, "Prize 1"));
        allEvents.add(new BookSigning("BookSigning_1", new Location("Location_signing_1", "address_signing_1",  Now, true), "Marian", "Viata lui Marian", true));
        allEvents.add(new MusicConcert("MusicConcert_1", new Location("Location_concert_1", "address_concert_1",  Now, true),  new ArrayList<String>(Arrays.asList("Loaoa", "banajs", "asdasdasf")), 123.0, 100));
        allEvents.add(new Play("Play_1", new Location("Location_play_1", "address_play_1",  Now, true), "papap", 20.0, 100,  new ArrayList<String>(Arrays.asList("paly", "play", "play"))));

        Integer size = -1;

        List<User> allOrders = new ArrayList<User>();

        EventService service = EventService.getInstance();
        Scanner sc = new Scanner(System.in);

        while(true)
        {
            User user = new User();
            System.out.println("              Welcome dummy!");
            System.out.println("Why are you here? (pick one)");
            System.out.println("1. Buy a ticket");
            System.out.println("2. I'm admin baby!");
            System.out.println("3. Let me oooooout!");
            String input = sc.nextLine();

            if(input.equalsIgnoreCase("3")) {
                System.out.println(" Bye bye birdie! Have... a day.");
                break;
            }
            switch (input) {
                case "1": {
                    while(true)
                    {
                        System.out.println("   Hi loser! ");
                        System.out.println("1. See Events");
                        System.out.println("2. Too much for me man! I want out!");

                        String input1 = sc.nextLine();

                        if(input1.equalsIgnoreCase("2")) {

                            if(user.getTickets().size() > 0)
                            {
                                System.out.println(" Can we have a name for this order? Insert name:");
                                String input4 = sc.nextLine();

                                service.printOrder(allOrders, user, input4);
                            }
                            else {
                                System.out.println("Come again, cheapskate!");
                            }
                            break;
                        }
                        switch (input1) {
                            case "1": {

                                while(true) {
                                    service.listAllEvents(allEvents);
                                    size = allEvents.size();
                                    System.out.println(size + ". I changed my mind! I wanna leave!");

                                    String input2 = sc.nextLine();

                                    if (Integer.parseInt(input2) < size){
                                        if (allEvents.get(Integer.parseInt(input2)) instanceof BookSigning) {
                                            System.out.println("         See ya at the book signing!");
                                            service.updateOrderBookSigning(((BookSigning) allEvents.get(Integer.parseInt(input2))), user);
                                        }
                                        else {
                                            while(true) {
                                                System.out.println("  Let's see how much friends we have, shall we?");
                                                System.out.println("Insert the number of tickets that you want to buy: ");

                                                String input3 = sc.nextLine();

                                                try {
                                                    Integer noTickets = Integer.parseInt(input3);
                                                    if (noTickets > 0)
                                                    {
                                                        try {
                                                            service.updateTicketsLeft(allEvents.get(Integer.parseInt(input2)), noTickets, user);
                                                            break;
                                                        }
                                                        catch (RuntimeException e) {
                                                            System.out.println(e.getMessage());
                                                        }
                                                    }
                                                    else if (noTickets == 0){
                                                        System.out.println("Well you changed your mind... so back you go!");
                                                        break;
                                                    }
                                                    else{
                                                        System.out.println("Try a valid number dummy! (bigger than 0)");
                                                    }
                                                }
                                                catch (Exception e) {
                                                    System.out.println("Mai I interest you in a natural positive number my liege?");
                                                }

                                            }
                                        }
                                    }
                                    else if (Integer.parseInt(input2) == size) {
                                        break;
                                    }
                                    else
                                        System.out.println("My guy... get your mind in order. Try again... or please don't.");
                                }
                                break;
                            }
                            default: {
                                System.out.println("Really? Try that one again my dude.");
                            }
                        }
                    }
                    break;
                }
                case "2": {
                    while(true){
                        System.out.println("   Hi almighty one! What are we doing today?");
                        System.out.println("1. Edit Events");
                        System.out.println("2. List all Events left");
                        System.out.println("3. List Events by Location");
                        System.out.println("4. Show Events from given date");
                        System.out.println("5. Alright, Imma head out.");

                        String input1 = sc.nextLine();

                        if(input1.equalsIgnoreCase("5")) {
                            System.out.println("Adios!");
                            break;
                        }
                        switch (input1){
                            case "1" : {
                                while(true){
                                    System.out.println("  Let's choose an action.");
                                    System.out.println("1.Add event");
                                    System.out.println("2.Delete event");
                                    System.out.println("3.Delete sold out events");
                                    System.out.println("4.See all orders placed");
                                    System.out.println("5.I'm bored and I want home, get me out!");

                                    String input4 = sc.nextLine();

                                    if(input4.equalsIgnoreCase("5")) {
                                        System.out.println("Have a great day my liege!");
                                        break;
                                    }
                                    switch(input4){
                                        case "1":{
                                            Boolean gaveUp = false;
                                            String newEventType = "";
                                            System.out.println("      Let's start with the beginning:");
                                            System.out.println("Event name: ");
                                            String newEventName = sc.nextLine();

                                            System.out.println("Insert the event's type: ");
                                            while(true) {
                                                System.out.println("  What type of event is it?");
                                                System.out.println("1.Car Meet");
                                                System.out.println("2.Book Signing");
                                                System.out.println("3.Music Concert");
                                                System.out.println("4.Play");
                                                System.out.println("5.I'm so confused... i give up.");

                                                String input6 = sc.nextLine();

                                                if(input6.equalsIgnoreCase("1")){
                                                    newEventType = "CM";
                                                    break;
                                                }
                                                else if(input6.equalsIgnoreCase("2")){
                                                    newEventType = "BS";
                                                    break;
                                                }
                                                else if(input6.equalsIgnoreCase("3")){
                                                    newEventType = "MC";
                                                    break;
                                                }
                                                else if(input6.equalsIgnoreCase("4")){
                                                    newEventType = "P";
                                                    break;
                                                }
                                                else if(input6.equalsIgnoreCase("5")){
                                                    gaveUp = true;
                                                    break;
                                                }
                                                else{
                                                    System.out.println("It's 1:15am,  just figure it out bud.");
                                                }

                                            }

                                            System.out.println("Insert the event's location name: ");
                                            String newEventLocationName = sc.nextLine();

                                            System.out.println("Insert the event's location address: ");
                                            String newEventLocationAddress = sc.nextLine();

                                            LocalDateTime newEventLocationDateTime = null;

                                            while(true){
                                                System.out.println("Insert the event's Date and Time: ");
                                                System.out.println("Give up? Write 'Tis but a scratch!'");

                                                String input7 = sc.nextLine();

                                                if(input7.equalsIgnoreCase("Tis but a scratch!")){
                                                    gaveUp = true;
                                                    break;
                                                }
                                                else {
                                                    try{
                                                        newEventLocationDateTime = LocalDateTime.parse(input7,
                                                                DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm"));
                                                        break;
                                                    }
                                                    catch (RuntimeException e) {
                                                        service.missInputMessage(input7);
                                                        System.out.println("Try something like this wen you're adding a new Event: MMM dd, yyy HH:mm (ex: Jan 15, 2019 20:00)");
                                                    }
                                                }
                                            }

                                            Boolean newEventLocationIsOutside = true;

                                            while(true) {
                                                System.out.println("Is outside or not? Insert 1 for 'Yes' and 2 for 'No'");
                                                System.out.println("Give up? Write 'A coconut'");
                                                String input8 = sc.nextLine();

                                                if(input8.equalsIgnoreCase("1")){
                                                    newEventLocationIsOutside = true;
                                                    break;

                                                }
                                                else if(input8.equalsIgnoreCase("2")){
                                                    newEventLocationIsOutside = false;
                                                    break;

                                                }
                                                else if(input8.equalsIgnoreCase("A coconut")){
                                                    gaveUp = true;
                                                    break;
                                                }
                                                else {
                                                    System.out.println("  How hard is it to write 1 or 2???!?!?1?!... see i just did it by mistake geesh.");
                                                }
                                            }


                                            if (gaveUp) {
                                                System.out.println("Did not add the new event... i guess you chickened oout.");
                                            }
                                            else {
                                                Boolean gUp = false;
                                                Location newEventLocation = new Location(newEventLocationName, newEventLocationAddress, newEventLocationDateTime, newEventLocationIsOutside);

                                                if(newEventType.equalsIgnoreCase("CM")) {

                                                    Double newEventEnteryFee = 0.0;
                                                    Integer newEventTicketsLeft = 0;
                                                    String newEventPrize = "";

                                                    while(true){
                                                        System.out.println("Insert the entry fee for the car meet: ");
                                                        System.out.println("Can't figure it out? Write 'I'm a big dummy!'");

                                                        String input9 = sc.nextLine();

                                                        if(input9.equalsIgnoreCase("I'm a big dummy!")){
                                                            gUp = true;
                                                            break;
                                                        }
                                                        else{
                                                            try{
                                                                newEventEnteryFee = Double.parseDouble(input9);
                                                                break;
                                                            }
                                                            catch (RuntimeException e) {
                                                                service.missInputMessage(input9);
                                                                System.out.println("Try a double number bruv.");
                                                            }
                                                        }
                                                    }

                                                    while(true){
                                                        System.out.println("Insert the number of tickets avilable for the car meet: ");
                                                        System.out.println("Can't figure it out? Write 'You a big dummy!'");

                                                        String input10 = sc.nextLine();

                                                        if(input10.equalsIgnoreCase("You a big dummy!")) {
                                                            gUp = true;
                                                            break;
                                                        }
                                                        else {
                                                            try{
                                                                newEventTicketsLeft = Integer.parseInt(input10);
                                                                break;
                                                            }
                                                            catch (RuntimeException e) {
                                                                System.out.println("Try a int number bruv.");
                                                            }
                                                        }
                                                    }

                                                    System.out.println("Insert the prize for the coolest car: ");
                                                    String input11 = sc.nextLine();

                                                    newEventPrize = input11;

                                                    if (gUp){
                                                        System.out.println("Not added a new event because you're a quitter");
                                                    }
                                                    else {
                                                        allEvents.add(new CarMeet(newEventName, newEventLocation, newEventEnteryFee, newEventTicketsLeft, newEventPrize));
                                                        System.out.println("Event Car Meet added succesfully");
                                                    }
                                                }
                                                else if (newEventType.equalsIgnoreCase("BS")) {
                                                    String newEventAuthor = "";
                                                    String newEventBookTitle = "";
                                                    Boolean newEventHasBookRead = null;

                                                    System.out.println("Insert the author's name: ");
                                                    String input9 = sc.nextLine();

                                                    newEventAuthor = input9;

                                                    System.out.println("Insert the author's book title: ");
                                                    String input10 = sc.nextLine();

                                                    newEventBookTitle = input10;

                                                    while(true) {
                                                        System.out.println("If there will be a book read choose 1 for Yes and 2 for No");

                                                        String input11 = sc.nextLine();
                                                        if(input11.equalsIgnoreCase("1")){
                                                            newEventHasBookRead = true;
                                                            break;
                                                        }
                                                        else if(input11.equalsIgnoreCase("2")){
                                                            newEventHasBookRead = false;
                                                            break;
                                                        }
                                                        else {
                                                            System.out.println("You know the drill... ");
                                                        }
                                                    }

                                                    allEvents.add(new BookSigning(newEventName, newEventLocation, newEventAuthor, newEventBookTitle, newEventHasBookRead));
                                                    System.out.println("Event Book Signing added succesfully");

                                                }
                                                else if (newEventType.equalsIgnoreCase("MC")) {
                                                    List<String> newEventArtists = null;
                                                    Double newEventPrice = 0.0;
                                                    Integer newEventTicketsLeft = 0;

                                                    System.out.println("Insert the artists names separated by commas : ");
                                                    String input9 = sc.nextLine();

                                                    newEventArtists = Arrays.stream(input9.split(",")).toList();

                                                    while(true){
                                                        System.out.println("Insert the price of a ticket: ");
                                                        System.out.println("Can't figure it out? Write 'I'm a big dummy!'");

                                                        String input10 = sc.nextLine();
                                                        if(input10.equalsIgnoreCase("I'm a big dummy!")){
                                                            gUp = true;
                                                            break;
                                                        }
                                                        else {
                                                            try{
                                                                newEventPrice = Double.parseDouble(input10);
                                                                break;
                                                            }
                                                            catch (RuntimeException e) {
                                                                System.out.println("Try a double number bruv.");
                                                            }
                                                        }
                                                    }

                                                    while(true){
                                                        System.out.println("Insert the number of tickets avilable for the Music Concert: ");
                                                        System.out.println("Can't figure it out? Write 'You a big dummy!'");

                                                        String input11 = sc.nextLine();

                                                        if(input11.equalsIgnoreCase("You a big dummy!")){
                                                            gUp = true;
                                                            break;
                                                        }
                                                        else {
                                                            try{
                                                                newEventTicketsLeft = Integer.parseInt(input11);
                                                                break;
                                                            }
                                                            catch (RuntimeException e) {
                                                                System.out.println("Try a integer bruv.");
                                                            }
                                                        }
                                                    }

                                                    if (gUp){
                                                        System.out.println("Not added a new event because you're a quitter");
                                                    }
                                                    else {
                                                        allEvents.add(new MusicConcert(newEventName, newEventLocation, newEventArtists, newEventPrice, newEventTicketsLeft));
                                                        System.out.println("Event Music Concert added succesfully");
                                                    }

                                                }
                                                else if (newEventType.equalsIgnoreCase("P")) {
                                                    String newEventGroupName = "";
                                                    Double newEventPrice = 0.0;
                                                    Integer newEventTicketsLeft = 0;
                                                    List<String> newEventListOfPlays;

                                                    System.out.println(" Insert the group's name: ");
                                                    String input9 = sc.nextLine();

                                                    newEventGroupName = input9;

                                                    while(true){
                                                        System.out.println("Insert the price of a ticket: ");
                                                        System.out.println("Can't figure it out? Write 'I'm a big dummy!'");

                                                        String input10 = sc.nextLine();

                                                        if(input10.equalsIgnoreCase("I'm a big dummy!")){
                                                            gUp = true;
                                                            break;
                                                        }
                                                        else {
                                                            try{
                                                                newEventPrice = Double.parseDouble(input10);
                                                                break;
                                                            }
                                                            catch (RuntimeException e) {
                                                                System.out.println("Try a double number bruv.");
                                                            }
                                                        }
                                                    }

                                                    while(true){
                                                        System.out.println("Insert the number of tickets avilable for the Play: ");
                                                        System.out.println("Can't figure it out? Write 'You a big dummy!'");

                                                        String input11 = sc.nextLine();

                                                        if(input11.equalsIgnoreCase("You a big dummy!")){
                                                            gUp = true;
                                                            break;
                                                        }
                                                        else {
                                                            try{
                                                                newEventTicketsLeft = Integer.parseInt(input11);
                                                                break;
                                                            }
                                                            catch (RuntimeException e) {
                                                                System.out.println("Try a integer bruv.");
                                                            }
                                                        }
                                                    }

                                                    System.out.println("Insert a list of plays separated by commas: ");
                                                    String line12 = sc.nextLine();

                                                    newEventListOfPlays = Arrays.stream(line12.split(",")).toList();

                                                    if (gUp){
                                                        System.out.println("Not added a new event because you're a quitter");
                                                    }
                                                    else {
                                                        allEvents.add(new Play(newEventName, newEventLocation, newEventGroupName, newEventPrice, newEventTicketsLeft, newEventListOfPlays));
                                                        System.out.println("Event Play added succesfully");
                                                    }
                                                }
                                                else{
                                                    System.out.println("Did not add the new event... What happened bud?");
                                                }
                                            }
                                            break;
                                        }
                                        case "2": {
                                            while(true){
                                                service.listAllEvents(allEvents);
                                                size = allEvents.size();
                                                System.out.println(size + ". I feel mercyful today!");

                                                String input5 = sc.nextLine();

                                                try {
                                                    if (Integer.parseInt(input5) < size) {
                                                        allEvents.remove(Integer.parseInt(input5));
                                                    }
                                                    else if (Integer.parseInt(input5) == size) {
                                                        System.out.println("Your wisdom knows no bounds my liege, tank ye!");
                                                        break;
                                                    }
                                                    else {
                                                        System.out.println("What am I? Your mama? Learn your own numbers... smaller than ... that one.");
                                                    }
                                                }
                                                catch (RuntimeException e){
                                                    System.out.println("What am I? Your mama? Learn your own numbers.");
                                                }
                                            }
                                            break;
                                        }
                                        case "3": {
                                            service.deleteSoldOutEvents(allEvents);
                                            System.out.println("Done!\n");
                                            break;
                                        }
                                        case "4": {
                                            System.out.println("Here are all the orders placed:");
                                            try{
                                                if(allOrders.size() > 0){
                                                    allOrders.forEach(System.out::println);
                                                    System.out.println("\n Glad to be of service!");
                                                }
                                                else
                                                    throw new RuntimeException("No orders placed yet I'm afraind.");

                                            }
                                            catch (RuntimeException e){
                                                System.out.println(e.getMessage());
                                            }
                                            finally{
                                                break;
                                            }
                                        }
                                        default: {
                                            System.out.println("Try one of the available options, you'd be surprised what happens.");
                                        }
                                    }
                                }
                                break;
                            }
                            case "2" : {
                                System.out.println("Here are all the events left in the database: ");
                                if(allEvents.size() > 0) {
                                    allEvents.forEach(System.out::println);
                                } else {
                                    System.out.println("Noting to see here folks, move along!");
                                }
                                break;
                            }
                            case "3" : {
                                while(true){

                                    System.out.println(" What are you waiting for? Insert the wanted location ... and you call yourself admin...");
                                    System.out.println("Or if you want to give up then type 'I surrender'");
                                    String input3 = sc.nextLine();

                                    if(input3.equalsIgnoreCase("I surrender")) {
                                        break;
                                    }
                                    else{
                                        try {
                                            service.showEventsFromLocation(input3, allEvents);
                                            System.out.println("Anything else?");
                                            break;
                                        } catch (RuntimeException e) {
                                            System.out.println("Try something like... idk a VALID LOCATION? Or give up already.");
                                        }
                                    }
                                }
                                break;
                            }
                            case "4" : {
                                while(true) {
                                    System.out.println(" What are you waiting for? Insert the wanted date ... and you call yourself admin...");
                                    System.out.println("Or if you want to give up then type 'I surrender'");

                                    String input2 = sc.nextLine();

                                    if(input2.equalsIgnoreCase("I surrender")) {
                                        break;
                                    }
                                    else {
                                        try {
                                            LocalDateTime dateTime = LocalDateTime.parse(input2,
                                                    DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm"));
                                            service.showEventsFromDate(dateTime, allEvents);
                                            System.out.println("Anything else?");
                                            break;
                                        } catch (RuntimeException e) {
                                            service.missInputMessage(input2);
                                            System.out.println("Try something like: MMM dd, yyy HH:mm (ex: Jan 15, 2019 20:00)");
                                        }
                                    }
                                }
                                break;
                            }
                            default : {
                                System.out.println(" Can I help you find a doctor for your Parkinson? No? Hmm better try that again then. ");
                            }
                        }
                    }
                    break;
                }
                default :{
                    System.out.println("Try again bucko!");
                }
            }
        }
    }
}
