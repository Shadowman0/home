package Controller;
import Model.*;

public class RocketLearnApp {
	
	public static void main(String[] args) {
		Simulation simulation =  new Simulation();
		while(true) {
		System.out.println(simulation.bodyList.toString());
		simulation.bodyList.doIterationStep(0.01);
		}
	}

}
