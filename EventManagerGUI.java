
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EventManagerGUI extends JFrame {

    private JTextField titleField, categoryField, dayField, monthField, yearField;
    private JTextArea displayArea;

    public EventManagerGUI() {
        setTitle("Event Manager");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        titleField = new JTextField(10);
        categoryField = new JTextField(10);
        dayField = new JTextField(3);
        monthField = new JTextField(3);
        yearField = new JTextField(5);

        add(new JLabel("Title:")); add(titleField);
        add(new JLabel("Category:")); add(categoryField);
        add(new JLabel("Day:")); add(dayField);
        add(new JLabel("Month:")); add(monthField);
        add(new JLabel("Year:")); add(yearField);

        JButton addBtn = new JButton("Add Event");
        JButton viewBtn = new JButton("View Events");

        add(addBtn); add(viewBtn);

        displayArea = new JTextArea(10, 30);
        add(new JScrollPane(displayArea));

        addBtn.addActionListener(e -> addEvent());
        viewBtn.addActionListener(e -> viewEvents());
    }

    private void addEvent() {
        try {
            Event event = new Event(
                titleField.getText(),
                categoryField.getText(),
                Integer.parseInt(dayField.getText()),
                Integer.parseInt(monthField.getText()),
                Integer.parseInt(yearField.getText())
            );

            FileHandler.saveEvent(event);
            JOptionPane.showMessageDialog(this, "Event saved!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input!");
        }
    }

    private void viewEvents() {
        ArrayList<Event> events = FileHandler.loadEvents();
        displayArea.setText("");

        for (Event e : events) {
            displayArea.append(e.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        new EventManagerGUI().setVisible(true);
    }
}
