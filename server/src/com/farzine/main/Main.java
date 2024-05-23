//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.main;

import com.farzine.connection.DatabaseConnection;
import com.farzine.service.Service;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends JFrame {
    private JScrollPane jScrollPane1;
    private JTextArea txt;

    public Main() {
        this.initComponents();
    }

    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.txt = new JTextArea();
        this.setDefaultCloseOperation(3);
        this.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent evt) {
                Main.this.formWindowOpened(evt);
            }
        });
        this.txt.setEditable(false);
        this.txt.setColumns(20);
        this.txt.setRows(5);
        this.jScrollPane1.setViewportView(this.txt);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 879, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(29, 29, 29).addComponent(this.jScrollPane1, -1, 508, 32767).addContainerGap()));
        this.pack();
        this.setLocationRelativeTo((Component)null);
    }

    private void formWindowOpened(WindowEvent evt) {
        try {
            DatabaseConnection.getInstance().connectToDatabase();
            Service.getInstance(this.txt).startServer();
        } catch (SQLException var3) {
            SQLException e = var3;
            this.txt.append("Error : " + e + "\n");
        }

    }

    public static void main(String[] args) {
        try {
            UIManager.LookAndFeelInfo[] var12 = UIManager.getInstalledLookAndFeels();
            int var2 = var12.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                UIManager.LookAndFeelInfo info = var12[var3];
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException var5) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            UnsupportedLookAndFeelException ex = var8;
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String)null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new Main()).setVisible(true);
            }
        });
    }
}
