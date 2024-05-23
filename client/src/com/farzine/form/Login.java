//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.form;

import com.farzine.event.EventLogin;
import com.farzine.event.EventMessage;
import com.farzine.event.PublicEvent;
import com.farzine.model.Model_Login;
import com.farzine.model.Model_Message;
import com.farzine.model.Model_Register;
import com.farzine.model.Model_User_Account;
import com.farzine.service.Service;
import com.farzine.swing.PanelSlide;
import com.farzine.swing.PictureBox;
import io.socket.client.Ack;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Login extends JPanel {
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private PictureBox pic;
    private PanelSlide slide;

    public Login() {
        this.initComponents();
        this.init();
    }

    private void init() {
        PublicEvent.getInstance().addEventLogin(new EventLogin() {
            public void login(final Model_Login data) {
                (new Thread(new Runnable() {
                    public void run() {
                        PublicEvent.getInstance().getEventMain().showLoading(true);
                        Service.getInstance().getClient().emit("login", new Object[]{data.toJsonObject(), new Ack() {
                            public void call(Object... os) {
                                if (os.length > 0) {
                                    boolean action = (Boolean)os[0];
                                    if (action) {
                                        Service.getInstance().setUser(new Model_User_Account(os[1]));
                                        PublicEvent.getInstance().getEventMain().showLoading(false);
                                        PublicEvent.getInstance().getEventMain().initChat();
                                    } else {
                                        PublicEvent.getInstance().getEventMain().showLoading(false);
                                    }
                                } else {
                                    PublicEvent.getInstance().getEventMain().showLoading(false);
                                }

                            }
                        }});
                    }
                })).start();
            }

            public void register(Model_Register data, final EventMessage message) {
                Service.getInstance().getClient().emit("register", new Object[]{data.toJsonObject(), new Ack() {
                    public void call(Object... os) {
                        if (os.length > 0) {
                            Model_Message ms = new Model_Message((Boolean)os[0], os[1].toString());
                            if (ms.isAction()) {
                                Model_User_Account user = new Model_User_Account(os[2]);
                                Service.getInstance().setUser(user);
                            }

                            message.callMessage(ms);
                        }

                    }
                }});
            }

            public void goRegister() {
                Login.this.slide.show(1);
            }

            public void goLogin() {
                Login.this.slide.show(0);
            }
        });
        P_Login login = new P_Login();
        P_Register register = new P_Register();
        this.slide.init(new Component[]{login, register});
    }

    private void initComponents() {
        this.pic = new PictureBox();
        this.jLabel2 = new JLabel();
        this.jLabel1 = new JLabel();
        this.jPanel1 = new JPanel();
        this.jPanel2 = new JPanel();
        this.slide = new PanelSlide();
        this.setBackground(new Color(255, 255, 255));
        this.pic.setImage(new ImageIcon(this.getClass().getResource("/com/farzine/icon/login_image.png")));
        this.jLabel2.setFont(new Font("sansserif", 0, 18));
        this.jLabel2.setForeground(new Color(66, 66, 66));
        this.jLabel2.setText("Chat Application");
        this.pic.setLayer(this.jLabel2, JLayeredPane.DEFAULT_LAYER);
        GroupLayout picLayout = new GroupLayout(this.pic);
        this.pic.setLayout(picLayout);
        picLayout.setHorizontalGroup(picLayout.createParallelGroup(Alignment.LEADING).addGroup(picLayout.createSequentialGroup().addGap(0, 0, 0).addComponent(this.jLabel2).addContainerGap(576, 32767)));
        picLayout.setVerticalGroup(picLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, picLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jLabel2).addGap(0, 0, 0)));
        this.jLabel1.setBackground(new Color(32, 140, 215));
        this.jLabel1.setOpaque(true);
        this.jPanel1.setBackground(new Color(32, 140, 215));
        this.jPanel2.setBackground(new Color(255, 255, 255));
        this.slide.setBackground(new Color(255, 255, 255));
        GroupLayout slideLayout = new GroupLayout(this.slide);
        this.slide.setLayout(slideLayout);
        slideLayout.setHorizontalGroup(slideLayout.createParallelGroup(Alignment.LEADING).addGap(0, 256, 32767));
        slideLayout.setVerticalGroup(slideLayout.createParallelGroup(Alignment.LEADING).addGap(0, 318, 32767));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.slide, -1, -1, 32767).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.slide, -1, -1, 32767).addContainerGap()));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.jPanel2, -1, -1, 32767).addGap(1, 1, 1)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.jPanel2, -1, -1, 32767).addGap(1, 1, 1)));
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.pic, -1, -1, 32767).addGap(100, 100, 100).addComponent(this.jPanel1, -2, -1, -2).addGap(50, 50, 50)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.pic, -1, -1, 32767).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 100, 32767).addComponent(this.jPanel1, -2, -1, -2).addGap(0, 100, 32767))).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel1, -2, 2, -2)));
    }
}
