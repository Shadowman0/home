package model;

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
		firstBody.addAccelerationByNeighborPart(secondBody, distance);
		secondBody.addAccelerationByNeighborPart(firstBody, distance);
	}

}
