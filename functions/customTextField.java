/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hse_application.functions;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author OPTIPLEX
 */
public class customTextField extends JTextField{
    
    private Color inactiveColor = UIManager.getColor(Color.white);
    
    
    public void setDisabledBackgroundColor(Color inactiveColor) {
        this.inactiveColor = inactiveColor;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        if (!isEditable() || !isEnabled()) {
            setOpaque(false);
            g.setColor(inactiveColor);
            g.fillRect(0, 0, getWidth(), getHeight());
        } else {
          setOpaque(true);
        }
        super.paintComponent(g);
    }

    
}
