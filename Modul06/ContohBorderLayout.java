package PP2_2025_233040068_B.Modul06;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
/**
 *
 * @author ADITYA EKA HERIYAWAN
 */
public class ContohBorderLayout {
    public static void main(String[]args) {
        
        JFrame frame = new JFrame("Contoh BorderLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        
        frame.add(new JButton("NORTH"), BorderLayout.NORTH);
        frame.add(new JButton("SOUTH"), BorderLayout.SOUTH);
        frame.add(new JButton("EAST"), BorderLayout.EAST);
        frame.add(new JButton("WEST"), BorderLayout.WEST);
        frame.add(new JButton("CENTER"), BorderLayout.CENTER);
        
        
        frame.setVisible(true);
                
    }
}
