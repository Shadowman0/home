package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import gui.GuiBody;
import model.AbstractBody;
import model.Vector;

public class KeyActionsBody {
    public JComponent component;
    public AbstractBody body;
    private GuiBody guiBody;

    public KeyActionsBody(JComponent component, AbstractBody body, GuiBody guiBody) {
        super();
        this.component = component;
        this.body = body;
        this.guiBody = guiBody;
    }

    public void setKeyMaps() {
        component.getInputMap().put(KeyStroke.getKeyStroke("pressed UP"), "Fire");
        component.getInputMap().put(KeyStroke.getKeyStroke("released UP"), "Fire ceased");
        MoveAction fireAction = new MoveAction(new Vector(0, -1), 10000, body, guiBody, Color.MAGENTA) {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                guiBody.setColor(Color.MAGENTA);
            }
        };
        component.getActionMap().put("Fire", fireAction);
        fireAction = new MoveAction(new Vector(0, 0), 1, body, guiBody, Color.cyan) {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                guiBody.setColor(Color.cyan);
            }
        };
        component.getActionMap().put("Fire ceased", fireAction);
    }
}

class MoveAction extends AbstractAction {

    public Vector direction;
    public double thrust;
    public AbstractBody body;
    private GuiBody guiBody;

    public MoveAction(Vector direction, double thrust, AbstractBody body, GuiBody guiBody, Color color) {
        super();
        this.direction = direction;
        this.thrust = thrust;
        this.body = body;
        this.guiBody = guiBody;
        guiBody.setColor(color);

    }
    //
    // @Override
    // public void actionPerformed(ActionEvent e) {
    // // body.accelerate(direction, thrust);
    //
    // System.out.println("Fired");
    // }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}