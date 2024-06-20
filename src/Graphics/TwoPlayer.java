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
    private RoundedButton[][] tableButtons = new RoundedButton[3][3];
    private JSeparator separator;
    private JLabel p1Label;
    private JLabel p2Label;
    private final ImageIcon crossIcon = new ImageIcon("./src/Images/cross.png");
    private final ImageIcon circleIcon = new ImageIcon("./src/Images/circle.png");
    int count = 0;

    public TwoPlayer() {

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
        p1Label = new JLabel();
        p1Label.setText("Player X");
        p1Label.setBounds(42, 30, 150, 24);
        p1Label.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 22));
        p1Label.setForeground(UIUtils.BT_COLOR1);
        UIUtils.panel.add(p1Label);

        // ========================================= Label (Player 2) ===========================================
        p2Label = new JLabel();
        p2Label.setText("Player O");
        p2Label.setBounds(212, 30, 150, 24);
        p2Label.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 22));
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
                            new WinnerDialog("Player X has won");

                        } else if (checkWinner(tableButtons) == 2) {

                            UIUtils.frame.setEnabled(false);
                            new WinnerDialog("Player O has won");
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
