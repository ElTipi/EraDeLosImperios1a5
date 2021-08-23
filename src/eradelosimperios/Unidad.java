package eradelosimperios;

public class Unidad {

	private int salud;
	private Posicion posicionUnidad;
	private int monedas;
	private static final int VALOR_POCION = 25;
	private static final int MAX_SALUD = 100;
	private static final int CANT_INICIAL_MONEDAS = 250;
	
	
	public Unidad(Posicion posicion) {
		this.posicionUnidad = posicion;
		this.salud = MAX_SALUD;
		this.monedas = CANT_INICIAL_MONEDAS;
	}
	
	public int getSalud() {
		return this.salud;
	}
	
	public void setSalud(int salud) {
		this.salud = salud;
	}
	
	public int getMonedas() {
		return this.monedas;
	}
	
	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}
	
	public void setBotin(int botin) {
		this.monedas += botin;
	}
	
	public void setPosicion() {
		this.posicionUnidad.setX(this.posicionUnidad.getX() + 3);
		this.posicionUnidad.setY(this.posicionUnidad.getY() + 4);
	}

	
	public Posicion mostrarPosicion() {
		Posicion posicion = new Posicion (this.posicionUnidad.getX(), 
				this.posicionUnidad.getY());
		return posicion;
	}
	
	
	
	protected void roboBotin(Unidad otraUnidad) {
		if(otraUnidad.getSalud() == 0) {
			int botin = otraUnidad.getMonedas();
			otraUnidad.setMonedas(0);
			this.setBotin(botin);
		}
	}
	
	
	public void restablecerSalud() {
		if(this.getMonedas() > VALOR_POCION) {
			this.setMonedas(this.getMonedas() - VALOR_POCION);
			this.setSalud(100);
		}
	}
	
	
	
	public void hacerDanio(int danio) {
		this.salud -= danio;
		if (this.salud < 0)
			this.salud = 0;
	}

	
	public double distanciaEntreUnidades(Unidad otraUnidad) {
		return this.posicionUnidad.distanciaCon(otraUnidad.posicionUnidad);
	}
	
	
	
}
