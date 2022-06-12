package views;

import listeners.ButtonAddListener;
import models.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private JButton btnShow;
    private JButton btnAdd;
    private JTextField txtAge;
    private JTextField txtName;
    private Model model;

    private PanelTop panelTop;


    public View(Model model) {
        this.model = this.model;
        setUpFrame();
        setUpPanel();
        addPanelsToFrame();
    }

    /**
     * Setup JFrame elements
     */

    private void setUpFrame(){
        this.setTitle("Input & Output");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(300, 150));
    }

    /**
     * Setup JPanel top and bottom
     */
    private void setUpPanel(){
        panelTop = new PanelTop(model);
    }

    /**
     * Add top and bottom to JFrame
     */
    private void addPanelsToFrame(){
        this.add(panelTop, BorderLayout.NORTH);

    }



    //_____________________GETTERS________________________//

    /**
     * Getter for button show
     * @return Open table and shows file content and returns button click
     */
    public JButton getBtnShow() {
        return panelTop.getBtnShow();
    }

    /**
     * Getter for button add
     * @return Sends form content to the file and returns button click
     */
    public JButton getBtnAdd() {
        return panelTop.getBtnAdd();
    }

    /**
     * Getter for age text field
     *
     * @return Returns text field data
     */
    public JTextField getTxtAge() {
        return ButtonAddListener.txtAge();
    }


    /**
     * Getter for age text field
     * @return Returns text filed data
     */
    public JTextField getTextName() {
        return ButtonAddListener.txtName();
    }

    public void setTxtAge(JTextField txtAge) {
        this.txtAge = ButtonAddListener.txtAge;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = ButtonAddListener.txtName;
    }

    //________________________Listeners___________________________//

    /**
     * Add button listener for a button Add
     * @param al Listens a button from panelTop btnAdd
     */
    public void registerButtonAdd(ActionListener al) {
        panelTop.getBtnAdd().addActionListener(al);
    }

    /**
     * Add button listener for a button Show
     * @param al Listens a button from panelTop btnShow
     */

    public void registerButtonShow(ActionListener al){
        panelTop.getBtnShow().addActionListener(al);
    }


}
