package UFC.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import UFC.peleadores.Peleadores;

/**
 * Pruebas de los diferentes metodos de {link Peleadores} donde probara de forma individual cada funcion que se encuentra en esta clase.
 * @author Josué Mateos (jjossuee008)
 * @version 1.0 (18032026)
 */
public class PeleadoresTest {

	/** Peleador que se usara en las diferentes pruebas */
	Peleadores mcGregor;
	/** Peleador que se usara en las diferentes pruebas */
	Peleadores ilia;
	
	/**
	 * Inicializa a los peleadores indicando sus datos
	 */
	@BeforeEach
	void setUp(){
		mcGregor  = new Peleadores("McGregor", "12", 22, 6, 19);
		ilia = new Peleadores("Topuria", "C", 15, 0, 8);
	}
	
	/**
	 * Comprueba que al crear un peleador asigna los datos de forma correcta.
	 */
    @Test
    public void testCreacionPeleador() {
        assertEquals("Topuria", ilia.getNombre());
        assertEquals("C", ilia.getRanking());
        assertEquals(15, ilia.getVictorias());
        assertEquals(0, ilia.getDerrotas());
        assertEquals(8, ilia.getNocauts());
    }

    /**
     * Comprueba que devuelve los datos del peleador de forma correcta.
     */
    @Test
    public void testDevolverDatos() {
        String datos = mcGregor.devolverDatos();
        assertTrue(datos.contains("McGregor"));
    }
    
    /**
     * Comprueba que devuelve las estadisticas del peleador de forma correcta.
     */
    @Test
    public void testDevolverEstadisticas() {
    	String datos = ilia.devolverEstadisticas();
    	assertTrue(datos.contains("15"));
    	assertTrue(datos.contains("0"));
    	assertTrue(datos.contains("8"));
    }
    
    /**
     * Comprueba que se asigna de forma correcta la categoria del peleador dependiendo de su peso.
     * @param peso del peleador
     * @param categoriaEsperada categoria que se deberia asignars
     */
    @ParameterizedTest
    @CsvSource({
        "50.0, Peso Mosca",
        "56.7, Peso Mosca",  
        "60.0, Peso Gallo",
        "61.2, Peso Gallo",   
        "65.0, Peso Ligero",
        "70.3, Peso Ligero",  
        "75.0, Peso Welter",
        "77.1, Peso Welter",  
        "90.0, Peso Pesado"
    })
    void testCalcularCategoria(double peso, String categoriaEsperada) {
        ilia.calcularCategoria(peso);
        String resultado = ilia.getCategoria();
        
        assertEquals(categoriaEsperada, resultado, 
            "Para el peso " + peso + " la categoría debería ser " + categoriaEsperada);
    }
    
    /**
     * Comprueba que a un peleador se le suman de forma correcta las estadisticas indicadas.
     */
    @Test
    public void testAñadirEstadisticas() {
    	ilia.sumarVictoria(2);
    	ilia.sumarDerrota(2);
    	ilia.sumarNocauts(3);
    	
    	assertEquals(17,ilia.getVictorias());
    	assertEquals(2, ilia.getDerrotas());
    	assertEquals(11, ilia.getNocauts());
    }
    
    /**
     * Comprueba que a un peleador se le puede asignar un apodo de forma correcta.
     */
    @Test
    public void testApodo() {
    	ilia.añadirApodo("Matador");
    	
    	assertTrue(ilia.devolverDatos().contains("Matador"));
    }
    
    /**
     * Comprueba que a un peleador se le asigna el puesta en la clasificacion de forma correcta.
     */
    @Test
    public void testRanking() {
    	ilia.asignarPuestoRanking(1);
    	
    	assertEquals("CAMPEON",ilia.getRanking());
    	
    	ilia.asignarPuestoRanking(2);
    	
    	assertEquals("2",ilia.getRanking());
    	
    }
}
