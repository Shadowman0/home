package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import Gui.*;
import Model.*;

public class RocketLearnApp {
	
	private static Timer timer;
	private static Simulation simulation;
	private static MainWindow mainWindow;
	
	
	public static void main(String[] args) {
		simulation = new Simulation();
		mainWindow = new MainWindow();	
		timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	timeStepAction();
            	
            }
        });
		timer.start();

	}
	static void timeStepAction() {
		simulation.bodyList.doIterationStep(0.01);
//		System.out.println(simulation.bodyList.toString());
		mainWindow.bodyCanvas.planet.setScaledPosition(simulation.bodyList.rockets.get(0).getPosition(), 100, 0.5);
		mainWindow.bodyCanvas.repaint();
	}
}



//while (true) {
//try {
//	Thread.currentThread().wait(30);
//	simulation.bodyList.doIterationStep(0.01);
//	System.out.println(simulation.bodyList.toString());
//	mainWindow.bodyCanvas.planet.setScaledPosition(simulation.bodyList.rockets.get(0).getPosition(), 10, 1);
//} catch (InterruptedException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
//}
//while(true) {
//System.out.println(simulation.bodyList.toString());
//simulation.bodyList.doIterationStep(0.01);