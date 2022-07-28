import javax.swing.*;

public class Start {
    private JFrame window;

    public Start(){
        window = new JFrame("Calculator");
        window.setSize(280, 340);
        window.add(new Panel());
        window.setLocation(550, 300);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public static void  main ( String [] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Start ();
            }
        });
    }


}