//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.swing;

import javax.swing.*;
import java.awt.*;

public class ScrollBar extends JScrollBar {
    public ScrollBar() {
        this.setUI(new ModernScrollBarUI());
        this.setPreferredSize(new Dimension(5, 5));
        this.setBackground(new Color(242, 242, 242));
        this.setUnitIncrement(20);
    }
}
