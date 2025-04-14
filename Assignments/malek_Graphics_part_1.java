package Assignments;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import guibasicfiles.Simple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**This program allows you to create balls and make them interact them in the environment
 */
public class malek_Graphics_part_1 extends JFrame implements KeyListener{
    static ArrayList<Ball> balls = new ArrayList<Ball>();
    Random rand = new Random();
    int play = 1;
    boolean exit = false;
    public static void main(String[] args) {
        new malek_Graphics_part_1();
    }

    /**
     * The main JFrame
     */
    malek_Graphics_part_1(){
        //Set the tite and frame settings
        this.setTitle("Malek's Graphics Assignment");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        malek_Graphics_part_1.DrawingPanel p = new malek_Graphics_part_1.DrawingPanel();
        panel.add(p);
        this.add(panel);
        this.pack();
        this.setVisible(true);
        addKeyListener(this);
        //Main animation loop
        while (true){
            if (play == 1){
                for (int i = 0; i<balls.size(); i ++){
                    balls.get(i).move();
                    balls.get(i).check_wall(800, 600);
                    for(int j = i+1; j<balls.size(); j++){
                        balls.get(j).check_collision(balls.get(i));
                    }
                }
                //Need this to make the animations smoother:
                Toolkit.getDefaultToolkit().sync();
                repaint();
            }
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException ex) {
                System.out.println("Error occurred!");
            }
            if (exit){
                System.exit(0);
            }
        }
    }

    /**
     * The KeyTyped Listener
     * @param keyEvent
     */
    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    /**
     * The KeyPressed Listener
     * @param keyEvent
     */
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();
        if (key == KeyEvent.VK_A){
            balls.add(new Ball(rand.nextInt(1, 800), rand.nextInt(1, 600), 50, new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)), rand.nextInt(-11,10), rand.nextInt(-11,10)));
        } else if (key == KeyEvent.VK_B){
            if(balls.size()>0){
                balls.removeFirst();
            }
        } else if (key == KeyEvent.VK_P){
            play *= -1;
        } else if (key == KeyEvent.VK_Q){
            exit = true;
        }
    }

    /**
     * The keyReleased Listener
     * @param keyEvent
     */
    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    /**
     * The drawing panel
     */
    private class DrawingPanel extends JPanel {
            DrawingPanel(){
                this.setPreferredSize(new Dimension(800,600));
            }

        /**
         * The painComponent method to paint the components on the screen
         * @param g
         */
        @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, 800, 600);
                for(Ball circle : balls){
                    circle.draw(g);
                }
                g.setColor(Color.WHITE);
                g.drawString("Press 'A' to add a ball, 'B' to remove a ball", 10, 15);
                g.drawString("Press 'P' to pause/unpause, 'Q' to Quit", 10, 30);
            }
        }
}
