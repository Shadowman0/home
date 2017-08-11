package model;

import java.util.ArrayList;
import java.util.List;

public class Rocket extends AbstractBody {

	private List<Strut> struts = new ArrayList<>();

	private List

	public Rocket(double mass, Vector position, Vector velocity) {
		super(mass, position, velocity);
	}

	public void addStrut(SimpleBody firstBody, SimpleBody secondBody, double length) {
		struts.add(new Strut(firstBody, secondBody, length));
	}

	@Override
	public boolean isColliding(SimpleBody body) {
		return false;
	}

	@Override
	public void calcInnerForces() {
		// TODO Auto-generated method stub
		for (Strut strut : struts) {
			strut.pushPull();
		}
	}

	@Override
	public void setVelocity(Vector position) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAccelerationByBody(AbstractBody body) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isColliding(AbstractBody body) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getMass() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector getVelocity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPosition(Vector position) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetAcceleration() {
		// TODO Auto-generated method stub

	}

	@Override
	public void accelerate(Vector direction, double scalar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doTimeStep(double h) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doTimeStepLeapFrog(double h) {
		// TODO Auto-generated method stub

	}

}
