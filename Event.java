
public class Event {
    private String title;
    private String category;
    private int day, month, year;

    public Event(String title, String category, int day, int month, int year) {
        this.title = title;
        this.category = category;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toFileString() {
        return title + "," + category + "," + day + "," + month + "," + year;
    }

    public static Event fromFileString(String line) {
        String[] parts = line.split(",");
        return new Event(parts[0], parts[1],
                Integer.parseInt(parts[2]),
                Integer.parseInt(parts[3]),
                Integer.parseInt(parts[4]));
    }

    public String toString() {
        return title + " | " + category + " | " + day + "/" + month + "/" + year;
    }

    public String getCategory() {
        return category;
    }
}
