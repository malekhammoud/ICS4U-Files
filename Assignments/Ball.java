package Assignments;
import javax.swing.*;
import java.awt.*;

/**
 * This is the ball class
 */
public class Ball extends Rectangle {
    int x, y, radius;
    int vx;
    int vy;
    Color color;

    /**
     * The Ball constructor
     * @param x
     * @param y
     * @param radius
     * @param color
     * @param vx
     * @param vy
     */
    Ball(int x, int y, int radius, Color color, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.vx = vx;
        this.vy = vy;
    }

    /**
     * Moves the ball based on the vx and vy variables
     */
    void move(){
        this.x += this.vx;
        this.y += this.vy;
    }

    /**
     * Draws the ball on the screen
     * @param g
     */
    void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, radius, radius);
    }

    /**
     * The values of of x, y, and radius turn into a rectangle
     * @return Returns a Rectangle
     */
    Rectangle getrect(){
        return new Rectangle(this.x,this.y,this.radius,this.radius);
    }

    /**
     * Checks the collision 2 balls
     * @param b The ball input
     */
    void check_collision(Ball b){
        //if collision the reverse the velocity
        if (this.getrect().intersects(b.getrect())) {
            this.vx *= -1;
            this.vy *= -1;
            b.vx *= -1;
            b.vy *= -1;
        }
    }

    /**
     * Checks the collision of the wall and bounces the ball
     * @param w the width of the screen
     * @param h the height of the screen
     */
    void check_wall(int w, int h){
        //if collision the reverse the velocity
        if (this.x<0 || this.x+this.radius>w ) {
            this.vx *= -1;
        }
        if(this.y<0 || this.y+this.radius>h){
            this.vy *= -1;
        }
    }
}
