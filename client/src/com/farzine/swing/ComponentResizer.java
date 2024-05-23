//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class ComponentResizer extends MouseAdapter {
    private static final Dimension MINIMUM_SIZE = new Dimension(10, 10);
    private static final Dimension MAXIMUM_SIZE = new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
    private static Map<Integer, Integer> cursors = new HashMap();
    private Insets dragInsets;
    private Dimension snapSize;
    private int direction;
    protected static final int NORTH = 1;
    protected static final int WEST = 2;
    protected static final int SOUTH = 4;
    protected static final int EAST = 8;
    private Cursor sourceCursor;
    private boolean resizing;
    private Rectangle bounds;
    private Point pressed;
    private boolean autoscrolls;
    private Dimension minimumSize;
    private Dimension maximumSize;

    public ComponentResizer() {
        this(new Insets(5, 5, 5, 5), new Dimension(1, 1));
    }

    public ComponentResizer(Component... components) {
        this(new Insets(5, 5, 5, 5), new Dimension(1, 1), components);
    }

    public ComponentResizer(Insets dragInsets, Component... components) {
        this(dragInsets, new Dimension(1, 1), components);
    }

    public ComponentResizer(Insets dragInsets, Dimension snapSize, Component... components) {
        cursors.put(1, 8);
        cursors.put(2, 10);
        cursors.put(4, 9);
        cursors.put(8, 11);
        cursors.put(3, 6);
        cursors.put(9, 7);
        cursors.put(6, 4);
        cursors.put(12, 5);
        this.minimumSize = MINIMUM_SIZE;
        this.maximumSize = MAXIMUM_SIZE;
        this.setDragInsets(dragInsets);
        this.setSnapSize(snapSize);
        this.registerComponent(components);
    }

    public Insets getDragInsets() {
        return this.dragInsets;
    }

    public void setDragInsets(Insets dragInsets) {
        this.validateMinimumAndInsets(this.minimumSize, dragInsets);
        this.dragInsets = dragInsets;
    }

    public Dimension getMaximumSize() {
        return this.maximumSize;
    }

    public void setMaximumSize(Dimension maximumSize) {
        this.maximumSize = maximumSize;
    }

    public Dimension getMinimumSize() {
        return this.minimumSize;
    }

    public void setMinimumSize(Dimension minimumSize) {
        this.validateMinimumAndInsets(minimumSize, this.dragInsets);
        this.minimumSize = minimumSize;
    }

    public void deregisterComponent(Component... components) {
        Component[] var2 = components;
        int var3 = components.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Component component = var2[var4];
            component.removeMouseListener(this);
            component.removeMouseMotionListener(this);
        }

    }

    public void registerComponent(Component... components) {
        Component[] var2 = components;
        int var3 = components.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Component component = var2[var4];
            component.addMouseListener(this);
            component.addMouseMotionListener(this);
        }

    }

    public Dimension getSnapSize() {
        return this.snapSize;
    }

    public void setSnapSize(Dimension snapSize) {
        this.snapSize = snapSize;
    }

    private void validateMinimumAndInsets(Dimension minimum, Insets drag) {
        int minimumWidth = drag.left + drag.right;
        int minimumHeight = drag.top + drag.bottom;
        if (minimum.width < minimumWidth || minimum.height < minimumHeight) {
            String message = "Minimum size cannot be less than drag insets";
            throw new IllegalArgumentException(message);
        }
    }

    public void mouseMoved(MouseEvent e) {
        Component source = e.getComponent();
        Point location = e.getPoint();
        this.direction = 0;
        if (location.x < this.dragInsets.left) {
            this.direction += 2;
        }

        if (location.x > source.getWidth() - this.dragInsets.right - 1) {
            this.direction += 8;
        }

        if (location.y < this.dragInsets.top) {
            ++this.direction;
        }

        if (location.y > source.getHeight() - this.dragInsets.bottom - 1) {
            this.direction += 4;
        }

        if (this.direction == 0) {
            source.setCursor(this.sourceCursor);
        } else {
            int cursorType = (Integer)cursors.get(this.direction);
            Cursor cursor = Cursor.getPredefinedCursor(cursorType);
            source.setCursor(cursor);
        }

    }

    public void mouseEntered(MouseEvent e) {
        if (!this.resizing) {
            Component source = e.getComponent();
            this.sourceCursor = source.getCursor();
        }

    }

    public void mouseExited(MouseEvent e) {
        if (!this.resizing) {
            Component source = e.getComponent();
            source.setCursor(this.sourceCursor);
        }

    }

    public void mousePressed(MouseEvent e) {
        if (this.direction != 0) {
            this.resizing = true;
            Component source = e.getComponent();
            this.pressed = e.getPoint();
            SwingUtilities.convertPointToScreen(this.pressed, source);
            this.bounds = source.getBounds();
            if (source instanceof JComponent) {
                JComponent jc = (JComponent)source;
                this.autoscrolls = jc.getAutoscrolls();
                jc.setAutoscrolls(false);
            }

        }
    }

    public void mouseReleased(MouseEvent e) {
        this.resizing = false;
        Component source = e.getComponent();
        source.setCursor(this.sourceCursor);
        if (source instanceof JComponent) {
            ((JComponent)source).setAutoscrolls(this.autoscrolls);
        }

    }

    public void mouseDragged(MouseEvent e) {
        if (this.resizing) {
            Component source = e.getComponent();
            Point dragged = e.getPoint();
            SwingUtilities.convertPointToScreen(dragged, source);
            this.changeBounds(source, this.direction, this.bounds, this.pressed, dragged);
        }
    }

    protected void changeBounds(Component source, int direction, Rectangle bounds, Point pressed, Point current) {
        int x = bounds.x;
        int y = bounds.y;
        int width = bounds.width;
        int height = bounds.height;
        int drag;
        int maximum;
        if (2 == (direction & 2)) {
            drag = this.getDragDistance(pressed.x, current.x, this.snapSize.width);
            maximum = Math.min(width + x, this.maximumSize.width);
            drag = this.getDragBounded(drag, this.snapSize.width, width, this.minimumSize.width, maximum);
            x -= drag;
            width += drag;
        }

        if (1 == (direction & 1)) {
            drag = this.getDragDistance(pressed.y, current.y, this.snapSize.height);
            maximum = Math.min(height + y, this.maximumSize.height);
            drag = this.getDragBounded(drag, this.snapSize.height, height, this.minimumSize.height, maximum);
            y -= drag;
            height += drag;
        }

        Dimension boundingSize;
        if (8 == (direction & 8)) {
            drag = this.getDragDistance(current.x, pressed.x, this.snapSize.width);
            boundingSize = this.getBoundingSize(source);
            maximum = Math.min(boundingSize.width - x, this.maximumSize.width);
            drag = this.getDragBounded(drag, this.snapSize.width, width, this.minimumSize.width, maximum);
            width += drag;
        }

        if (4 == (direction & 4)) {
            drag = this.getDragDistance(current.y, pressed.y, this.snapSize.height);
            boundingSize = this.getBoundingSize(source);
            maximum = Math.min(boundingSize.height - y, this.maximumSize.height);
            drag = this.getDragBounded(drag, this.snapSize.height, height, this.minimumSize.height, maximum);
            height += drag;
        }

        source.setBounds(x, y, width, height);
        source.validate();
    }

    private int getDragDistance(int larger, int smaller, int snapSize) {
        int halfway = snapSize / 2;
        int drag = larger - smaller;
        drag += drag < 0 ? -halfway : halfway;
        drag = drag / snapSize * snapSize;
        return drag;
    }

    private int getDragBounded(int drag, int snapSize, int dimension, int minimum, int maximum) {
        while(dimension + drag < minimum) {
            drag += snapSize;
        }

        while(dimension + drag > maximum) {
            drag -= snapSize;
        }

        return drag;
    }

    private Dimension getBoundingSize(Component source) {
        if (source instanceof Window) {
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Rectangle bounds = env.getMaximumWindowBounds();
            return new Dimension(bounds.width, bounds.height);
        } else {
            return source.getParent().getSize();
        }
    }
}
