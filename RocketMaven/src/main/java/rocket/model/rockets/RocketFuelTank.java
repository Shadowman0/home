package rocket.model.rockets;

import rocket.model.AbstractBody;
import rocket.model.SimpleBody;
import rocket.model.Vector;

public class RocketFuelTank extends SimpleBody {
	private double fuelMass;
	private double fuelCapacity;
	private double dryMass;

	public RocketFuelTank(double mass, Vector position, Vector velocity, double fuelMass, double fuelCapacity) {
		super(mass, position, velocity);
		this.fuelMass = fuelMass;
		this.fuelCapacity = fuelCapacity;
		this.dryMass = mass - fuelMass;
	}

	@Override
	public boolean isColliding(AbstractBody body) {
		// TODO Auto-generated method stub
		return false;
	}

}