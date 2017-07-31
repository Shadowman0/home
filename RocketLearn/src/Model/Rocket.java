package Model;

public class Rocket extends Body {

	public Rocket(double mass, Vector position, Vector velocity) {
		super(mass, position, velocity);
	}

	@Override
	public boolean isColliding(Planet body) {
		return false;
	}
	
	
	
	
}
