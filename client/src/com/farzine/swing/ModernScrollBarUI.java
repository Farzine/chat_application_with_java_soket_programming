//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.swing;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class ModernScrollBarUI extends BasicScrollBarUI {
    private static final int SCROLL_BAR_ALPHA_ROLLOVER = 100;
    private static final int SCROLL_BAR_ALPHA = 50;
    private static final int THUMB_SIZE = 8;
    private static final Color THUMB_COLOR;

    public ModernScrollBarUI() {
    }

    protected JButton createDecreaseButton(int orientation) {
        return new InvisibleScrollBarButton();
    }

    protected JButton createIncreaseButton(int orientation) {
        return new InvisibleScrollBarButton();
    }

    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
    }

    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        int alpha = this.isThumbRollover() ? 100 : 50;
        int orientation = this.scrollbar.getOrientation();
        int x = thumbBounds.x;
        int y = thumbBounds.y;
        int width = orientation == 1 ? 8 : thumbBounds.width;
        width = Math.max(width, 8);
        int height = orientation == 1 ? thumbBounds.height : 8;
        height = Math.max(height, 8);
        Graphics2D graphics2D = (Graphics2D)g.create();
        graphics2D.setColor(new Color(THUMB_COLOR.getRed(), THUMB_COLOR.getGreen(), THUMB_COLOR.getBlue(), alpha));
        graphics2D.fillRect(x, y, width, height);
        graphics2D.dispose();
    }

    static {
        THUMB_COLOR = Color.BLACK;
    }

    private static class InvisibleScrollBarButton extends JButton {
        private InvisibleScrollBarButton() {
            this.setOpaque(false);
            this.setFocusable(false);
            this.setFocusPainted(false);
            this.setBorderPainted(false);
            this.setBorder(BorderFactory.createEmptyBorder());
        }
    }
}
