package model.rockets;

import model.AbstractBody;
import model.SimpleBody;
import model.Vector;

public class RocketEngine extends SimpleBody {
	private double thrust;

	private Vector direction;
	private double angle;
	private double maxAngle;

	public RocketEngine(double mass, Vector position, Vector velocity, double thrust, Vector direction, double angle,
			double maxAngle) {
		super(mass, position, velocity);
		this.thrust = thrust;
		this.direction = direction;
		this.angle = angle;
		this.maxAngle = maxAngle;
	}

	public RocketEngine(double mass, Vector position, Vector velocity, double thrust) {
		super(mass, position, velocity);
		this.thrust = thrust;
		this.direction = new Vector(0, -1);
		this.angle = 0;
		this.maxAngle = Math.PI / 180 * 10;
	}

	@Override
	public boolean isColliding(AbstractBody body) {
		// TODO Auto-generated method stub
		return false;
	}

}