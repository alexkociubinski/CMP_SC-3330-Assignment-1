// Create ticketmanager class
public final class TicketManager {

    // Create variables for ticketbook and nextid, uses ticketbook class
    private final TicketBook ticketBook;
    private int nextId;

    public TicketManager(TicketBook ticketBook) { // Check for NULL
        if (ticketBook == null) {
            throw new IllegalArgumentException("TicketBook cannot be NULL!");
        }
        this.ticketBook = ticketBook;
        this.nextId = 1; // ticket ids start at 1
    }

    // Creates a ticket with next available id and increases counter
    public Ticket createTicket(Event event, TicketType type, String studentName) {
        Ticket ticket = ticketBook.createTicket(nextId, event, type, studentName);
        nextId++; // Increment nextID
        return ticket;
    }

    // Finds ticket and cancels it
    public boolean cancelTicket(int id) {
        Ticket ticket = ticketBook.findById(id); // Use findByID from TicketBook
        if (ticket == null) { // Check for NULL and throw exception
            throw new IllegalArgumentException("Couldn't find id: " + id);
        }
        return ticket.cancel(); // Use cancel from Ticket class
    }

    // Finds ticket and admits it
    public boolean admitTicket(int id) {
        Ticket ticket = ticketBook.findById(id); // Use findByID from TicketBook
        if (ticket == null) { // Check for NULL and throw exception
            throw new IllegalArgumentException("Couldn't find id: " + id);
        }
        return ticket.admit(); // Use admit from Ticket class
    }

    public TicketBook getTicketBook() {
        return ticketBook;
    }
}