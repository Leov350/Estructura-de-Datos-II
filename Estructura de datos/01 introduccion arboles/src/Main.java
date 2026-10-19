import java.util.ArrayList; // Permite guardar varios hijos dentro de cada nodo.
import java.util.List; // Define la lista que vamos a usar para representar los hijos.

public class Main { // Esta clase contiene el programa principal y las pruebas.
    public static void main(String[] args) { // Java empieza a ejecutar el programa desde este método.
        NodoGeneral<String> A = new NodoGeneral<>("A"); // A será la raíz porque no tendrá padre.
        NodoGeneral<String> B = new NodoGeneral<>("B"); // Creamos el segundo nodo del árbol.
        NodoGeneral<String> C = new NodoGeneral<>("C"); // Creamos otro nodo del segundo nivel.
        NodoGeneral<String> D = new NodoGeneral<>("D"); // Creamos el tercer nodo del segundo nivel.
        NodoGeneral<String> E = new NodoGeneral<>("E"); // Creamos un hijo para el nodo B.
        NodoGeneral<String> F = new NodoGeneral<>("F"); // Creamos otro hijo para el nodo B.
        NodoGeneral<String> G = new NodoGeneral<>("G"); // Creamos un hijo para el nodo C.
        NodoGeneral<String> H = new NodoGeneral<>("H"); // Creamos otro hijo para el nodo C.
        NodoGeneral<String> I = new NodoGeneral<>("I"); // Creamos un hijo para el nodo D.
        NodoGeneral<String> J = new NodoGeneral<>("J"); // Creamos un hijo para el nodo E.
        NodoGeneral<String> K = new NodoGeneral<>("K"); // Creamos otro hijo para el nodo E.
        NodoGeneral<String> L = new NodoGeneral<>("L"); // Creamos un hijo para el nodo H.

        A.agregarHijo(B); // B queda conectado directamente debajo de la raíz A.
        A.agregarHijo(C); // C también queda conectado directamente debajo de A.
        A.agregarHijo(D); // D también queda conectado directamente debajo de A.
        B.agregarHijo(E); // E pasa a ser hijo de B.
        B.agregarHijo(F); // F pasa a ser hijo de B.
        C.agregarHijo(G); // G pasa a ser hijo de C.
        C.agregarHijo(H); // H pasa a ser hijo de C.
        D.agregarHijo(I); // I pasa a ser hijo de D.
        E.agregarHijo(J); // J pasa a ser hijo de E.
        E.agregarHijo(K); // K pasa a ser hijo de E.
        H.agregarHijo(L); // L pasa a ser hijo de H y crea el cuarto nivel.

        System.out.println("ANATOMIA Y PROPIEDADES DE UN ARBOL"); // Mostramos el título de la prueba.
        System.out.println("Cantidad de nodos: " + contarNodos(A)); // Contamos todos los nodos desde la raíz.
        System.out.println("Raiz: " + A.getDato()); // Mostramos el nodo que no tiene padre.
        System.out.println("Grado del arbol: " + gradoArbol(A)); // Buscamos el mayor número de hijos de un nodo.
        System.out.println("Altura del arbol: " + altura(A)); // Calculamos la altura mediante recursividad.
        System.out.println(); // Dejamos una línea vacía para separar resultados.

        System.out.println("Nodo | Padre | Grado | Profundidad | Altura | Tipo"); // Encabezado de la tabla de métricas.
        imprimirMetricas(A, null, 0); // Recorremos el árbol para mostrar las métricas de cada nodo.
        System.out.println(); // Separamos la tabla de las pruebas de caminos.

        System.out.println("Profundidad de las hojas:"); // Indicamos que vamos a revisar las hojas.
        imprimirProfundidadHojas(A, 0); // Mostramos la profundidad de cada nodo que no tiene hijos.
        System.out.println(); // Dejamos espacio antes de los caminos.

        System.out.println("Camino 1: A -> B -> E -> J; longitud: 3 aristas"); // Presentamos un camino de la raíz a una hoja.
        System.out.println("Camino 2: A -> C -> H -> L; longitud: 3 aristas"); // Presentamos otro camino distinto.
        System.out.println(); // Separamos el resultado de la prueba adicional.

        NodoGeneral<String> M = new NodoGeneral<>("M"); // Creamos un nodo nuevo para probar un nivel adicional.
        L.agregarHijo(M); // Agregamos M debajo de L, formando un nivel más.
        System.out.println("Altura despues de agregar el nodo M: " + altura(A)); // Comprobamos que la altura aumenta de 3 a 4.
    } // Aquí termina el método principal.

    static int altura(NodoGeneral<?> nodo) { // Calcula cuántas aristas hay en el camino más largo hacia una hoja.
        if (nodo.getHijos().isEmpty()) { // Comprueba si el nodo actual no tiene hijos.
            return 0; // Una hoja tiene altura cero porque no hay aristas debajo de ella.
        } // Termina la condición que identifica una hoja.
        int max = 0; // Guarda la mayor altura encontrada entre los hijos.
        for (NodoGeneral<?> hijo : nodo.getHijos()) { // Revisa uno por uno todos los hijos del nodo actual.
            max = Math.max(max, altura(hijo)); // Calcula la altura del hijo y conserva el valor mayor.
        } // Termina el recorrido de los hijos.
        return 1 + max; // Suma una arista entre el nodo actual y el hijo con mayor altura.
    } // Aquí termina el método recursivo de altura.

