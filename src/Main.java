public final class Main public final class Main {

    public static void main(String[] args) {

        Event lecture = new Event("Cybersecurity Guest Lecture", "Engineering Building");           // set up a couple events
        Event concert = new Event("Fall Jazz Concert", "Performing Arts Center");

        TicketType student = new TicketType("Student", 5.00);        // ticket types
        TicketType general = new TicketType("General", 15.00);

        TicketBook ticketBook = new TicketBook(10);
        TicketManager manager = new TicketManager(ticketBook);

        Ticket t1 = manager.createTicket(lecture, student, "Jaden");               // making 5 tickets, mix of events and types
        Ticket t2 = manager.createTicket(lecture, general, "Brayden");
        Ticket t3 = manager.createTicket(concert, general, "Alex");
        Ticket t4 = manager.createTicket(concert, student, "Sam");
        Ticket t5 = manager.createTicket(lecture, general, "Matt");

        System.out.println("All tickets:");
        ticketBook.printAll();
        System.out.println();

        boolean admitResult = manager.admitTicket(t1.getId());        // admit ticket 1
        System.out.println("Admitted ticket 1: " + admitResult);

        boolean cancelResult = manager.cancelTicket(t3.getId());              // cancel ticket 3
        System.out.println("Cancelled ticket 3: " + cancelResult);
        System.out.println();

        System.out.println("Now trying some invalid stuff:");               // now try some stuff that should fail

        boolean reAdmit = manager.admitTicket(t1.getId()); // already admitted, should be false
        System.out.println("Tried to admit ticket 1 again: " + reAdmit);

        boolean cancelAdmitted = manager.cancelTicket(t1.getId()); // cant cancel an admitted ticket
        System.out.println("Tried to cancel ticket 1 (already admitted): " + cancelAdmitted);

        boolean admitCanceled = manager.admitTicket(t3.getId()); // already cancelled
        System.out.println("Tried to admit ticket 3 (already cancelled): " + admitCanceled);

        try {
            manager.admitTicket(9999); // id doesnt exist
        } catch (IllegalArgumentException e) {
            System.out.println("Tried a ticket id that doesn't exist: " + e.getMessage());
        }

        System.out.println();
        System.out.println("All tickets after everything:");
        ticketBook.printAll();

        System.out.println();
        System.out.println("Tickets just for the lecture:");
        ticketBook.printForEvent(lecture);
    }
}