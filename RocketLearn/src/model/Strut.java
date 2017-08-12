package model;

import model.forces.Forces;

public class Strut {

	private SimpleBody firstBody;
	private SimpleBody secondBody;
	private double distance;

	public Strut(SimpleBody firstBody, SimpleBody secondBody, double distance) {
		super();
		this.firstBody = firstBody;
		this.secondBody = secondBody;
		this.distance = distance;
	}

	public void pushPull() {
		Vector forceVector = Forces.hookForceBetweenBodys(firstBody, secondBody, distance);
		firstBody.addAccelerationByForce(forceVector);
		secondBody.addAccelerationByForce(forceVector);
	}

}
