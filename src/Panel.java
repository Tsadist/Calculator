import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel {

    private JButton numbers[] = new JButton[10];
    private Font font = new Font("SanSerif", Font.BOLD, 20);
    private JTextField output = new JTextField();
    private JButton backspace = new JButton("<");
    private JButton equ = new JButton("=");
    private JButton plus = new JButton("+");
    private JButton minus = new JButton("-");
    private JButton multi = new JButton("*");
    private JButton division = new JButton("/");
    private int number1 = 0;
    private String symbol = "";


    public Panel() {
        setLayout(null);
        setFocusable(true);
        grabFocus();

        addBotton(backspace, 10, 250, e -> {
            String s = output.getText();
            output.setText(removeLastChar(s));
        });
        addBotton(equ, 130, 250, e -> {
            String s = output.getText();
            int num2 = Integer.parseInt(output.getText());
            int result = 0;
            switch (symbol) {
                case "+":
                    result = number1 + num2;
                    break;
                case "-":
                    result = number1 - num2;
                    break;
                case "*":
                    result = number1 * num2;
                    break;
                case "/":
                    result = number1 / num2;
                    break;
            }
            output.setText(String.valueOf(result));
        });
        addBotton(plus, 190, 70, e -> {
            number1 = Integer.parseInt(output.getText());
            output.setText("");
            symbol = "+";
        });
        addBotton(minus, 190, 130, e -> {
            number1 = Integer.parseInt(output.getText());
            output.setText("");
            symbol = "-";
        });
        addBotton(multi, 190, 190, e -> {
            number1 = Integer.parseInt(output.getText());
            output.setText("");
            symbol = "*";
        });
        addBotton(division, 190, 250, e -> {
            number1 = Integer.parseInt(output.getText());
            output.setText("");
            symbol = "/";
        });

        numbers[0] = new JButton("0");
        numbers[0].setBounds(70, 250, 50, 50);
        numbers[0].setFont(font);
        add(numbers[0]);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                numbers[y * 3 + x + 1] = new JButton((y * 3 + x + 1) + "");
                numbers[y * 3 + x + 1].setBounds(x * (50 + 10) + 10, y * (50 + 10) + 70, 50, 50);
                numbers[y * 3 + x + 1].setFont(font);
                add(numbers[y * 3 + x + 1]);

            }

        }

        output.setBounds(10, 10, 230, 50);
        output.setEditable(false);
        output.setFont(font);
        add(output);

        ActionListener l = (ActionEvent e) -> {
            JButton b = (JButton) e.getSource();
            output.setText(output.getText() + b.getText());
        };

        for (JButton b : numbers) {
            b.addActionListener(l);
        }

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char symbol = e.getKeyChar();

                if (!Character.isDigit(symbol))
                    return;

                output.setText(output.getText() + symbol);
            }
        });

    }

    private void addBotton(JButton button, int x, int y, ActionListener listner) {
        button.setBounds(x, y, 50, 50);
        button.setFont(font);
        add(button);
        button.addActionListener(listner);
    }

    public static String removeLastChar(String s1) {
        return (s1 == null || s1.length() == 0)
                ? ""
                : (s1.substring(0, s1.length() - 1));
    }

}
