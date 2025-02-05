package generated_files;
import java.util.Arrays;

public class spinning_M {
    public static void main(String[] args) {
        int k;
        double A = 0, B = 0;

        double[] z = new double[1760];
        char[] b = new char[1760];
        char[] chars = {'.', ',', '-', '~', ':', ';', '=', '!', '*', '#', '$', '@'};

        // Define the M's line segments in 3D space
        double[][][] segments = {
                {{-2, -2, 0}, {-2, 2, 0}},  // Left vertical
                {{-2, 2, 0}, {0, -2, 0}},   // Middle left diagonal
                {{0, -2, 0}, {2, 2, 0}},    // Middle right diagonal
                {{2, 2, 0}, {2, -2, 0}}     // Right vertical
        };

        // Clear screen
        for (int c = 0; c < 50; c++) {
            System.out.println();
        }

        while (true) {
            Arrays.fill(b, ' ');
            Arrays.fill(z, 0);

            // Draw each segment of the M
            for (double[][] segment : segments) {
                double[] start = segment[0];
                double[] end = segment[1];
                for (double t = 0; t <= 1.0; t += 0.005) { // Increased point density
                    // Calculate current point along the segment
                    double x = start[0] + t * (end[0] - start[0]);
                    double y = start[1] + t * (end[1] - start[1]);
                    double zPoint = start[2] + t * (end[2] - start[2]);

                    // Apply 3D rotations
                    double xRotX = x;
                    double yRotX = y * Math.cos(A) - zPoint * Math.sin(A);
                    double zRotX = y * Math.sin(A) + zPoint * Math.cos(A);

                    double xRotY = xRotX * Math.cos(B) + zRotX * Math.sin(B);
                    double yRotY = yRotX;
                    double zRotY = -xRotX * Math.sin(B) + zRotX * Math.cos(B);

                    // Perspective projection
                    double depth = 1 / (zRotY + 5);
                    int xProj = (int) (40 + 30 * depth * xRotY);
                    int yProj = (int) (12 + 15 * depth * yRotY);

                    // Update display buffer
                    if (xProj >= 0 && xProj < 80 && yProj >= 0 && yProj < 22) {
                        int o = xProj + 80 * yProj;
                        if (depth > z[o]) {
                            z[o] = depth;
                            int charIndex = (int) (8 * depth);
                            charIndex = Math.max(0, Math.min(11, charIndex));
                            b[o] = chars[charIndex];
                        }
                    }
                }
            }

            // Display the frame
            System.out.print("\u001b[H");
            for (k = 0; k < 1760; k++) {
                System.out.print(k % 80 > 0 ? b[k] : '\n');
            }

            // Update rotation angles
            A += 0.01;
            B += 0.005;

            // Control animation speed
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}