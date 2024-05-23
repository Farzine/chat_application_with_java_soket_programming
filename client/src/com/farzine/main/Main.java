//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.main;

import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import com.farzine.event.EventImageView;
import com.farzine.event.EventMain;
import com.farzine.event.PublicEvent;
import com.farzine.form.Home;
import com.farzine.form.Loading;
import com.farzine.form.Login;
import com.farzine.form.VIew_Image;
import com.farzine.model.Model_User_Account;
import com.farzine.service.Service;
import com.farzine.swing.ComponentResizer;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    private int pX;
    private int pY;
    private JPanel background;
    private JLayeredPane body;
    private JPanel border;
    private JButton cmdClose;
    private JButton cmdMinimize;
    private Home home;
    private Loading loading;
    private Login login;
    private JPanel title;
    private VIew_Image vIew_Image;

    public Main() {
        this.initComponents();
        this.init();
    }

    private void init() {
        this.setIconImage((new ImageIcon(this.getClass().getResource("/com/farzine/icon/icon.png"))).getImage());
        ComponentResizer com = new ComponentResizer();
        com.registerComponent(new Component[]{this});
        com.setMinimumSize(new Dimension(900, 500));
        com.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        com.setSnapSize(new Dimension(10, 10));
        this.login.setVisible(true);
        this.loading.setVisible(false);
        this.vIew_Image.setVisible(false);
        this.home.setVisible(false);
        this.initEvent();
        Service.getInstance().startServer();
    }

    private void initEvent() {
        PublicEvent.getInstance().addEventMain(new EventMain() {
            public void showLoading(boolean show) {
                Main.this.loading.setVisible(show);
            }

            public void initChat() {
                Main.this.home.setVisible(true);
                Main.this.login.setVisible(false);
                Service.getInstance().getClient().emit("list_user", new Object[]{Service.getInstance().getUser().getUserID()});
            }

            public void selectUser(Model_User_Account user) {
                Main.this.home.setUser(user);
            }

            public void updateUser(Model_User_Account user) {
                Main.this.home.updateUser(user);
            }
        });
        PublicEvent.getInstance().addEventImageView(new EventImageView() {
            public void viewImage(Icon image) {
                Main.this.vIew_Image.viewImage(image);
            }

            public void saveImage(Icon image) {
                System.out.println("Save Image next update");
            }
        });
    }

    private void initComponents() {
        this.border = new JPanel();
        this.background = new JPanel();
        this.title = new JPanel();
        this.cmdMinimize = new JButton();
        this.cmdClose = new JButton();
        this.body = new JLayeredPane();
        this.loading = new Loading();
        this.login = new Login();
        this.vIew_Image = new VIew_Image();
        this.home = new Home();
        this.setDefaultCloseOperation(3);
        this.setUndecorated(true);
        this.border.setBackground(new Color(229, 229, 229));
        this.background.setBackground(new Color(255, 255, 255));
        this.title.setBackground(new Color(229, 229, 229));
        this.title.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                Main.this.titleMouseDragged(evt);
            }
        });
        this.title.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                Main.this.titleMousePressed(evt);
            }
        });
        this.cmdMinimize.setIcon(new ImageIcon(this.getClass().getResource("/com/farzine/icon/minimize.png")));
        this.cmdMinimize.setBorder((Border)null);
        this.cmdMinimize.setContentAreaFilled(false);
        this.cmdMinimize.setCursor(new Cursor(12));
        this.cmdMinimize.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Main.this.cmdMinimizeActionPerformed(evt);
            }
        });
        this.cmdClose.setIcon(new ImageIcon(this.getClass().getResource("/com/farzine/icon/close.png")));
        this.cmdClose.setBorder((Border)null);
        this.cmdClose.setContentAreaFilled(false);
        this.cmdClose.setCursor(new Cursor(12));
        this.cmdClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Main.this.cmdCloseActionPerformed(evt);
            }
        });
        GroupLayout titleLayout = new GroupLayout(this.title);
        this.title.setLayout(titleLayout);
        titleLayout.setHorizontalGroup(titleLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, titleLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.cmdMinimize).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.cmdClose).addContainerGap()));
        titleLayout.setVerticalGroup(titleLayout.createParallelGroup(Alignment.LEADING).addGroup(titleLayout.createSequentialGroup().addGap(0, 0, 0).addGroup(titleLayout.createParallelGroup(Alignment.LEADING).addComponent(this.cmdClose, -1, 20, 32767).addComponent(this.cmdMinimize, -1, -1, 32767)).addGap(0, 0, 0)));
        this.body.setLayout(new CardLayout());
        this.body.add(this.loading, "card5");
        this.body.add(this.login, "card4");
        this.body.setLayer(this.vIew_Image, JLayeredPane.POPUP_LAYER);
        this.body.add(this.vIew_Image, "card3");
        this.body.add(this.home, "card2");
        GroupLayout backgroundLayout = new GroupLayout(this.background);
        this.background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(backgroundLayout.createParallelGroup(Alignment.LEADING).addComponent(this.title, Alignment.TRAILING, -1, -1, 32767).addGroup(backgroundLayout.createSequentialGroup().addContainerGap().addComponent(this.body, -1, 1210, 32767).addContainerGap()));
        backgroundLayout.setVerticalGroup(backgroundLayout.createParallelGroup(Alignment.LEADING).addGroup(backgroundLayout.createSequentialGroup().addGap(0, 0, 0).addComponent(this.title, -2, -1, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.body, -1, 606, 32767).addContainerGap()));
        GroupLayout borderLayout = new GroupLayout(this.border);
        this.border.setLayout(borderLayout);
        borderLayout.setHorizontalGroup(borderLayout.createParallelGroup(Alignment.LEADING).addGroup(borderLayout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.background, -1, -1, 32767).addGap(1, 1, 1)));
        borderLayout.setVerticalGroup(borderLayout.createParallelGroup(Alignment.LEADING).addGroup(borderLayout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.background, -1, -1, 32767).addGap(1, 1, 1)));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.border, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.border, -1, -1, 32767));
        this.pack();
        this.setLocationRelativeTo((Component)null);
    }

    private void titleMouseDragged(MouseEvent evt) {
        this.setLocation(this.getLocation().x + evt.getX() - this.pX, this.getLocation().y + evt.getY() - this.pY);
    }

    private void titleMousePressed(MouseEvent evt) {
        this.pX = evt.getX();
        this.pY = evt.getY();
    }

    private void cmdCloseActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void cmdMinimizeActionPerformed(ActionEvent evt) {
        this.setState(1);
    }

    public static void main(String[] args) {
        FlatArcIJTheme.setup();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new Main()).setVisible(true);
            }
        });
    }
}
