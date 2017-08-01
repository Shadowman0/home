package Gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import Model.Rocket;

public class GuiRocket extends GuiBody {

	public GuiRocket(Rocket rocket, double scaling) {
		super(rocket,scaling);
	}

	@Override
	void paintBody(Graphics g,double scaling) {
		Graphics2D g2 = (Graphics2D) g;
		setScaledPosition(body.getPosition(), scaling);
        g2.setPaint(Color.RED);
        g2.fillRect(position.x, position.y, 10, 10);
	}

}
