package paint;

import java.awt.*;

public class Circle {
    int x, y, radius;
    Color color;
    Circle(int x, int y, int radius,Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }
    Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = Color.BLACK;
    }
    void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, radius, radius);
    }
}
