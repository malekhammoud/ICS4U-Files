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
        for (int i = 50; i > 0; i-=1) {
            squaresx.add((int)(Math.random()*500));
            squaresy.add((int)(Math.random()*500));
            squaresvx.add((int)(Math.random()*10));
            squaresvy.add((int)(Math.random()*10));
        }
        while (true) {
            for(int i = 0; i < squaresx.size(); i++) {
                squaresx.set(i, squaresx.get(i)+squaresvx.get(i));
                squaresy.set(i, squaresy.get(i)+squaresvy.get(i));
                if (squaresx.get(i)< 0 ||  squaresx.get(i)+BALL_SIZE > 800){
                    squaresvx.set(i, -1*squaresvx.get(i));
                } else if (squaresy.get(i) < 0 || squaresy.get(i) + BALL_SIZE > getHeight()) {
                    squaresvy.set(i, -1*squaresvy.get(i));
                }
            }
            for(int i = 0; i < squaresx.size(); i++) {
                for(int j = 0; j < squaresx.size(); j++) {
                    if (((squaresx.get(i)<squaresx.get(j)+BALL_SIZE)&&(squaresy.get(i)<squaresy.get(j)+BALL_SIZE && squaresy.get(i)+BALL_SIZE>squaresy.get(j) && squaresx.get(i)>squaresx.get(j))) ){
                        if((Math.abs(squaresvx.get(i)) == squaresvx.get(i) && Math.abs(squaresvx.get(j)) == squaresvx.get(j)) || (Math.abs(squaresvx.get(i)) != squaresvx.get(i) && Math.abs(squaresvx.get(j)) != squaresvx.get(j)) ) {
                            if (Math.abs(squaresvx.get(i))<Math.abs(squaresvx.get(j))) {
                                squaresvx.set(j, (int)(-0.8*squaresvx.get(j)));
                                squaresvx.set(i, (int)(1.3*squaresvx.get(i)));

                            }else if (Math.abs(squaresvx.get(i))>Math.abs(squaresvx.get(j))) {
                                squaresvx.set(i, (int)(-0.8*squaresvx.get(i)));
                                squaresvx.set(j, (int)(1.3*squaresvx.get(j)));
                            }
                        }
                        else{
                            squaresvx.set(i, -1*squaresvx.get(i));
                            squaresvx.set(j, -1*squaresvx.get(j));
                        }
                        if((Math.abs(squaresvy.get(i)) == squaresvy.get(i) && Math.abs(squaresvy.get(j)) == squaresvy.get(j)) || (Math.abs(squaresvy.get(i)) != squaresvy.get(i) && Math.abs(squaresvy.get(j)) != squaresvy.get(j)) && false ) {
                            if (Math.abs(squaresvy.get(i)) < Math.abs(squaresvy.get(j))) {
                                squaresvy.set(j, (int) (-0.8 * squaresvy.get(j)));
                                squaresvy.set(i, (int) (1.3 * squaresvy.get(i)));
                            } else if (Math.abs(squaresvy.get(i)) > Math.abs(squaresvy.get(j))) {
                                squaresvy.set(i, (int) (-0.8 * squaresvy.get(i)));
                                squaresvy.set(j, (int) (1.3 * squaresvy.get(j)));
                            }
                        }
                        else{
                            squaresvy.set(i, -1*squaresvy.get(i));
                            squaresvy.set(j, -1*squaresvy.get(j));
                        }
                    } else if ((squaresy.get(i)<squaresy.get(j)+BALL_SIZE)&&(squaresx.get(i)<squaresx.get(j)+BALL_SIZE && squaresx.get(i)+BALL_SIZE>squaresx.get(j) && squaresy.get(i)>squaresy.get(j)))  {
                        squaresvy.set(i, -1*squaresvy.get(i));
                        squaresvy.set(j, -1*squaresvy.get(j));
                    }
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
