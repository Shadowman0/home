package Model;

import java.util.ArrayList;

public abstract class Body {
	protected double mass;
	protected Vector position;
	protected Vector velocity;
	protected Vector acceleration;

	public double getMass() {
		return mass;
	}

	public Vector getPosition() {
		return position;
	}

	public void setPosition(Vector position) {
		this.position = position;
	}

	public double distance(Body body) {
		return position.calcDistance(body.getPosition());
	}

	public Body(double mass, Vector position, Vector velocity) {
		super();
		this.mass = mass;
		this.position = position;
		this.velocity = velocity;
	}

	public void resetAcceleration() {
		acceleration.setValue(0, 0);
	}

	public void addAccelerationByBody(Body body) {
		Vector position = body.getPosition();
		double mass = body.getMass();
		double distance = this.position.calcDistance(body.getPosition());
		Vector deltaA = position.calcNormedDistance(position).multByScalar(PhysicConstants.G * mass);
		acceleration.addVector(deltaA);
	}

	public void doTimeStep(double h) {
		velocity.addVector(acceleration, h);
		position.addVector(velocity, h);
	}

	abstract public boolean isColliding(Planet body);

	

}
