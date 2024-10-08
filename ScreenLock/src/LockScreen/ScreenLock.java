/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package LockScreen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Pixel FXS...
 */
public class ScreenLock extends javax.swing.JFrame {
private JPanel loginPanel;
JTextField userName = new JTextField(20);
JPasswordField passUser = new JPasswordField(20);
Font font = new Font("Cascadia Mono", Font.PLAIN, 16);
    /**
     * Creates new form ScreenLock
     */
    
    
    public ScreenLock() {
        initComponents();
        Dimension getSize=Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(getSize.width, getSize.height);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setAlwaysOnTop(true);
        getContentPane().setBackground(Color.WHITE);
        new Task(this).SetBlock();
        
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/image/Logotype.png"));
        JLabel imageLabel = new JLabel(originalIcon);
        JLabel userLabel = new JLabel("User:");
        JLabel passLabel = new JLabel("Password:");
        JButton loginButton = new JButton("Login");
        
        loginButton.setBackground(Color.decode("#2ecc71"));
        loginButton.setForeground(Color.BLACK);
        loginButton.setBorderPainted(false);
        loginButton.setFont(font);
        userLabel.setFont(font);
        passLabel.setFont(font);
        userName.setFont(font);
        passUser.setFont(font);
        
        add(imageLabel);
        add(userLabel);
        add(passLabel);     
        add(userName);
        add(passUser);
        add(loginButton);
        
        int customWidth = 250;
        int customHeight = 35; 
        int labelWidth = 100; 
        Dimension frameSize = getSize();
        int textFieldX = (frameSize.width - customWidth) / 2;
        int textFieldY = (frameSize.height - customHeight) / 2 - 60;
        int labelX = textFieldX - labelWidth - 10;

        int imageX = (frameSize.width - 400) / 2;
        int imageY = (frameSize.height - 300) / 2 - 150;

        imageLabel.setBounds(imageX, imageY, 400, 200);
        
        userLabel.setBounds(labelX, textFieldY, labelWidth, customHeight);
        userName.setBounds(textFieldX, textFieldY, customWidth, customHeight);
        textFieldY += 50;
        passLabel.setBounds(labelX, textFieldY, labelWidth, customHeight);
        passUser.setBounds(textFieldX, textFieldY, customWidth, customHeight);
        textFieldY += 50;
        loginButton.setBounds(textFieldX, textFieldY, customWidth, customHeight);
        
        
        
         loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userName.getText();
                String password = new String(passUser.getPassword());
                loadCredentials(user, password);
            }
        });
       
    }
    //configure your validation for credential in BD or API
    private void loadCredentials(String user, String password){
        if (user.matches("root") && password.matches("1020")){
            JOptionPane.showMessageDialog(this, "Logged");
            dispose();
        }else{
            setVisible(true);
            JOptionPane.showMessageDialog(this,"Credentials Incorrect");       
            userName.setText(""); 
            passUser.setText("");
            userName.requestFocus();        
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE); //mantiene la interface abierta 
            addWindowListener(new java.awt.event.WindowAdapter(){
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt){ }
            });
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
        
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
            java.util.logging.Logger.getLogger(ScreenLock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScreenLock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScreenLock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScreenLock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
           new ScreenLock().setVisible(true);
        });
        
//        Manager startScan = new Manager();
//        startScan.startMonitoring();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
