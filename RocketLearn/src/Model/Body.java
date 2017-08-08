package Model;

public abstract class Body {
	protected double mass;
	protected Vector position;
	protected Vector velocity;
	protected Vector orientation = new Vector(0, -1);
	protected Vector acceleration;
	protected Vector accelerationDefault = new Vector(0, 0);
	protected Vector accelerationLast;

	public double getMass() {
		return mass;
	}

	@Override
	public String toString() {
		return "Body [mass=" + mass + ", position=" + position + ", velocity=" + velocity + ", acceleration="
				+ acceleration + "]";
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

	public double distance(Body body) {
		return position.calcDistance(body.getPosition());
	}

	public Body(double mass, Vector position, Vector velocity) {
		super();
		this.mass = mass;
		this.position = position;
		this.velocity = velocity;
		this.acceleration = new Vector(0, 0);
		this.accelerationLast = new Vector(0, 0);
	}

	public void resetAcceleration() {
		accelerationLast.setValue(acceleration);
		acceleration.setValue(accelerationDefault);
	}

	public void accelerate(Vector direction, double scalar) {
		accelerationDefault.setValue(direction.multByScalar(scalar));
	}

	public void addAccelerationByBody(Body body) {

		Vector deltaA = position.addVector2(body.getPosition(), -1);
		double scalar = -Math.pow(deltaA.norm(), -3) * PhysicConstants.G * body.getMass();
		deltaA = deltaA.multByScalar(scalar);
		if (!body.isColliding(this)) {
			this.acceleration.addVector(deltaA);
		}
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

	abstract public boolean isColliding(Body body);

}
