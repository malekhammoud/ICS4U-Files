package Unit4_Graphics;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.Timer;

/**
 * MoveABall.java
 * This program demonstrates how to move a ball around the screen using the arrow keys.
 * The ball will bounce off the edges of the window.
 */

public class MoveABall extends JFrame implements KeyListener, ActionListener {
    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MoveABall();
            }
        });
    }
    ball b = new ball(200, 200, 50);
    Timer timer;
    MoveABall(){
        addKeyListener(this);
        this.setTitle("Move a Ball");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawingPanel panel = new DrawingPanel();

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3)); // 1 row, 4 columns
        buttonPanel.add(new JLabel(""));

        JButton button = new JButton("up");
        button.setActionCommand("up");
        button.addActionListener(this);
        buttonPanel.add(button);
        buttonPanel.add(new JLabel(""));

        JButton button4 = new JButton("left");
        button4.setActionCommand("left");
        button4.addActionListener(this);
        buttonPanel.add(button4);
        buttonPanel.add(new JLabel(""));
        JButton button3 = new JButton("right");
        button3.setActionCommand("right");
        button3.addActionListener(this);
        buttonPanel.add(button3);
        buttonPanel.add(new JLabel(""));
        JButton button2 = new JButton("down");
        button2.setActionCommand("down");
        button2.addActionListener(this);
        buttonPanel.add(button2);
        buttonPanel.add(new JLabel(""));



        panel.setLayout(new BorderLayout());
        panel.add(new JLabel("Use arrow keys to move the ball."), BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(panel);
        setFocusable(true);
        requestFocusInWindow();
        this.pack();
        this.setVisible(true);
        timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                b.move();
                panel.repaint(); // Repaint the panel to update the ball's position
                requestFocusInWindow();
            }
        });
        timer.start();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            b.setVelocity(0,-1);
            // Logic to move the ball up
        }
        if (key == KeyEvent.VK_DOWN) {
            b.setVelocity(0,1);
            // Logic to move the ball down
        }
        if (key == KeyEvent.VK_LEFT) {
            b.setVelocity(-1,0);
            // Logic to move the ball left
        }
        if (key == KeyEvent.VK_RIGHT) {
            b.setVelocity(1,0);
            // Logic to move the ball right
        }

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    private class DrawingPanel extends JPanel {
        DrawingPanel() {  //constructor
            this.setPreferredSize(new Dimension(500, 500));
            this.setBackground(Color.WHITE);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // Call the superclass's method to clear the panel
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            b.draw(g2d);
        }
    }

    private class ball extends Rectangle{
        double x, y, vx, vy;
        int diameter;


        ball(double x, double y, int diameter) {
            this.x = x;
            this.y = y;
            this.vx = 0; // Initial horizontal velocity
            this.vy = 0; // Initial vertical velocity
            this.diameter = diameter;
        }

        void move() {
            this.x += vx;
            this.y += vy;
            if(vx>0) vx -= 0.05; // Slow down the ball gradually
            if(vy>0) vy -= 0.05;
            if (vx < 0) vx += 0.05; // Slow down the ball gradually
            if (vy < 0) vy += 0.05;
            // Check for boundaries and bounce if necessary
            if (x < 0 || x > 500) {
                this.vx = -vx; // Reverse direction on x-axis
            }
            if (y < 0 || y > 500) {
                this.vy = -vy;
            }
        }

        void setVelocity(double vx, double vy) {
            if (this.vx < 3) {
                this.vx += vx;
            }
            if (this.vy < 3) {
                this.vy += vy;
            }
        }
        void draw(Graphics2D g) {
            g.setColor(Color.RED);
            g.fillOval((int)this.x, (int)this.y, this.diameter,this.diameter); // Draw a red ball at (200, 200) with diameter 50
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("up")) {
            b.setVelocity(0,-1);
        }
        if (actionEvent.getActionCommand().equals("down")) {
            b.setVelocity(0,1);
        }
        if (actionEvent.getActionCommand().equals("left")) {
            b.setVelocity(-1,0);
        }
        if (actionEvent.getActionCommand().equals("right")) {
            b.setVelocity(1,0);
        }
    }
}
