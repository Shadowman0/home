package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Timer;

import gui.MainWindow;
import model.Simulation;
import model.Vector;

public class RocketLearnApp {

    private static Timer timer;
    private static Simulation simulation;
    private static MainWindow mainWindow;
    private static KeyActionsBody keyActionsBody;
    private static KeyActionsGui keyActionsGui;
    private static MouseWheelEvent mouseWheelEvent;

    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        mainWindow = new MainWindow(simulation.bodyList);

        timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeStepAction();

            }
        });
        mainWindow.bodyCanvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                simulation.bodyList.planets.get(0).setPosition(new Vector(e.getPoint()));
            }
        });
        keyActionsBody = new KeyActionsBody(mainWindow.bodyCanvas, simulation.bodyList.rockets.get(0), mainWindow.bodyCanvas.guiRockets.get(0));
        keyActionsGui = new KeyActionsGui(mainWindow.bodyCanvas, mainWindow, timer);
        mouseWheelEvent = new MouseWheelEvent(mainWindow.bodyCanvas, mainWindow);
        timer.start();

    }

    static void timeStepAction() {
        simulation.bodyList.doIterationStep(0.01);
        mainWindow.bodyCanvas.repaint();
    }
}

// while (true) {
// try {
// Thread.currentThread().wait(30);
// simulation.bodyList.doIterationStep(0.01);
// System.out.println(simulation.bodyList.toString());
// mainWindow.bodyCanvas.planet.setScaledPosition(simulation.bodyList.rockets.get(0).getPosition(),
// 10, 1);
// } catch (InterruptedException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
// }
// while(true) {
// System.out.println(simulation.bodyList.toString());
// simulation.bodyList.doIterationStep(0.01);