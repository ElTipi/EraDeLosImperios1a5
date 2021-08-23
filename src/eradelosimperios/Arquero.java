package eradelosimperios;

public class Arquero extends Unidad {
	
	private static final int DANIO = 7;
	private static final double DISTMINATQ = 5;
	private static final double DISTMAXATQ = 25;
	private int cantFlechas = 12;
	
	
	public int getCantFlechas() {
		return this.cantFlechas;
	}
	
	
	public Arquero(Posicion posicion) {
		super(posicion);
	}
	
	public void arqueroAtaca(Unidad otraUnidad) {
		
		boolean distancias5A25 = 
				distanciaEntreUnidades(otraUnidad) >= DISTMINATQ &&
				distanciaEntreUnidades(otraUnidad) <= DISTMAXATQ;
				
		if (cantFlechas == 0) {
			recargarFlechas();
		} else if (otraUnidad.getSalud() > 0 && distancias5A25) {
			otraUnidad.hacerDanio(DANIO);
			super.roboBotin(otraUnidad);
			cantFlechas--;
		}
	}
	
	
	public int recargarFlechas() {
		return cantFlechas = 12;
	}

	
	
}
