/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dev.kit2512.oop_sms.presentation.views;

import dev.kit2512.oop_sms.App;
import dev.kit2512.oop_sms.domain.models.UserModel;
import dev.kit2512.oop_sms.presentation.controllers.DashboardController;
import dev.kit2512.oop_sms.presentation.controllers.LoginController;
import dev.kit2512.oop_sms.presentation.models.LoginModel;
import dev.kit2512.oop_sms.presentation.views.DashboardView.DashboardView;
import dev.kit2512.oop_sms.presentation.views.InfoView.InforView;

import java.beans.PropertyChangeEvent;
import javax.inject.Inject;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author macpro13
 */
public class LoginView extends javax.swing.JFrame implements AbstractView {

    /**
     * Creates new form LoginView
     *
     * @param controller
     */

    private LoginController controller;

    @Inject
    public LoginView(LoginController controller) {
        this.controller = controller;
        this.controller.addView(this);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        usernameTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();
        errorMessageLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        loginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginLabel.setText("Log in");
        loginLabel.setName("loginLabel"); // NOI18N

        usernameLabel.setText("Username");

        usernameTxt.getDocument().addDocumentListener(new UsernameTextListener());

        jLabel1.setText("Password");

        passwordTxt.getDocument().addDocumentListener(new PasswordTextListener());

        loginBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        loginBtn.setText("GO >>");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        errorMessageLabel.setForeground(new java.awt.Color(255, 51, 0));
        errorMessageLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Copyright (c) KitTeam KMA. All rights reserved");
        jLabel2.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(errorMessageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(usernameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                    .addComponent(passwordTxt)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(loginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(loginBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        controller.elementLoginButtonPressed();
    }//GEN-LAST:event_loginBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    @Override
    public void modelPropertyChange(PropertyChangeEvent event) {
        switch (event.getPropertyName()) {
            case LoginModel.ERROR_MESSAGE_PROPERTY -> {
                if (event.getNewValue() == null) {
                    errorMessageLabel.setText(null);
                } else {
                    final String errorMessage = (String) event.getNewValue();
                    errorMessageLabel.setText(errorMessage);
                }
            }
            case LoginModel.IS_LOADING_PROPERTY -> {
                final boolean isLoading = (boolean) event.getNewValue();
                usernameTxt.setEditable(!isLoading);
                passwordTxt.setEditable(!isLoading);
                loginBtn.setEnabled(!isLoading);
            }

            case LoginModel.SUCCESS_PROPERTY -> {
                if ((boolean) event.getNewValue()) {
                    this.usernameTxt.setText(null);
                    this.passwordTxt.setText(null);
                    this.errorMessageLabel.setText(null);
                }
            }

            case LoginModel.USER_PROPERTY ->  {
                final UserModel user = (UserModel) event.getNewValue();
                this.setVisible(false);
                this.dispose();
                switch (user.getUserRole()) {
                    case ADMIN, STAFF -> {
                        final DashboardController dashboardController = App.appGraph.getDashboardController();
                        final DashboardView dashboardView = App.appGraph.getDashboardView();
//                        dashboardController.addView(dashboardView);
                        dashboardView.setVisible(true);
                        dashboardView.fetchStudentList();
                    }
                    case STUDENT -> {
                        final InforView userInformationView = new InforView();
                        userInformationView.setVisible(true);
                    }
                }
            }
        }
    }
    
    private class UsernameTextListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            listen(e);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
                        listen(e);

        }

        @Override
        public void changedUpdate(DocumentEvent e) {
                        listen(e);

        }
        
        private void listen(DocumentEvent e) {
           final String newValue = usernameTxt.getText();
           controller.elementUserNameChanged(newValue);
        }
    }
    
    private class PasswordTextListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            listen(e);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            listen(e);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            listen(e);
        }
        
        private void listen(DocumentEvent e) {
           final String newValue = String.valueOf(passwordTxt.getPassword());
           controller.elementPasswordChanged(newValue);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorMessageLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTxt;
    // End of variables declaration//GEN-END:variables
}
