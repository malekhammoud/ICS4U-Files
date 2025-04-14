package guibasicfiles;

import java.awt.*;
import javax.swing.*;
public class Simple extends JFrame {
    public static void main(String[] args) {
        new Simple();
    }
    Simple(){
        //Create the Jframe
        this.setTitle("HELLOW WORLD");
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        DrawingPanel p = new DrawingPanel();
        panel.add(p);
        JButton button1 = new JButton("Click Me");
        JLabel label1 = new JLabel("HI");
        button1.setPreferredSize(new Dimension(200,100));
        panel.add(label1);
        panel.add(button1);
        this.setUndecorated(true);
        this.add(panel);
        this.pack();
        this.setVisible(true);
    }
    private class DrawingPanel extends JPanel {
        DrawingPanel(){
            this.setPreferredSize(new Dimension(500,500));
        }
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 100,50);
        }
    }
}
