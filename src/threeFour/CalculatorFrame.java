package threeFour;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame implements ActionListener {
    private JButton[] numberButtons = new JButton[9];
    private JButton[] funcButtons = new JButton[5];
    private final JFrame calcFrame = new JFrame();
    private final JPanel prompt = new JPanel();
    private final JPanel calc = new JPanel();
    private final JTextField textField = new JTextField();
    private final Font myFont = new Font("Arial",Font.BOLD,42);
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
        textField.setFont(myFont);
        textField.setBounds(0,0,prompt.getWidth(),prompt.getHeight());


        calc.setLayout(new GridLayout(4,4, 5,5));
        calcFrame.add(calc, BorderLayout.CENTER);
        calc.setBackground(Color.BLACK);


        for(int i=0;i<9;i++){
            numberButtons[i] = new JButton(String.valueOf(i+1));
            calc.add(numberButtons[i]);
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void setFrameVisible(boolean x){
        calcFrame.setVisible(x);
    }
}
