package UFC.peleadores;

/**
 * Base del programa en la cual se permitira crear a los peleadores indicando sus diferentes estadisticas.
 * Se podran hacer diferentes funciones a partir de sus estadisticas.
 * 
 * @author Josué Mateos (jjossuee008)
 * @version 1.0 (17032026)
 */
public class Peleadores {

	/** Indicara el nombre del peleador */
	private String nombre;
	/** Guardara el apodo del peleador en caso de tenerlo */
	private String apodo;
	/** Indicara la categoria en la que compite dependiendo de su peso */
	private String categoriaPeso;
	
	/** Indica el puesto en el que se encuentra dentro de su categoria de peso */
	private String puestoRanking;
	/** Indica el Nº de vistorias con las que cuenta el peleador */
	private int victorias;
	/** Indica el Nº de derrotas con las que cuenta el peleador */
	private int derrotas;
	/** Indica el Nº de veces que el peleador ha ganado por nocaut */
	private int nocauts;
	
	/**
	 * Creara un peleador a partir de sus datos.
	 * 
	 * @param nombre del peleador.
	 * @param puestoRanking en el que se encuentra.
	 * @param victorias del peleador.
	 * @param derrotas del peleador.
	 * @param nocauts victorias por nocaut del peleador.
	 */
	public Peleadores(String nombre, String puestoRanking, int victorias, int derrotas, int nocauts) {
		this.nombre = nombre;
		this.puestoRanking = puestoRanking;
		this.victorias = victorias;
		this.derrotas = derrotas;
		this.nocauts = nocauts;
	}
	
	/**
	 * Sumara al contador de vistorias del peleador el numero de nuevas victorias a sumar.
	 * @param suma Nº de victorias a sumar.
	 */
	public void sumarVictoria(int suma) {
		this.victorias += suma;
	}
	
	/**
	 * Sumara al contador de Derrotas del peleador el numero de nuevas Derrotas a sumar.
	 * @param suma Nº de Derrotas a sumar.
	 */
	public void sumarDerrota(int suma) {
		this.derrotas += suma;
	}
	
	/**
	 * Sumara al contador de nocauts del peleador el numero de nuevas nocauts a sumar.
	 * @param suma Nº de nocauts a sumar.
	 */
	public void sumarNocauts(int suma) {
		this.nocauts += suma;
	}
	
	/**
	 * Añadira al peleador un apodo indicado.
	 * @param apodo que se debe añadir
	 */
	public void añadirApodo(String apodo) {
		this.apodo = apodo;
	}
	
	/**
	 * A partir de un peso indicador asignara al peleador una categoria en la que competir.
	 * @param peso del peleador
	 * @return categoria asignada;
	 */
	public String calcularCategoria(double peso) {
	    if (peso <= 56.7) {
	        categoriaPeso = "Peso Mosca";
	    } else if (peso <= 61.2) {
	        categoriaPeso = "Peso Gallo";
	    } else if (peso <= 70.3) {
	        categoriaPeso = "Peso Ligero";
	    } else if (peso <= 77.1) {
	        categoriaPeso = "Peso Welter";
	    } else {
	        categoriaPeso = "Peso Pesado";
	    }
	    return categoriaPeso;  
	}
	
	/**
	 * @return Devolvera el nombre del peleador.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Devolvera la informacion del peleador indicando su nombre, apodo y categoria en caso de tener.
	 * @return datos del peleador
	 */
	public String devolverDatos() {
		String datos;
		if(categoriaPeso == null) {
			datos = String.format("||PELEADOR|| Nombre: %s, Apodo: %s, Categoria: no asignada", nombre, apodo);
		} else {
			datos = String.format("||PELEADOR|| Nombre: %s, Apodo: %s, Categoria: %s", nombre, apodo, categoriaPeso);
		}
		
		return datos;
	}
	
	/**
	 * Devolvera las estadisticas de un peleador, indicando su Nº de victorias, derrotas y nocauts.
	 * @return estadisticas de la competicion.
	 */
	public String devolverEstadisticas() {
		String datos;
		
		datos = String.format("||Peleador %s|| Victorias: %d, Posicion: %s, Derrotas: %d, KOs: %d", nombre,puestoRanking,victorias,derrotas,nocauts);
		return datos;
	}
	
	/**
	 * Asignara una nueva posicion en el ranking de la categoria a la que pertenezca el peleador.
	 * @param pos a asginar
	 */
	public void asignarPuestoRanking(int pos) {
		if(pos == 1) {
			puestoRanking = "CAMPEON";
		} else {
			puestoRanking = Integer.toString(pos);
		}
	}
	
}
