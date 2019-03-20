/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hse_application;

import emiratesid.ae.exceptions.ErrorCodes;
import emiratesid.ae.exceptions.MiddlewareException;
import emiratesid.ae.publicdata.CardHolderPublicData;
import emiratesid.ae.publicdata.PublicDataFacade;
import emiratesid.ae.readersmgt.CardTypeEnum;
import emiratesid.ae.readersmgt.PCSCReader;
import emiratesid.ae.readersmgt.ReaderManagement;
import hse_application.functions.DBConnect;
import hse_application.functions.TitleCaseConversion;
import static hse_application.functions.TitleCaseConversion.TitleCaseConversion;
import static hse_application.functions.tbl_function.tbl_function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import org.jfree.chart.title.Title;
import emiratesid.ae.utils.Utils;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import org.openide.util.Exceptions;

/**
 *
 * @author OPTIPLEX
 */
//public class AddEmiratesID extends javax.swing.JFrame {
public class AddEmiratesID extends JDialog {
    int xMouse;
    int yMouse;
    PreparedStatement pstmt = null;
    Connection con = null;
    ResultSet rs = null;
    private String emiratesID;
    private String names;
    private String[] split;
    String IDofUser = "";
    
    
    int percent = 0;
    private static final int PROGRESS_MAX = 100; 
    private Timer timer = null;
    Thread th = null;
    
    
    
    private byte [] thePhoto;
    SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
    Date myDate;
    public Path path;
    byte[] photo;
    
    private PCSCReader reader = null;
    public ReaderManagement readerMgr;
    
    
      
    private void initialize(){
        try{

            // check if there is a connected card reader
            if(readerMgr.getReaders()==null || readerMgr.getReaders().length == 0){
                JOptionPane.showMessageDialog(null,"There is no PCSC readers found.", "NO PCSC Readers", JOptionPane.ERROR_MESSAGE);
                
              
                this.dispose();
                //return;
            }else{
                // Get the first reader regardless of how many
                String theReader = readerMgr.getReaders()[0].getReaderName();
                
                reader = readerMgr.selectReaderByName(theReader);
                boolean validCard = false;  //variable to check if UAE or UAE test card
               
                initComponents();
            }

            
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
   
    
    
//    public void setFields(String nameValue, String nationality, String dobValue, byte [] photo, String emid){
//        txt_name.setText(nameValue);
//        search_field.setText(nameValue);
//        names = nameValue.replace(" ","");
//        
//        split = nameValue.split("\\s+");
//        
//        txt_nationality.setText(nationality);
//        txt_bday.setText(dobValue);
//        emiratesID = emid;
//        Image image;
//        try {
//            if(photo != null)
//            {
////                    image = ImageIO.read(new ByteArrayInputStream(photo));
//            image = getToolkit().createImage(photo);
//            
//            System.out.println("hello");
//
//            ImageIcon icon = new ImageIcon(image);
//            photograph.setIcon(null);
//            photograph.setIcon(icon);
////                    ((PhotoPanel)photoPane).setImage(image);
////                    photoPane.updateUI();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
    /**
     * Creates new form AddStudent
     * @param owner
     */
    public AddEmiratesID(Frame owner, ReaderManagement readerMgr, String userID) {
        super(owner);
        con = DBConnect.ConnDB();
        
        this.readerMgr = readerMgr;
        initialize();
        myDate = new Date();
        System.out.println(myDate);
        
        IDofUser = userID;
        System.out.println(IDofUser);
        
        tbl_function(tbl_studentlist);
        
//        try{
//            System.out.println("Establishing connection");
//            readerMgr.establishContext();
//                   
//            System.out.println("Discovering Readers");
//            readerMgr.discoverReaders();
//
//            // check if there is a connected card reader
//            if(readerMgr.getReaders()==null || readerMgr.getReaders().length == 0){
//                JOptionPane.showMessageDialog(null,"There is no PCSC readers found.", "NO PCSC Readers", JOptionPane.ERROR_MESSAGE);
//                
//                this.dispose();
//                
//                HSE_HomePage e = new HSE_HomePage();
//                e.setVisible(true);
//                
//                //return;
//            }else{
//                // Get the first reader regardless of how many
//                String theReader = readerMgr.getReaders()[0].getReaderName();
//
//                reader = readerMgr.selectReaderByName(theReader);
//                boolean validCard = false;  //variable to check if UAE or UAE test card
//                initComponents();
//        
//                tbl_function(tbl_studentlist);
//
//                sdf = new SimpleDateFormat("yyyy-MM-dd");
//                myDate = new Date();
//                
//
//            }
//
//            
//        } catch (MiddlewareException ex){
//            ex.printStackTrace();
//        }
        
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_bday = new javax.swing.JLabel();
        txt_nationality = new javax.swing.JLabel();
        txt_name = new javax.swing.JLabel();
        btn_showeid = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        emirates_id = new javax.swing.JLabel();
        chk_eid = new javax.swing.JCheckBox();
        chk_name = new javax.swing.JCheckBox();
        chk_nation = new javax.swing.JCheckBox();
        chk_bday = new javax.swing.JCheckBox();
        photograph = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        progressbar1 = new javax.swing.JProgressBar();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_studentlist = new javax.swing.JTable();
        search_field = new javax.swing.JTextField();
        label1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btn_update = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 132, 197)));

