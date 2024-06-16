package Graphics;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Shape;
import java.awt.Cursor;
import java.awt.Insets;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;


public class TextField extends JTextField {
    private Shape shape;
    private Color borderColor = UIUtils.PR_COLOR;

    public TextField() {
        setOpaque(false);
        setBackground(UIUtils.BG_COLOR);
        setForeground(Color.white);
        setCaretColor(Color.white);
        setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        setMargin(new Insets(2, 10, 2, 2));
        setHorizontalAlignment(SwingConstants.LEFT);
        setFont(new Font("Segoe UI", Font.PLAIN, 20));
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2 = UIUtils.get2dGraphics(g);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, UIUtils.BT_ROUNDNESS, UIUtils.BT_ROUNDNESS);
        super.paintComponent(g2);
    }

    protected void paintBorder(Graphics g) {
        Graphics2D g2 = UIUtils.get2dGraphics(g);
        g2.setColor(borderColor);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, UIUtils.BT_ROUNDNESS, UIUtils.BT_ROUNDNESS);
    }

    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, UIUtils.BT_ROUNDNESS, UIUtils.BT_ROUNDNESS);
        }
        return shape.contains(x, y);
    }

    public void setBorderColor(Color color) {
        borderColor = color;
        repaint();
    }
}