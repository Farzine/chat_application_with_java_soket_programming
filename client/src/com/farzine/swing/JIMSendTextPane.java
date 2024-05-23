//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.swing;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class JIMSendTextPane extends JTextPane {
    private String hintText = "";

    public String getHintText() {
        return this.hintText;
    }

    public void setHintText(String hintText) {
        this.hintText = hintText;
    }

    public JIMSendTextPane() {
        this.setEditorKit(new WarpEditorKit());
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (this.getText().length() == 0 && !this.hintText.equals("")) {
            int h = this.getHeight();
            ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            Insets ins = this.getInsets();
            FontMetrics fm = g.getFontMetrics();
            int c0 = this.getBackground().getRGB();
            int c1 = this.getForeground().getRGB();
            int m = -16843010;
            int c2 = ((c0 & m) >>> 1) + ((c1 & m) >>> 1);
            g.setColor(new Color(c2, true));
            g.drawString(this.hintText, ins.left, h / 2 + fm.getAscent() / 2 - 2);
        }

    }

    private class WarpLabelView extends LabelView {
        public WarpLabelView(Element elem) {
            super(elem);
        }

        public float getMinimumSpan(int axis) {
            switch (axis) {
                case 0:
                    return 0.0F;
                case 1:
                    return super.getMinimumSpan(axis);
                default:
                    throw new IllegalArgumentException("Invalid axis:" + axis);
            }
        }
    }

    private class WarpColumnFactory implements ViewFactory {
        private WarpColumnFactory() {
        }

        public View create(Element elem) {
            String kind = elem.getName();
            if (kind != null) {
                if (kind.equals("content")) {
                    return JIMSendTextPane.this.new WarpLabelView(elem);
                }

                if (kind.equals("paragraph")) {
                    return new ParagraphView(elem);
                }

                if (kind.equals("section")) {
                    return new BoxView(elem, 1);
                }

                if (kind.equals("component")) {
                    return new ComponentView(elem);
                }

                if (kind.equals("icon")) {
                    return new IconView(elem);
                }
            }

            return new LabelView(elem);
        }
    }

    private class WarpEditorKit extends StyledEditorKit {
        private ViewFactory defaultFactory;

        private WarpEditorKit() {
            this.defaultFactory = JIMSendTextPane.this.new WarpColumnFactory();
        }

        public ViewFactory getViewFactory() {
            return this.defaultFactory;
        }
    }
}
