//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.swing;

import com.farzine.swing.Progress.ProgressType;

import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.ImageObserver;

public class ProgressCircleUI extends BasicProgressBarUI {
    private final Progress pro;
    private final Image imageDown;
    private final Image imageCancel;
    private final Image imageFile;

    public ProgressCircleUI(Progress pro) {
        this.pro = pro;
        this.imageDown = (new ImageIcon(this.getClass().getResource("/com/farzine/icon/down.png"))).getImage();
        this.imageCancel = (new ImageIcon(this.getClass().getResource("/com/farzine/icon/cancel.png"))).getImage();
        this.imageFile = (new ImageIcon(this.getClass().getResource("/com/farzine/icon/file.png"))).getImage();
    }

    public Dimension getPreferredSize(JComponent c) {
        Dimension d = super.getPreferredSize(c);
        int v = Math.max(d.width, d.height);
        d.setSize(v, v);
        return d;
    }

    public void paint(Graphics g, JComponent c) {
        Insets b = this.progressBar.getInsets();
        int barRectWidth = this.progressBar.getWidth() - b.right - b.left;
        int barRectHeight = this.progressBar.getHeight() - b.top - b.bottom;
        if (barRectWidth > 0 && barRectHeight > 0) {
            Graphics2D g2 = (Graphics2D)g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.setColor(new Color(60, 60, 60, 50));
            g2.fillOval(0, 0, this.pro.getWidth(), this.pro.getHeight());
            if (this.pro.getProgressType() != ProgressType.NONE) {
                g2.drawImage(this.pro.getProgressType() == ProgressType.CANCEL ? this.imageCancel : (this.pro.getProgressType() == ProgressType.DOWN_FILE ? this.imageDown : this.imageFile), 10, 10, this.pro.getWidth() - 20, this.pro.getHeight() - 20, (ImageObserver)null);
            }

            g2.setPaint(this.progressBar.getForeground());
            double degree = 360.0 * this.progressBar.getPercentComplete();
            double sz = (double)Math.min(barRectWidth, barRectHeight);
            double cx = (double)b.left + (double)barRectWidth * 0.5;
            double cy = (double)b.top + (double)barRectHeight * 0.5;
            double or = sz * 0.5;
            double ir = or * 0.9;
            Shape inner = new Ellipse2D.Double(cx - ir, cy - ir, ir * 2.0, ir * 2.0);
            Shape outer = new Arc2D.Double(cx - or, cy - or, sz, sz, 90.0 - degree, degree, 2);
            Area area = new Area(outer);
            area.subtract(new Area(inner));
            g2.fill(area);
            g2.dispose();
            if (this.progressBar.isStringPainted()) {
                this.paintString(g, b.left, b.top, barRectWidth, barRectHeight, 0, b);
            }

        }
    }
}
