public final class Event {

    private final String name;
    private final String location;

    public Event(String name, String location) {
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Event location can't be NULL!");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Event name can't be NULL!");
        }
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return name + " at " + location;
    }
}
