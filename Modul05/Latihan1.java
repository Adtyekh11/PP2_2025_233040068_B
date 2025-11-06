package PP2_2025_233040068_B.Modul05;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 *
 * @author ADITYA EKA HERIYAWAN
 */
public class Latihan1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Jendela Pertamaku");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
