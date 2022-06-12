package listeners;

import models.FileData;
import models.Model;
import views.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ButtonShowListener implements ActionListener {

    private Model model;
    private View view;




    //_________________Constructor__________________//
    public ButtonShowListener(Model model, View view) throws IOException {
        this.model = model;
        this.view = view;


    }


    //___________________Execute____________________//
    @Override
    public void actionPerformed(ActionEvent e) {
        //JOptionPane.showMessageDialog(null, "Button show was clicked!");
        try {
            if(model.readFromFile()){
                JDialog dialog = new JDialog();
                model.addToTable(dialog);
                dialog.setModal(true);
                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(view, "Empty data");
            }


        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    

}
