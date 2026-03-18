package UFC.funciones;

/**
 * Lanzara el programa lanzando el menu deseado con las diferentes opciones.
 * @author Josué Mateos (jjossuee008)
 * @version 1.0 (18032026)
 */
public class LanzadorUFC {
	/**
     * Punto de entrada principal de la aplicación.
     * Crea una instancia del controlador y cede el flujo de ejecución 
     * al bucle principal del programa.
     * @param args Argumentos de la línea de comandos (no utilizados en esta versión).
     */
	public static void main(String[] args) {
		ControlUFC programa = new ControlUFC();
		programa.buclePrincipal();
	}
}
