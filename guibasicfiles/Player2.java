package guibasicfiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Player2 extends Rectangle implements ActionListener {
    double v;
    double[] vy = {0,0};
    double[] vx = {0,0};
    int x, y, width, height;
    boolean stop = false;

    ArrayList<Player2> shadows =  new ArrayList<Player2>();
    Timer timer = new Timer(10, this);

    Color c;
    Player2(int x, int y, int w, int h, double v, Color c) {
        this.v = v;
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.c = c;
        timer.start();
        timer.addActionListener(this::actionPerformed);
    }
    Player2(int x, int y, int w, int h, double v) {
        this.v = v;
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.c =new Color(0f,0f,0f,.03f );
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
    void drawSingle(Graphics g){
        g.setColor(this.c);
        g.fillRect(this.x,this.y,this.width,this.height);
    }
    void draw(Graphics g){
        for(int i = 0; i<this.shadows.size(); i++){
            this.shadows.get(i).drawSingle(g);
        }
        g.setColor(this.c);
        g.fillRect(this.x,this.y,this.width,this.height);
    }
    void move(){
        if(!this.stop){
            this.x += this.vx[0] + this.vx[1];
            this.y += this.vy[0] + this.vy[1];
        }
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
    void checkCollision(Rectangle r){
        if (this.getTop().intersects(r)) {
            this.vy[0]=0;
            this.y += this.v;
        }
        if (this.getBottom().intersects(r)) {
            this.vy[1]=0;
            this.y -= this.v;
        }
        if (this.getLeft().intersects(r)) {
            this.vx[0]=0;
            this.x += this.v;
        }
        if (this.getRight().intersects(r)) {
            this.vx[1]=0;
            this.x -= this.v;
        }
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.shadows.add(new Player2(this.x, this.y, 20, 20, 0));
        if(this.shadows.size()>25){
            this.shadows.remove(0);
        }
    }
}
