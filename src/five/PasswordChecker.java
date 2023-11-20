package five;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordChecker extends JFrame implements ActionListener {
    private final Label passwordStrengthStatus = new Label("result of the test");
    private final JPasswordField passwordField = new JPasswordField();
    private Integer strengthPoints = 0;
    PasswordChecker(){
        setTitle("Password Strength checker");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        JPanel passwordStatus = new JPanel();
        add(passwordStatus, BorderLayout.NORTH);
        setSize(600, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Font myFont = new Font("Arial", Font.PLAIN, 24);

        passwordStatus.setLayout(new FlowLayout(FlowLayout.CENTER));
        Label passwordStrenghtLabel = new Label("Strength:");
        passwordStatus.add(passwordStrenghtLabel);
        passwordStatus.add(passwordStrengthStatus);
        passwordStrenghtLabel.setFont(myFont);
        passwordStrengthStatus.setFont(myFont);

        JPanel passwordFieldContainer = new JPanel();
        passwordFieldContainer.setLayout(new GridLayout(2,1));
        passwordFieldContainer.setBackground(Color.WHITE);
        passwordFieldContainer.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        add(passwordFieldContainer,BorderLayout.CENTER);

        passwordFieldContainer.add(passwordField);
        passwordField.setFont(myFont);

        JButton passwordCheckerButton = new JButton("CHECK");
        passwordCheckerButton.setFont(myFont);
        passwordCheckerButton.setBackground(Color.lightGray);
        passwordFieldContainer.add(passwordCheckerButton);
        passwordCheckerButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(passwordField.getPassword().length>8) strengthPoints++;

        if(passwordField.getPassword().length>12) strengthPoints++;

        if(containsCapital(passwordField.getPassword())) strengthPoints++;

        strengthPoints += containsNumbers(passwordField.getPassword());

        if(containsSpecialChars(passwordField.getPassword())) strengthPoints++;


        switch (strengthPoints){
            case 0:
                passwordStrengthStatus.setText("Very Bad");
                break;
            case 1:
                passwordStrengthStatus.setText("Bad");
                break;
            case 2:
                passwordStrengthStatus.setText("Medicare");
                break;
            case 3:
                passwordStrengthStatus.setText("Above Medicare");
                break;
            case 4:
                passwordStrengthStatus.setText("Good");
                break;
            case 5:
                passwordStrengthStatus.setText("Very Good");
                break;
            case 6:
                passwordStrengthStatus.setText("Excellent");
                break;
            default:
                break;
        }
        strengthPoints=0;
    }

    private boolean containsCapital(char[] str){
        for (char currentChar : str) {
            if (Character.isUpperCase(currentChar)) {
                return true;
            }
        }
        return false;
    }

    private int containsNumbers(char[] str){
        int howMany = 0;
        for(char currentChar : str) {
            if(Character.isDigit(currentChar)){
                howMany++;
            }
        }

        if(howMany>1){
            return 2;
        }
        else if(howMany==1){
            return 1;
        }
        else {
            return 0;
        }
    }

    private boolean containsSpecialChars(char[] str){
        for(char currentChar : str) {
            if(!Character.isAlphabetic(currentChar)){
                return true;
            }
        }
        return false;
    }

    public void showFrame(){
        setVisible(true);
    }

    public void hideFrame(){
        setVisible(true);
    }
}
