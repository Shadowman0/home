package Model;

import java.util.ArrayList;
import java.util.List;

public class RocketPart extends Body {

	private List<RocketPart> neighbourParts = new ArrayList<>();

	public RocketPart(double mass, Vector position, Vector velocity) {
		super(mass, position, velocity);
	}

	public void addNeighbour(RocketPart part) {
		neighbourParts.add(part);
	}

	@Override
	public boolean isColliding(Body body) {
		// TODO Auto-generated method stub
		return false;
	}

}
