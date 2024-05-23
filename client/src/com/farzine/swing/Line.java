//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.swing;

import javax.swing.*;
import java.awt.*;

public class Line extends JLabel {
    public Line() {
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.getForeground());
        g.drawLine(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);
    }
}
