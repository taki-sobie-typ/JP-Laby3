package threeFour;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class CalculatorFrame implements ActionListener {
    private final JButton[] numberButtons = new JButton[10];
    private final JFrame calcFrame = new JFrame();
    private final JTextField textField = new JTextField();
    private final JButton addButton = new JButton("+");
    private final JButton subButton = new JButton("-");
    private final JButton mulButton = new JButton("*");
    private final JButton divButton = new JButton("/");
    private final JButton eqlButton = new JButton("=");
    private final JButton cleButton = new JButton("C");

    private Double number1;
    private Double number2;
    private Double result;
    private String operator;
    CalculatorFrame(String title){
        calcFrame.setTitle("Witaj! "+title);
        calcFrame.setSize(500, 600); // sets size x,y
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calcFrame.setResizable(false); // prevent resizing
        calcFrame.setLayout(new BorderLayout());
        calcFrame.setLocationRelativeTo(null);

        JPanel prompt = new JPanel();
        calcFrame.add(prompt, BorderLayout.NORTH);
        prompt.setLayout(new BorderLayout());
        prompt.setPreferredSize(new Dimension(calcFrame.getWidth(),100));
        prompt.setBackground(Color.WHITE);
        prompt.add(textField);
        prompt.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        Font myFont = new Font("Arial", Font.BOLD, 42);
        textField.setFont(myFont);
        textField.setBounds(0,0, prompt.getWidth(), prompt.getHeight());


        JPanel calc = new JPanel();
        calc.setLayout(new GridLayout(4,4, 5,5));
        calcFrame.add(calc, BorderLayout.CENTER);
        calc.setBackground(Color.BLACK);
        calc.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));


        for(int i=0;i<10;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            calc.add(numberButtons[i]);
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(Color.WHITE);
        }


        JButton[] funcButtons = new JButton[6];
        funcButtons[0] = cleButton;
        funcButtons[1] = addButton;
        funcButtons[2] = subButton;
        funcButtons[3] = mulButton;
        funcButtons[4] = divButton;
        funcButtons[5] = eqlButton;


        for(int i=0;i<6;i++){
            calc.add(funcButtons[i]);
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(myFont);
            funcButtons[i].setFocusable(false);
            funcButtons[i].setBackground(Color.DARK_GRAY);
            funcButtons[i].setForeground(Color.WHITE);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++){
            if(e.getSource()==numberButtons[i]) {
                textField.setText(textField.getText().concat(numberButtons[i].getText()));
            }
        }

        Object source = e.getSource();
        if (source.equals(addButton)) {
            number1 = Double.parseDouble(textField.getText());
            operator = "+";
            textField.setText("");
        }
        else if (source.equals(subButton)) {
            number1 = Double.parseDouble(textField.getText());
            operator = "-";
            textField.setText("");
        }
        else if (source.equals(mulButton)) {
            number1 = Double.parseDouble(textField.getText());
            operator = "*";
            textField.setText("");
        }
        else if (source.equals(divButton)) {
            number1 = Double.parseDouble(textField.getText());
            operator = "/";
            textField.setText("");
        }
        else if (source.equals(cleButton)) {
            textField.setText("");
            number1 = null;
            number2 = null;
            operator = " ";
        }
        // MOST IMPORTANT PART OF A CALCULATOR EQL STATEMENT
        else if (source.equals(eqlButton)) {
            if(!Objects.equals(textField.getText(), "")){
                number2 = Double.parseDouble(textField.getText());
            }

            switch (operator){
                case "+":
                    result = number1+number2;
                    afterEqlButton();
                    break;
                case "-":
                    result = number1-number2;
                    afterEqlButton();
                    break;
                case "*":
                    result = number1*number2;
                    afterEqlButton();
                    break;
                case "/":
                    if(number2!=0) {
                        result = number1/number2;
                        afterEqlButton();
                    }
                    else{
                        textField.setText("0");
                    }
                    break;
                default:
                    break;
            }
            number2 = null;
        }
    }

    private void afterEqlButton(){
        number1 = result;
        textField.setText(String.valueOf(result));
        operator = " ";
    }

    public void setFrameVisible(boolean x){
        calcFrame.setVisible(x);
    }
}
