package listeners;

import models.Model;
import views.PanelTop;
import views.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ButtonAddListener implements ActionListener {
    public static JTextField txtName;
    public static JTextField txtAge;
    //https://www.tutorialspoint.com/how-can-we-limit-the-number-of-characters-inside-a-jtextfield-in-java
    private Model model;
    private View view;
    private PanelTop panelTop;




    public ButtonAddListener(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //JOptionPane.showMessageDialog(null, "Button add was clicked!");//Test
        String txtName = view.getTxtName().getText();
        int age = Integer.parseInt(view.getTxtAge().getText());
        //System.out.println("Person name: " + txtName);
        //System.out.println("Person age: " + age);
        if (!txtName.isEmpty() && txtName.length() > 1 && txtName.length() < 20 && age > 0 && age < 100){
            //System.out.println("Hello world!");
            writeToFileToFile();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(null, "Something is missing on form filed. Please " +
                    "try again", "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        view.getTxtName().setText(null);
        view.getTxtAge().setText(null);
    }
    public void writeToFileToFile(){
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(model.getFileName(), true))) {
            String line = view.getTxtName().getText() + ";" + view.getTxtAge().getText();
            fw.write(line);
            fw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
