//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.form;

import com.farzine.component.Item_People;
import com.farzine.component.MenuButton;
import com.farzine.event.EventMenuLeft;
import com.farzine.event.PublicEvent;
import com.farzine.model.Model_User_Account;
import com.farzine.swing.ScrollBar;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;
import net.miginfocom.swing.MigLayout;

public class Menu_Left extends JPanel {
    private List<Model_User_Account> userAccount;
    private JLayeredPane menu;
    private MenuButton menuBox;
    private MenuButton menuGroup;
    private JLayeredPane menuList;
    private MenuButton menuMessage;
    private JScrollPane sp;

    public Menu_Left() {
        this.initComponents();
        this.init();
    }

    private void init() {
        this.sp.setVerticalScrollBar(new ScrollBar());
        this.menuList.setLayout(new MigLayout("fillx", "0[]0", "0[]0"));
        this.userAccount = new ArrayList();
        PublicEvent.getInstance().addEventMenuLeft(new EventMenuLeft() {
            public void newUser(List<Model_User_Account> users) {
                Iterator var2 = users.iterator();

                while(var2.hasNext()) {
                    Model_User_Account d = (Model_User_Account)var2.next();
                    Menu_Left.this.userAccount.add(d);
                    Menu_Left.this.menuList.add(new Item_People(d), "wrap");
                    Menu_Left.this.refreshMenuList();
                }

            }

            public void userConnect(int userID) {
                Iterator var2 = Menu_Left.this.userAccount.iterator();

                while(var2.hasNext()) {
                    Model_User_Account u = (Model_User_Account)var2.next();
                    if (u.getUserID() == userID) {
                        u.setStatus(true);
                        PublicEvent.getInstance().getEventMain().updateUser(u);
                        break;
                    }
                }

                if (Menu_Left.this.menuMessage.isSelected()) {
                    Component[] var7 = Menu_Left.this.menuList.getComponents();
                    int var8 = var7.length;

                    for(int var4 = 0; var4 < var8; ++var4) {
                        Component com = var7[var4];
                        Item_People item = (Item_People)com;
                        if (item.getUser().getUserID() == userID) {
                            item.updateStatus();
                            break;
                        }
                    }
                }

            }

            public void userDisconnect(int userID) {
                Iterator var2 = Menu_Left.this.userAccount.iterator();

                while(var2.hasNext()) {
                    Model_User_Account u = (Model_User_Account)var2.next();
                    if (u.getUserID() == userID) {
                        u.setStatus(false);
                        PublicEvent.getInstance().getEventMain().updateUser(u);
                        break;
                    }
                }

                if (Menu_Left.this.menuMessage.isSelected()) {
                    Component[] var7 = Menu_Left.this.menuList.getComponents();
                    int var8 = var7.length;

                    for(int var4 = 0; var4 < var8; ++var4) {
                        Component com = var7[var4];
                        Item_People item = (Item_People)com;
                        if (item.getUser().getUserID() == userID) {
                            item.updateStatus();
                            break;
                        }
                    }
                }

            }
        });
        this.showMessage();
    }

    private void showMessage() {
        this.menuList.removeAll();
        Iterator var1 = this.userAccount.iterator();

        while(var1.hasNext()) {
            Model_User_Account d = (Model_User_Account)var1.next();
            this.menuList.add(new Item_People((Model_User_Account)null), "wrap");
        }

        this.refreshMenuList();
    }

    private void showGroup() {
        this.menuList.removeAll();

        for(int i = 0; i < 5; ++i) {
            this.menuList.add(new Item_People((Model_User_Account)null), "wrap");
        }

        this.refreshMenuList();
    }

    private void showBox() {
        this.menuList.removeAll();

        for(int i = 0; i < 10; ++i) {
            this.menuList.add(new Item_People((Model_User_Account)null), "wrap");
        }

        this.refreshMenuList();
    }

    private void refreshMenuList() {
        this.menuList.repaint();
        this.menuList.revalidate();
    }

    private void initComponents() {
        this.menu = new JLayeredPane();
        this.menuMessage = new MenuButton();
        this.menuGroup = new MenuButton();
        this.menuBox = new MenuButton();
        this.sp = new JScrollPane();
        this.menuList = new JLayeredPane();
        this.setBackground(new Color(242, 242, 242));
        this.menu.setBackground(new Color(229, 229, 229));
        this.menu.setOpaque(true);
        this.menu.setLayout(new GridLayout(1, 3));
        this.menuMessage.setIconSelected(new ImageIcon(this.getClass().getResource("/com/farzine/icon/message_selected.png")));
        this.menuMessage.setIconSimple(new ImageIcon(this.getClass().getResource("/com/farzine/icon/message.png")));
        this.menuMessage.setSelected(true);
        this.menuMessage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Menu_Left.this.menuMessageActionPerformed(evt);
            }
        });
        this.menu.add(this.menuMessage);
        this.menuGroup.setIcon(new ImageIcon(this.getClass().getResource("/com/farzine/icon/group.png")));
        this.menuGroup.setIconSelected(new ImageIcon(this.getClass().getResource("/com/farzine/icon/group_selected.png")));
        this.menuGroup.setIconSimple(new ImageIcon(this.getClass().getResource("/com/farzine/icon/group.png")));
        this.menuGroup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Menu_Left.this.menuGroupActionPerformed(evt);
            }
        });
        this.menu.add(this.menuGroup);
        this.menuBox.setIcon(new ImageIcon(this.getClass().getResource("/com/farzine/icon/box.png")));
        this.menuBox.setIconSelected(new ImageIcon(this.getClass().getResource("/com/farzine/icon/box_selected.png")));
        this.menuBox.setIconSimple(new ImageIcon(this.getClass().getResource("/com/farzine/icon/box.png")));
        this.menuBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Menu_Left.this.menuBoxActionPerformed(evt);
            }
        });
        this.menu.add(this.menuBox);
        this.sp.setBackground(new Color(242, 242, 242));
        this.sp.setBorder((Border)null);
        this.sp.setHorizontalScrollBarPolicy(31);
        this.menuList.setBackground(new Color(242, 242, 242));
        this.menuList.setOpaque(true);
        GroupLayout menuListLayout = new GroupLayout(this.menuList);
        this.menuList.setLayout(menuListLayout);
        menuListLayout.setHorizontalGroup(menuListLayout.createParallelGroup(Alignment.LEADING).addGap(0, 0, 32767));
        menuListLayout.setVerticalGroup(menuListLayout.createParallelGroup(Alignment.LEADING).addGap(0, 576, 32767));
        this.sp.setViewportView(this.menuList);
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.menu, -1, 200, 32767).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.sp).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.menu, -2, 40, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.sp).addContainerGap()));
    }

    private void menuMessageActionPerformed(ActionEvent evt) {
        if (!this.menuMessage.isSelected()) {
            this.menuMessage.setSelected(true);
            this.menuGroup.setSelected(false);
            this.menuBox.setSelected(false);
            this.showMessage();
        }

    }

    private void menuGroupActionPerformed(ActionEvent evt) {
        if (!this.menuGroup.isSelected()) {
            this.menuMessage.setSelected(false);
            this.menuGroup.setSelected(true);
            this.menuBox.setSelected(false);
            this.showGroup();
        }

    }

    private void menuBoxActionPerformed(ActionEvent evt) {
        if (!this.menuBox.isSelected()) {
            this.menuMessage.setSelected(false);
            this.menuGroup.setSelected(false);
            this.menuBox.setSelected(true);
            this.showBox();
        }

    }
}
