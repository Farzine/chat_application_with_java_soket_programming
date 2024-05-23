//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.swing;

import javax.swing.JProgressBar;

public class Progress extends JProgressBar {
    private ProgressType progressType;

    public ProgressType getProgressType() {
        return this.progressType;
    }

    public void setProgressType(ProgressType progressType) {
        this.progressType = progressType;
        this.repaint();
    }

    public Progress() {
        this.progressType = Progress.ProgressType.NONE;
        this.setOpaque(false);
        this.setUI(new ProgressCircleUI(this));
    }

    public static enum ProgressType {
        NONE,
        DOWN_FILE,
        CANCEL,
        FILE;

        private ProgressType() {
        }
    }
}
