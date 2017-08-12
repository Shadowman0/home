package model.rockets;

import model.SimpleBody;
import model.Vector;

public class RocketSmall extends Rocket {
	private RocketEngine engine;
	private RocketFuelTank tank;
	private SimpleBody cargo;

	public RocketSmall(RocketEngine engine, RocketFuelTank tank, SimpleBody cargo, double strutLength) {
		super();
		this.engine = engine;
		this.tank = tank;
		this.cargo = cargo;
		addStrut(engine, tank, strutLength);
		addStrut(tank, cargo, strutLength);
	}

	public RocketSmall(double mass, Vector position, Vector velocity) {
		super();
		double partMass = mass / 5;
		double strutLength = 1;

		Vector defaultPosition = new Vector(0, 0);
		Vector defaultVelocity = new Vector(0, 0);
		RocketEngine engine = new RocketEngine(partMass, defaultPosition, defaultVelocity, 1);
		RocketFuelTank tank = new RocketFuelTank(partMass, defaultPosition, defaultVelocity, partMass / 9 * 8,
				partMass / 9 * 8);
		SimpleBody cargo = new SimpleBody(partMass, defaultVelocity, defaultVelocity);
		this.engine = engine;
		this.tank = tank;
		this.cargo = cargo;
		addStrut(engine, tank, strutLength);
		addStrut(tank, cargo, strutLength);

	}

}
