package Pong;

import guibasicfiles.map;

import java.awt.*;

public class ball extends Object {
    public ball(int x, int y, int width, int height, int v, int vx, int vy) {
        super(x, y, width, height, v, vx, vy);
    }
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval((int) x, (int) y, (int) width, (int) height);
    }
    /*
    void bounceCollision(Rectangle r, double dir){
        if (this.getTop().intersects(r)) {
            this.vy*=-1;
            this.vx*=(int) dir;
        }
        if (this.getBottom().intersects(r)) {
            this.vy*=-1;
            this.vx*=(int) dir;
        }
        if (this.getLeft().intersects(r)) {
            this.vx*=-1;
        }
        if (this.getRight().intersects(r)) {
            this.vx*=-1;
        }
    }
     */
    boolean bounceBlock(Rectangle r){
        if (this.getTop().intersects(r)) {
            this.vy*=-1;
            return true;
        }
        if (this.getBottom().intersects(r)) {
            this.vy*=-1;
            return true;
        }
        if (this.getLeft().intersects(r)) {
            this.vx*=-1;
            return true;
        }
        if (this.getRight().intersects(r)) {
            this.vx*=-1;
            return true;
        }
        return false;
    }
    void check_wall(int w, int h){
        //if collision the reverse the velocity
        if (this.x<0 || this.x+this.width>w ) {
            this.vx *= -1;
        }
        if(this.y<0 || this.y+this.height>h){
            this.vy *= -1;
        }
    }
}
