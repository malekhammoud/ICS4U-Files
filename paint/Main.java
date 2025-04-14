package paint;

import guibasicfiles.Simple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main extends JFrame  {
    ArrayList<Circle> points = new ArrayList<Circle>();
    //points.add(new Circle(100, 100, 10));
    public static void main(String[] args) {
        new Main();
    }
    Main(){
        this.setTitle("Paint");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        Main.DrawingPanel p = new Main.DrawingPanel();
        panel.add(p);
        this.add(panel);
        this.pack();
        this.setVisible(true);
    }

    private class DrawingPanel extends JPanel implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent mouseEvent) {
            points.add(new Circle(mouseEvent.getX(), mouseEvent.getY(), 15, Color.RED));
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent mouseEvent) {

        }
        DrawingPanel(){
            this.setPreferredSize(new Dimension(500,500));
        }
        @Override
        public void paintComponent(Graphics g){
            addMouseMotionListener(this);
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 500,500);
            g.setColor(Color.WHITE);
            g.fillRect(5, 5, 490,490);
            for(Circle circle : points){
                circle.draw(g);
            }
        }
    }
}
