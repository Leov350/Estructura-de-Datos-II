/**
 * Clase de apoyo para manejar el arbol.
 * Solo guarda la raiz; todo lo demas se alcanza siguiendo
 * las referencias izquierda y derecha de cada nodo.
 */
public class ArbolBinario<T> {

    private NodoArbol<T> raiz;

    // Arbol vacio (la raiz es null)
    public ArbolBinario() {
        raiz = null;
    }

    // Arbol que ya arranca con una raiz
    public ArbolBinario(NodoArbol<T> raiz) {
        this.raiz = raiz;
    }

    public NodoArbol<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol<T> raiz) {
        this.raiz = raiz;
    }

    /**
     * Metodo pedido en la guia: imprime la raiz y sus dos hijos.
     * Se revisa cada referencia antes de usarla para no caer
     * en un NullPointerException.
     */
    public void imprimirRaizYHijos() {

        // Primero miramos si el arbol esta vacio
        if (raiz == null) {
            System.out.println("El arbol esta vacio.");
            return;
        }

        System.out.println("Raiz: " + raiz.getDato());

        // Hijo izquierdo: solo pedimos el dato si existe
        if (raiz.getIzquierdo() != null) {
            System.out.println("Hijo izquierdo: " + raiz.getIzquierdo().getDato());
        } else {
            System.out.println("Hijo izquierdo: null");
        }

        // Lo mismo con el hijo derecho
        if (raiz.getDerecho() != null) {
            System.out.println("Hijo derecho: " + raiz.getDerecho().getDato());
        } else {
            System.out.println("Hijo derecho: null");
        }
    }

    // Imprime todo el arbol con sangria segun el nivel
    public void imprimirArbol() {
        if (raiz == null) {
            System.out.println("El arbol esta vacio.");
            return;
        }
        imprimirRecursivo(raiz, 0, "RAIZ");
    }

    private void imprimirRecursivo(NodoArbol<T> nodo, int nivel, String relacion) {

        // Caso base: si no hay nodo, no hay nada que imprimir
        if (nodo == null) {
            return;
        }

        // Tres espacios por cada nivel para que se vea la jerarquia
        String sangria = "   ".repeat(nivel);
        System.out.println(sangria + relacion + " -> " + nodo.getDato());

        // Bajamos primero por la izquierda y luego por la derecha
        imprimirRecursivo(nodo.getIzquierdo(), nivel + 1, "IZQ");
        imprimirRecursivo(nodo.getDerecho(), nivel + 1, "DER");
    }

    // Cuenta todos los nodos del arbol
    public int contarNodos() {
        return contarNodos(raiz);
    }

    private int contarNodos(NodoArbol<T> nodo) {
        if (nodo == null) return 0;
        // 1 por este nodo + lo que haya a cada lado
        return 1 + contarNodos(nodo.getIzquierdo()) + contarNodos(nodo.getDerecho());
    }

    // Cuenta los nodos que no tienen hijos
    public int contarHojas() {
        return contarHojas(raiz);
    }

    private int contarHojas(NodoArbol<T> nodo) {
        if (nodo == null) return 0;
        if (nodo.esHoja()) return 1;
        return contarHojas(nodo.getIzquierdo()) + contarHojas(nodo.getDerecho());
    }

    /**
     * Altura contada en aristas (lineas entre nodos).
     * Arbol vacio = -1 y una hoja sola = 0.
     */
    public int altura() {
        return altura(raiz);
    }

    private int altura(NodoArbol<T> nodo) {
        if (nodo == null) return -1;
        int izq = altura(nodo.getIzquierdo());
        int der = altura(nodo.getDerecho());
        // Nos quedamos con el lado mas profundo y sumamos 1 por este nodo
        return 1 + Math.max(izq, der);
    }
}
