public final class TicketType {

  private final String name;
  private final double price;

  public TicketType(String name, double price) {if (name == null || name.isBlank()) {
    throw new IllegalArgumentException("TicketType name can't null or blank."); // Check if ticket is blank or null
  }

    if (price < 0) {
      throw new IllegalArgumentException("TicketType price must be positive.");  // Make's sure that the cost of the ticket is always pos
    }

    this.name = name;
    this.price = price;
  }


  public String getName() {
    return name; // fetches name
  }


  public double getPrice() {
    return price; // fetches cost
  }


  @Override
  public String toString() {
    return String.format("%s ($%.2f)", name, price); // This makes sure that you can go and print it out without looking band
  }
}