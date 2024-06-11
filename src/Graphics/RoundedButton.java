package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;

public class RoundedButton extends JButton {

    private Color buttonColor;
    private int buttonRoundness = UIUtils.BT_ROUNDNESS;

    public RoundedButton() {

        super();
        setContentAreaFilled(false); // Ensure the button's background is not painted by default
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(buttonColor.darker()); // Set color when button is pressed
        } else {
            g.setColor(buttonColor); // Set default background color
        }
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, buttonRoundness, buttonRoundness); // Draw the rounded
        // rectangle

        super.paintComponent(g); // Paint the text and other content
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(null);
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, buttonRoundness, buttonRoundness); // Draw the border
    }

    public void setButtonColor(Color newColor) {
        this.buttonColor = newColor;
    }

    public void setButtonRoundness(int newRoundness) {
        this.buttonRoundness = newRoundness;
    }
}