package eradelosimperios;

public class Posicion {

	private double x;
	private double y;
	
	
	protected double getX() {
		return x;
	}

	protected void setX(double x) {
		this.x = x;
	}

	protected double getY() {
		return y;
	}

	protected void setY(double y) {
		this.y = y;
	}

	public Posicion(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}
	
	
		
	public double distanciaCon(Posicion otraPosicion) {
		return Math.sqrt(Math.pow(this.x - otraPosicion.x, 2)
				+ Math.pow(this.y - otraPosicion.y, 2));
	}

}
