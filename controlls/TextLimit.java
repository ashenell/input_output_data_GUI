package controlls;

import models.Model;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.text.View;

//https://www.tutorialspoint.com/how-can-we-limit-the-number-of-characters-inside-a-jtextfield-in-java
public class TextLimit extends PlainDocument {
    private Model model;
    private View view;

    private int limit;
    TextLimit(int limit){
        super();
        this.limit = limit;
    }
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) return;

        if ((getLength() + str.length() <= limit)) {
            super.insertString(offset, str, attr);
        }
    }

}
