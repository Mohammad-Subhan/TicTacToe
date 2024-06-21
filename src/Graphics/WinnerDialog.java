package Graphics;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WinnerDialog {

    private final JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private RoundedButton textButton = new RoundedButton();
    private RoundedButton button = new RoundedButton();

    public WinnerDialog(String text) {

        // ========================================== Winner Label ==============================================
        textButton.setText(text);
        textButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
        textButton.setBounds(0, 35, 300, 40);
        textButton.setButtonColor(UIUtils.PR_COLOR);
        textButton.setForeground(UIUtils.BG_COLOR);
        textButton.setFocusable(false);
        panel.add(textButton);

        // ============================================ OK Button ===============================================
        button.setBounds(110, 100, 80, 30);
        button.setText("OK");
        button.setForeground(UIUtils.PR_COLOR);
        button.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
        button.setFocusable(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                UIUtils.frame.setEnabled(true);
                UIUtils.panel.removeAll();
                UIUtils.panel.setVisible(false);
                new MainMenu();
            }

        });
        button.setButtonColor(UIUtils.BG_COLOR);
        panel.add(button);

        // ============================================== Panel =================================================
        panel.setBackground(UIUtils.PR_COLOR);
        panel.setLayout(null);
        panel.setBounds(0, 0, 300, 150);
        MouseAdapter ma = new MouseAdapter() {
            int lastX, lastY;

            @Override
            public void mousePressed(MouseEvent e) {
                lastX = e.getXOnScreen();
                lastY = e.getYOnScreen();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                frame.setLocation(frame.getLocationOnScreen().x + x - lastX, frame.getLocationOnScreen().y + y - lastY);
                lastX = x;
                lastY = y;
            }
        };
        panel.addMouseListener(ma);
        panel.addMouseMotionListener(ma);
        frame.add(panel);

        // -------------------- Settings for the frame ------------------------
        frame.setUndecorated(true);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }
}