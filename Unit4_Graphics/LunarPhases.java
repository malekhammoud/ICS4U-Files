package Unit4_Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
public class LunarPhases implements ActionListener {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LunarPhases();
            }
        });
    }
    static String moonPhase = "New Moon"; // Default phase
    Timer timer;

    LunarPhases() {
        JFrame frame = new JFrame("Lunar Phases");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DrawingPanel panel= new DrawingPanel();

        JComboBox comboBox = new JComboBox(new String[] {
            "New Moon",
            "Waxing Crescent",
            "First Quarter",
            "Waxing Gibbous",
            "Full Moon",
            "Waning Gibbous",
            "Last Quarter",
            "Waning Crescent"
        });
        comboBox.addActionListener(this);

        panel.setLayout(new BorderLayout());
        panel.add(comboBox, BorderLayout.NORTH);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.repaint(); // Repaint the panel to update the ball's position
            }
        });
        timer.start();
    }

    private class DrawingPanel extends JPanel {
        DrawingPanel() {
            setPreferredSize(new Dimension(800, 600));
            setBackground(Color.BLACK);
        }
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawMoon(g, 400, 300, 100, moonPhase); // Draw a half moon
        }
        private void drawMoon(Graphics g, int x, int y, int radius, String moonPhase) {
            if (moonPhase.equals("New Moon")) {
                // Draw no moon
                g.setColor(Color.BLACK);
                g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
            } else if (moonPhase.equals("Waxing Crescent") || moonPhase.equals("Waning Crescent")) {
                // Draw crescent moon
                g.setColor(Color.WHITE);
                g.fillArc(x - radius, y - radius, radius * 2, radius * 2, 0, 180);
                g.setColor(Color.BLACK);
                g.fillArc(x - radius / 2, y - radius, radius * 2, radius * 2, 0, 180);
            } else if (moonPhase.equals("First Quarter") || moonPhase.equals("Last Quarter")) {
                // Draw half moon
                g.setColor(Color.WHITE);
                g.fillArc(x - radius, y - radius, radius * 2, radius * 2, 0, 180);
            } else if (moonPhase.equals("Waxing Gibbous") || moonPhase.equals("Waning Gibbous")) {
                // Draw gibbous moon
                g.setColor(Color.WHITE);
                g.fillArc(x - radius, y - radius, radius * 2, radius * 2, 0, 270);
            } else if (moonPhase.equals("Full Moon")) {
                // Draw full moon
                g.setColor(Color.WHITE);
                g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JComboBox comboBox = (JComboBox)event.getSource();
        String itemName = (String)comboBox.getSelectedItem();

        if (itemName.equals("New Moon")) {
            moonPhase = "New Moon";
        } else if (itemName.equals("Waxing Crescent")) {
            moonPhase = "Waxing Crescent";
        } else if (itemName.equals("First Quarter")) {
            moonPhase = "First Quarter";
        } else if (itemName.equals("Waxing Gibbous")) {
            moonPhase = "Waxing Gibbous";
        } else if (itemName.equals("Full Moon")) {
            moonPhase = "Full Moon";
        } else if (itemName.equals("Waning Gibbous")) {
            moonPhase = "Waning Gibbous";
        } else if (itemName.equals("Last Quarter")) {
            moonPhase = "Last Quarter";
        } else if (itemName.equals("Waning Crescent")) {
            moonPhase = "Waning Crescent";

        }
    }
}
