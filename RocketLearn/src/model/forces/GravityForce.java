package model.forces;

import model.AbstractBody;
import model.PhysicConstants;
import model.Vector;

public class GravityForce implements IForce {

	@Override
	public Vector calcForceBetweenBodys(AbstractBody body1, AbstractBody body2) {
		Vector deltaA = new Vector(body1.getPosition().addVector2(body2.getPosition(), -1));
		if (!(deltaA.norm() == 0)) {
			double scalar = -Math.pow(deltaA.norm(), -3) * PhysicConstants.GRAVITY_CONSTANT * body1.getMass()
					* body2.getMass();
			deltaA = deltaA.multByScalar(scalar);
			if (!body2.isColliding(body1)) {
				return deltaA;
			}
		}
		return new Vector(0, 0);
	}

}
