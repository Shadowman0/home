package gui;

import java.awt.Graphics;
import java.awt.Point;

import model.AbstractBody;
import model.Vector;

public abstract class GuiBody {
    public Point position;
    public AbstractBody body;

    public GuiBody(AbstractBody body, double scaling) {
        super();
        this.body = body;
        setScaledPosition(body.getPosition(), scaling);
    }

    public void setScaledPosition(Vector vector, double scaling) {
        position = vector.toPoint(scaling);
    }

    abstract void paintBody(Graphics g, double scaling);

}
