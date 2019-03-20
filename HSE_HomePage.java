/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hse_application;

import emiratesid.ae.exceptions.MiddlewareException;
import emiratesid.ae.publicdata.CardHolderPublicData;
import emiratesid.ae.publicdata.PublicDataFacade;
import emiratesid.ae.readersmgt.CardTypeEnum;
import emiratesid.ae.readersmgt.PCSCReader;
import emiratesid.ae.readersmgt.ReaderManagement;
import emiratesid.ae.sm.modules.SecureMessagingModulesFactory;
import emiratesid.ae.utils.Utils;
import hse_application.functions.DBConnect;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import org.openide.util.Exceptions;


/**
 *
 * @author OPTIPLEX
 */
public class HSE_HomePage extends javax.swing.JFrame {
    private PCSCReader reader;
    public ReaderManagement readerMgr = new ReaderManagement();
    Connection con;
    public String userName;
    public String userID;
    int xMouse;
    int yMouse;

    
    //Setter
    public void setUser(String user, String id){
        this.userName = user;
        this.userID = id;
        lbl_username.setText(userName);
        System.out.println(this.userName);
    }
    
    public String getUser(){
        return userName;
        
    }
    
    //Getter
    public String getID(){
        return userID;
    }
    
    
    
    
    /**
     * Creates new form HSE_HomePage
     */
    public HSE_HomePage() {
//        con = DBConnect.ConnDB();

        initComponents();
        initialize();
        
        
        this.setIconImage(new ImageIcon(getClass().getResource("/hse_application/Icons/icon.jpg")).getImage());
        
        
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                checkReader();
            }
        }, 0, 2, TimeUnit.SECONDS);
        
        
