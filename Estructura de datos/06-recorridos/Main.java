import java.util.Scanner; // Permite leer lo que escribe el usuario
public class Main { // Define la clase principal
    public static void main(String[] args) { // Punto de inicio del programa
        Scanner teclado = new Scanner(System.in); // Prepara la entrada de datos
        System.out.println("Ingresa tu nombre:"); // Muestra una pregunta
        String nombre = teclado.nextLine(); // Guarda el nombre escrito
        System.out.println(nombre + ", me darias tu numero? Si o No");
        String respuesta = teclado.nextLine(); // Guarda la respuesta
        if (respuesta.equalsIgnoreCase("Si")) { // Compara sin distinguir mayusculas
            System.out.println("Ingresa numero:"); // Pide el numero
            String numero = teclado.nextLine(); // Guarda el numero como texto
            System.out.println("Gracias :D"); // Agradece al usuario
        } else { // Se ejecuta si la respuesta no fue "Si"
            System.out.println("Gracias de todas formas :D");
        }
        teclado.close(); // Cierra el lector de datos
    }
}