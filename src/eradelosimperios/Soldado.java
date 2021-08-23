package eradelosimperios;

public class Soldado extends Unidad {

	private static final int DANIO = 20;
	private static final double DISTMINATQ = 0;
	private static final double DISTMAXATQ = 1.5;
	private static final double MAX_ATAQUES = 5;
	private int cantAtaques = 0;
	
	
	
	public Soldado(Posicion posicion) {
		super(posicion);
		// TODO Auto-generated constructor stub
	}

	
	public void soldadoAtaca(Unidad otraUnidad) {
		
		boolean distancias0A15 = 
				distanciaEntreUnidades(otraUnidad) >= DISTMINATQ &&
				distanciaEntreUnidades(otraUnidad) <= DISTMAXATQ;
		
		if (cantAtaques == MAX_ATAQUES) 
			soldadoDescansar();
		else if (otraUnidad.getSalud() > 0 && distancias0A15) {
			otraUnidad.hacerDanio(DANIO);
			super.roboBotin(otraUnidad);
			cantAtaques++;
		}
	}
	
	
	public int soldadoDescansar() {
		return cantAtaques = 0;
	}
	
	
}
