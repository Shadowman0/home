package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import model.Body;
import model.Vector;

public class KeyActions {
	public JComponent component;
	public Body body;

	public KeyActions(JComponent component, Body body) {
		super();
		this.component = component;
		this.body = body;
	}

	public void setKeyMaps() {
		component.getInputMap().put(KeyStroke.getKeyStroke("pressed UP"), "Fire");
		component.getInputMap().put(KeyStroke.getKeyStroke("released UP"), "Fire ceased");
		component.getActionMap().put("Fire", new MoveAction(new Vector(0, -1), 10000, body));
		component.getActionMap().put("Fire ceased", new MoveAction(new Vector(0, 0), 1, body));
	}
}

class MoveAction extends AbstractAction {

	public Vector direction;
	public double thrust;
	public Body body;

	public MoveAction(Vector direction, double thrust, Body body) {
		super();
		this.direction = direction;
		this.thrust = thrust;
		this.body = body;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		body.accelerate(direction, thrust);
		System.out.println("test");
	}
}