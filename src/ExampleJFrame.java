import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ExampleJFrame extends JFrame {
    ExampleJFrame(){

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanel.setBackground(Color.gray);

        JLabel label = new JLabel("Insert example text:");
        jPanel.add(label);

        JTextField textField = new JTextField(20);
        jPanel.add(textField);

        JPasswordField passwordField = new JPasswordField(20);
        jPanel.add(passwordField);

        JButton button = new JButton("ADD");
        jPanel.add(button);

        JButton buttonScreenPlacer = new JButton("Change Params");
        jPanel.add(buttonScreenPlacer);

        JTextArea textArea = new JTextArea(40,20);

        setTitle("Example Title");
        setSize(900, 600); // sets size x,y
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true); // prevent resizing
        setLayout(new BorderLayout());
        add(jPanel, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);
        setLocationRelativeTo(null);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(textField.getText()+", ");
                stringBuilder.append(passwordField.getPassword());

                textArea.append(stringBuilder + "\n");
                stringBuilder.setLength(0);

                textField.setText("");
                passwordField.setText("");
            }
        });


        JDialog jDialog = new JDialog();

        jDialog.setTitle("ChangePlacement");
        jDialog.setSize(300, 200);
        jDialog.setLayout(new FlowLayout(FlowLayout.LEFT));
        jDialog.setLocationRelativeTo(this);

        String[] optionsColors = {"GRAY","WHITE","RED"};
        JComboBox<String> comboBoxColors = new JComboBox<>(optionsColors);
        jDialog.add(new Label("Color:"));
        jDialog.add(comboBoxColors);

        String[] optionsPlacement = {"NORTH","SOUTH"};
        JComboBox<String> comboBoxPlacement = new JComboBox<>(optionsPlacement);
        jDialog.add(new Label("Placement:"));
        jDialog.add(comboBoxPlacement);

        JButton buttonSubmit = new JButton("Submit");
        jDialog.add(buttonSubmit);

        buttonScreenPlacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog.setVisible(true);
            }
        });

        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (String.valueOf(comboBoxPlacement.getSelectedItem())) {
                    case "NORTH" -> {
                        remove(jPanel);
                        add(jPanel, BorderLayout.NORTH);
                    }
                    case "SOUTH" -> {
                        remove(jPanel);
                        add(jPanel, BorderLayout.SOUTH);
                    }
                    default -> {
                    }
                }

                switch (String.valueOf(comboBoxColors.getSelectedItem())) {
                    case "GRAY" -> {
                        jPanel.setBackground(Color.gray);
                    }
                    case "WHITE" -> {
                        jPanel.setBackground(Color.white);
                    }
                    case "RED" -> {
                        jPanel.setBackground(Color.red);
                    }
                    default -> {
                    }
                }

                setVisible(true);
                jDialog.setVisible(false);

            }
        });

    }
}
