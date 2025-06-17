package Unit4_Graphics;

import javax.swing.*;
import java.awt.*;

public class bouncingBall extends JFrame{
    public static void main(String[] args){
        new bouncingBall();
    }
    double x, y;
    double vx = 2, vy = 2; // Velocity in x and y directions

    bouncingBall(){
        this.setTitle("Bouncing Ball");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawing_panel panel = new drawing_panel();
        this.add(panel);
        this.pack();
        this.setVisible(true);
        while(true){
            panel.repaint();
            x += vx;
            y += vy;
            if (x < 0 || x > panel.getWidth() - 30) {
                vx = -vx; // Reverse direction on x-axis
            }
            if (y < 0 || y > panel.getHeight() - 30) {
                vy = -vy; // Reverse direction on y-axis
            }
            try{
                Thread.sleep(10);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
    private class drawing_panel extends JPanel{
        drawing_panel(){
            setPreferredSize(new Dimension(800, 600));
            setBackground(Color.white);
        }
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawOval((int)x, (int)y, 30, 30);
        }

    }
}
