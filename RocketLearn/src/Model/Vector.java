package Model;

public class Vector {
	public double[] value = new double[2] ;
	
	
	Vector(double x, double y) {
		setValue(x, y);
	}	
	
	Vector(Vector vector) {
		setValue(vector.value[0], vector.value[1]);
	}
	
	public void setValue(double x,double y) {
		value[0] = x;
		value[1] = y;
	}
	public void setValue(Vector vector) {
		value[0] = vector.value[0];
		value[0] = vector.value[0];
	}
	public Vector multByScalar(double scalar) {
		return new Vector(value[0]*scalar,value[1]*scalar); 
		
	}
	
	public void addVector(Vector vector) {
		this.value[0] += vector.value[0];
		this.value[1] += vector.value[1];
	}
	public void addVector(Vector vector, double scalar) {
		this.value[0] += scalar*vector.value[0];
		this.value[1] += scalar*vector.value[1];
	}
	
	
	public double calcDistance(Vector vector) {
		return Math.sqrt( vector.value[0]*vector.value[0] 
				+ vector.value[1]*vector.value[1]  );
	}
	public double norm() {
		return calcDistance(new Vector(0,0));
	}
	
	public Vector calcNormedDistance(Vector vector) {
		double distance = calcDistance(vector);
		return multByScalar(Math.pow(distance, 3));
		
	}

}
