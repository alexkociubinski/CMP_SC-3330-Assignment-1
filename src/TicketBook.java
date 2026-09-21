public final class TicketBook {     // stores tickets in array, keeps track of how many were used

    private final Ticket[] tickets;
    private int count;


    public TicketBook(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("tickets must be positive");
        }
        this.tickets = new Ticket[capacity];
        this.count = 0;
    }

    public Ticket createTicket(int id, Event event, TicketType type, String studentName) {        // makes new ticket and adds to the array
        if (count >= tickets.length) {
            throw new IllegalStateException("tickets are full");
        }
        Ticket ticket = new Ticket(id, event, type, studentName);
        tickets[count] = ticket;
        count++;
        return ticket;
    }

    public Ticket findById(int id) {            // looks through array with the id, returns null if its not found
        for (int i = 0; i < count; i++) {
            if (tickets[i].getId() == id) {
                return tickets[i];
            }
        }
        return null;
    }

    public void printAll() {            // prints the tickets
        for (int i = 0; i < count; i++) {
            System.out.println(tickets[i]);
        }
    }
        // only print ticket that belong to the event
    public void printForEvent(Event event) {
        for (int i = 0; i < count; i++) {
            if (tickets[i].getEvent() == event) {
                System.out.println(tickets[i]);
            }
        }
    }

    public int getCount() {     // how many tickets are stored
        return count;
    }
}