package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

import model.Planet;
import model.Vector;

public class GuiPlanet extends GuiBody {
    private int radius;
    private Shape shape;
    private Planet body;

    public GuiPlanet(Planet planet, Point offset, double scaling) {
        super(planet, offset, scaling);
        this.body = planet;
        setScaledPosition(planet.getPosition(), planet.getRadius(), offset, scaling);
        repositionShape(planet, offset, scaling);
    }

    private void repositionShape(Planet planet, Point offset, double scaling) {
        shape = new Ellipse2D.Double(
                planet.getPosition().value[0] - planet.getRadius(),
                planet.getPosition().value[1] - planet.getRadius(),
                2 * planet.getRadius(),
                2 * planet.getRadius());
        AffineTransform at = new AffineTransform();
        at.scale(scaling, scaling);
        at.translate(offset.getX(), offset.getY());
        Path2D path = new Path2D.Double(shape);
        shape = path.createTransformedShape(at);
    }

    public void setScaledPosition(Vector vector, double radius, Point offset, double scaling) {
        super.setScaledPosition(vector, offset, scaling);
        this.radius = (int) Math.round(scaling * radius);
    }

    @Override
    public void paintBody(Graphics g, double scaling, Point offset) {
        Graphics2D g2 = (Graphics2D) g;
        setScaledPosition(getBody().getPosition(), ((Planet) getBody()).getRadius(),
                offset, scaling);
        g2.setPaint(Color.BLUE);
        repositionShape(body, offset, scaling);
        // g2.fill(shape);
        g2.fillRect(position.x, position.y, 10, 10);
        g2.fillOval(position.x - radius, position.y - radius, radius * 2, radius *
                2);
        System.out.println(radius);
    }
}