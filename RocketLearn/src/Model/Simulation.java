package Model;

public class Simulation {
	public BodyList bodyList;
	
	public Simulation(){
		bodyList= new BodyList();
		bodyList.createPlanet(100, new Vector(300, 500),new Vector(0,0), 1);
		bodyList.createRocket(1, new Vector(600, 500), new Vector(0,100));
		bodyList.createRocket(1, new Vector(900, 1000), new Vector(-100,100));
		bodyList.createRocket(1, new Vector(300, 500), new Vector(100,100));
		bodyList.createRocket(1, new Vector(200, 500), new Vector(0,200));
	}
	
	
	
}
