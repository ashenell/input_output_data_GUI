package views;

import listeners.ButtonAddListener;
import models.Model;

import javax.swing.*;
import java.awt.*;

public class PanelTop extends JPanel {
    public JTextField textAge;
    private Model model;
    
    private JPanel pnlComponents = new JPanel(new GridBagLayout());
    private Font fontNormal = new Font("Verdana", Font.PLAIN, 14);
    private GridBagConstraints gbc = new GridBagConstraints();

    //There are components what need's to be access else where

    private JTextField txtName, txtAge;
    private JButton btnAdd, btnShow;

    public PanelTop(Model model) {
        this.model = model;
        setUpPanel();
        setUpConstraint();
        setUpLineFirst();
        setUpLineSecond();
        setUpLineThird();
        this.add(pnlComponents);
    }

    private void setUpPanel(){
        setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    private void setUpConstraint(){
        //Row content is align to left
        gbc.anchor = GridBagConstraints.WEST;
        //Rounded with 2px all sides
        gbc.insets = new Insets(2,2,2,2);
        //Makes filed components wider
        gbc.fill = GridBagConstraints.BOTH;
    }

    /**
     * Grid Layout starts from here
     * First row
     */
    private void setUpLineFirst(){
        //First column
        JLabel lblName = new JLabel("Name");
        lblName.setFont(fontNormal);
        gbc.gridx = 0;
        gbc.gridy = 0;
        pnlComponents.add(lblName,gbc);
        //Second column
        txtName = new JTextField("", 10);
        txtName.setFont(fontNormal);
        gbc.gridx = 1;
        gbc.gridy = 0;
        pnlComponents.add(txtName, gbc);


    }

    /**
     * Grid layout
     * Second row
     */

    private void setUpLineSecond(){
        //First column
        JLabel lblAge = new JLabel("Age");
        lblAge.setFont(fontNormal);
        gbc.gridx = 0;
        gbc.gridy = 1;
        pnlComponents.add(lblAge, gbc);
        //Second column
        txtAge = new JTextField("", 10);
        txtAge.setFont(fontNormal);
        gbc.gridx = 1;
        gbc.gridy = 1;
        pnlComponents.add(txtAge, gbc);
    }

    /**
     * Grid layout
     * Third row
     */

    private void setUpLineThird(){
        //First column
        btnShow = new JButton("Show data");
        btnShow.setFont(fontNormal);
        gbc.gridx = 0;
        gbc.gridy = 2;
        pnlComponents.add(btnShow, gbc);
        //Second column
        btnAdd = new JButton("Add person");
        btnShow.setFont(fontNormal);
        gbc.gridx = 1;
        gbc.gridy = 2;
        pnlComponents.add(btnAdd, gbc);
    }



    public JTextField getTxtName() {
        return ButtonAddListener.txtName;
    }

    public JTextField getTxtAge() {
        return txtAge;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnShow() {
        return btnShow;
    }
}
