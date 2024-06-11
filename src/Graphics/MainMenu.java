package Graphics;

// imports
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu implements ActionListener {

    JFrame frame;
    JPanel panel;
    JLabel welcomeLabel;
    JLabel logoLabel;
    RoundedButton tpButton;
    RoundedButton spButton;

    public MainMenu() {

        // ============================================== JFrame ==================================================
        frame = new JFrame();
        frame.setTitle("TicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(350, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

        // ============================================== JPanel ==================================================
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 350, 400);
        panel.setBackground(UIUtils.BG_COLOR);
        panel.setVisible(true);
        frame.add(panel);

        // ===================================== JButton (Single Player) ==========================================
        spButton = new RoundedButton();
        spButton.setBounds(95, 185, 160, 45);
        spButton.setText("Single Player");
        spButton.setForeground(UIUtils.BG_COLOR);
        spButton.setButtonColor(UIUtils.PR_COLOR);
        spButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
        spButton.setFocusable(false);
        spButton.addActionListener(this);
        panel.add(spButton);

        // ====================================== JButton (Two Players) ===========================================
        tpButton = new RoundedButton();
        tpButton.setBounds(95, 250, 160, 45);
        tpButton.setText("Two Players");
        tpButton.setForeground(UIUtils.BG_COLOR);
        tpButton.setButtonColor(UIUtils.PR_COLOR);
        tpButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
        tpButton.setFocusable(false);
        tpButton.addActionListener(this);
        panel.add(tpButton);

        // ========================================== JLabel (Logo) ===============================================
        logoLabel = new JLabel();
        ImageIcon logo = new ImageIcon("./src/Images/logo.png");
        logoLabel.setIcon(logo);
        logoLabel.setBounds(140, 40, 64, 64);
        panel.add(logoLabel);

        // ==================================== JLabel (Introductory Text) ========================================
        welcomeLabel = new JLabel();
        welcomeLabel.setText("Welcome to Tic-Tac-Toe!");
        welcomeLabel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
        welcomeLabel.setForeground(UIUtils.TXT_COLOR);
        welcomeLabel.setBounds(60, 112, 230, 30);
        welcomeLabel.setVisible(true);
        panel.add(welcomeLabel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == spButton) {
            // Single Player Logic
        } else if (e.getSource() == tpButton) {
            /// Two Players Logic
        }

    }
}