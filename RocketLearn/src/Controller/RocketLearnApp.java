package Controller;
import javax.swing.JPanel;

import Gui.*;
import Model.*;

public class RocketLearnApp {
	public static void main(String[] args) {
		Simulation simulation =  new Simulation();
		MainWindow mainWindow = new MainWindow();
		JPanel panel = new JPanel();
		mainWindow.init();
//		while(true) {
//		System.out.println(simulation.bodyList.toString());
//		simulation.bodyList.doIterationStep(0.01);
//		}
	}

}
