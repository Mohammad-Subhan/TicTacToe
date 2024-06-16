package Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoPlayer implements ActionListener {

    private RoundedButton backbutton;
    private final RoundedButton[][] tableButtons = new RoundedButton[3][3];
    private final TextField p1Field;
    private final TextField p2Field;
    private JSeparator separator;
    private JLabel crossLabel;
    private JLabel circleLabel;
    private final JLabel infoLabel;
    private final JLabel p1Label;
    private final JLabel p2Label;
    private final RoundedButton startButton;
    private final ImageIcon crossIcon = new ImageIcon("./src/Images/cross.png");
    private final ImageIcon circleIcon = new ImageIcon("./src/Images/circle.png");
    int count = 0;

    public TwoPlayer() {

        UIUtils.panel.setVisible(true);

        // ========================================= Button (Back) ==============================================
        backbutton = new RoundedButton();
        backbutton.setBounds(5, 10, 40, 40);
        ImageIcon imageIcon = new ImageIcon("./src/Images/backArrow.png");
        backbutton.setIcon(imageIcon);
        backbutton.setButtonColor(UIUtils.BG_COLOR);
        backbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backbutton.setFocusable(false);
        backbutton.addActionListener(this);
        UIUtils.panel.add(backbutton);

        // =========================================== Info Label ===============================================
        infoLabel = new JLabel();
        infoLabel.setText("Players Info");
        infoLabel.setBounds(117, 20, 106, 24);
        infoLabel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
        infoLabel.setForeground(UIUtils.PR_COLOR);
        UIUtils.panel.add(infoLabel);

        // ===================================== Input Label (Player 1) =========================================
        p1Label = new JLabel();
        p1Label.setText("Player 1 Name : ");
        p1Label.setBounds(70, 90, 150, 18);
        p1Label.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
        p1Label.setForeground(UIUtils.BT_COLOR1);
        UIUtils.panel.add(p1Label);

        // ===================================== Input Field (Player 1) =========================================
        p1Field = new TextField();
        p1Field.setBounds(70, 115, 200, 30);
        p1Field.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
        p1Field.setForeground(UIUtils.BT_COLOR1);
        p1Field.setCaretColor(UIUtils.BT_COLOR1);
        p1Field.setBorderColor(UIUtils.BT_COLOR1);
        UIUtils.panel.add(p1Field);

        // ===================================== Input Label (Player 2) =========================================
        p2Label = new JLabel();
        p2Label.setText("Player 2 Name : ");
        p2Label.setBounds(70, 160, 150, 18);
        p2Label.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
        p2Label.setForeground(UIUtils.BT_COLOR2);
        UIUtils.panel.add(p2Label);

        // ===================================== Input Field (Player 2) =========================================
        p2Field = new TextField();
        p2Field.setBounds(70, 185, 200, 30);
        p2Field.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
        p2Field.setForeground(UIUtils.BT_COLOR2);
        p2Field.setCaretColor(UIUtils.BT_COLOR2);
        p2Field.setBorderColor(UIUtils.BT_COLOR2);
        UIUtils.panel.add(p2Field);

        // ======================================== Start Game Button ===========================================
        startButton = new RoundedButton();
        startButton.setText("Start Game");
        startButton.setBounds(100, 260, 140, 40);
        startButton.setButtonColor(UIUtils.PR_COLOR);
        startButton.setForeground(UIUtils.BG_COLOR);
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        startButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        startButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
        UIUtils.panel.add(startButton);

    }

    private void startGame() {

        UIUtils.panel.setVisible(true);

        // ========================================= Button (Back) ==============================================
        backbutton = new RoundedButton();
        backbutton.setBounds(135, 290, 70, 40);
        backbutton.setText("Leave");
        backbutton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
        backbutton.setForeground(UIUtils.BG_COLOR);
        backbutton.setButtonColor(Color.RED);
        backbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backbutton.setFocusable(false);
        backbutton.addActionListener(this);
        UIUtils.panel.add(backbutton);

        // ============================================ Separator ===============================================
        separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setForeground(UIUtils.PR_COLOR);
        separator.setBounds(170, 10, 1, 70);
        UIUtils.panel.add(separator);


        // ========================================= Label (Player 1) ===========================================
        p1Label.setText("P1 : " + p1Field.getText());
        p1Label.setBounds(20, 15, 150, 18);
        p1Label.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
        p1Label.setForeground(UIUtils.BT_COLOR1);
        UIUtils.panel.add(p1Label);

        // ========================================== Label (Cross) =============================================
        crossLabel = new JLabel();
        crossLabel.setIcon(crossIcon);
        crossLabel.setBounds(73, 35, 24, 40);
        UIUtils.panel.add(crossLabel);

        // ========================================== Label (Circle) ============================================
        circleLabel = new JLabel();
        circleLabel.setIcon(circleIcon);
        circleLabel.setBounds(243, 35, 24, 40);
        UIUtils.panel.add(circleLabel);

        // ========================================= Label (Player 2) ===========================================
        p2Label.setText("P2 : " + p2Field.getText());
        p2Label.setBounds(190, 15, 150, 18);
        p2Label.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
        p2Label.setForeground(UIUtils.BT_COLOR2);
        UIUtils.panel.add(p2Label);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                tableButtons[i][j] = new RoundedButton();
                tableButtons[i][j].setBounds(85 + (60 * j), 100 + (60 * i), 50, 50);
                tableButtons[i][j].setButtonColor(new Color(0xfcf2af));
                tableButtons[i][j].setFocusable(false);
                tableButtons[i][j].addActionListener(this);
                UIUtils.panel.add(tableButtons[i][j]);

            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        count++;

        if (e.getSource() == backbutton) {
            UIUtils.panel.removeAll();
            UIUtils.panel.setVisible(false);
            new MainMenu();

        } else if (e.getSource() == startButton) {
            UIUtils.panel.removeAll();
            UIUtils.panel.setVisible(false);
            startGame();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (e.getSource() == tableButtons[i][j]) {

                    if (tableButtons[i][j].getIcon() == null) {
                        if (count % 2 == 1) {
                            tableButtons[i][j].setIcon(crossIcon);
                        } else if (count % 2 == 0) {
                            tableButtons[i][j].setIcon(circleIcon);
                        }

                        if (checkWinner(tableButtons) == 1) {

                            UIUtils.frame.setEnabled(false);
                            new WinnerDialog(p1Field.getText() + " has won");

                        } else if (checkWinner(tableButtons) == 2) {

                            UIUtils.frame.setEnabled(false);
                            new WinnerDialog(p2Field.getText() + " has won");
                        }

                    } else {
                        count--;
                    }

                }
            }
        }

    }

    private int checkWinner(RoundedButton[][] tableButtons) {

        for (int i = 0; i < 3; i++) {

            if ((tableButtons[i][0].getIcon() == tableButtons[i][1].getIcon()) && (tableButtons[i][1].getIcon() == tableButtons[i][2].getIcon())) {

                if (tableButtons[i][0].getIcon() == crossIcon)
                    return 1;
                else if (tableButtons[i][0].getIcon() == circleIcon)
                    return 2;

            } else if ((tableButtons[0][i].getIcon() == tableButtons[1][i].getIcon()) && (tableButtons[1][i].getIcon() == tableButtons[2][i].getIcon())) {

                if (tableButtons[0][i].getIcon() == crossIcon)
                    return 1;
                else if (tableButtons[0][i].getIcon() == circleIcon)
                    return 2;

            }
        }

        if ((tableButtons[0][0].getIcon() == tableButtons[1][1].getIcon()) && (tableButtons[1][1].getIcon() == tableButtons[2][2].getIcon())) {

            if (tableButtons[0][0].getIcon() == crossIcon)
                return 1;
            else if (tableButtons[0][0].getIcon() == circleIcon)
                return 2;

        } else if ((tableButtons[2][0].getIcon() == tableButtons[1][1].getIcon()) && (tableButtons[1][1].getIcon() == tableButtons[0][2].getIcon())) {

            if (tableButtons[2][0].getIcon() == crossIcon)
                return 1;
            else if (tableButtons[2][0].getIcon() == circleIcon)
                return 2;

        }

        return 0;
    }
}