    static int contarNodos(NodoGeneral<?> nodo) { // Cuenta el nodo actual y todos los que dependen de él.
        int total = 1; // El nodo actual cuenta como un elemento.
        for (NodoGeneral<?> hijo : nodo.getHijos()) { // Recorre todos los hijos del nodo.
            total += contarNodos(hijo); // Suma los nodos encontrados dentro de cada rama.
        } // Termina el recorrido de los hijos.
        return total; // Devuelve la cantidad total de nodos de la rama.
    } // Aquí termina el método para contar nodos.

    static int gradoArbol(NodoGeneral<?> nodo) { // Encuentra el mayor grado entre todos los nodos.
        int mayor = nodo.getHijos().size(); // El grado del nodo actual es la cantidad de sus hijos.
        for (NodoGeneral<?> hijo : nodo.getHijos()) { // Revisa cada rama del árbol.
            mayor = Math.max(mayor, gradoArbol(hijo)); // Conserva el grado más alto encontrado.
        } // Termina la revisión de las ramas.
        return mayor; // Devuelve el grado general del árbol.
    } // Aquí termina el método de grado del árbol.

    static int profundidad(NodoGeneral<?> nodo, int nivel) { // En este programa el nivel recibido equivale a la profundidad.
        return nivel; // Devuelve la distancia en aristas desde la raíz hasta el nodo.
    } // Aquí termina el método de profundidad.

    static int alturaNodo(NodoGeneral<?> nodo) { // Permite obtener la altura de cualquier nodo.
        return altura(nodo); // Reutiliza el mismo cálculo recursivo de altura.
    } // Aquí termina el método de altura de un nodo.

    static void imprimirMetricas(NodoGeneral<?> nodo, String padre, int nivel) { // Imprime información de un nodo y luego de sus hijos.
        String tipo; // Variable donde guardamos si el nodo es raíz, hoja o interno.
        if (padre == null) { // Si no se indicó padre, estamos en la raíz.
            tipo = "Raiz"; // Marcamos el nodo como raíz.
        } else if (nodo.getHijos().isEmpty()) { // Si no tiene hijos y sí tiene padre, es una hoja.
            tipo = "Hoja"; // Marcamos el nodo como hoja.
        } else { // Si tiene padre y al menos un hijo, es un nodo interno.
            tipo = "Interno"; // Marcamos el nodo como interno.
        } // Termina la clasificación del nodo.
        System.out.println(nodo.getDato() + " | " + (padre == null ? "Ninguno" : padre) + " | " + nodo.getHijos().size() + " | " + profundidad(nodo, nivel) + " | " + alturaNodo(nodo) + " | " + tipo); // Muestra las métricas de la fila actual.
        for (NodoGeneral<?> hijo : nodo.getHijos()) { // Recorre los hijos para imprimir sus datos.
            imprimirMetricas(hijo, String.valueOf(nodo.getDato()), nivel + 1); // Envía el dato actual como padre y aumenta la profundidad.
        } // Termina el recorrido de los hijos.
    } // Aquí termina la impresión de las métricas.

    static void imprimirProfundidadHojas(NodoGeneral<?> nodo, int nivel) { // Busca las hojas y muestra su profundidad.
        if (nodo.getHijos().isEmpty()) { // Comprueba si el nodo actual es una hoja.
            System.out.println("Hoja " + nodo.getDato() + ": profundidad " + nivel); // Muestra el nombre de la hoja y su profundidad.
            return; // Evita seguir recorriendo cuando ya se encontró una hoja.
        } // Termina la condición de hoja.
        for (NodoGeneral<?> hijo : nodo.getHijos()) { // Revisa todos los hijos del nodo actual.
            imprimirProfundidadHojas(hijo, nivel + 1); // Avanza un nivel para cada hijo.
        } // Termina el recorrido de los hijos.
    } // Aquí termina la impresión de profundidades de hojas.
} // Aquí termina la clase principal.

class NodoGeneral<T> { // Representa un nodo que puede guardar cualquier tipo de dato.
    private T dato; // Guarda el valor o etiqueta del nodo.
    private List<NodoGeneral<T>> hijos; // Guarda los nodos que dependen directamente de este nodo.

    public NodoGeneral(T dato) { // Constructor que se ejecuta cuando se crea un nodo.
        this.dato = dato; // Guarda el dato recibido al crear el objeto.
        this.hijos = new ArrayList<>(); // Inicializa la lista de hijos vacía.
    } // Aquí termina el constructor.

    public T getDato() { // Permite consultar el dato almacenado en el nodo.
        return dato; // Devuelve el valor del nodo.
    } // Aquí termina el método getDato.

    public List<NodoGeneral<T>> getHijos() { // Permite consultar la lista de hijos.
        return hijos; // Devuelve la lista de hijos del nodo.
    } // Aquí termina el método getHijos.

    public void agregarHijo(NodoGeneral<T> hijo) { // Conecta un nodo como hijo del nodo actual.
        hijos.add(hijo); // Agrega el hijo al final de la lista.
    } // Aquí termina el método agregarHijo.
} // Aquí termina la clase NodoGeneral.
