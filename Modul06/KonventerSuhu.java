package PP2_2025_233040068_B.Modul06;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


/**
 *
 * @author ADITYA EKA HERIYAWAN
 */
public class KonventerSuhu {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Konversi Suhu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setLayout(new GridLayout(3, 2, 10, 10));
        
        JLabel celciusLabel = new JLabel("Celcius: ");
        JTextField celciusField = new JTextField();
        JButton convertButton = new JButton("Konversi");
        JLabel fahrenheitLabel = new JLabel("Fahrenheit: ");
        JLabel resultLabel = new JLabel("");
        
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String celciusText = celciusField.getText();
                    double celcius = Double.parseDouble(celciusText);
                    double fahrenheit = (celcius *9 / 5) + 32;
                    resultLabel.setText(String.format("%.2f", fahrenheit));
                } catch (NumberFormatException ex){
                    resultLabel.setText("Input Salah! ");
                }
            }
        });
        
        frame.add(celciusLabel);
        frame.add(celciusField);
        frame.add(fahrenheitLabel);
        frame.add(resultLabel);
        frame.add(convertButton);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}