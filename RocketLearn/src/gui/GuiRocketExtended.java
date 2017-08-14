package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import model.rockets.Rocket;

public class GuiRocketExtended extends GuiAbstractBody {

    private Rocket body;

    public Rocket getBody() {
        return body;
    }

    public GuiRocketExtended(Rocket rocket, Point offset, double scaling) {
        // super(rocket, offset, scaling);
        // TODO Auto-generated constructor stub
    }

    @Override
    void paintBody(Graphics g, double scaling, Point offset) {
        // TODO Auto-generated method stub
        Graphics2D g2 = (Graphics2D) g;
        // setScaledPosition(getBody().getPosition(), offset, scaling);
        // g2.setPaint(color);
        // g2.fillRect(position.x - 5, position.y - 5, 10, 10);
    }

}
