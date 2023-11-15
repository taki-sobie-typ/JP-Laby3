package threeFour;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame implements ActionListener {
    private final JFrame calcFrame = new JFrame();
    private final JPanel prompt = new JPanel();
    private final JPanel calc = new JPanel();
    private final JTextField textField = new JTextField();
    CalculatorFrame(String title){
        calcFrame.setTitle("Witaj! "+title);
        calcFrame.setSize(500, 600); // sets size x,y
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calcFrame.setResizable(false); // prevent resizing
        calcFrame.setLayout(new BorderLayout());
        calcFrame.setLocationRelativeTo(null);

        calcFrame.add(prompt, BorderLayout.NORTH);
        prompt.setLayout(new BorderLayout());
        prompt.setPreferredSize(new Dimension(calcFrame.getWidth(),100));
        prompt.setBackground(Color.gray);
        prompt.add(textField);
        textField.setBounds(0,0,prompt.getWidth(),prompt.getHeight());


        calc.setLayout(new GridLayout(4,4));
        calcFrame.add(calc, BorderLayout.CENTER);
        calc.setBackground(Color.red);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void setFrameVisible(boolean x){
        calcFrame.setVisible(x);
    }
}
