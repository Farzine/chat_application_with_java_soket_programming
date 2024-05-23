//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class ActiveStatus extends Component {
    private boolean active;

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
        this.repaint();
    }

    public ActiveStatus() {
        this.setPreferredSize(new Dimension(8, 8));
    }

    public void paint(Graphics grphcs) {
        if (this.active) {
            Graphics2D g2 = (Graphics2D)grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(62, 165, 49));
            g2.fillOval(0, this.getHeight() / 2 - 4, 8, 8);
        }

    }
}
