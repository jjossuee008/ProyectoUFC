package UFC.vistas;

import java.util.List;
import java.util.Scanner;

/**
 * Clase de utilidad para la interfaz de usuario por consola.
 * Proporciona métodos estáticos para mostrar textos, avisos, títulos 
 * y gestionar la entrada de datos de forma segura.
 * 
 * @author Josué Mateos (jjossuee008)
 * @version 1.0 (17032026)
 */
public class VistaGeneral {

    /** Formato de salida estándar para textos con salto de línea. */
    private static final String FORMATO_PRINTF_MOSTRARTEXTO = "%s%n";
    
    /** Formato de salida para mensajes de aviso o error. */
    private static final String FORMATO_PRINTF_MOSTRARAVISO = "[AVISO] %s%n";
    
    /** Escáner único para la lectura de datos desde la entrada estándar. */
    static final Scanner scEntrada = new Scanner(System.in);
    
    /**
     * Muestra un texto simple en la consola.
     * @param texto El contenido a mostrar.
     */
    public static void mostrarTexto(String texto) {
        System.out.printf(FORMATO_PRINTF_MOSTRARTEXTO, texto);
    }
    
    /**
     * Muestra un mensaje de aviso resaltado con el prefijo [AVISO].
     * @param texto El mensaje de advertencia.
     */
    public static void mostrarAviso(String texto) {
        System.out.printf(FORMATO_PRINTF_MOSTRARAVISO, texto);
    }
    
    /**
     * Muestra un título de primer nivel resaltado en mayúsculas y entre símbolos.
     * @param texto El título principal.
     */
    public static void mostrarTitulo1(String texto) {
        System.out.printf("%n== %s ==%n", texto.toUpperCase());
    }
    
    /**
     * Muestra un título de segundo nivel o subtítulo.
     * @param texto El subtítulo a mostrar.
     */
    public static void mostrarTitulo2(String texto) {
        System.out.printf("-- %s --%n", texto);
    }
    
    /**
     * Solicita un número entero al usuario de forma segura.
     * Si la entrada no es numérica, solicita el dato repetidamente.
     * @param texto El mensaje de solicitud al usuario.
     * @return El número entero introducido validado.
     */
    public static int pedirNúmero(String texto) {
        mostrarTexto(texto);
        
        while (!scEntrada.hasNextInt()) {
            mostrarAviso("Por favor, introduce un número válido.");
            scEntrada.next(); // Descarta la entrada no válida
        }
        
        int numero = scEntrada.nextInt();
        scEntrada.nextLine(); // Limpieza de buffer para evitar saltos en futuras lecturas
        return numero;
    }
    
    /**
     * Detiene la ejecución del programa hasta que el usuario pulse la tecla Enter.
     * @param texto Mensaje informativo para mostrar durante la pausa.
     */
    public static void pausa(String texto) {
        mostrarTexto(texto + " (Pulsa Enter para continuar)");
        scEntrada.nextLine(); 
    }
    
    /**
     * Solicita una confirmación de tipo Sí o No al usuario.
     * @param texto La pregunta que requiere confirmación.
     * @return true si el usuario pulsa 'S' o 's', false en cualquier otro caso.
     */
    public static boolean pedirConfirmacion(String texto) {
        mostrarTexto(texto + " (S/N):");
        String respuesta = scEntrada.nextLine();
        return respuesta.trim().equalsIgnoreCase("s");
    }
    
    /**
     * Imprime una lista de cadenas de texto línea a línea.
     * @param lista La colección de elementos a mostrar.
     */
    public static void mostrarLista(List<String> lista) {
        for (String elemento : lista) {
            System.out.println(elemento);
        }
    }

    /**
     * Proporciona acceso al objeto Scanner compartido.
     * @return El Scanner configurado para la entrada estándar.
     */
    public static Scanner getScEntrada() {
        return scEntrada;
    }
}
