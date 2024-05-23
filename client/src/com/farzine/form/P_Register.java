//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.form;

import com.farzine.event.EventMessage;
import com.farzine.event.PublicEvent;
import com.farzine.model.Model_Message;
import com.farzine.model.Model_Register;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class P_Register extends JPanel {
    private JButton cmdBackLogin;
    private JButton cmdRegister;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel lbError;
    private JLabel lbTitle;
    private JPasswordField txtPass;
    private JPasswordField txtRePassword;
    private JTextField txtUser;

    public P_Register() {
        this.initComponents();
    }

    private void initComponents() {
        this.lbTitle = new JLabel();
        this.jLabel1 = new JLabel();
        this.txtUser = new JTextField();
        this.jLabel2 = new JLabel();
        this.txtPass = new JPasswordField();
        this.cmdRegister = new JButton();
        this.cmdBackLogin = new JButton();
        this.txtRePassword = new JPasswordField();
        this.jLabel3 = new JLabel();
        this.lbError = new JLabel();
        this.setBackground(new Color(255, 255, 255));
        this.lbTitle.setFont(new Font("sansserif", 0, 30));
        this.lbTitle.setForeground(new Color(87, 87, 87));
        this.lbTitle.setHorizontalAlignment(0);
        this.lbTitle.setText("Register");
        this.jLabel1.setText("User Name");
        this.jLabel2.setText("Password");
        this.cmdRegister.setText("Register");
        this.cmdRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                P_Register.this.cmdRegisterActionPerformed(evt);
            }
        });
        this.cmdBackLogin.setFont(new Font("sansserif", 0, 11));
        this.cmdBackLogin.setForeground(new Color(15, 128, 206));
        this.cmdBackLogin.setText("Back Login");
        this.cmdBackLogin.setContentAreaFilled(false);
        this.cmdBackLogin.setCursor(new Cursor(12));
        this.cmdBackLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                P_Register.this.cmdBackLoginActionPerformed(evt);
            }
        });
        this.jLabel3.setText("Confirm Password");
        this.lbError.setFont(new Font("sansserif", 0, 11));
        this.lbError.setForeground(new Color(255, 0, 0));
        this.lbError.setHorizontalAlignment(0);
        this.lbError.setText(" ");
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.lbTitle, -1, -1, 32767).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.lbError, -1, -1, 32767)).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(this.cmdBackLogin, -1, -1, 32767).addComponent(this.cmdRegister, -1, -1, 32767).addComponent(this.txtPass).addComponent(this.txtUser, Alignment.LEADING).addComponent(this.jLabel1, Alignment.LEADING, -1, -1, 32767).addComponent(this.jLabel2, Alignment.LEADING, -1, 228, 32767).addComponent(this.txtRePassword).addComponent(this.jLabel3, Alignment.LEADING, -1, 228, 32767)))).addGap(20, 20, 20)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.lbTitle).addGap(20, 20, 20).addComponent(this.jLabel1).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.txtUser, -2, -1, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.txtPass, -2, -1, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel3).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.txtRePassword, -2, -1, -2).addGap(18, 18, 18).addComponent(this.cmdRegister).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.cmdBackLogin).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.lbError).addGap(0, 9, 32767)));
    }

    private void cmdBackLoginActionPerformed(ActionEvent evt) {
        PublicEvent.getInstance().getEventLogin().goLogin();
    }

    private void cmdRegisterActionPerformed(ActionEvent evt) {
        String userName = this.txtUser.getText().trim();
        String password = String.valueOf(this.txtPass.getPassword());
        String confirmPassword = String.valueOf(this.txtRePassword.getPassword());
        if (userName.equals("")) {
            this.txtUser.grabFocus();
        } else if (password.equals("")) {
            this.txtPass.grabFocus();
        } else if (!password.equals(confirmPassword)) {
            this.txtPass.grabFocus();
        } else {
            Model_Register data = new Model_Register(userName, password);
            PublicEvent.getInstance().getEventLogin().register(data, new EventMessage() {
                public void callMessage(Model_Message message) {
                    if (!message.isAction()) {
                        P_Register.this.lbError.setText(message.getMessage());
                    } else {
                        PublicEvent.getInstance().getEventMain().initChat();
                    }

                }
            });
        }

    }
}
