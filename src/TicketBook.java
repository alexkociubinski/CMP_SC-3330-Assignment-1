public final class TicketBook {

    private final Ticket[] tickets;
    private int count;


    public TicketBook(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("tickets must be positive");
        }
        this.tickets = new Ticket[capacity];
        this.count = 0;
    }

    public Ticket createTicket(int id, Event event, TicketType type, String studentName) {
        if (count >= tickets.length) {
            throw new IllegalStateException("tickets are full");
        }
        Ticket ticket = new Ticket(id, event, type, studentName);
        tickets[count] = ticket;
        count++;
        return ticket;
    }

    public Ticket findById(int id) {
        for (int i = 0; i < count; i++) {
            if (tickets[i].getId() == id) {
                return tickets[i];
            }
        }
        return null;
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(tickets[i]);
        }
    }

    public void printForEvent(Event event) {
        for (int i = 0; i < count; i++) {
            if (tickets[i].getEvent() == event) {
                System.out.println(tickets[i]);
            }
        }
    }

    public int getCount() {
        return count;
    }
}