package controller;

import java.awt.event.MouseWheelListener;

import javax.swing.JComponent;

import gui.MainWindow;

public class MouseWheelEvent implements MouseWheelListener {
    public JComponent component;
    public MainWindow mainWindow;

    public MouseWheelEvent(JComponent component, MainWindow mainWindow) {
        super();
        this.component = component;
        this.mainWindow = mainWindow;
        mainWindow.bodyCanvas.addMouseWheelListener(this);
    }

    @Override
    public void mouseWheelMoved(java.awt.event.MouseWheelEvent e) {
        // TODO Auto-generated method stub
        System.out.println(e.getPoint());
        mainWindow.bodyCanvas.scaling += e.getWheelRotation() * 0.05;
        mainWindow.bodyCanvas.repaint();

    }
}