import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SwingExample extends JFrame {
    private JLabel label;
    public SwingExample() {
        label = new JLabel("This is Swing");
        JButton button = new JButton("Click Me");
        setLayout(new FlowLayout());
        add(label);
        add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Swing Button Clicked!");
            }
        });
        setTitle("Swing Example");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SwingExample();
    }
}