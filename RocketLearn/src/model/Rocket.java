package model;

import java.util.ArrayList;
import java.util.List;

public class Rocket extends Body {

	private List<Strut> struts = new ArrayList<>();

	public Rocket(double mass, Vector position, Vector velocity) {
		super(mass, position, velocity);
	}

	public void addStrut(Body firstBody, Body secondBody, double length) {
		struts.add(new Strut(firstBody, secondBody, length));
	}

	@Override
	public boolean isColliding(Body body) {
		return false;
	}

	@Override
	public void calcInnerForces() {
		// TODO Auto-generated method stub
		for (Strut strut : struts) {
			strut.pushPull();
		}
	}

}
