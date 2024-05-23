//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.form;

import com.farzine.component.Chat_Body;
import com.farzine.component.Chat_Bottom;
import com.farzine.component.Chat_Title;
import com.farzine.event.EventChat;
import com.farzine.event.PublicEvent;
import com.farzine.model.Model_Receive_Message;
import com.farzine.model.Model_Send_Message;
import com.farzine.model.Model_User_Account;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;

public class Chat extends JPanel {
    private Chat_Title chatTitle;
    private Chat_Body chatBody;
    private Chat_Bottom chatBottom;

    public Chat() {
        this.initComponents();
        this.init();
    }

    private void init() {
        this.setLayout(new MigLayout("fillx", "0[fill]0", "0[]0[100%, fill]0[shrink 0]0"));
        this.chatTitle = new Chat_Title();
        this.chatBody = new Chat_Body();
        this.chatBottom = new Chat_Bottom();
        PublicEvent.getInstance().addEventChat(new EventChat() {
            public void sendMessage(Model_Send_Message data) {
                Chat.this.chatBody.addItemRight(data);
            }

            public void receiveMessage(Model_Receive_Message data) {
                if (Chat.this.chatTitle.getUser().getUserID() == data.getFromUserID()) {
                    Chat.this.chatBody.addItemLeft(data);
                }

            }
        });
        this.add(this.chatTitle, "wrap");
        this.add(this.chatBody, "wrap");
        this.add(this.chatBottom, "h ::50%");
    }

    public void setUser(Model_User_Account user) {
        this.chatTitle.setUserName(user);
        this.chatBottom.setUser(user);
        this.chatBody.clearChat();
    }

    public void updateUser(Model_User_Account user) {
        this.chatTitle.updateUser(user);
    }

    private void initComponents() {
        this.setBackground(new Color(255, 255, 255));
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGap(0, 727, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGap(0, 681, 32767));
    }
}
