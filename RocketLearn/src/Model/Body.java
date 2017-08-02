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



	public Vector getVelocity() {
		return velocity;
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
		
//		System.out.println(body);	
		
		Vector deltaA = position.addVector2(body.getPosition(), -1);
//		System.out.println(deltaA);
		double scalar = -Math.pow(deltaA.norm(), -3)*PhysicConstants.G * body.getMass();
		deltaA = deltaA.multByScalar(scalar);
//		if (deltaA.norm()>2000) {
//			deltaA = new Vector(0,0);
//		}
//		System.out.println(deltaA.norm());
		if (!body.isColliding(this)) {
			this.acceleration.addVector(deltaA);
		}
	}

	public void doTimeStep(double h) {
		velocity.addVector(acceleration, h);
		position.addVector(velocity, h);
//		System.out.println(this);
	}

	abstract public boolean isColliding(Body body);


	

}
