package Model;

import java.awt.Graphics;
import java.util.ArrayList;

public abstract class Body {
	protected double mass;
	protected Vector position;
	protected Vector velocity;
	protected Vector acceleration;

	public double getMass() {
		return mass;
	}

	

	@Override
	public String toString() {
		return "Body [mass=" + mass + ", position=" + position + ", velocity=" + velocity + ", acceleration="
				+ acceleration + "]";
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
		this.acceleration = new Vector(0, 0);
	}

	public void resetAcceleration() {
		acceleration.setValue(0, 0);
	}

	public void addAccelerationByBody(Body body) {
		Vector position = body.getPosition();
//		System.out.println(body);	
		
		double mass = body.getMass();
		Vector deltaA = this.position.calcNormedDistance(position);
		deltaA = deltaA.multByScalar(-PhysicConstants.G * mass);
		this.acceleration.addVector(deltaA);
	}

	public void doTimeStep(double h) {
		velocity.addVector(acceleration, h);
		position.addVector(velocity, h);
	}

	abstract public boolean isColliding(Planet body);


	

}
