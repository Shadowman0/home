package Gui;

import javax.swing.JFrame;

public class MainWindow {
	JFrame frame = new JFrame("RocketTest");
	
	public void init() {
		frame.setSize(500, 500);
		frame.setVisible(true);
		new BodyCanvas();
	}
	public MainWindow(){

	}
}