//        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/DefaultButtons/Print.png"))); // NOI18N
        
        
    }
    
    public PCSCReader getSelectedReader() {
        return reader;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        btn_addeid = new javax.swing.JButton();
        btn_signup = new javax.swing.JButton();
        readerStatus = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_username = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        bg = new javax.swing.JLabel();
        lbl_header = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HSEPro Application");
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(11, 68, 124)));

        jPanel1.setBackground(new java.awt.Color(234, 238, 243));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/DefaultButtons/Print.png"))); // NOI18N
        jButton2.setToolTipText("Print attendance form using the training code from the database");
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.setFocusable(false);
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/DefaultButtons/Print.png"))); // NOI18N
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/HoverButtons/Print Raised.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btn_addeid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/DefaultButtons/Update.png"))); // NOI18N
        btn_addeid.setToolTipText("Update the student's information based on the emirates ID");
        btn_addeid.setBorder(null);
        btn_addeid.setBorderPainted(false);
        btn_addeid.setContentAreaFilled(false);
        btn_addeid.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_addeid.setFocusPainted(false);
        btn_addeid.setFocusable(false);
        btn_addeid.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/DefaultButtons/Update.png"))); // NOI18N
        btn_addeid.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/HoverButtons/Update Raised.png"))); // NOI18N
        btn_addeid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addeidActionPerformed(evt);
            }
        });

        btn_signup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/DefaultButtons/Signup.png"))); // NOI18N
        btn_signup.setBorder(null);
        btn_signup.setBorderPainted(false);
        btn_signup.setContentAreaFilled(false);
        btn_signup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_signup.setFocusPainted(false);
        btn_signup.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/DefaultButtons/Signup.png"))); // NOI18N
        btn_signup.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/HoverButtons/Signup Raised.png"))); // NOI18N
        btn_signup.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btn_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signupActionPerformed(evt);
            }
        });

        readerStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/Reader is connected.png"))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(228, 232, 239));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(48, 48, 48));
        jLabel1.setForeground(new java.awt.Color(109, 109, 109));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("v1.9.03.10  ");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(48, 48, 48));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(109, 109, 109));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/account.png"))); // NOI18N

        lbl_username.setBackground(new java.awt.Color(48, 48, 48));
        lbl_username.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbl_username.setForeground(new java.awt.Color(109, 109, 109));
        lbl_username.setText("Name of user");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_username)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_username)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(btn_signup)
                    .addGap(6, 6, 6)
                    .addComponent(btn_addeid)
                    .addGap(6, 6, 6)
                    .addComponent(jButton2)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(readerStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_signup)
                    .addComponent(btn_addeid)
                    .addComponent(jButton2))
                .addGap(22, 22, 22)
                .addComponent(readerStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        header.setBackground(new java.awt.Color(11, 68, 124));
        header.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(11, 68, 124)));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 16)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/close (2).png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setFocusPainted(false);
        jButton4.setFocusable(false);
        jButton4.setMargin(new java.awt.Insets(2, 10, 2, 8));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        header.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, -1, 39));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/hse_images/Backgrounds/headerhome.png"))); // NOI18N
        bg.setPreferredSize(new java.awt.Dimension(493, 39));
        header.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 39));

        lbl_header.setText("jLabel3");
        lbl_header.setPreferredSize(new java.awt.Dimension(493, 39));
        lbl_header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbl_headerMouseDragged(evt);
            }
        });
        lbl_header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_headerMousePressed(evt);
            }
        });
        header.add(lbl_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addeidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addeidActionPerformed
        
//        if (readerMgr.getReaders()==null || readerMgr.getReaders().length == 0){
//            JOptionPane.showMessageDialog(this, "Cannot open\nReader not connected.");
//        }else{
            AddEmiratesID addStudent = new AddEmiratesID(HSE_HomePage.this, readerMgr, userID);
    //        addStudent.setFields(final_name, get_nationality, dobValue, photo, idNumber);
            addStudent.setModal(true);
            addStudent.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
            addStudent.setVisible(true);

    }//GEN-LAST:event_btn_addeidActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        attendanceClass s = new attendanceClass(HSE_HomePage.this);
        s.setReaderManager(readerMgr);
        s.setVisible(true);
        s.setModal(true);
        s.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered

    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited

    }//GEN-LAST:event_jButton4MouseExited

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int dialogresult = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Warning!", JOptionPane.YES_NO_OPTION);
        
        if (dialogresult==0){
            try {
                readerMgr.closeContext();

                this.dispose();
                
                LoginFrame e = new LoginFrame();
                e.setVisible(true);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btn_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signupActionPerformed
        if (readerMgr.getReaders()==null || readerMgr.getReaders().length == 0){
            JOptionPane.showMessageDialog(this, "Cannot open\nReader not connected.");
        }else{
//            SignUp_Frame signup = new SignUp_Frame(HSE_HomePage.this, readerMgr, userID);
            //changed to frame - 3/15/19

            SignUp_Frame signup = new SignUp_Frame(readerMgr, userID);
//            signup.setModal(true);
//            signup.userID = userID;
//            System.out.println(signup.userID);
            signup.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            signup.setVisible(true);
        }

    }//GEN-LAST:event_btn_signupActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void lbl_headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_lbl_headerMousePressed

    private void lbl_headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_lbl_headerMouseDragged

    
    private void initialize(){
        try{
            System.out.println("Establishing connection");
            readerMgr.establishContext();
                   
            System.out.println("Discovering Readers");
            readerMgr.discoverReaders();

            // check if there is a connected card reader
            
        } catch (MiddlewareException ex){
            ex.printStackTrace();
        }
    }
    
    private void checkReader(){
        try {
            if(readerMgr.getReaders()==null || readerMgr.getReaders().length == 0){

                    //                JOptionPane.showMessageDialog(null,"There is no PCSC readers found.", "NO PCSC Readers", JOptionPane.ERROR_MESSAGE);
//                    readerStatus.setText("Reader is not connected");
//                    readerStatus.setIcon(new ImageIcon("Reader is disconnected.png"));
                    readerStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/Reader is disconnected.png"))); // NOI18N

                    readerStatus.setForeground(Color.red);
//                    System.out.println("Hello");
                    readerMgr.discoverReaders();
                    //return;
            }else{
                // Get the first reader regardless of how many
                String theReader = readerMgr.getReaders()[0].getReaderName();

                reader = readerMgr.selectReaderByName(theReader);
//                readerStatus.setText("Reader is connected");
                readerStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hse_application/Icons/Reader is connected.png"))); // NOI18N
                readerStatus.setForeground(Color.blue);
                
//                System.out.println("World");
                readerMgr.discoverReaders();
                
                
                boolean validCard = false;  //variable to check if UAE or UAE test card

            }
        } catch (MiddlewareException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
    
    protected boolean retryConnection(PCSCReader reader) {
        try {
            reader.connect(readerMgr.getContext());
            reader.getReaderName();
            
            return reader.isConnected();

        } catch (MiddlewareException e1) {
            e1.printStackTrace();
        }
        return false;
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    System.out.println("done");
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HSE_HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HSE_HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HSE_HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HSE_HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HSE_HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton btn_addeid;
    private javax.swing.JButton btn_signup;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbl_header;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JLabel readerStatus;
    // End of variables declaration//GEN-END:variables
}
