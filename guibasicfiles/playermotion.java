package guibasicfiles;

import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.image.*;
import java.util.ArrayList;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;


class playermotion extends JComponent implements KeyListener{

    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    Player player1 = new Player(WIDTH/2, HEIGHT/2, 20, 20, 5);

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_UP){
            player1.moveup();
        }
        if(key == KeyEvent.VK_LEFT){
            player1.moveleft();
        }
        if(key == KeyEvent.VK_DOWN){
            player1.movedown();
        }
        if(key == KeyEvent.VK_RIGHT){
            player1.moveright();
        }
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP){
            player1.vy[0]=0;
        }
        if(key == KeyEvent.VK_LEFT){
            player1.vx[0]=0;
        }
        if(key == KeyEvent.VK_DOWN){
            player1.vy[1]=0;
        }
        if(key == KeyEvent.VK_RIGHT){
            player1.vx[1]=0;
        }

    }
    public void keyTyped(KeyEvent e) {}
    public void paintComponent(Graphics g) {
        player1.draw(g);
    }


    public void pause(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException ex) {
            System.out.println("Error occurred!");
        }
    }

    public void playAnimation() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        while (true) {
            player1.move();
            Toolkit.getDefaultToolkit().sync();
            repaint();
            pause(30);
        }
    }

    public static void main(String[] args) {
        playermotion my_animation = new playermotion();
        JFrame frame = new JFrame();

        frame.add(my_animation);

        frame.setTitle("My Animation");
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        my_animation.playAnimation();
    }
}