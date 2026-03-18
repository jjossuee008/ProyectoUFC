package UFC.funciones;

import UFC.peleadores.ConjuntoPeleadores;
import UFC.peleadores.Peleadores;
import UFC.vistas.VistaGeneral;

/**
 * Carga los datos que se le indiquen y exportara estos datos si asi se desea
 * @aurhor Josué Mateos (jjossuee008)
 * @version 1.0 (18032026)
 */
public class ImportacionArchivo {
	
	/** Almacen que guarda a los peleadores */
	private static ConjuntoPeleadores almacen = new ConjuntoPeleadores();
	
	/** Sacara los datos en un archivo fuera del programa */
	public static void exportar() {
	    try (java.io.PrintWriter pw = new java.io.PrintWriter("datos.txt")) {
	        for (Peleadores p : almacen.devolverElementos()) {
	            // Escribimos los datos básicos separados por ";"
	            pw.println(p.devolverDatos() + ";" + p.devolverEstadisticas());
	        }
	        VistaGeneral.mostrarAviso("Archivo guardado con éxito.");
	    } catch (java.io.FileNotFoundException e) {
	        VistaGeneral.mostrarAviso("No se pudo crear el archivo.");
	    }
	}
	
	/** Añadira los datos de un archivo que indique el usuario */
	public static void importar() {
	    java.io.File archivo = new java.io.File("datos.txt");
	    if (!archivo.exists()) {
	        VistaGeneral.mostrarAviso("No hay datos previos para cargar.");
	        return;
	    }

	    try (java.util.Scanner lector = new java.util.Scanner(archivo)) {
	        while (lector.hasNextLine()) {
	            String linea = lector.nextLine();
	            String[] trozos = linea.split(";"); // Separa el texto por cada ";"
	            
	            // Creamos el peleador con los trozos (Ojo: convierte los números)
	            Peleadores p = new Peleadores(
	                trozos[0], // Nombre
	                trozos[1], // Ranking
	                Integer.parseInt(trozos[2]), // Victorias
	                0, 0 // Rellenamos el resto con 0 o lo que necesites
	            );
	            
	            almacen.alta(p);
	        }
	        VistaGeneral.mostrarAviso("Datos cargados correctamente.");
	    } catch (Exception e) {
	        VistaGeneral.mostrarAviso("Error al leer el archivo.");
	    }
	}
}
