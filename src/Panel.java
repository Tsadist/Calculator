import javax.swing.*;

public class Panel extends JPanel {

    public Panel(){
        setLayout(null);

        JButton b1 = new JButton("123");
        b1.setBounds(100, 100, 80 , 50);
        add(b1);
    }
}
