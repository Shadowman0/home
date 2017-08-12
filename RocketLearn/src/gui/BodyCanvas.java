package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import model.BodyList;
import model.Planet;
import model.rockets.Rocket;

public class BodyCanvas extends JPanel {

    public List<GuiPlanet> guiPlanets = new ArrayList<>();
    public List<GuiRocket> guiRockets = new ArrayList<>();
    public List<GuiTrajectory> guiTrajectories = new ArrayList<>();
    public double scaling;
    public Point offset;
    // public GuiPlanet planet;
    private BodyList bodyList;

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        drawBodys(g);
    }

    // private void drawBodyTrajectories(Graphics g) {
    // for (GuiTrajectory guiTrajectory : guiTrajectories) {
    // guiTrajectory.paintBody(g, scaling);
    // }
    // }

    public BodyCanvas(BodyList bodyList, double scaling, Point offset) {
        this.bodyList = bodyList;
        this.scaling = scaling;
        this.offset = offset;
        createGuiBodys();
    }

    private void createGuiBodys() {
        for (Planet planet : bodyList.planets) {
            GuiPlanet guiPlanet = new GuiPlanet(
                    planet, scaling);
            guiPlanets.add(guiPlanet);

        }
        for (Rocket rocket : bodyList.rockets) {
            GuiRocket guiRocket = new GuiRocket(
                    rocket, scaling);
            guiRockets.add(guiRocket);

            GuiTrajectory guiTrajectory = new GuiTrajectory(
                    rocket, scaling);
            guiTrajectories.add(guiTrajectory);
        }
    }

    public void drawBodys(Graphics g) {
        for (GuiPlanet guiBody : guiPlanets) {
            guiBody.paintBody(g, scaling, offset);
        }
        for (GuiRocket guiBody : guiRockets) {
            guiBody.paintBody(g, scaling, offset);
        }
        for (GuiTrajectory guiTrajectory : guiTrajectories) {
            guiTrajectory.paintBody(g, scaling, offset);
        }

        // System.out.println(guiPlanets.get(0).position);
    }
}