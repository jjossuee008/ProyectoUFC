package UFC.funciones;
import java.util.List;

import UFC.peleadores.ConjuntoPeleadores;
import UFC.peleadores.Peleadores;
import UFC.vistas.*;

/** Base para controlar el menu del programa. Nos mostrara las diferentes opciones que se podran elegir.
 * 	usando {@link VistaMenú} Podremos realizar diferentes acciones.
 * 
 * 	@auhor Josué Mateos (jjossuee008)
 * 	@version 1.5 (17032026)
 */
public class ControlUFC {

	private static ConjuntoPeleadores almacen;
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
        
        VistaGeneral.mostrarAviso("FIN");
	}
	
	public static void ejecutarAlta() {
		Peleadores nuevoPeleador;
		VistaGeneral.mostrarTitulo2("ALTA DE NUEVO PELEADOR");
		
		VistaGeneral.mostrarTexto("Nombre del peleador:");
        String nombre = VistaGeneral.getScEntrada().nextLine();
        
        VistaGeneral.mostrarTexto("Puesto en el Ranking:");
        String ranking = VistaGeneral.getScEntrada().nextLine();
        
        int victorias = VistaGeneral.pedirNúmero("Número de Victorias:");
        int derrotas = VistaGeneral.pedirNúmero("Número de Derrotas:");
        int nocauts = VistaGeneral.pedirNúmero("Número de Nocauts:");
        
        nuevoPeleador = new Peleadores(nombre,ranking,victorias,derrotas,nocauts);
        
        double peso = VistaGeneral.pedirNúmero("Peso del peleador:");
        nuevoPeleador.calcularCategoria(peso);
        
        VistaGeneral.mostrarTexto("¿Deseas asignarle un apodo? (s/n)");
        if(VistaGeneral.pedirConfirmacion("¿Deseas asignarle un apodo?")) {
            VistaGeneral.mostrarTexto("Introduce el apodo:");
            String apodo = VistaGeneral.getScEntrada().nextLine();
            nuevoPeleador.añadirApodo(apodo); 
        }
        
        almacen.alta(nuevoPeleador);
        VistaGeneral.mostrarAviso("Peleador añadido de forma exitosa");
	}
	
	public static void listarRanking() {
		VistaGeneral.mostrarTexto("Indica la categoria que deseas:");
		String categoria = VistaGeneral.getScEntrada().nextLine();
		
		for(int i = 0; i < almacen.contarElementos(); i++) {
			if(almacen.getElemento(i).getCategoria().equals(categoria)) {
				
			};
		}
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
