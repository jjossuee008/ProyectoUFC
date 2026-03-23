package UFC.funciones;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import UFC.peleadores.Peleadores;
import UFC.vistas.VistaGeneral;

/** Clase encargada de la persistencia de datos */
public class ImportacionArchivo {

	/**
	 * Emportara los peleadores que se encuentren en el programa.
	 * @param lista de peleadores del programa.
	 */
	public static void exportar(List<Peleadores> lista) {
	    // 1. Verificación de seguridad: ¿Hay algo que guardar?
	    if (lista == null || lista.isEmpty()) {
	        System.out.println("[DEBUG] La lista está vacía, por eso el archivo sale en blanco.");

	        return;
	    }

	    // 2. El bloque try(...) asegura que el archivo se CIERRE al terminar
	    try (java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.FileWriter("datos.txt"))) {
	        
	        for (Peleadores p : lista) {
	            // Escribimos los datos puros separados por ";"
	            pw.println(p.getNombre() + ";" + p.getRanking() + ";" + p.getVictorias() + ";" + p.getDerrotas() + ";" + p.getNocauts());
	            // Este print es para que TÚ veas en la consola que está trabajando
	            System.out.println("[DEBUG] Escribiendo en archivo a: " + p.getNombre());
	        }
	        
	        pw.flush(); 
	        
	    } catch (java.io.IOException e) {
	        System.out.println("[ERROR] No se pudo escribir: " + e.getMessage());
	    }
	}

	/**
     * Lee el archivo 'datos.txt' y reconstruye los objetos Peleadores.
     * @return Una lista con los peleadores cargados.
     */
    public static List<Peleadores> importar() {
        List<Peleadores> auxiliar = new ArrayList<>();
        String nombreArchivo = VistaGeneral.getScEntrada().nextLine();
        File archivo = new File(nombreArchivo);

        if (!archivo.exists()) {
            VistaGeneral.mostrarAviso("No existe el archivo 'datos.txt'.");
            return auxiliar;
        }

        try (Scanner lector = new Scanner(archivo)) {
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                if (linea.trim().isEmpty()) continue; 

                String[] t = linea.split(";");
             
                if (t.length >= 5) {
                    Peleadores p = new Peleadores(
                        t[0],                        // Nombre
                        t[1],                        // Ranking
                        Integer.parseInt(t[2]),      // Victorias
                        Integer.parseInt(t[3]),      // Derrotas
                        Integer.parseInt(t[4])       // Nocauts
                    );
                    auxiliar.add(p);
                }
            }
            VistaGeneral.mostrarAviso("Importación completada.");
        } catch (Exception e) {
            VistaGeneral.mostrarAviso("Error de formato al importar datos.");
        }
        return auxiliar;
    }
}

