package Pong;

import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class Object extends Rectangle {
    int x, y, width, height,v, vx, vy;
    public Object(int x, int y, int width, int height, int v, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.v = v;
        this.vx = vx;
        this.vy = vy;
    }
    public void move(){
        this.x += this.vx;
        this.y += this.vy;
    }
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect((int) x, (int) y, (int) width, (int) height);
        //g.fillOval((int) x, (int) y, (int) width, (int) height);
    }

    Rectangle getTop(){
        return new Rectangle(this.x+this.width/5,this.y,this.width-this.width/5 *2,this.height/2);
    }
    Rectangle getBottom(){
        return new Rectangle(this.x+this.width/5,this.y+this.height/2,this.width-this.width/5*2,this.height/2);
    }
    Rectangle getRight(){
        return new Rectangle(this.x+this.width/2,this.y+this.height/5,this.width/2,this.height-this.height/5 *2 );
    }
    Rectangle getLeft(){
        return new Rectangle(this.x,this.y+this.height/5,this.width/2,this.height-this.height/5 *2 );
    }
    Rectangle getrect(){
        return new Rectangle(this.x,this.y,this.width,this.height);
    }
    void bounceCollision(Rectangle r){
        if (this.getTop().intersects(r)) {
            this.vy*=-1;
        }
        if (this.getBottom().intersects(r)) {
            this.vy*=-1;
        }
        if (this.getLeft().intersects(r)) {
            this.vx*=-1;
        }
        if (this.getRight().intersects(r)) {
            this.vx*=-1;
        }
    }
    void checkCollision(Rectangle r){
        if (this.getTop().intersects(r)) {
            this.vy=0;
            this.y += this.v;
        }
        if (this.getBottom().intersects(r)) {
            this.vy=0;
            this.y -= this.v;
        }
        if (this.getLeft().intersects(r)) {
            this.vx=0;
            this.x += this.v;
        }
        if (this.getRight().intersects(r)) {
            this.vx=0;
            this.x -= this.v;
        }
    }

}
