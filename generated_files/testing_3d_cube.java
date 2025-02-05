package generated_files;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class testing_3d_cube extends JPanel {
    private double[][] cubeVertices;
    private int[][] edges;
    private double angle = 0;
    private final double cameraZ = 5; // Camera position on the Z-axis

    public testing_3d_cube() {
        // Define cube vertices (x, y, z)
        cubeVertices = new double[][] {
                {-1, -1, -1}, {1, -1, -1}, {1, 1, -1}, {-1, 1, -1},
                {-1, -1, 1}, {1, -1, 1}, {1, 1, 1}, {-1, 1, 1}
        };

        // Define edges (connections between vertices)
        edges = new int[][] {
                {0,1}, {1,2}, {2,3}, {3,0}, // Front face
                {4,5}, {5,6}, {6,7}, {7,4}, // Back face
                {0,4}, {1,5}, {2,6}, {3,7}  // Connecting edges
        };

        // Animation timer
        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += 0.05;
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Clear the screen
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Project 3D points to 2D screen
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        double scale = 100; // Scale factor to adjust size

        for (int[] edge : edges) {
            double[] p1 = projectVertex(cubeVertices[edge[0]], angle);
            double[] p2 = projectVertex(cubeVertices[edge[1]], angle);

            // Draw the edge
            g2d.setColor(Color.WHITE);
            g2d.drawLine(
                    (int) (centerX + p1[0] * scale),
                    (int) (centerY + p1[1] * scale),
                    (int) (centerX + p2[0] * scale),
                    (int) (centerY + p2[1] * scale)
            );
        }
    }

    // Project a 3D vertex to 2D screen coordinates
    private double[] projectVertex(double[] vertex, double angle) {
        // Rotate around Y-axis
        double x = vertex[0] * Math.cos(angle) - vertex[2] * Math.sin(angle);
        double y = vertex[1];
        double z = vertex[0] * Math.sin(angle) + vertex[2] * Math.cos(angle) + cameraZ;

        // Perspective projection
        double fov = 300; // Field of view
        double perspective = fov / (fov + z);
        return new double[] {x * perspective, y * perspective};
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple 3D World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new testing_3d_cube());
        frame.setVisible(true);
    }
}