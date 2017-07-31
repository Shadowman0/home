package Model;

public class Planet extends Body {
	private double radius;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Planet(double mass, Vector position, Vector velocity, double radius) {
		super(mass, position, velocity);
		this.radius = radius;
		
	}
	@Override
	public boolean isColliding(Planet body) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean isColliding(Body body) {
		return distance(body) <= radius;
	}
	
	public void projectBody(Body body) {
		if (isColliding(body)) {
			Vector distanceVector = body.getPosition();
			distanceVector.addVector(position, -1);
			double norm = distanceVector.norm();
			Vector newPosition = new Vector(position);
			newPosition.addVector(distanceVector, 1/norm);
			body.setPosition(newPosition);	
		}
	}


	

}
