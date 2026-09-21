public final class TicketType {

  private final String name;
  private final double cost;

  public TicketType(String name, double cost) {if (name == null || name.isBlank()) {
    throw new IllegalArgumentException("TicketType name can't null or blank."); // Check if ticket is blank or null
  }

    if (cost < 0) {
      throw new IllegalArgumentException("TicketType price must be positive.");  // Make's sure that the cost of the ticket is always pos
    }

    this.name = name;
    this.cost = cost;
  }


  public String getName() {
    return name; // fetches name
  }


  public double getCost() {
    return cost; // fetches cost
  }


  @Override
  public String toString() {
    return String.format("%s ($%.2f)", name, cost); // This makes sure that you can go and print it out without looking band
  }
}