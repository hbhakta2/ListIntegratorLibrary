/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listintegratorlibrary;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * LimitedLengthDocument class inherits PlainDocument
 * 
 * @author Hardikkumar Bhakta
 */
public class LimitedLengthDocument extends PlainDocument {
    
    private final int limit;
    
    /**
     * Constructor takes int
     * @param limit 
     * and sets limit of digits allowed
     */
    public LimitedLengthDocument(int limit) {
        this.limit = limit;
    }
    
    @Override
    public void insertString(int offset, String string, AttributeSet attributeSet) throws BadLocationException {
        if (getLength() + string.length() <= limit) {
            super.insertString(offset, string, attributeSet);
        }
    }
    
}
