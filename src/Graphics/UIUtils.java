package Graphics;

// imports
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.HashMap;

public class UIUtils {

    public static final Color BG_COLOR = new Color(0xfefae0);
    public static final Color PR_COLOR = new Color(0x606c38);
    public static final Color BT_COLOR1 = new Color(0xbc4625);
    public static final Color BT_COLOR2 = new Color(0x43380D);
    public static final Color TXT_COLOR = new Color(0x606c38);
    public static final int BT_ROUNDNESS = 8;
    public static final JFrame frame = new JFrame();
    public static final JPanel panel = new JPanel();

    static {
        // ======================================== Initializing JFrame ===========================================
        frame.setTitle("TicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(355, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // ========================================= Initializing JPanel ==========================================
        panel.setLayout(null);
        panel.setBounds(0, 0, 340, 400);
        panel.setBackground(UIUtils.BG_COLOR);
        frame.add(panel);
    }

    public static Graphics2D get2dGraphics(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.addRenderingHints(new HashMap<RenderingHints.Key, Object>() {
            {
                put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
            }
        });
        return g2;
    }

}