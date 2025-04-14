package guibasicfiles;

import java.awt.*;

public class Player extends Rectangle {
    double v;
    double[] vy = {0,0};
    double[] vx = {0,0};
    int x, y, width, height;
    Color c;
    Player(int x, int y, int w, int h, double v, Color c) {
        this.v = v;
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.c = c;
    }
    Player(int x, int y, int w, int h, double v) {
        this.v = v;
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.c =new Color(0f,0f,0f,.1f );
    }
    void moveup(){
        this.vy[0] = -this.v;
    }
    void movedown(){
        this.vy[1] =this.v;
    }
    void moveleft(){
        this.vx[0] = -this.v;
    }
    void moveright(){
        this.vx[1] =this.v;
    }
    void draw(Graphics g){
        g.setColor(this.c);
        g.fillRect(this.x,this.y,this.width,this.height);
    }
    void move(){
        this.x += this.vx[0] + this.vx[1];
        this.y += this.vy[0] + this.vy[1];
    }
}
