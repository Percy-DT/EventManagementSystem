
import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private static final String FILE_NAME = "events.txt";

    public static void saveEvent(Event event) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(event.toFileString());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Event> loadEvents() {
        ArrayList<Event> events = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                events.add(Event.fromFileString(line));
            }
        } catch (IOException e) {
            System.out.println("No file found yet.");
        }
        return events;
    }

    public static void overwriteFile(ArrayList<Event> events) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Event e : events) {
                bw.write(e.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
