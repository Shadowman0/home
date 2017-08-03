package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import Gui.*;
import Model.*;

public class RocketLearnApp {

	private static Timer timer;
	private static Simulation simulation;
	private static MainWindow mainWindow;
	private static KeyActions keyActions;

	public static void main(String[] args) {
		simulation = new Simulation();
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
		keyActions = new KeyActions(mainWindow.bodyCanvas, simulation.bodyList.rockets.get(0));
		keyActions.setKeyMaps();
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