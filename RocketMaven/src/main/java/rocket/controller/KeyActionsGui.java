package rocket.controller;

import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import rocket.gui.MainWindow;

public class KeyActionsGui {
    public JComponent component;
    public MainWindow mainWindow;
    public Timer timer;

    public KeyActionsGui(JComponent component, MainWindow mainWindow, Timer timer) {
        super();
        this.component = component;
        this.mainWindow = mainWindow;
        this.timer = timer;
        setKeyMapsGuiMovement();
        SetKeyMaps();
    }

    private void SetKeyMaps() {
        component.getInputMap().put(KeyStroke.getKeyStroke("pressed SPACE"), "Toggle Timer");
        AbstractAction action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timer.isRunning())
                    timer.stop();
                else
                    timer.start();

            }
        };
        component.getActionMap().put("Toggle Timer", action);

    }

    private void setKeyMapsGuiMovement() {
        GuiMoveAction action;
        component.getInputMap().put(KeyStroke.getKeyStroke("pressed W"), "Up");
        action = new GuiMoveAction(new Point(0, -10), component, mainWindow);
        component.getActionMap().put("Up", action);
        component.getInputMap().put(KeyStroke.getKeyStroke("pressed A"), "Left");
        action = new GuiMoveAction(new Point(-10, 0), component, mainWindow);
        component.getActionMap().put("Left", action);
        component.getInputMap().put(KeyStroke.getKeyStroke("pressed D"), "Right");
        action = new GuiMoveAction(new Point(10, 0), component, mainWindow);
        component.getActionMap().put("Right", action);
        component.getInputMap().put(KeyStroke.getKeyStroke("pressed S"), "Down");
        action = new GuiMoveAction(new Point(0, 10), component, mainWindow);
        component.getActionMap().put("Down", action);
    }

}

class GuiMoveAction extends AbstractAction {
    public Point offsetToAdd;
    public JComponent component;
    private MainWindow mainWindow;

    public GuiMoveAction(Point offsetToAdd, JComponent component, MainWindow mainWindow) {
        super();
        this.offsetToAdd = offsetToAdd;
        this.component = component;
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainWindow.bodyCanvas.offset.translate(offsetToAdd.x, offsetToAdd.y);
        mainWindow.bodyCanvas.repaint();
        System.out.println(offsetToAdd);
    }

}