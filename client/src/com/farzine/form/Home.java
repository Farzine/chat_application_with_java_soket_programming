//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.form;

import com.farzine.model.Model_User_Account;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class Home extends JLayeredPane {
    private Chat chat;

    public Home() {
        this.initComponents();
        this.init();
    }

    private void init() {
        this.setLayout(new MigLayout("fillx, filly", "0[200!]5[fill, 100%]5[200!]0", "0[fill]0"));
        this.add(new Menu_Left());
        this.chat = new Chat();
        this.add(this.chat);
        this.add(new Menu_Right());
        this.chat.setVisible(false);
    }

    public void setUser(Model_User_Account user) {
        this.chat.setUser(user);
        this.chat.setVisible(true);
    }

    public void updateUser(Model_User_Account user) {
        this.chat.updateUser(user);
    }

    private void initComponents() {
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGap(0, 1007, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGap(0, 551, 32767));
    }
}
