package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import model.rockets.Rocket;

public class GuiRocket extends GuiBody {

    public GuiRocket(Rocket rocket, double scaling) {
        super(rocket, scaling);
        setColor(Color.GREEN);
    }

    @Override
    void paintBody(Graphics g, double scaling, Point offset) {
        Graphics2D g2 = (Graphics2D) g;
        setScaledPosition(body.getPosition(), scaling);
        g2.setPaint(color);
        g2.fillRect(position.x - 5 - offset.x, position.y - 5 - offset.y, 10, 10);

    }

}
