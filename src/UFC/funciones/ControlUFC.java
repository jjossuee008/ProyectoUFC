package UFC.funciones;
import java.util.List;

import UFC.peleadores.ConjuntoPeleadores;
import UFC.vistas.*;

/** Base para controlar el menu del programa. Nos mostrara las diferentes opciones que se podran elegir.
 * 	usando {@link VistaMenú} Podremos realizar diferentes acciones.
 * 
 * 	@auhor Josué Mateos (jjossuee008)
 * 	@version 1.0 (17032026)
 */
public class ControlUFC {

	private ConjuntoPeleadores almacen;
	private static VistaMenú menú;
	// Las constantes para las opciones del menú
	private static final List<String> OPCIONES = List.of(
	    "Dar de alta peleador",
	    "Listar ranking",
	    "Borrar peleador",
	    "Exportar a archivo",
	    "Importar desde archivo"
	);
	
	public ControlUFC() {
		almacen = new ConjuntoPeleadores();
		menú = new VistaMenú("Menu UFC", OPCIONES);
	}
	
	public static void buclePrincipal() {
		int opción = -1;
		
		menú.mostrarTitulo();
		menú.mostrarOpciones();
        opción = menú.pedirOpción(); 
         
        do {
	        switch(opción) {
	            case 1:
	            	ejecutarAlta();
	            	break;
	            case 2:
	            	listarRanking();
	            	break;
	            case 3:
	            	borrarPeleador();
	            	break;
	            case 4:
	            	importar();
	             	break;
	            case 5:
	            	exportar();
	            case 0:
	            	break;
	            default:
	                opciónNoDisponible();
	                break;
	        }
        } while(opción != 0);
	}
	
	public static void ejecutarAlta() {
		
	}
	
	public static void listarRanking() {
		
	}
	
	public static void borrarPeleador() {
		
	}
	
	public static void importar() {
		
	}
	
	public static void exportar() {
		
	}
	
	public static void opciónNoDisponible() {
		
	}
}
