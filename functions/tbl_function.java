/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hse_application.functions;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;

/**
 *
 * @author OPTIPLEX
 */
public class tbl_function {
    public static void tbl_function(JTable myTable) {

        myTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 11));
        myTable.getTableHeader().setForeground(new Color(70,70,70));
        myTable.getTableHeader().setReorderingAllowed(false);
        myTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        myTable.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        myTable.setFillsViewportHeight(true);  
        myTable.setGridColor(new Color(170,170,170));
        myTable.setRowHeight(27);
        myTable.setForeground(new Color(47,47,47));
        myTable.setBackground(Color.white);
        
        
    }
}
