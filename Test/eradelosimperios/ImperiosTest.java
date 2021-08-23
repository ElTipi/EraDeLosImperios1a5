package eradelosimperios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ImperiosTest {

	Posicion pos0, pos1, pos4, pos31, pos10, pos60;
	Caballero c1, c2, c3, c4, c5;
	Arquero a1, a2, a3;
	Soldado s1, s2, s3;
	
	@Before
	public void setup() {
		
		pos1 = new Posicion(1,1);
		pos4 = new Posicion(3,3);
		pos31 = new Posicion(31,31);
		pos10 = new Posicion(10,10);
		pos60 = new Posicion(60,60);
		pos0 = new Posicion(0,0);
		c1 = new Caballero(pos0);
		a1 = new Arquero(pos0);
		s1 = new Soldado(pos0);
		c2 = new Caballero(pos4);
		a2 = new Arquero(pos31);
		s2 = new Soldado(pos60);
		a3 = new Arquero(pos1);
		s3 = new Soldado(pos10);
		c4 = new Caballero(pos60);
		c5 = new Caballero(pos10);
	}
	
	
	@Test
	public void objetosNotNulltest() {
		assertNotNull(pos1);
		assertNotNull(c1);
	}
	
	
	@Test
	public void saludCaballero100Test() {
		assertTrue(c1.getSalud() == 100);
	}
	
	
	@Test
	public void quitarSaludCaballeroTest() {
		c1.hacerDanio(30);
		assertEquals(70, c1.getSalud());
	}
	
	@Test
	public void quitarSaludMayor100Test() {
		c1.hacerDanio(110);
		assertEquals(0, c1.getSalud());
	}
	
	@Test
	public void caballeroAtacaEntre1y3Test() {
		c1.caballeroAtaca(a3);
		assertEquals(70, a3.getSalud());
	}
	
	
	@Test
	public void caballeroAtacaArqueroCerca0Test() {
		c1.caballeroAtaca(a1);
		assertTrue(a1.getSalud() == 100);
		assertEquals(100, a1.getSalud());
	}
	
	
	@Test
	public void arqueroAtacaSoldadoyQuita7Test() {
		a1.arqueroAtaca(s3);
		assertEquals(93, s3.getSalud());
	}
	
	
	
	@Test
	public void arqueroAtacaCaballerofueraDeRangoMenos5Mas25Test() {
		a1.arqueroAtaca(c2);
		assertTrue(c2.getSalud() == 100);
		assertEquals(100, c2.getSalud());
	}
	
	
	@Test
	public void arqueroAtacaCaballerofueraMayor25Test() {
		a1.arqueroAtaca(c4);
		assertTrue(c4.getSalud() == 100);
		assertEquals(100, c4.getSalud());
	}
	
	
	@Test
	public void arqueroAtaca10VecesTest() {
		a1.arqueroAtaca(s3);
		a1.arqueroAtaca(c5);
		a1.arqueroAtaca(s3);
		a1.arqueroAtaca(c5);
		a1.arqueroAtaca(s3);
		a1.arqueroAtaca(c5);
		a1.arqueroAtaca(s3);
		a1.arqueroAtaca(c5);
		a1.arqueroAtaca(s3);
		a1.arqueroAtaca(c5);
		assertEquals(2, a1.getCantFlechas());
	}
	
	@Test
	public void arqueroAtaca12VecesTest() {
		
		a1.arqueroAtaca(s3);
		a1.arqueroAtaca(c5);
		a1.arqueroAtaca(s3);
		a1.arqueroAtaca(c5);
		a1.arqueroAtaca(s3);
		a1.arqueroAtaca(c5);
		a1.arqueroAtaca(s3);
		a1.arqueroAtaca(c5);
		a1.arqueroAtaca(s3);
		a1.arqueroAtaca(c5);
		a1.arqueroAtaca(s3);
		a1.arqueroAtaca(c5);
		
		assertEquals(0, a1.getCantFlechas());
		assertEquals(58, s3.getSalud());
		assertEquals(58, c5.getSalud());
		
		a1.arqueroAtaca(s3);
		assertEquals(58, s3.getSalud());
		a1.arqueroAtaca(s3);
		assertEquals(51, s3.getSalud());
	}
	
	@Test
	public void caballeroAtaca2VecesTest() {
		c1.caballeroAtaca(a3);
		c1.caballeroAtaca(a3);
		assertFalse(c1.getNivelEspantoCaballo());
	}
	
	@Test
	public void caballeroAtaca3VecesYSeEspantaCaballoTest() {
		
		c1.caballeroAtaca(a3);
		c1.caballeroAtaca(a3);
		c1.caballeroAtaca(a3); //al atacar por tercera vez dentro
		//del mismo metodo caballeroAtaca controla si el nivel
		//de espanto del caballo llego a 3. Como es true, se espanta
		//se traslada 3,4 posiciones y luego se tranquiliza
		//por lo que el nivel de Espanto del caballo sera False.
		assertFalse(c1.getNivelEspantoCaballo());
	}
	
	
	@Test
	public void caballeroAtacaMataArqueroYLeRobaTest() {
		a3.setSalud(50);
		assertEquals(50, a3.getSalud());
		assertEquals(250, a3.getMonedas());
		
		c1.caballeroAtaca(a3);
		c1.caballeroAtaca(a3);
		
		assertEquals(0, a3.getSalud());
		c1.roboBotin(a3);
		assertFalse(c1.getNivelEspantoCaballo());
		assertEquals(500, c1.getMonedas());
		assertEquals(0, a3.getMonedas());
	}
	
	@Test
	public void caballoSeEspantaNuevaPosicionTest() {
		assertEquals("(0.0,0.0)", c1.mostrarPosicion().toString());
		c1.caballeroAtaca(a3);
		c1.caballeroAtaca(a3);
		c1.caballeroAtaca(a3);
		assertFalse(c1.getNivelEspantoCaballo());
		assertEquals("(3.0,4.0)", c1.mostrarPosicion().toString());
	}
	
	@Test
	public void arqueroRestableceSaludConPocionTest() {
		assertEquals(100, a3.getSalud());
		c1.caballeroAtaca(a3);
		assertEquals(70, a3.getSalud());
		a3.restablecerSalud();
		assertEquals(100, a3.getSalud());
	}
	
	@Test
	public void arqueroNoPuedeRestablecerSaludPorNoTenerMonedasSuficientes() {
		a3.setMonedas(10);
		assertEquals(100, a3.getSalud());
		c1.caballeroAtaca(a3);
		assertEquals(70, a3.getSalud());
		a3.restablecerSalud();
		assertEquals(70, a3.getSalud());
	}
	
}
