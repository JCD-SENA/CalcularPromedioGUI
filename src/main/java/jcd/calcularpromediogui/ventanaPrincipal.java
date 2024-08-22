package jcd.calcularpromediogui;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

public class ventanaPrincipal extends JFrame implements ActionListener {
    
    JPanel mainPanel;
    JLabel title, subjectLabel, nameLabel, labelNote1, labelNote2, labelNote3;
    JTextField nameInput, subjectInput, note1, note2, note3;
    Button calculateButton, exitButton, cleanButton;
    JTextArea output;
    int width, height;
    
    public ventanaPrincipal() {
        width = 600;
        height = 400;
        declareWidgets();
        setTitle("Calcular nota");
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    public void declareWidgets () {
        mainPanel = new JPanel();
        title = new JLabel();
        nameLabel = new JLabel();
        subjectLabel = new JLabel();
        labelNote1 = new JLabel();
        labelNote2 = new JLabel();
        labelNote3 = new JLabel();
        nameInput = new JTextField();
        subjectInput = new JTextField();
        note1 = new JTextField();
        note2 = new JTextField();
        note3 = new JTextField();
        calculateButton = new Button("Calcular");
        exitButton = new Button("Salir");
        cleanButton = new Button("Limpiar");
        output = new JTextArea();
        
        title.setText("Calcular nota de estudiante");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(0, 10, width, 16);

        nameLabel.setText("Nombre del estudiante");
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setBounds(60, 32, 130, 16);
        
        subjectLabel.setText("Nombre de la materia");
        subjectLabel.setHorizontalAlignment(SwingConstants.CENTER);
        subjectLabel.setBounds(60, 64, 130, 24);
        
        nameInput.setBounds(200, 32, 250, 24);
        
        subjectInput.setBounds(200, 64, 250, 24);
        
        labelNote1.setText("Primera nota");
        labelNote1.setBounds((width / 4)-38, 106, 80, 16);
        note1.setBounds((width / 4)-39, 124, 80, 24);
        
        labelNote2.setText("Segunda nota");
        labelNote2.setBounds((width / 4 * 2)-38, 106, 80, 16);
        note2.setBounds((width / 4 * 2)-39, 124, 80, 24);
        
        labelNote3.setText("Tercera nota");
        labelNote3.setBounds((width / 4 * 3)-38, 106, 80, 16);
        note3.setBounds((width / 4 * 3)-39, 124, 80, 24);
        
        calculateButton.setBounds(20, 164, 80, 32);
        cleanButton.setBounds(20, 204, 80, 32);
        exitButton.setBounds(20, height - 80, 80, 32);
        
        calculateButton.addActionListener(this);
        cleanButton.addActionListener(this);
        exitButton.addActionListener(this);
        
        output.setEditable(false);
        output.setLineWrap(true);
        output.setBounds(110, 164, width - 150, 187);
        
        mainPanel.setBackground(Color.getHSBColor(120, 50, 250));
        mainPanel.setLayout(null);
        mainPanel.add(title);
        mainPanel.add(nameLabel);
        mainPanel.add(subjectLabel);
        mainPanel.add(nameInput);
        mainPanel.add(subjectInput);
        mainPanel.add(labelNote1);
        mainPanel.add(labelNote2);
        mainPanel.add(labelNote3);
        mainPanel.add(note1);
        mainPanel.add(note2);
        mainPanel.add(note3);
        mainPanel.add(calculateButton);
        mainPanel.add(cleanButton);
        mainPanel.add(exitButton);
        mainPanel.add(output);
        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Salir":
                System.exit(0);
                break;
            case "Calcular":
                calculate();
                break;
            case "Limpiar":
                clear();
                break;
        }
    }
    
    public void clear() {
        output.setText("");
        note1.setText("");
        note2.setText("");
        note3.setText("");
        nameInput.setText("");
        subjectInput.setText("");
    }
    
    public void calculate() {
        try {
            int average = (int)(Double.parseDouble(note1.getText()) + Double.parseDouble(note2.getText()) + Double.parseDouble(note2.getText())) / 3;
            String outputValue = "El estudiante "+nameInput.getText()+" ha sacado un promedio de "+average+" en "+subjectInput.getText();
            output.setText(outputValue);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Uno de los valores ingresados no es valido", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
