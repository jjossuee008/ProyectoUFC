package UFC.funciones;

import java.util.List;

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
	        ControlUFC.buclePrincipal();
	        return;
	    }

	    // 2. El bloque try(...) asegura que el archivo se CIERRE al terminar
	    try (java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.FileWriter("datos.txt"))) {
	        
	        for (Peleadores p : lista) {
	            // Escribimos los datos puros separados por ";"
	            pw.println(p.getNombre() + ";" + p.getRanking());
	            // Este print es para que TÚ veas en la consola que está trabajando
	            System.out.println("[DEBUG] Escribiendo en archivo a: " + p.getNombre());
	            ControlUFC.buclePrincipal();
	        }
	        
	        pw.flush(); 
	        
	    } catch (java.io.IOException e) {
	        System.out.println("[ERROR] No se pudo escribir: " + e.getMessage());
	        ControlUFC.buclePrincipal();
	    }
	}

    public static List<Peleadores> importar() {
        List<Peleadores> auxiliar = new java.util.ArrayList<>();
        java.io.File archivo = new java.io.File("datos.txt");

        if (!archivo.exists()) {
            VistaGeneral.mostrarAviso("No existe el archivo 'datos.txt' para importar.");
            return auxiliar;
        }

        try (java.util.Scanner lector = new java.util.Scanner(archivo)) {
            while (lector.hasNextLine()) {
                String[] t = lector.nextLine().split(";");
                Peleadores p = new Peleadores(t[0], t[1], Integer.parseInt(t[2]), 0, 0);
                auxiliar.add(p);
            }
        } catch (Exception e) {
            VistaGeneral.mostrarAviso("Error de formato en el archivo.");
        }
        return auxiliar;
    }
}

