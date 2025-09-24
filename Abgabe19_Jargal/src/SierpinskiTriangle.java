import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SierpinskiTriangle extends JPanel {
    private int currentDepth = 0;
    private final int MAX_DEPTH = 7;
    private Timer timer;
    private boolean isAnimating = true;

    public SierpinskiTriangle() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isAnimating) {
                    currentDepth++;
                    if (currentDepth > MAX_DEPTH) {
                        currentDepth = 0;
                    }
                    repaint();
                }
            }
        });
        timer.start();

        // Tastatursteuerung hinzufügen
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_SPACE:
                        isAnimating = !isAnimating; // Play/Pause
                        break;
                    case KeyEvent.VK_RIGHT:
                        currentDepth = Math.min(currentDepth + 1, MAX_DEPTH);
                        repaint();
                        break;
                    case KeyEvent.VK_LEFT:
                        currentDepth = Math.max(currentDepth - 1, 0);
                        repaint();
                        break;
                    case KeyEvent.VK_R:
                        currentDepth = 0; // Reset
                        repaint();
                        break;
                }
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        drawSierpinski(g, currentDepth, getWidth() / 2, 0, 0, getHeight(), getWidth(), getHeight());

        // Informationen anzeigen
        g.drawString("Stufe: " + currentDepth + " von " + MAX_DEPTH, 10, 20);
        g.drawString("Leertaste: Play/Pause", 10, 40);
        g.drawString("Pfeiltasten: Vor/Zurück", 10, 60);
        g.drawString("R: Reset", 10, 80);
        g.drawString("Status: " + (isAnimating ? "Läuft" : "Pausiert"), 10, 100);
    }

    private void drawSierpinski(Graphics g, int depth, int x1, int y1, int x2, int y2, int x3, int y3) {
        if (depth == 0) {
            g.drawLine(x1, y1, x2, y2);
            g.drawLine(x2, y2, x3, y3);
            g.drawLine(x3, y3, x1, y1);
            return;
        }

        int midx1 = (x1 + x2) / 2;
        int midy1 = (y1 + y2) / 2;

        int midx2 = (x2 + x3) / 2;
        int midy2 = (y2 + y3) / 2;

        int midx3 = (x3 + x1) / 2;
        int midy3 = (y3 + y1) / 2;

        drawSierpinski(g, depth-1, x1, y1, midx1, midy1, midx3, midy3);
        drawSierpinski(g, depth-1, midx1, midy1, x2, y2,  midx2, midy2);
        drawSierpinski(g, depth-1, midx3, midy3, midx2, midy2, x3, y3 );
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sierpinski Triangle Animation");
        SierpinskiTriangle triangle = new SierpinskiTriangle();
        frame.add(triangle);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
