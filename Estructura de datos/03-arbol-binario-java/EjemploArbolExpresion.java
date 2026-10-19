/**
 * Ejercicio de la guia: arbol de expresiones con operadores y operandos.
 *
 *          *
 *        /   \
 *       +     -
 *      / \   / \
 *     3   5 10  2
 *
 * Representa la expresion (3 + 5) * (10 - 2)
 * Los operadores son nodos internos y los numeros son las hojas.
 */
public class EjemploArbolExpresion {

    public static void main(String[] args) {

        // Operadores
        NodoArbol<String> mult = new NodoArbol<>("*");
        NodoArbol<String> suma = new NodoArbol<>("+");
        NodoArbol<String> resta = new NodoArbol<>("-");

        // Operandos
        NodoArbol<String> n3 = new NodoArbol<>("3");
        NodoArbol<String> n5 = new NodoArbol<>("5");
        NodoArbol<String> n10 = new NodoArbol<>("10");
        NodoArbol<String> n2 = new NodoArbol<>("2");

        // Enlazamos: la multiplicacion queda arriba
        mult.setIzquierdo(suma);
        mult.setDerecho(resta);

        suma.setIzquierdo(n3);
        suma.setDerecho(n5);

        resta.setIzquierdo(n10);
        resta.setDerecho(n2);

        ArbolBinario<String> arbol = new ArbolBinario<>(mult);

        System.out.println("=== ARBOL DE EXPRESION ===");
        arbol.imprimirArbol();

        System.out.println("\nResultado de (3 + 5) * (10 - 2): " + evaluar(mult));
    }

    /**
     * Evalua el arbol de forma recursiva.
     * Si es hoja devuelve el numero; si no, resuelve los dos lados
     * y aplica el operador que tiene el nodo.
     */
    public static int evaluar(NodoArbol<String> nodo) {

        // Evaluar null no tiene sentido, mejor avisar con una excepcion clara
        if (nodo == null) {
            throw new IllegalArgumentException("No se puede evaluar una referencia null.");
        }

        // Caso base: una hoja es un numero
        if (nodo.esHoja()) {
            return Integer.parseInt(nodo.getDato());
        }

        int izq = evaluar(nodo.getIzquierdo());
        int der = evaluar(nodo.getDerecho());

        return switch (nodo.getDato()) {
            case "+" -> izq + der;
            case "-" -> izq - der;
            case "*" -> izq * der;
            case "/" -> izq / der;
            default -> throw new IllegalArgumentException(
                "Operador no valido: " + nodo.getDato());
        };
    }
}
