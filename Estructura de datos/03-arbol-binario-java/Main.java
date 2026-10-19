/**
 * Guia 3: construccion manual de un arbol binario de 7 nodos.
 * En vez de letras, cada nodo guarda el nombre de un lenguaje de programacion.
 */
public class Main {

    public static void main(String[] args) {

        // 1. Creamos los siete nodos sueltos
        NodoArbol<String> java = new NodoArbol<>("Java");
        NodoArbol<String> python = new NodoArbol<>("Python");
        NodoArbol<String> cpp = new NodoArbol<>("C++");
        NodoArbol<String> go = new NodoArbol<>("Go");
        NodoArbol<String> rust = new NodoArbol<>("Rust");
        NodoArbol<String> php = new NodoArbol<>("PHP");
        NodoArbol<String> swift = new NodoArbol<>("Swift");

        /*
         * 2. Enlazamos las referencias para armar esto:
         *
         *               Java
         *             /      \
         *        Python        C++
         *        /   \        /   \
         *      Go   Rust    PHP   Swift
         *
         * Queda lleno, completo y perfecto a la vez.
         */
        java.setIzquierdo(python);
        java.setDerecho(cpp);

        python.setIzquierdo(go);
        python.setDerecho(rust);

        cpp.setIzquierdo(php);
        cpp.setDerecho(swift);

        // 3. El arbol solo necesita conocer la raiz
        ArbolBinario<String> arbol = new ArbolBinario<>(java);

        // 4. Metodo que pide la guia
        System.out.println("=== RAIZ E HIJOS ===");
        arbol.imprimirRaizYHijos();

        // 5. Estructura completa
        System.out.println("\n=== ARBOL COMPLETO ===");
        arbol.imprimirArbol();

        // 6. Algunas propiedades para comprobar que todo quedo bien enlazado
        System.out.println("\n=== PROPIEDADES ===");
        System.out.println("Nodos: " + arbol.contarNodos());
        System.out.println("Hojas: " + arbol.contarHojas());
        System.out.println("Altura: " + arbol.altura());
        System.out.println("Grado de Java: " + java.grado());
        System.out.println("Go es hoja?: " + go.esHoja());

        // 7. Prueba con null: Go es hoja, asi que sus hijos son null
        System.out.println("\n=== CONTROL DE NULL ===");
        System.out.println("Hijo izquierdo de Go: " + go.getIzquierdo());

        // Siempre preguntamos antes de pedir el dato del hijo
        if (go.getIzquierdo() != null) {
            System.out.println(go.getIzquierdo().getDato());
        } else {
            System.out.println("Go no tiene hijo izquierdo; la referencia es null.");
        }

        // 8. Arbol vacio, tambien debe funcionar sin errores
        System.out.println("\n=== ARBOL VACIO ===");
        ArbolBinario<Integer> vacio = new ArbolBinario<>();
        vacio.imprimirRaizYHijos();
    }
}
