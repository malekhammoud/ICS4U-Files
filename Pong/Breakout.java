package Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Breakout extends JFrame implements KeyListener, ActionListener {
    static int WIDTH = 1000;
    static int HEIGHT = 800;
    static paddle control_paddle = new paddle(100, HEIGHT-100, 100, 20, 3, 0, 0);
    static ball ball1= new ball(100, 300, 20, 20, 10, 5, 5);
    int[][] maps= {
            {0,0,1,1,1,1,1,1,1,1,1,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,1,0},
            {0,0,1,1,1,1,1,1,0,1,1,1,0},
            {0,0,1,1,1,1,1,1,0,1,1,1,0},
            {0,0,1,1,1,1,1,1,0,1,1,1,0},
            {0,0,1,1,1,1,1,1,0,1,1,1,0},
            {0,0,0,1,1,1,1,1,0,1,1,1,0},
            {0,0,0,1,1,1,1,1,0,1,1,1,0},
            {0,0,0,1,1,1,1,0,0,1,1,1,0},
    };
    ArrayList<Rectangle> walls=  new ArrayList<Rectangle>();
    void drawmap(Graphics g){
        int width = 80;
        int height = 30;
        for (int y = 0; y < maps.length; y++){
            for (int x = 0; x < maps[y].length; x++){
                if (maps[y][x] == 1){
                    g.setColor(Color.BLACK);
                    Rectangle tempRect = new Rectangle(x*width, y*height, width, height);
                    if(ball1.bounceBlock(tempRect)){
                        maps[y][x] = 0;
                    }
                    g.drawRect(x*width, y*height, width, height);
                };
            }
        }

    }
    public static void main(String[] args) {
        new Breakout();
    }
    Breakout(){
        this.setTitle("HELLO WORLD");
        this.setSize(1000,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        Breakout.DrawingPanel p = new Breakout.DrawingPanel();
        panel.add(p);
        this.add(panel);
        this.pack();
        this.setVisible(true);
        this.playAnimation();
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT){
            control_paddle.vx = control_paddle.v;
        } else if(key == KeyEvent.VK_LEFT){
            control_paddle.vx = -control_paddle.v;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT) {
            control_paddle.vx = 0;
        }
    }


    private class DrawingPanel extends JPanel {
        DrawingPanel(){
            this.setPreferredSize(new Dimension(1000,800));
        }
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            control_paddle.draw(g);
            ball1.draw(g);
            drawmap(g);
        }
    }
    public void playAnimation() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        while (true) {
            control_paddle.move();
            ball1.move();
            ball1.bounceCollision(control_paddle.getrect());
            ball1.check_wall(WIDTH, HEIGHT);
            Toolkit.getDefaultToolkit().sync();
            repaint();
            pause(5);
        }
    }
    public void pause(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException ex) {
            System.out.println("Error occurred!");
        }
    }
}
