
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewClass {

    public static void main(String[] args) {
        JFrame fr = new JFrame();
        JLabel l1 = new JLabel();
        JPanel p1 = new JPanel();
        JTextField text1 = new JTextField("");
        JTextField text2 = new JTextField("Enter your name here");
        JButton b1 = new JButton("Click");
        JComboBox bx1 = new JComboBox();
        bx1.addItem("Thailand");
        bx1.addItem("NewZealand");
        bx1.addItem("Taiwan");
        text1.setEditable(false);
        text2.setEditable(true);
        p1.setLayout(new GridLayout(3, 3));
        fr.add(bx1, BorderLayout.EAST);
        fr.add(text1, BorderLayout.NORTH);
        fr.add(text2, BorderLayout.CENTER);
        p1.add(b1);
        p1.add(l1);
        fr.add(p1, BorderLayout.SOUTH);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(230, 110);
        fr.pack();
        fr.setVisible(true);
        fr.setResizable(false);

        //text that only display
        text2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                text2.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                String text = text2.getText().trim();
                if (text.isEmpty()) {
//                    text2.setText("Enter your name here");
                    l1.setText("Put your name first.");
                } else {
                    l1.setText("I've known you from " + bx1.getSelectedItem() + ".");
                }
            }
        });

        // action listener for the button
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedValue = (String) bx1.getSelectedItem();
                System.out.println("Selected value: " + selectedValue);
                if (!text2.getText().isEmpty()) {
                    l1.setText("I've known you from " + bx1.getSelectedItem() + ".");
                    text1.setText("Hello " + text2.getText() + " !");
                } else {
                    l1.setText("Put your name first.");
                }
            }
        });
    }
}
