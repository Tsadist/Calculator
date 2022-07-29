import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Panel extends JPanel {

    private JButton numbers [] = new JButton[10];
    private Font font = new Font("SanSerif", Font.BOLD, 20);
    private JTextField output = new JTextField();

    public Panel(){
        setLayout(null);
        numbers[0] = new JButton("0");
        numbers[0].setBounds(70, 250, 50, 50 );
        numbers[0].setFont(font);
        add(numbers[0]);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                numbers[y*3+x+1] = new JButton((y * 3 + x + 1)+ "");
                numbers[y*3+x+1].setBounds(x*(50+10)+10, y* (50+10) + 70, 50, 50 );
                numbers[y*3+x+1].setFont(font);
                add(numbers[y*3+x+1]);

            }

        }
        output.setBounds(10, 10, 220, 50);
        output.setEditable(false);
        add(output);

        ActionListener l;

    }
}
