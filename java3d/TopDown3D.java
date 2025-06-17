package java3d;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TopDown3D extends JPanel implements KeyListener {

    private double angleX = 0;
    private double angleY = 0;

    public TopDown3D() {
        setFocusable(true);
        addKeyListener(this);
        setBackground(Color.BLACK);
    }

    private int[] project(double x, double y, double z) {
        double distance = 200;
        double zbuffer = distance / (distance + z);
        int screenX = (int) (x * zbuffer) + getWidth() / 2;
        int screenY = (int) (y * zbuffer) + getHeight() / 2;
        return new int[]{screenX, screenY};
    }

    private void drawCube(Graphics g, double size) {
        double halfSize = size / 2;
        // Define cube vertices
        double[][] vertices = {
                {-halfSize, -halfSize, -halfSize},
                {halfSize, -halfSize, -halfSize},
                {halfSize, halfSize, -halfSize},
                {-halfSize, halfSize, -halfSize},
                {-halfSize, -halfSize, halfSize},
                {halfSize, -halfSize, halfSize},
                {halfSize, halfSize, halfSize},
                {-halfSize, halfSize, halfSize}
        };

        // Rotation matrices
        double sinX = Math.sin(angleX);
        double cosX = Math.cos(angleX);
        double sinY = Math.sin(angleY);
        double cosY = Math.cos(angleY);

        // Rotate and project vertices
        int[][] projectedVertices = new int[8][2];
        for (int i = 0; i < 8; i++) {
            double x = vertices[i][0];
            double y = vertices[i][1];
            double z = vertices[i][2];

            // Rotate around Y-axis
            double rotatedX = cosY * x + sinY * z;
            double rotatedZ = -sinY * x + cosY * z;

            // Rotate around X-axis
            double finalY = cosX * y - sinX * rotatedZ;
            double finalZ = sinX * y + cosX * rotatedZ;

            projectedVertices[i] = project(rotatedX, finalY, finalZ);
        }

        // Draw cube faces
        drawFace(g, projectedVertices, 0, 1, 2, 3);
        drawFace(g, projectedVertices, 4, 5, 6, 7);
        drawFace(g, projectedVertices, 0, 1, 5, 4);
        drawFace(g, projectedVertices, 1, 2, 6, 5);
        drawFace(g, projectedVertices, 2, 3, 7, 6);
        drawFace(g, projectedVertices, 3, 0, 4, 7);
    }

    private void drawFace(Graphics g, int[][] vertices, int i, int j, int k, int l) {
        g.setColor(Color.WHITE);
        g.drawLine(vertices[i][0], vertices[i][1], vertices[j][0], vertices[j][1]);
        g.drawLine(vertices[j][0], vertices[j][1], vertices[k][0], vertices[k][1]);
        g.drawLine(vertices[k][0], vertices[k][1], vertices[l][0], vertices[l][1]);
        g.drawLine(vertices[l][0], vertices[l][1], vertices[i][0], vertices[i][1]);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCube(g, 100);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        double rotationSpeed = 0.05;
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            angleY -= rotationSpeed;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            angleY += rotationSpeed;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            angleX -= rotationSpeed;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            angleX += rotationSpeed;
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Top-Down 3D");
        TopDown3D panel = new TopDown3D();
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}