        jPanel3.setBackground(new java.awt.Color(234, 238, 243));

        jPanel2.setBackground(new java.awt.Color(234, 238, 243));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(32, 33, 36));
        jLabel4.setText("Date of Birth: ");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(32, 33, 36));
        jLabel1.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(32, 33, 36));
        jLabel3.setText("Nationality: ");

        txt_bday.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_nationality.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btn_showeid.setBackground(new java.awt.Color(255, 255, 255));
        btn_showeid.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        btn_showeid.setForeground(new java.awt.Color(220, 220, 220));
        btn_showeid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/DefaultButtons/ShowEIDDefault.png"))); // NOI18N
        btn_showeid.setBorder(null);
        btn_showeid.setBorderPainted(false);
        btn_showeid.setContentAreaFilled(false);
        btn_showeid.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_showeid.setFocusPainted(false);
        btn_showeid.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/ClickedButtons/showeid.png"))); // NOI18N
        btn_showeid.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/HoverButtons/Hover Button-1.png"))); // NOI18N
        btn_showeid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_showeidActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(32, 33, 36));
        jLabel2.setText("Emirates ID:");

        emirates_id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        chk_eid.setBackground(new java.awt.Color(234, 238, 243));
        chk_eid.setSelected(true);
        chk_eid.setEnabled(false);

        chk_name.setBackground(new java.awt.Color(234, 238, 243));

        chk_nation.setBackground(new java.awt.Color(234, 238, 243));
        chk_nation.setSelected(true);
        chk_nation.setEnabled(false);

        chk_bday.setBackground(new java.awt.Color(234, 238, 243));
        chk_bday.setSelected(true);
        chk_bday.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_showeid)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_nationality, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emirates_id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(txt_bday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chk_eid)
                            .addComponent(chk_name)
                            .addComponent(chk_nation)
                            .addComponent(chk_bday))))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(emirates_id, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chk_eid))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(chk_name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chk_nation)))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txt_bday, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chk_bday))
                .addGap(12, 12, 12)
                .addComponent(btn_showeid)
                .addGap(10, 10, 10))
        );

        photograph.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photograph.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(11, 68, 124)));
        photograph.setPreferredSize(new java.awt.Dimension(130, 154));

        label.setFont(new java.awt.Font("Segoe UI Semibold", 0, 19)); // NOI18N
        label.setForeground(new java.awt.Color(32, 33, 36));
        label.setText("Emirates ID Information");

        progressbar1.setStringPainted(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(photograph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(progressbar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(0, 0, 0)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(label)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(photograph, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(progressbar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel4.setBackground(new java.awt.Color(234, 238, 243));

        tbl_studentlist.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        tbl_studentlist.setForeground(new java.awt.Color(47, 47, 47));
        tbl_studentlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student No.", "Name", "Contact No.", "Branch"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_studentlist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbl_studentlist.setFocusable(false);
        tbl_studentlist.setRowHeight(27);
        tbl_studentlist.getTableHeader().setReorderingAllowed(false);
        tbl_studentlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentlistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_studentlist);
        if (tbl_studentlist.getColumnModel().getColumnCount() > 0) {
            tbl_studentlist.getColumnModel().getColumn(0).setResizable(false);
            tbl_studentlist.getColumnModel().getColumn(0).setPreferredWidth(4);
        }

        search_field.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        search_field.setForeground(new java.awt.Color(153, 153, 153));
        search_field.setText("Enter name here...");
        search_field.setMargin(new java.awt.Insets(2, 7, 2, 2));
        search_field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                search_fieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                search_fieldFocusLost(evt);
            }
        });
        search_field.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search_fieldMouseClicked(evt);
            }
        });
        search_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_fieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_fieldKeyTyped(evt);
            }
        });

        label1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 19)); // NOI18N
        label1.setForeground(new java.awt.Color(32, 33, 36));
        label1.setText("Search");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(search_field, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(search_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(234, 238, 243));

        btn_update.setBackground(new java.awt.Color(255, 255, 255));
        btn_update.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 0));
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/DefaultButtons/UpdateStudentDefault.png"))); // NOI18N
        btn_update.setBorder(null);
        btn_update.setBorderPainted(false);
        btn_update.setContentAreaFilled(false);
        btn_update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_update.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/DefaultButtons/disabled_update.png"))); // NOI18N
        btn_update.setEnabled(false);
        btn_update.setFocusPainted(false);
        btn_update.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_update.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/ClickedButtons/update.png"))); // NOI18N
        btn_update.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/HoverButtons/Hover Button-2.png"))); // NOI18N
        btn_update.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btn_update.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_cancel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/DefaultButtons/Cancel Default.png"))); // NOI18N
        btn_cancel.setBorder(null);
        btn_cancel.setBorderPainted(false);
        btn_cancel.setContentAreaFilled(false);
        btn_cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel.setFocusPainted(false);
        btn_cancel.setOpaque(true);
        btn_cancel.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/ClickedButtons/cancelclicked.png"))); // NOI18N
        btn_cancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/HoverButtons/cancelhover.png"))); // NOI18N
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cancel)
                .addGap(12, 12, 12)
                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_update)
                    .addComponent(btn_cancel))
                .addGap(20, 20, 20))
        );

        header.setBackground(new java.awt.Color(11, 68, 124));
        header.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(11, 68, 124)));
        header.setPreferredSize(new java.awt.Dimension(574, 39));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/hse_images/Backgrounds/updatestudent.png"))); // NOI18N
        jLabel6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel6MouseDragged(evt);
            }
        });
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });
        header.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 574, 39));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        

        if (emirates_id.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please read card data first", "No Data", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        DefaultTableModel mod = (DefaultTableModel)tbl_studentlist.getModel();
        
        int selectedRow = tbl_studentlist.getSelectedRow();
        
        
        if (selectedRow<0){
            JOptionPane.showMessageDialog(this, "Please select the student you want to update", "No Data", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int check = JOptionPane.showConfirmDialog(this, "Are you sure you want to update the details of this student?", 
                "Confirm", JOptionPane.YES_NO_OPTION);
        
        if (check==0){
            String studentID = tbl_studentlist.getValueAt(selectedRow, 0).toString();
            
            String currentDate = sdf.format(myDate);
            System.out.println(currentDate);
            
            try{ 
                con.setAutoCommit(false);
                
                
                String eid = emirates_id.getText();
 
                String checkIfAlreadyLinked = "SELECT reg_student_name name, reg_student_number studNumber FROM tbl_reg_student"
                        + " WHERE reg_student_emirates_id = '"+eid+"'";
                pstmt = con.prepareStatement(checkIfAlreadyLinked);
                rs = pstmt.executeQuery();
                if (rs.next()){
                    // If there is already a linked emirates id, ask user to confirm
                    
                    String studentNumber = rs.getString("studNumber");
                    
                    
                    int confirmation = JOptionPane.showConfirmDialog(this, "This Emirates ID is already linked to "+rs.getString("name")+"\n"
                            + " Do you still want to update?", "Confirm", JOptionPane.YES_NO_OPTION);
                    
                    if (confirmation == 1){
                        return;
                    }else{
                        String removeOldEmiratesID = "UPDATE tbl_reg_student SET"
                                + " reg_student_emirates_ID = null,"
                                + " lastDateModified = '"+currentDate+"'"
                                + " WHERE reg_student_number = '"+studentNumber+"'";
                        pstmt = con.prepareStatement(removeOldEmiratesID);
                        pstmt.executeUpdate();
                        
                        String removeOldEmiratesID_student = "UPDATE tbl_student SET"
                                + " student_emirates_ID = null,"
                                + " lastDateModified = '"+currentDate+"'"
                                + " WHERE student_number = '"+studentNumber+"'";
                        pstmt = con.prepareStatement(removeOldEmiratesID_student);
                        pstmt.executeUpdate();
                        
                        System.out.println("removed the eid from "+rs.getString("name"));

                        
                    }
                }
                
                
                
                if (chk_name.isSelected()){
                    String query1 = "UPDATE tbl_reg_student SET"
                            + " reg_student_emirates_ID = '"+eid+"',"
                            + " reg_student_nationality = '"+txt_nationality.getText()+"',"
                            + " reg_student_birthday = '"+txt_bday.getText()+"',"
                            + " lastDateModified = '"+currentDate+"',"
                            + " reg_student_photo = ?,"
                            + " reg_student_name = '"+txt_name.getText()+"'"
                            + " WHERE reg_student_number= '"+studentID+"'";
                    pstmt = con.prepareStatement(query1);
                    pstmt.setBytes(1, photo); // byte [] photo
                    pstmt.executeUpdate(); // execute the update
                    System.out.println("Updated the tbl_reg_student"+studentID);
                    
                    String query2 = "UPDATE tbl_student SET"
                            + " student_emirates_ID = '"+eid+"',"
                            + " student_nationality = '"+txt_nationality.getText()+"',"
                            + " student_birthday = '"+txt_bday.getText()+"',"
                            + " lastDateModified = '"+currentDate+"',"
                            + " student_photo = ?,"
                            + " student_fullname = '"+txt_name.getText()+"'"
                            + " WHERE student_number= '"+studentID+"'";
                    pstmt = con.prepareStatement(query2);
                    pstmt.setBytes(1, photo); // byte [] photo
                    pstmt.executeUpdate(); // execute the update
                    
                    System.out.println("Updated the tbl_student");
                    con.commit();
                    
                    
                    
                    
                }else{
                    
                    String query1 = "UPDATE tbl_reg_student SET"
                            + " reg_student_emirates_ID = '"+eid+"',"
                            + " reg_student_nationality = '"+txt_nationality.getText()+"',"
                            + " reg_student_birthday = '"+txt_bday.getText()+"',"
                            + " lastDateModified = '"+currentDate+"',"
                            + " reg_student_photo = ?"
                            + " WHERE reg_student_number= '"+studentID+"'";
                    pstmt = con.prepareStatement(query1);
                    pstmt.setBytes(1, photo);
                    pstmt.executeUpdate();
                    
                    System.out.println("Updated the tbl_reg_student"+studentID);
                    
                    String query2 = "UPDATE tbl_student SET"
                            + " student_emirates_ID = '"+eid+"',"
                            + " student_nationality = '"+txt_nationality.getText()+"',"
                            + " student_birthday = '"+txt_bday.getText()+"',"
                            + " lastDateModified = '"+currentDate+"',"
                            + " student_photo = ?"
                            + " WHERE student_number= '"+studentID+"'";
                    pstmt = con.prepareStatement(query2);
                    pstmt.setBytes(1, photo); // byte [] photo
                    pstmt.executeUpdate(); // execute the update
                    
                    System.out.println("Updated the tbl_student");
                    con.commit();
   
                }

                JOptionPane.showMessageDialog(this, "Successfully linked the emirates ID");
      
            }catch (Exception e){
                e.printStackTrace();
                try {
                    if (con != null){
                        System.err.println("Transaction is being rolled back");
                        con.rollback();
                    }
                    
                } catch (SQLException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }finally{
                try {
                    if (pstmt != null){
                        pstmt.close();
                    }
                    
                    con.setAutoCommit(true);
                } catch (SQLException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        }
    
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        
        try {
            con.close();
            System.out.println("DB Connection Closed");
            this.dispose();   
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);

        }
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
//        updateTable(tbl_studentlist);
    }//GEN-LAST:event_formComponentShown

    private void search_fieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_fieldKeyReleased
        updateTable(tbl_studentlist);
//        try{
//            DefaultTableModel table = (DefaultTableModel)tbl_studentlist.getModel();
//            table.setRowCount(0);
//            
//            String query = "SELECT student_number num, student_fullname name, student_contact contact"
//                    + " FROM tbl_student WHERE student_fullname like '%"+search_field.getText()+"%'";
//            pstmt = con.prepareStatement(query);
//            rs = pstmt.executeQuery();
//            
//            while(rs.next()){
//                String number = rs.getString("num");
//                String name = TitleCaseConversion(rs.getString("name"));
//                String contact = rs.getString("contact");
//                
//                Object [] data = {number, name, contact};
//                table.addRow(data);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_search_fieldKeyReleased

    private void btn_showeidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_showeidActionPerformed
        System.out.println("Reader connected?" + reader.isConnected());  //Return true if a card is connected
        System.out.println("Is it UAE Card?" + isUAECard(reader)); //return true if the card inserted is a UAE or UAE test Card
        try{
            reader.disconnect();
            reader.connect(readerMgr.getContext());
//            reader.extractATR();
            
            if(!reader.isConnected() || !isUAECard(reader)){

                while(JOptionPane.showConfirmDialog(this,
                    "Please insert UAE card\nChoose Yes to retry, No to go back",
                    "Card reader is empty, or not UAE card.", JOptionPane.YES_NO_OPTION) == 0) {

                    if(retryConnection(reader) && isUAECard(reader)) {
                        try{
                            th = new Thread(new PublicDataThread());
                            th.start();						
                        } catch(Exception iex){
                            JOptionPane.showMessageDialog(this, iex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            iex.printStackTrace();
                        }
                        break;
                    }
                }            
            }else{
                
                try{
                    th = new Thread(new PublicDataThread());
                    th.start();						
                } catch(Exception iex){
                    JOptionPane.showMessageDialog(this, iex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    iex.printStackTrace();
                }
                
                
                System.out.println("Card is Connected");
            }
            
            
        }catch (Exception e){
            e.printStackTrace();
            
        }
    }//GEN-LAST:event_btn_showeidActionPerformed

    private void tbl_studentlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentlistMouseClicked
        if (evt.getClickCount()==2){
            try {
                int i = tbl_studentlist.getSelectedRow();
                String studentNumber = tbl_studentlist.getValueAt(i, 0).toString();
                
                String query = "SELECT reg_student_name name, reg_student_photo photo"
                        + ", reg_student_mobile mobile, reg_student_number number, "
                        + " reg_student_email email, reg_student_birthday birthday, reg_student_nationality nationality,"
                        + " reg_student_emirates_ID eid, registeredDate, branch_name"
                        + " FROM tbl_reg_student"
                        + " INNER JOIN tbl_branch"
                        + " ON tbl_reg_student.fk_branch_id = tbl_branch.branch_id"
                        + " WHERE reg_student_number = '"+studentNumber+"'";
                
                pstmt = con.prepareStatement(query);
                rs = pstmt.executeQuery();
                
                while(rs.next()){
                    byte [] hello = rs.getBytes("photo");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String nation = rs.getString("nationality");
                    String dob = rs.getString("birthday");
                    String eid = rs.getString("eid");
                    String lmd = rs.getString("registeredDate");
                    String stud_no = rs.getString("number");
                    String contact = rs.getString("mobile");
                    String branch = rs.getString("branch_name");
                    
                    System.out.println(dob+nation);
                    
                    StudentInfoFrame info = new StudentInfoFrame(AddEmiratesID.this);
                    info.setDetails(stud_no, name, email, nation, dob, eid, lmd, hello, contact, branch);
                    info.setVisible(true);
                    
                }
            } catch (SQLException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }//GEN-LAST:event_tbl_studentlistMouseClicked

    private void search_fieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search_fieldFocusGained
        if (search_field.getText().trim().equals("Enter name here...") || !search_field.getText().isEmpty()){
            search_field.setText("");
            search_field.setForeground(Color.black);
            search_field.setFont(new Font("Segoe UI", 0, 14));    
        }
        
    }//GEN-LAST:event_search_fieldFocusGained

    private void search_fieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search_fieldFocusLost
        if (search_field.getText().trim().isEmpty()){
            search_field.setText("Enter name here...");
            search_field.setForeground(new Color(153, 153, 153));
            search_field.setFont(new Font("Segoe UI", 2, 14));

        }
    }//GEN-LAST:event_search_fieldFocusLost

    private void search_fieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_fieldMouseClicked
        
    }//GEN-LAST:event_search_fieldMouseClicked

    private void search_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_fieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_search_fieldKeyTyped

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jLabel6MousePressed

    private void jLabel6MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jLabel6MouseDragged
    
    
    
    
    private void updateTable(JTable table){
        DefaultTableModel mod = (DefaultTableModel) table.getModel();
        mod.setRowCount(0);
        
        
        try{
//            String query = "SELECT student_number, student_fullname, student_contact"
//                    + " FROM tbl_student WHERE student_fullname LIKE"
//                    + " '%"+search_field.getText()+"%'"
//                    + " OR student_fullname LIKE '%"+names+"%'";
            
            String query = "SELECT a.reg_student_number number, a.reg_student_name name, a.reg_student_mobile mobile, b.branch_name branch"
                    + " FROM tbl_reg_student a"
                    + " INNER JOIN tbl_branch b"
                    + " ON a.fk_branch_id = b.branch_id"
                    + " WHERE fk_branch_id = (SELECT fk_branch_id FROM tbl_user WHERE user_id = '"+IDofUser+"')"
                    + " AND a.reg_student_name LIKE"
                    + " '%"+search_field.getText()+"%' OR"
                    + " a.reg_student_name LIKE '%"+names+"%'";
            
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                String studentNo = rs.getString("number");
                    String studentFullName = rs.getString("name");
                    String contactNo = rs.getString("mobile");
                    String branchname = rs.getString("branch");
                    
                    String [] data = {studentNo, studentFullName, contactNo, branchname};
                    mod.addRow(data);
            }
//            if (!rs.next()){
//                JOptionPane.showMessageDialog(this, "No Student with the same name");
//                
//            }else{
//                do{
//                    String studentNo = rs.getString("student_number");
//                    String studentFullName = rs.getString("student_fullname");
//                    String contactNo = rs.getString("student_contact");
//                    
//                    String [] data = {studentNo, studentFullName, contactNo};
//                    mod.addRow(data);
//                }while (rs.next());
//            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
     protected boolean retryConnection(PCSCReader reader) {
        try {
//            reader.disconnect();
//            reader.connect(readerMgr.getContext());
//            reader.getReaderName();

            reader.disconnect();
            reader.connect(readerMgr.getContext());
//            reader.extractATR();

            return reader.isConnected();

        } catch (MiddlewareException e1) {
            e1.printStackTrace();
        }
            return false;
	}
    
    
    
    // This is the method to check if the card inserted is a UAE Card...
    protected boolean isUAECard(PCSCReader reader) {
		if(reader.getType() == CardTypeEnum.UAE_ID_CARD)
			return true;
		else if(reader.getType() == CardTypeEnum.UAE_ID_TEST_CARD)
			return true;
		else
			return false;
	}
            

     //load the public data
    protected void loadPublicData() {

        try{
//            PublicDataFacade pdf = reader.getPublicDataFacade();
            PublicDataFacade publicDataFacade = reader.getPublicDataFacade();
            
            timer = new Timer(100, new ProgressTimer(progressbar1));
            timer.start();
            
            
            CardHolderPublicData publicdata = publicDataFacade.readPublicData(true, true, true
            , true, false);
            displayPublicData(publicdata);
            btn_update.setEnabled(true);
            
            
            
            
        } catch (MiddlewareException mex) {
            if(mex.getCode() == ErrorCodes.E_ID_READ_PHOTOGRAPHY)
            	JOptionPane.showMessageDialog(this, "Error reading photography.\n" +
            			"Photography may be protected\nPlease try again.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            else
            	JOptionPane.showMessageDialog(this, "Error occured when reading public data : " + mex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            mex.printStackTrace();
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(this, "Error occured when reading public data",
                    "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
        finally
        {
            setProgressPercent(PROGRESS_MAX);
        }
        
    }
    
    
    private void displayPublicData(CardHolderPublicData publicdata){

        if (publicdata == null)
            return;

        
        String sex = PublicDataUtils.getSex(Utils.CharArrayToUTF8String(publicdata.getSex()));
        String fullName = PublicDataUtils.removeCommas(Utils.CharArrayToUTF8String(publicdata.getFullName()));
        String idNumber = PublicDataUtils.removeCommas(Utils.CharArrayToUTF8String(publicdata.getIDNumber()));
        String get_nationality = Utils.CharArrayToUTF8String(publicdata.getNationality());
        String expirydate = Utils.CharArrayToStringDate(publicdata.getExpiryDate());
        String maritalStatus = PublicDataUtils.getMaritalStatus(Utils.CharArrayToHex(publicdata.getMaritalStatus()));
        String dobValue = Utils.CharArrayToStringDate(publicdata.getDateOfBirth());
//        expiryDateValue.setText(Utils.CharArrayToStringDate(publicdata.getExpiryDate()));

        photo = Utils.ToByteArray(publicdata.getPhotography());
        System.out.println(fullName);
        

        String final_name = fullName.trim().replaceAll(" +", " ");
        
        txt_name.setText(final_name);
        txt_nationality.setText(get_nationality);
        txt_bday.setText(dobValue);
//        search_field.setText(final_name);
        emirates_id.setText(idNumber);
        
        ImageIcon icon = new ImageIcon(photo);
        
        photograph.setIcon(icon);
        
       
        thePhoto = Utils.ToByteArray(publicdata.getPhotography());
   
        
        try{
            DefaultTableModel mod = (DefaultTableModel)tbl_studentlist.getModel();
            mod.setRowCount(0);
            String query = "SELECT reg_student_name name, reg_student_number number, reg_student_mobile mobile, branch_name branch"
                    + " FROM tbl_reg_student"
                    + " INNER JOIN tbl_branch"
                    + " ON tbl_reg_student.fk_branch_id = tbl_branch.branch_id"
                    + " WHERE reg_student_emirates_ID = '"+idNumber+"' AND reg_student_status = 'OS'";
        
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            
            if (rs.next()){
                
                
                String name = rs.getString("name");
                String number = rs.getString("number");
                String contact = rs.getString("mobile");
                String branch = rs.getString("branch");
                
                Object [] data = {number, name, contact, branch};
                
                mod.addRow(data);
                setProgressPercent(PROGRESS_MAX);
                JOptionPane.showMessageDialog(this, "One student has matched", "Found a match", JOptionPane.INFORMATION_MESSAGE);
                

                
            }else{
                setProgressPercent(PROGRESS_MAX);
                JOptionPane.showMessageDialog(this, "No student found with the same Emirates ID", "Not a match", JOptionPane.ERROR_MESSAGE);
                

            }
            
//            if (!rs.next()){
//                int x = JOptionPane.showConfirmDialog(this, "Emirates ID not registered\n Do you want to link this ID to a registered student?",
//                        "Error", JOptionPane.YES_NO_OPTION);
//                
//                if (x==0){
//                    
//                    
//                }
//            }else{
//                do{
//                    String name = rs.getString();
//                }while(rs.next());
//            }  
        }catch (SQLException e){
            e.printStackTrace();

        }
    }
    
    class ProgressTimer implements ActionListener {
		JProgressBar bar;
		public ProgressTimer(JProgressBar bar) {
                        percent = 0;
			this.bar = bar;
		}
		public void actionPerformed(ActionEvent e) {
			if(percent != PROGRESS_MAX - 1)
				setProgressPercent(percent + 1);
			bar.setValue(percent);
			
			if(percent >= PROGRESS_MAX) 
        		timer.stop();
		}
	}
    
    
    protected synchronized void setProgressPercent(int percent) {
		this.percent = percent;
	}
    
    
    class PublicDataThread implements Runnable {
		public PublicDataThread() {
			setProgressPercent(0);
		}
		
		public void run() {
			loadPublicData();
		}
	}
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddEmiratesID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEmiratesID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEmiratesID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEmiratesID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new AddEmiratesID().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_showeid;
    private javax.swing.JButton btn_update;
    private javax.swing.JCheckBox chk_bday;
    private javax.swing.JCheckBox chk_eid;
    private javax.swing.JCheckBox chk_name;
    private javax.swing.JCheckBox chk_nation;
    private javax.swing.JLabel emirates_id;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel photograph;
    private javax.swing.JProgressBar progressbar1;
    private javax.swing.JTextField search_field;
    private javax.swing.JTable tbl_studentlist;
    private javax.swing.JLabel txt_bday;
    private javax.swing.JLabel txt_name;
    private javax.swing.JLabel txt_nationality;
    // End of variables declaration//GEN-END:variables
}
