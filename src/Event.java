//Create Event Class
public final class Event {

    // Create variables for name and location
    private final String name;
    private final String location;

    // Create a new event
    public Event(String name, String location) {
        if (location == null || location.isBlank()) { // Check for null or blank values
            throw new IllegalArgumentException("Event location can't be NULL!");
        }
        if (name == null || name.isBlank()) { // Check for null or blank values
            throw new IllegalArgumentException("Event name can't be NULL!");
        }
        // Save name and location
        this.name = name;
        this.location = location;
    }

    // Get event name
    public String getName() {
        return name;
    }

    // Get location name
    public String getLocation() {
        return location;
    }

    // Return the event name as a string
    @Override
    public String toString() {
        return name + " at " + location;
    }
}
