//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.form;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;

public class Loading extends JComponent {
    private JLabel lb;

    public Loading() {
        this.initComponents();
    }

    private void initComponents() {
        this.lb = new JLabel();
        this.lb.setIcon(new ImageIcon(this.getClass().getResource("/com/farzine/icon/loading.gif")));
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.lb, -2, 197, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.lb, -2, 155, -2).addContainerGap(-1, 32767)));
    }

    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D)grphcs;
        g2.setColor(new Color(255, 255, 255, 200));
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());
        super.paintComponent(grphcs);
    }
}
