import javax.swing.*;
import java.awt.*;

/*
 * FractalTree.java
 *
 * This program draws a recursive fractal tree using Java Swing.
 * It extends JPanel and overrides paintComponent to start the recursion.
 *
 * Each branch splits into two smaller branches recursively until a maximum depth is reached.
 * The angle and length of branches decrease to create a tree-like shape.
 *
 */
public class FractalTree extends JPanel {

    private final int MAX_DEPTH = 9;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Start the recursion from the bottom center of the panel
        int startX = getWidth() / 2;
        int startY = getHeight() - 50;
        drawTree(g, startX, startY, -90, MAX_DEPTH);
    }

    /*
     * Recursively draws a fractal tree.
     *
     * @param g The graphics object to draw on.
     * @param x1 The starting x-coordinate of the branch.
     * @param y1 The starting y-coordinate of the branch.
     * @param angle The angle of the branch in degrees.
     * @param depth The current recursion depth (stops when 0).
     */
    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        // Base case: stop recursion when depth reaches 0
        if (depth == 0) {
            return;
        }

        // Length of the branch decreases with depth
        int branchLength = depth * 10;

        // Calculate end point using trigonometry
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * branchLength);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * branchLength);

        // Draw the branch
        g.drawLine(x1, y1, x2, y2);

        // Recursive calls: left and right sub-branches
        drawTree(g, x2, y2, angle - 20, depth - 1); // Left
        drawTree(g, x2, y2, angle + 20, depth - 1); // Right
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Recursive Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.add(new FractalTree());
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }
}