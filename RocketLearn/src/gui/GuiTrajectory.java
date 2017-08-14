package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import model.AbstractBody;
import model.Vector;

public class GuiTrajectory extends GuiBody {

    public GuiTrajectory(AbstractBody body, Point offset, double scaling) {
        super(body, offset, scaling);
    }

    List<Vector> dotsReal = new ArrayList<>();
    List<Point> dots = new ArrayList<>();

    private void setScaledPosition(double scaling, Point offset) {
        dots = new ArrayList<>();
        for (Vector vector : dotsReal) {
            dots.add(vector.toPointWithOffset(scaling, offset));
        }
    }

    @Override
    void paintBody(Graphics g, double scaling, Point offset) {
        // TODO Auto-generated method stub
        dotsReal.add(getBody().getPosition());
        Graphics2D g2 = (Graphics2D) g;
        setScaledPosition(scaling, offset);
        g2.setPaint(Color.YELLOW);
        int x1 = dots.get(0).x;
        int y1 = dots.get(0).y;
        for (Point point : dots) {
            int x2 = point.x;
            int y2 = point.y;
            g2.drawLine(x1, y1, x2, y2);
            x1 = x2;
            y1 = y2;
        }
    }

}
