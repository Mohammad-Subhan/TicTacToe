package Graphics;

// imports
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu implements ActionListener {

    private JLabel welcomeLabel;
    private JLabel logoLabel;
    private RoundedButton tpButton;
    private RoundedButton spButton;

    public MainMenu() {

        UIUtils.frame.setVisible(true);
        UIUtils.panel.setVisible(true);

        // ====================================== Button (Single Player) ==========================================
        spButton = new RoundedButton();
        spButton.setBounds(90, 185, 160, 45);
        spButton.setText("Single Player");
        spButton.setForeground(UIUtils.BG_COLOR);
        spButton.setButtonColor(UIUtils.PR_COLOR);
        spButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        spButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
        spButton.setFocusable(false);
        spButton.addActionListener(this);
        UIUtils.panel.add(spButton);

        // ======================================= Button (Two Players) ===========================================
        tpButton = new RoundedButton();
        tpButton.setBounds(90, 250, 160, 45);
        tpButton.setText("Two Players");
        tpButton.setForeground(UIUtils.BG_COLOR);
        tpButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tpButton.setButtonColor(UIUtils.PR_COLOR);
        tpButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
        tpButton.setFocusable(false);
        tpButton.addActionListener(this);
        UIUtils.panel.add(tpButton);

        // =========================================== Label (Logo) ===============================================
        logoLabel = new JLabel();
        ImageIcon logo = new ImageIcon("./src/Images/logo.png");
        logoLabel.setIcon(logo);
        logoLabel.setBounds(138, 40, 64, 64);
        UIUtils.panel.add(logoLabel);

        // ===================================== Label (Introductory Text) ========================================
        welcomeLabel = new JLabel();
        welcomeLabel.setText("Welcome to Tic-Tac-Toe!");
        welcomeLabel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
        welcomeLabel.setForeground(UIUtils.TXT_COLOR);
        welcomeLabel.setBounds(55, 112, 230, 30);
        welcomeLabel.setVisible(true);
        UIUtils.panel.add(welcomeLabel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == spButton) {

            // Single Player Logic
            UIUtils.frame.setEnabled(false);
            new WinnerDialog("Coming soon");

        } else if (e.getSource() == tpButton) {

            // Two Players Logic
            UIUtils.panel.removeAll();
            UIUtils.panel.setVisible(false);
            new TwoPlayer();

        }

    }
}