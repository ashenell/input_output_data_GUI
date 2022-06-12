package listeners;

import models.Model;
import views.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAddListener implements ActionListener {
    public static JTextField txtName;
    public static JTextField txtAge;
    //https://www.tutorialspoint.com/how-can-we-limit-the-number-of-characters-inside-a-jtextfield-in-java
    private Model model;
    private View view;




    public ButtonAddListener(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public static JTextField txtAge() {
        return txtAge;
    }

    public static JTextField txtName() {
        return txtName;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //JOptionPane.showMessageDialog(null, "Button add was clicked!");//Test
        String txtName = txtName().getText();
        JTextField age = txtAge();
        System.out.println("Person name: " + txtName);
        System.out.println("Person age: " + age);
        if (1 < 0){
            System.out.println("tere");
        }
    }

    private void cleatForm() {
        view.getTextName().setText("");
        view.getTxtAge();
    }

    public static JTextField getTxtName() {
        return txtName;
    }

    public static JTextField getTxtAge() {
        return txtAge;
    }
    
}
