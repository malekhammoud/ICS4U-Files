package BasicFiles;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;
public class RandomBubbles extends JFrame implements ActionListener{
    DrawingPanel panel;
    ArrayList<Bubble> bubbles;

    Timer timer;
    int TIMERSPEED = 25;
    Random r = new Random();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RandomBubbles();
            }
        });
    }


    RandomBubbles() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Random Bubbles");
        panel = new DrawingPanel();
        //Create a list of bubbles
        bubbles = new ArrayList<Bubble>();

        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        //Set up your timer AFTER you set your frame to be visible
        timer = new Timer(TIMERSPEED, this);
        timer.start();
        timer.setInitialDelay(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Generate a random bubble and add to the list
        Color color = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
        bubbles.add(new Bubble(r.nextInt(panel.panW), r.nextInt(panel.panH), color));
        panel.repaint();	//repaint the panel
    }

    private class DrawingPanel extends JPanel {
        int panW = 500;
        int panH = 500;

        DrawingPanel() {
            this.setPreferredSize(new Dimension(panW, panH));
        }
        private int countDown = 10;

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D)g;
            //turn on antialiasing
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            //Paint each bubble in the list on the panel
            for (Bubble b: bubbles) {
                g2.setColor(b.color);
                b.paint(g2);
            }
        }
    }
    private class Bubble {
        int x, y, size;
        Color color;

        Bubble(int x, int y, Color c) {
            this.x = x;
            this.y = y;
            this.size = 10;
            this.color = c;
        }

        /**
         * Draws the bubble
         * @param g	Graphics object needed for drawing
         */
        public void paint(Graphics g) {
            g.setColor(color);
            g.fillOval(x, y, size, size);
        }
    }
}


