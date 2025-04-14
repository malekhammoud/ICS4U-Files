package guibasicfiles;

import BasicFiles.RandomBubbles;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class playermotion2 extends JFrame implements KeyListener, ActionListener {
    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    Player player1 = new Player(WIDTH/2, HEIGHT/2, 20, 20, 1, new Color(0,0,0));

    ArrayList<Player> shadows =  new ArrayList<Player>();


    Timer timer = new Timer(10, this);

    public static void main(String[] args) {
        new playermotion2();
    }

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
    playermotion2(){
        timer.start();
        timer.addActionListener(this::actionPerformed);
        //Create the Jframe
        this.setTitle("HELLOW WORLD");
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //this.setUndecorated(true);

        JPanel panel = new JPanel();
        DrawingPanel p = new DrawingPanel();
        panel.add(p);
        this.add(panel);
        this.pack();
        this.setVisible(true);
        this.playAnimation();
    }

    public void pause(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException ex) {
            System.out.println("Error occurred!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        shadows.add(new Player(player1.x, player1.y, 20, 20, 0));
        if(shadows.size()>10){
            shadows.remove(0);
        }
    }

    private class DrawingPanel extends JPanel {
        DrawingPanel(){
            this.setPreferredSize(new Dimension(500,500));
        }
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            for(int i = 0; i<shadows.size(); i++){
                shadows.get(i).draw(g);
            }
            player1.draw(g);
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
            pause(5);
        }
    }
}
