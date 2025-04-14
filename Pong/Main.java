package Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame implements KeyListener, ActionListener {
    static int WIDTH = 1000;
    static int HEIGHT = 800;
    static paddle control_paddle = new paddle(100, HEIGHT-100, 100, 20, 3, 0, 0);
    static paddle control_paddle2 = new paddle(100, 100, 100, 20, 3, 0, 0);
    static ball ball1= new ball(100, 200, 20, 20, 1, 1, 1);
    static Rectangle left = new Rectangle(0, 0, 20, HEIGHT);
    static Rectangle right = new Rectangle(WIDTH-20, 0, 20, HEIGHT);
    public static void main(String[] args) {
        new Main();
    }
    Main(){
        this.setTitle("HELLO WORLD");
        this.setSize(1000,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        Main.DrawingPanel p = new Main.DrawingPanel();
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
        if(key == KeyEvent.VK_A){
            control_paddle2.vx = -control_paddle.v;
        } else if(key == KeyEvent.VK_D){
            control_paddle2.vx = control_paddle.v;
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT) {
            control_paddle.vx = 0;
        }
        if (key == KeyEvent.VK_A|| key == KeyEvent.VK_D) {
            control_paddle2.vx = 0;
        }
    }


    private class DrawingPanel extends JPanel {
        DrawingPanel(){
            this.setPreferredSize(new Dimension(1000,800));
        }
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 100,50);
            control_paddle.draw(g);
            control_paddle2.draw(g);
            ball1.draw(g);
        }
    }
    public void playAnimation() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        while (true) {
            control_paddle.move();
            control_paddle2.move();
            ball1.move();
            ball1.bounceCollision(control_paddle.getrect());
            ball1.bounceCollision(control_paddle2.getrect());
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
