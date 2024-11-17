package com.practice.mypractice.interview18;
/*

This is a TDD exercise -
Given a class with multiple test cases, write down the code so that all the tests pass.
You are not allowed to modify the tests.


import junit.framework.*;

public class ConcertTicketTest extends TestCase {
    private Concert concert;
    private User user;
    private User user2;

    protected void setUp() {
        concert = new Concert();
        user = new User();
        user2 =  new User();
    }

    public void testCreateTicket() {
        concert.initialRow("Row A", 3000);
        concert.initialRow("Row B", 1500);
        concert.initialRow("Row C", 500);

        Ticket ticket = concert.createTicket("Row B");
        assertEquals("Row B", ticket.getRow());
        assertEquals(1500, ticket.getPrice());
    }

    public void testCreateTicketFromUnavailableRow() {
        concert.initialRow("Row A", 3000);
        concert.initialRow("Row B", 1500);
        concert.initialRow("Row C", 500);

        Ticket ticket = concert.createTicket("Row D");
        assertEquals(null, ticket);
    }

    public void testCreateTwoTicket() {
        concert.initialRow("Row A", 2000);
        concert.initialRow("Row B", 1200);
        concert.initialRow("Row C", 800);

        Ticket ticket = concert.createTicket("Row C");
        assertEquals("Row C", ticket.getRow());
        assertEquals(800, ticket.getPrice());

        Ticket ticket2 = concert.createTicket("Row B");
        assertEquals("Row B", ticket2.getRow());
        assertEquals(1200, ticket2.getPrice());
    }

    public void testUserPurchaseConcertTickets() {
        concert.initialRow("Row A", 3000, 2);
        concert.initialRow("Row B", 1500, 3);
        concert.initialRow("Row C", 500);

        user.purchase(concert.createTicket("Row A"));
        user.purchase(concert.createTicket("Row A"));
        user.purchase(concert.createTicket("Row B"));

        assertEquals(7500, user.totalPrice());
        assertEquals(3, user.getNumberOfOwnedTickets());
        assertEquals(0, concert.getAvailableSeats("Row A"));
        assertEquals(2, concert.getAvailableSeats("Row B"));
        assertEquals(Integer.MAX_VALUE, concert.getAvailableSeats("Row C"));
    }

    public void testPurchaseTicketOverLimit() {
        concert.initialRow("Row A", 2000, 2);
        concert.initialRow("Row B", 1200, 3);
        concert.initialRow("Row C", 800, 10);

        user.purchase(concert.createTicket("Row A"));
        user.purchase(concert.createTicket("Row A"));
        user.purchase(concert.createTicket("Row A"));
        user.purchase(concert.createTicket("Row C"));
        user.purchase(concert.createTicket("Row C"));
        user2.purchase(concert.createTicket("Row A"));

        assertEquals("Row A", user.getOwnedTickets().get(0).getRow());
        assertEquals(2000, user.getOwnedTickets().get(0).getPrice());

        assertEquals("Row A", user.getOwnedTickets().get(1).getRow());
        assertEquals(2000, user.getOwnedTickets().get(1).getPrice());

        assertEquals("Row C", user.getOwnedTickets().get(2).getRow());
        assertEquals(800, user.getOwnedTickets().get(2).getPrice());

        assertEquals(5600, user.totalPrice());
        assertEquals(4, user.getNumberOfOwnedTickets());

        assertEquals(0, user2.totalPrice());
        assertEquals(0, user2.getNumberOfOwnedTickets());

        assertEquals(0, concert.getAvailableSeats("Row A"));
        assertEquals(8, concert.getAvailableSeats("Row C"));
    }
}








package com.mycompany.app;

public class Row {

    private String rowName;

    private int price;

    private int availableSeats;


    public Row(String rowName, int price) {
        this.rowName = rowName;
        this.price = price;
        this.availableSeats = Integer.MAX_VALUE;
    }


    public Row(String rowName, int price, int availableSeats) {
        this.rowName = rowName;
        this.price = price;
        this.availableSeats = availableSeats;
    }

    public String getRowName(){
        return rowName;
    }


    public void setRowName(String rowName){
        this.rowName = rowName;
    }


    public int getPrice(){
        return price;
    }


    public void setPrice(int price){
        this.price = price;
    }



    public int getAvailableSeats(){
        return availableSeats;
    }


    public void setAvailableSeats(int availableSeats){
        this.availableSeats = availableSeats;
    }

}







package com.mycompany.app;
import java.util.*;

public class User {

    private List<Ticket> tickets;

    private int totalAmountSpent;

    public User(){
        tickets = new ArrayList<>();
        totalAmountSpent = 0;
    }


    public void purchase(Ticket ticket) {
        if (ticket != null){
            tickets.add(ticket);
            totalAmountSpent += ticket.getPrice();
        }
    }

    public int totalPrice() {
        return totalAmountSpent;
    }

    public int getNumberOfOwnedTickets() {
        return tickets.size();
    }

    public List<Ticket> getOwnedTickets() {
        return tickets;
    }
}








package com.mycompany.app;
import java.util.*;

public class Concert {

    Map<String, Row> rows;


    public Concert() {
        rows = new HashMap<>();
    }




    public void initialRow(String rowName, int price) {
        rows.put(rowName, new Row(rowName, price));
    }

    public void initialRow(String rowName, int price, int availableSeats) {
        rows.put(rowName, new Row(rowName, price, availableSeats));
    }

    public Ticket createTicket(String rowName){
        Ticket ticket = null;
        Row row = rows.get(rowName);
        if (row != null){
            int availableSeats = row.getAvailableSeats();
            int price = row.getPrice();
            if (availableSeats > 0) {

                ticket = new Ticket(rowName, price);
                if (availableSeats != Integer.MAX_VALUE) {
                    row.setAvailableSeats(availableSeats-1);
                }
            }
        }
        return ticket;
    }

    public int getAvailableSeats(String rowName){
        Row row = rows.get(rowName);
        if (row != null) {
            return row.getAvailableSeats();
        }

        return -1;
    }
}










package com.mycompany.app;
import java.util.*;

public class Ticket {

    private String row;
    private int price;

    public Ticket(String row, int price){
        this.row = row;
        this.price = price;
    }

    public String getRow(){
        return row;
    }



    public int getPrice(){
        return price;
    }



}


 */