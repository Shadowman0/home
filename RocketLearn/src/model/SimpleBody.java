package model;

public abstract class SimpleBody extends AbstractBody {
	protected double mass;
	protected Vector position;
	protected Vector velocity;
	protected Vector acceleration;
	protected Vector accelerationLast;

	public void setVelocity(Vector velocity) {
		this.velocity = velocity;
	}

	public double getMass() {
		return mass;
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

	public double distance(SimpleBody body) {
		return position.calcDistance(body.getPosition());
	}

	public SimpleBody(double mass, Vector position, Vector velocity) {
		super();
		this.mass = mass;
		this.position = position;
		this.velocity = velocity;
		this.acceleration = new Vector(0, 0);
		this.accelerationLast = new Vector(0, 0);
	}

	public void resetAcceleration() {
		accelerationLast.setValue(acceleration);
		acceleration.setValue(new Vector(0, 0));
	}

	public void doTimeStep(double h) {
		velocity.addVector(acceleration, h);
		position.addVector(velocity, h);
	}

	public void doTimeStepLeapFrog(double h) {
		position.addVector(velocity, h);
		position.addVector(accelerationLast, h * h / 2);

		velocity.addVector(acceleration, h / 2);
		velocity.addVector(accelerationLast, h / 2);
	}

	public void addAccelerationByForce(Vector forceVector) {
		acceleration = acceleration.addVector2(forceVector.multByScalar(1 / getMass()));
	}

	public void calcInnerForces() {

	}

}