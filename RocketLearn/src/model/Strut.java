package model;

public class Strut {

	private Body firstBody;
	private Body secondBody;
	private double distance;

	public Strut(Body firstBody, Body secondBody, double distance) {
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
