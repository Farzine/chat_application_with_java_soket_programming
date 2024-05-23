//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.form;

import com.farzine.event.PublicEvent;
import com.farzine.model.Model_Login;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class P_Login extends JPanel {
    private JButton cmdLogin;
    private JButton cmdRegister;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel lbTitle;
    private JPasswordField txtPass;
    private JTextField txtUser;

    public P_Login() {
        this.initComponents();
    }

    private void initComponents() {
        this.lbTitle = new JLabel();
        this.jLabel1 = new JLabel();
        this.txtUser = new JTextField();
        this.jLabel2 = new JLabel();
        this.txtPass = new JPasswordField();
        this.cmdLogin = new JButton();
        this.cmdRegister = new JButton();
        this.setBackground(new Color(255, 255, 255));
        this.lbTitle.setFont(new Font("sansserif", 0, 30));
        this.lbTitle.setForeground(new Color(87, 87, 87));
        this.lbTitle.setHorizontalAlignment(0);
        this.lbTitle.setText("Login");
        this.jLabel1.setText("User Name");
        this.jLabel2.setText("Password");
        this.cmdLogin.setText("Login");
        this.cmdLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                P_Login.this.cmdLoginActionPerformed(evt);
            }
        });
        this.cmdRegister.setFont(new Font("sansserif", 0, 11));
        this.cmdRegister.setForeground(new Color(15, 128, 206));
        this.cmdRegister.setText("Register");
        this.cmdRegister.setContentAreaFilled(false);
        this.cmdRegister.setCursor(new Cursor(12));
        this.cmdRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                P_Login.this.cmdRegisterActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.lbTitle, -1, -1, 32767).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addGap(20, 20, 20).addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(this.cmdRegister, -1, -1, 32767).addComponent(this.cmdLogin, -1, -1, 32767).addComponent(this.txtPass).addComponent(this.txtUser, Alignment.LEADING).addComponent(this.jLabel1, Alignment.LEADING, -1, -1, 32767).addComponent(this.jLabel2, Alignment.LEADING, -1, 228, 32767)).addGap(20, 20, 20)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.lbTitle).addGap(20, 20, 20).addComponent(this.jLabel1).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.txtUser, -2, -1, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.txtPass, -2, -1, -2).addGap(18, 18, 18).addComponent(this.cmdLogin).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.cmdRegister).addGap(0, 86, 32767)));
    }

    private void cmdRegisterActionPerformed(ActionEvent evt) {
        PublicEvent.getInstance().getEventLogin().goRegister();
    }

    private void cmdLoginActionPerformed(ActionEvent evt) {
        PublicEvent.getInstance().getEventLogin().login(new Model_Login(this.txtUser.getText(), String.valueOf(this.txtPass.getPassword())));
    }
}
