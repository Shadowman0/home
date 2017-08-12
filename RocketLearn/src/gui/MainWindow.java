package gui;

import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;

import model.BodyList;

public class MainWindow {
    JFrame frame = new JFrame("RocketTest");
    private double scaling = 1;
    public BodyCanvas bodyCanvas;

    public MainWindow(BodyList bodyList) {
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
                Toolkit.getDefaultToolkit().getScreenSize().height / 2);

        frame.setVisible(true);
        bodyCanvas = new BodyCanvas(bodyList, scaling);
        frame.add(bodyCanvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        bodyCanvas.drawBodys(g);
    }

}
