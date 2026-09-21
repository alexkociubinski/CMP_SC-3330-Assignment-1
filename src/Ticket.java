public final class Ticket {

  private final int id;
  private final Event event;
  private final TicketType ticketType;
  private final String studentName;
  private boolean canceled;
  private boolean admitted;

  public Ticket(int id, Event event, TicketType ticketType, String studentName) {
    if (id <= 0) {
      throw new IllegalArgumentException("Ticket id has to be positive.");
    }

    if (event == null) {
      throw new IllegalArgumentException("Ticket event cannot null.");
    }

    if (ticketType == null) {
      throw new IllegalArgumentException("ticketType cannot not be null.");
    }

    if (studentName == null || studentName.isBlank()) {
      throw new IllegalArgumentException("studentName cannot be null or blank.");
    }

    // Initiate everything to their base value
    this.id = id;
    this.event = event;
    this.ticketType = ticketType;
    this.studentName = studentName;
    this.canceled = false;
    this.admitted = false;
  }

  public boolean cancel() {
    if (canceled || admitted) { // If canceled or admitted, if they go to the event or if its already canceled return false if not they return true while setting canceled to true
        return false;
    }
    canceled = true;
    return true;
  }

  public boolean admit() {
    if (admitted || canceled) { // Same Idea as before
      return false;
    }
    admitted = true;
    return true;
  }

  // Getters
  public int getId() {
    return id;
  }

  public Event getEvent() {
    return event;
  }

  public TicketType getTicketType() {
    return ticketType;
  }

  public String getStudentName() {
    return studentName;
  }

  public boolean isCanceled() {
    return canceled;
  }

  public boolean isAdmitted() {
    return admitted;
  }

  public boolean isActive() {
    if (canceled || admitted) {
      return false;
    }
    return true;
  }


  private String statusLabel() { // Returns the status of the Ticket
    if (canceled) {
      return "CANCELED";
    }
    if (admitted) {return "ADMITTED";
    }
    return "ACTIVE";
  }


  @Override
  public String toString() { // make it print prettier
    return String.format(
      "Ticket id: #%d | Name: %s | Event: %s | Status: %s | status: %s", id, studentName, event, ticketType, statusLabel());
  }
}