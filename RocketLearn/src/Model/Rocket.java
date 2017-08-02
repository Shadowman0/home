package Model;

public class Rocket extends Body {

	public Rocket(double mass, Vector position, Vector velocity) {
		super(mass, position, velocity);
	}

	@Override
	public boolean isColliding(Body body) {
		return false;
	}
	
	
	
	
}
