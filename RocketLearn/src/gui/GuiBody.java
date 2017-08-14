package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import model.AbstractBody;
import model.Vector;

public abstract class GuiBody {
    public Point position;
    protected AbstractBody body;

    public AbstractBody getBody() {
        return body;
    }

    protected Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public GuiBody(AbstractBody body, Point offset, double scaling) {
        super();
        this.body = body;
        setScaledPosition(body.getPosition(), offset, scaling);
    }

    public void setScaledPosition(Vector vector, Point offset, double scaling) {
        position = vector.toPointWithOffset(scaling, offset);
    }

    abstract void paintBody(Graphics g, double scaling, Point offset);

}
