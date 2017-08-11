package model;

import java.util.ArrayList;

public class BodyList {
	public ArrayList<Planet> planets = new ArrayList();;
	public ArrayList<Rocket> rockets = new ArrayList();;

	public BodyList() {
		super();
	}

	@Override
	public String toString() {
		return "BodyList [planets=" + planets + ", rockets=" + rockets + "]";
	}

	public void createPlanet(double mass, Vector position, Vector velocity, double radius) {
		Planet planet = new Planet(mass, position, velocity, radius);
		planets.add(planet);

	}

	public void createRocket(double mass, Vector position, Vector velocity) {
		Rocket rocket = new Rocket(mass, position, velocity);
		rockets.add(rocket);

	}

	public void calculateAccelerations() {
		for (Planet planet1 : planets) {
			for (Planet planet2 : planets) {
				if (planet1 != planet2)
					planet1.addAccelerationByBody(planet2);
			}
		}

		for (Rocket rocket : rockets) {
			for (SimpleBody body : planets) {
				rocket.addAccelerationByBody(body);
			}
		}
	}

	public void doIterationStep(double h) {
		calculateAccelerations();
		for (SimpleBody body : planets) {
			body.doTimeStepLeapFrog(h);
		}
		for (Rocket body : rockets) {
			body.doTimeStepLeapFrog(h);
		}
		for (Rocket body : rockets) {
			for (Planet planet : planets) {
				planet.projectBody(body);
			}
		}
		resetAccelerations();

	}

	private void resetAccelerations() {
		for (SimpleBody body : planets) {
			body.resetAcceleration();
		}
		for (Rocket body : rockets) {
			body.resetAcceleration();
		}

	}

}
