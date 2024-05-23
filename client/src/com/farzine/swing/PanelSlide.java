//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PanelSlide extends JPanel {
    private final List<Component> list = new ArrayList();
    private final Timer timer = new Timer(0, new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            PanelSlide.this.animate();
        }
    });
    private Component comExit;
    private Component comShow;
    private int currentShowing;
    private boolean animateRight;
    private int animate = 1;

    public int getAnimate() {
        return this.animate;
    }

    public void setAnimate(int animate) {
        this.animate = animate;
    }

    public PanelSlide() {
    }

    public void init(Component... com) {
        if (com.length > 0) {
            Component[] var2 = com;
            int var3 = com.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                Component c = var2[var4];
                this.list.add(c);
                c.setSize(this.getPreferredSize());
                c.setVisible(false);
                this.add(c);
            }

            Component show = (Component)this.list.get(0);
            show.setVisible(true);
            show.setLocation(0, 0);
        }

    }

    public void show(int index) {
        if (!this.timer.isRunning() && this.list.size() > 1 && index < this.list.size() && index != this.currentShowing) {
            this.comShow = (Component)this.list.get(index);
            this.comExit = (Component)this.list.get(this.currentShowing);
            this.animateRight = index < this.currentShowing;
            this.currentShowing = index;
            this.comShow.setVisible(true);
            if (this.animateRight) {
                this.comShow.setLocation(-this.comShow.getWidth(), 0);
            } else {
                this.comShow.setLocation(this.getWidth(), 0);
            }

            this.timer.start();
        }

    }

    private void animate() {
        if (this.animateRight) {
            if (this.comShow.getLocation().x < 0) {
                this.comShow.setLocation(this.comShow.getLocation().x + this.animate, 0);
                this.comExit.setLocation(this.comExit.getLocation().x + this.animate, 0);
            } else {
                this.comShow.setLocation(0, 0);
                this.timer.stop();
                this.comExit.setVisible(false);
            }
        } else if (this.comShow.getLocation().x > 0) {
            this.comShow.setLocation(this.comShow.getLocation().x - this.animate, 0);
            this.comExit.setLocation(this.comExit.getLocation().x - this.animate, 0);
        } else {
            this.comShow.setLocation(0, 0);
            this.timer.stop();
            this.comExit.setVisible(false);
        }

    }
}
