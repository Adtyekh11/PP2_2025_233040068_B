package PP2_2025_233040068_B.Modul05;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
/**
 *
 * @author ADITYA EKA HERIYAWAN
 */
public class Latihan2 {
      public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Jendela dengan Label");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                JLabel label = new JLabel("Ini adalah Jlabel");
                
                frame.add(label);
                frame.setVisible(true);
            }
        });
    }
}
