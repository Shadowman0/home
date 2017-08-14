package gui;

import java.awt.Graphics;
import java.awt.Point;

import model.AbstractBody;

public abstract class GuiAbstractBody {
    abstract void paintBody(Graphics g, double scaling, Point offset);

    abstract public AbstractBody getBody();

}
