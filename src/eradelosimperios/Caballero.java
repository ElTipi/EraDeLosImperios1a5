package eradelosimperios;

public class Caballero extends Unidad {

	private static final int DANIO = 30;
	private static final double DISTMINATQ = 1;
	private static final double DISTMAXATQ = 3;
	private static final double MAX_ATAQUES = 3;
	private boolean nivelEspantoCaballo = false;
	private int cantAtaques = 0;
	
	
	public Caballero(Posicion posicion) {
		super(posicion);
	}
	
	
	public boolean getNivelEspantoCaballo() {
		return this.nivelEspantoCaballo;
	}
	
	
	public void caballeroAtaca(Unidad otraUnidad) {
		
		boolean distancias1A3 = 
				distanciaEntreUnidades(otraUnidad) >= DISTMINATQ &&
				distanciaEntreUnidades(otraUnidad) <= DISTMAXATQ;
			
		if (otraUnidad.getSalud() > 0 && distancias1A3) {
			otraUnidad.hacerDanio(DANIO);
			super.roboBotin(otraUnidad);
			this.cantAtaques++;
			if(cantAtaques == MAX_ATAQUES)
				nivelEspantoCaballo = true;
				if (nivelEspantoCaballo) {
					caballoDesbocado();
					caballoTranquilizar();
				}
		}
		
	}
	
	
	public boolean caballoTranquilizar() {
		this.cantAtaques = 0;
		return nivelEspantoCaballo = false;
	}
	
	
	public void caballoDesbocado() {
		super.setPosicion();
	}
	
	
	
}
