package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import model.rockets.Rocket;

public class GuiRocket extends GuiBody {

    public GuiRocket(Rocket rocket, Point offset, double scaling) {
        super(rocket, offset, scaling);
        setColor(Color.GREEN);
    }

    @Override
    void paintBody(Graphics g, double scaling, Point offset) {
        Graphics2D g2 = (Graphics2D) g;
        setScaledPosition(getBody().getPosition(), offset, scaling);
        g2.setPaint(color);
        g2.fillRect(position.x - 5, position.y - 5, 10, 10);

    }

}
