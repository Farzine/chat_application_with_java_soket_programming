//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.form;

import com.farzine.event.PublicEvent;
import com.farzine.swing.PictureBox;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VIew_Image extends JComponent {
    private Icon image;
    private JButton cmdSave;
    private PictureBox pic;

    public VIew_Image() {
        this.initComponents();
    }

    public void viewImage(Icon image) {
        this.image = image;
        this.pic.setImage(image);
        this.setVisible(true);
    }

    private void initComponents() {
        this.pic = new PictureBox();
        this.cmdSave = new JButton();
        this.pic.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                VIew_Image.this.picMousePressed(evt);
            }
        });
        this.cmdSave.setIcon(new ImageIcon(this.getClass().getResource("/com/farzine/icon/save.png")));
        this.cmdSave.setContentAreaFilled(false);
        this.cmdSave.setCursor(new Cursor(12));
        this.cmdSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                VIew_Image.this.cmdSaveActionPerformed(evt);
            }
        });
        this.pic.setLayer(this.cmdSave, JLayeredPane.DEFAULT_LAYER);
        GroupLayout picLayout = new GroupLayout(this.pic);
        this.pic.setLayout(picLayout);
        picLayout.setHorizontalGroup(picLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, picLayout.createSequentialGroup().addContainerGap(735, 32767).addComponent(this.cmdSave).addContainerGap()));
        picLayout.setVerticalGroup(picLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, picLayout.createSequentialGroup().addContainerGap(464, 32767).addComponent(this.cmdSave).addContainerGap()));
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.pic, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.pic, -1, -1, 32767));
    }

    private void picMousePressed(MouseEvent evt) {
        if (SwingUtilities.isLeftMouseButton(evt)) {
            this.setVisible(false);
        }

    }

    private void cmdSaveActionPerformed(ActionEvent evt) {
        PublicEvent.getInstance().getEventImageView().saveImage(this.image);
    }

    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D)grphcs;
        g2.setColor(new Color(0, 0, 0, 150));
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());
        super.paintComponent(grphcs);
    }
}
