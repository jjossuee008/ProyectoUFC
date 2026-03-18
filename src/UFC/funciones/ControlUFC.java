package UFC.funciones;
import java.util.List;

import UFC.peleadores.ConjuntoPeleadores;
import UFC.peleadores.Peleadores;
import UFC.vistas.*;

/** Base para controlar el menu del programa. Nos mostrara las diferentes opciones que se podran elegir.
 * 	usando {@link VistaMenú} Podremos realizar diferentes acciones.
 * 
 * 	@auhor Josué Mateos (jjossuee008)
 * 	@version 2.0 (18032026)
 */
public class ControlUFC {
	
	/** Almacen que guardara a los diferentes peleadores */
	private static ConjuntoPeleadores almacen;
	/** Establece la forma del menu a traves de {@link VistaMenú} */
	private static VistaMenú menú;
	/** Indica las diferentes opciones que tendra el menu */
	private static final List<String> OPCIONES = List.of(
	    "Dar de alta peleador",
	    "Listar ranking",
	    "Borrar peleador",
	    "Exportar a archivo",
	    "Importar desde archivo",
	    "Lista todos los peleadores"
	);
	
	/**
	 * Inicia el almacen y el menu
	 */
	public ControlUFC() {
		almacen = new ConjuntoPeleadores();
		menú = new VistaMenú("Menu UFC", OPCIONES);
	}
	
	/** Bucle que se utilizara para que el usuario eliga una opcion de forma optima */
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
	            case 4: {
	            	ImportacionArchivo.exportar(almacen.devolverElementos());
	                break;
	            }
	            
	            case 5: {
	                List<Peleadores> listaCargada = ImportacionArchivo.importar();
	                for(Peleadores p : listaCargada) {
	                    almacen.alta(p);
	                }
	                break;
	            }
	            case 6:
	            	listarPeleadores();
	            	break;
	            case 0:
	            	break;
	            default:
	                opciónNoDisponible();
	                break;
	        }
        } while(opción != 0);
        
        VistaGeneral.mostrarAviso("FIN");
	}
	
	/** Creara un peleador a traves de {@link Peleadores} y la añadira al almacen utilizando {@link ConjuntoPeleadores} */
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
        
        if(VistaGeneral.pedirConfirmacion("¿Deseas asignarle un apodo?")) {
            VistaGeneral.mostrarTexto("Introduce el apodo:");
            String apodo = VistaGeneral.getScEntrada().nextLine();
            nuevoPeleador.añadirApodo(apodo); 
        }
        
        almacen.alta(nuevoPeleador);
        VistaGeneral.mostrarAviso("Peleador añadido de forma exitosa");
        buclePrincipal();
	}
	
	/** Lista a los peleadores creados utilizando la posicion indicada anteriormente */
	public static void listarRanking() {
	    VistaGeneral.mostrarTexto("Indica la categoría que deseas (ej: PESADO, PLUMA):");
	    String categoriaBusqueda = VistaGeneral.getScEntrada().nextLine();
	    
	    VistaGeneral.mostrarTitulo1("RANKING: " + categoriaBusqueda);
	    
	    boolean encontrado = false;
	    List<Peleadores> lista = almacen.devolverElementos();

	    for (Peleadores p : lista) {
	        if (p.getCategoria().equalsIgnoreCase(categoriaBusqueda)) {
	            
	            if (p.getRanking().equalsIgnoreCase("CAMPEON")) {
	                VistaGeneral.mostrarTexto("[ORO] " + p.devolverDatos());
	            } else {
	                try {
	                    int puesto = Integer.parseInt(p.getRanking());
	                    VistaGeneral.mostrarTexto("#" + puesto + " - " + p.devolverDatos());
	                } catch (NumberFormatException e) {
	                    VistaGeneral.mostrarTexto("Puesto: " + p.getRanking() + " - " + p.devolverDatos());
	                }
	            }
	            encontrado = true;
	        }
	    }

	    if (!encontrado) {
	        VistaGeneral.mostrarAviso("No hay peleadores registrados en la categoría: " + categoriaBusqueda);
	    }
	    
	    VistaGeneral.pausa("Presiona Enter para volver al menú");
	}
	
	/**
	 * Borrara el peleador indicando su nombre.
	 */
	public static void borrarPeleador() {
		String peleador;
		
		VistaGeneral.mostrarTexto("Nombre del peleador que se desea borrar:");
		peleador = VistaGeneral.getScEntrada().nextLine();
		
	    almacen.borrarElemento(peleador);
	   
	}
	
	/**
	 * Listara todos los peleadores que se encuentren en el almacaen.
	 */
	public static void listarPeleadores() {
		for(int i = 0; i < almacen.contarElementos(); i++) {
			System.out.println(almacen.getElemento(i).devolverDatos() + " " + almacen.getElemento(i).devolverEstadisticas());
		}
		buclePrincipal();
	}
	
	/** Lanza un aviso cuando se quiere indicar una opcion que no esta entre las indicadas */
	public static void opciónNoDisponible() {
		VistaGeneral.mostrarAviso("Indica una opcion disponible");
	}
}
