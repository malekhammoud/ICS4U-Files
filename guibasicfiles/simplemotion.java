package guibasicfiles;
// Include the libraries necessary for graphics
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

import java.util.ArrayList; // import the ArrayList class
class simplemotion extends JComponent {

    ArrayList<Integer> squaresx= new ArrayList<Integer>();
    ArrayList<Integer> squaresy= new ArrayList<Integer>();
    ArrayList<Integer> squaresvx= new ArrayList<Integer>();
    ArrayList<Integer> squaresvy= new ArrayList<Integer>();
    // Instance variables that define the current characteristics
    // of your animated object.
    int ballX = 50;
    int ballY = 50;
    final int BALL_SIZE = 30;

    // Ball's speed for x and y
    int ballSpeedX = 3;
    int ballSpeedY = 3;

    private static final int UPDATE_RATE = 24;

    // This special method is automatically called when the scene needs to be drawn.
    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 800, 600);

        g.setColor(Color.white);
        for(int i = 0; i < squaresx.size(); i++){
            g.fillRect(squaresx.get(i), squaresy.get(i), BALL_SIZE, BALL_SIZE);
        }

    }


    // Pause the program for ms milliseconds so the animation doesn't go too fast
    public void pause(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException ex) {
            System.out.println("Error occurred!");
        }
    }

    public void playAnimation() {
        for (int i = 0; i < 100; i++) {
            squaresx.add(i*50);
            squaresy.add(0);
            squaresvx.add((int)(Math.random()*10));
            squaresvy.add(3);
        }
        while (true) {
            for(int i = 0; i < squaresx.size(); i++) {
                squaresx.set(i, squaresx.get(i)+squaresvx.get(i));
                squaresy.set(i, squaresy.get(i)+squaresvy.get(i));
                if (squaresx.get(i)< 0 ||  squaresx.get(i)+BALL_SIZE > 800){
                    squaresvx.set(i, -1*squaresvx.get(i));
                } else if (squaresy.get(i) <0 || squaresy.get(i) + BALL_SIZE > 580) {
                    squaresvy.set(i, -1*squaresvy.get(i));
                }
            }
            Toolkit.getDefaultToolkit().sync();
            repaint();
            pause(30);
        }
    }


    public static void main(String[] args) {
        simplemotion my_animation = new simplemotion();
        JFrame frame = new JFrame();

        frame.add(my_animation);

        frame.setTitle("My Animation");
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        my_animation.playAnimation();
    }
}
