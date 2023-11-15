package threeFour;

import javax.swing.*;

public class HelloMessage{
    private String name;

    public void message(String message){
        JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.PLAIN_MESSAGE);
    }

    public void enterName(String prompt){
        name = JOptionPane.showInputDialog(null, prompt, "Wprowadź", JOptionPane.QUESTION_MESSAGE);
    }

    public String getNameEntered(){
        return name;
    }
}
