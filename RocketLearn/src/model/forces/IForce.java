package model.forces;

import model.AbstractBody;
import model.Vector;

public interface IForce {
	Vector calcForceBetweenBodys(AbstractBody body1, AbstractBody body2);
}
