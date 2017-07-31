package Model;

public class Simulation {
	public BodyList bodyList;
	
	public Simulation(){
		bodyList= new BodyList();
		bodyList.createPlanet(10, new Vector(1, 0),new Vector(0,0), 1);
		bodyList.createRocket(1, new Vector(10,0), new Vector(0,0.3));
		
	}
	
	
	
}
