package UFC.peleadores;

import java.util.ArrayList;
import java.util.List;

import UFC.vistas.VistaGeneral;

/** 
 * A partir de {@link Peleadores} podremos crear un almacen donde guardar a todos los peleadores creados si asi lo queremos.
 * Con este almacen podremos realizar una serie de opciones.
 * @author Josué Mateos (jjossuee008)
 * @version 2.0 (18022026)
 */
public class ConjuntoPeleadores {
	
	/** Almacen donde se guardaran los peleadores */
	private List<Peleadores> listaPeleadores;

	/** 
	 * Constructor que inicializara el almacens.
	 */
	public ConjuntoPeleadores() {
		listaPeleadores = new ArrayList<>();
	}
	
	
	/**
	 * Añadira a la lista el Peleador que indiquemos.
	 * @param luchador peleador indicado.
	 */
	public void alta(Peleadores luchador) {
		listaPeleadores.add(luchador);
	}
	
	/**
	 * Eliminara el peleador indicado por el usuario.
	 * @param nombre del peleador que se desea eliminar.
	 */
	public void borrarElemento(String nombre) {
		boolean encontrado = false;

	    for (int i = 0; i < listaPeleadores.size(); i++) { 
	        Peleadores p = listaPeleadores.get(i);
	        
	        if (p.getNombre().equalsIgnoreCase(nombre)) {
	            listaPeleadores.remove(i);
	            i--;
	            encontrado = true;
	        }
	    }

	    if (!encontrado) {
	        VistaGeneral.mostrarAviso("No se ha encontrado el peleador: " + nombre);
	    } else {
	        VistaGeneral.mostrarAviso("Peleador eliminado con éxito.");
	    }
	}

	/**
	 * Indicara el numero de peleadores que hay en el almacen.
	 * @return cantidad de peleadores en el almacen.
	 */
	public int contarElementos() {
		return listaPeleadores.size();
	}
	
	/**
	 * @return Devolvera el almacen completo.
	 */
	public List<Peleadores> devolverElementos() {
		return listaPeleadores;
	}
	
	/**
	 * @param index del peleador a devolver.
	 * @return devuelve un peleador del almacen.
	 */
	public Peleadores getElemento(int index) {
		return listaPeleadores.get(index);
	}
}
