package model.rockets;

import model.SimpleBody;
import model.Vector;

public class RocketSmall extends Rocket {
	private RocketEngine engine;
	private RocketFuelTank tank;
	private SimpleBody cargo;

	public RocketSmall(RocketEngine engine, RocketFuelTank tank, SimpleBody cargo, double strutlength) {
		super();
		this.engine = engine;
		this.tank = tank;
		this.cargo = cargo;
		addStrut(engine, tank, strutlength);
		addStrut(tank, cargo, strutlength);
	}

	public RocketSmall(double mass, Vector position, Vector velocity) {
		super();
		double partMass = mass/5;
		RocketEngine engine = new RocketEngine(partMass, position, velocity, thrust)
		RocketFuelTank tank;
		SimpleBody cargo;
		
		this.mass = mass;
		this.position = position;
		this.velocity = velocity;
		this.acceleration = new Vector(0, 0);
		this.accelerationLast = new Vector(0, 0);
		this.engine = engine;
		this.tank = tank;
		this.cargo = cargo;
		addStrut(engine, tank, strutlength);
		addStrut(tank, cargo, strutlength);

	}

}
