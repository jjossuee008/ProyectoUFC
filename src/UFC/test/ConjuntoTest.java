package UFC.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import UFC.peleadores.ConjuntoPeleadores;
import UFC.peleadores.Peleadores;

/**
 * Pruebas de funcionamiento de los diferentes metodos de {@link ConjuntoPeleadores}.
 * @author Josué Mateos (jjossuee008)
 * @version 1.0 (18032026)
 */
class ConjuntoTest {
	
	/** Guarda los peleadores para hacer las pruebas */
	ConjuntoPeleadores almacen;
	/** Peleador que se usara en las pruebas */
	Peleadores ilia;
	/** Peleador que se usara en las pruebas */
	Peleadores mcGregor;
	
	/**
	 * Inicializa el almacen y los distintos peleadores con sus datos.
	 */
	@BeforeEach
	void setUp() {
		almacen = new ConjuntoPeleadores();
		mcGregor  = new Peleadores("McGregor", "12", 22, 6, 19);
		ilia = new Peleadores("Topuria", "C", 15, 0, 8);
	}
	
	/**
	 * Comprueba que se añade de forma correcta un peleador al almacen.
	 */
	@Test
	void testAltaPeleadores() {
		almacen.alta(ilia);
		
		assertEquals(1, almacen.contarElementos());
		
		almacen.alta(mcGregor);
		
		assertEquals(2, almacen.contarElementos());
	}

	/**
	 * Comprueba que se borra de forma correcta el peleador indicado.
	 */
	@Test
	void testBorrarPeleador() {
		almacen.alta(ilia);
		almacen.borrarElemento(ilia.getNombre());
		
		assertEquals(0, almacen.contarElementos());
	}
	
	/**
	 * Comprueba que se devuelven los elementos de forma correcta.
	 */
	@Test
	void testDevolverElementos() {
	    almacen.alta(ilia);
	    almacen.alta(mcGregor);

	    List<Peleadores> lista = almacen.devolverElementos();

	    assertNotNull(lista, "La lista no debería ser nula");
	    assertEquals(2, lista.size(), "La lista debería tener 2 elementos");
	    assertTrue(lista.contains(ilia), "La lista debería contener a Josue");
	    assertTrue(lista.contains(mcGregor), "La lista debería contener a Ilia");
	}
	
	/**
	 * Comprueba que devuelve de forma correcta el elemento indicado.
	 */
	@Test
	void testGetElemento() {
	    almacen.alta(ilia);

	    Peleadores resultado = almacen.getElemento(0);
	    
	    assertEquals(ilia, resultado, "El elemento obtenido por índice 0 debe ser el mismo que añadimos");
	    assertEquals("Topuria", resultado.getNombre(), "El nombre del peleador obtenido debe coincidir");
	}
}
