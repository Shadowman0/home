package model;

public abstract class AbstractBody {

	public abstract double getMass();

	public abstract Vector getVelocity();

	public abstract void setVelocity(Vector position);

	public abstract Vector getPosition();

	public abstract void setPosition(Vector position);

	public abstract void resetAcceleration();

	public abstract void addAccelerationByForce(AbstractBody body);

	// public abstract void accelerate(Vector direction, double scalar);

	public double distance(AbstractBody body) {

		return getPosition().calcDistance(body.getPosition());
	}

	abstract public void doTimeStep(double h);

	abstract public void doTimeStepLeapFrog(double h);

	abstract public boolean isColliding(AbstractBody body);

	abstract public void calcInnerForces();

	@Override
	public String toString() {
		return "Body [mass=" + getMass() + ", position=" + getPosition() + ", velocity=" + getVelocity() + "]";
	}

}
