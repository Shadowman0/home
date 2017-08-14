package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;

import model.AbstractBody;

public class GuiSimpleBody extends GuiAbstractBody {
    private Color color;
    private Shape shape;
    private AbstractBody body;

    public GuiSimpleBody(Color color, Shape shape, AbstractBody body) {
        super();
        this.color = color;
        this.shape = shape;
        this.body = body;
    }

    @Override
    void paintBody(Graphics g, double scaling, Point offset) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(color);
        g2.draw(shape);

    }

    @Override
    public AbstractBody getBody() {
        return body;
    }

}
