package model.forces;

import model.AbstractBody;
import model.Vector;

public class HookForce implements IForce {
	private double desiredDistance;

	public HookForce(double desiredDistance) {
		super();
		this.desiredDistance = desiredDistance;
	}

	@Override
	public Vector calcForceBetweenBodys(AbstractBody body1, AbstractBody body2) {
		// TODO Auto-generated method stub
		return null;
	}
}
