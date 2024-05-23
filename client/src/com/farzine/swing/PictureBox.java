//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class PictureBox extends JLayeredPane {
    private Icon image;

    public PictureBox() {
    }

    public Icon getImage() {
        return this.image;
    }

    public void setImage(Icon image) {
        this.image = image;
        this.repaint();
    }

    protected void paintComponent(Graphics grphcs) {
        if (this.image != null) {
            Graphics2D g2 = (Graphics2D)grphcs;
            Rectangle size = this.getAutoSize(this.image);
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(this.toImage(this.image), size.getLocation().x, size.getLocation().y, size.getSize().width, size.getSize().height, (ImageObserver)null);
        }

        super.paintComponent(grphcs);
    }

    private Rectangle getAutoSize(Icon image) {
        int w = this.getWidth();
        int h = this.getHeight();
        if (w > image.getIconWidth()) {
            w = image.getIconWidth();
        }

        if (h > image.getIconHeight()) {
            h = image.getIconHeight();
        }

        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        double xScale = (double)w / (double)iw;
        double yScale = (double)h / (double)ih;
        double scale = Math.min(xScale, yScale);
        int width = (int)(scale * (double)iw);
        int height = (int)(scale * (double)ih);
        int x = this.getWidth() / 2 - width / 2;
        int y = this.getHeight() / 2 - height / 2;
        return new Rectangle(new Point(x, y), new Dimension(width, height));
    }

    private Image toImage(Icon icon) {
        return ((ImageIcon)icon).getImage();
    }
}
