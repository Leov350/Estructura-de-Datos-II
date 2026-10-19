/**
 * Nodo generico de un arbol binario.
 * Guarda un dato y dos referencias: una al hijo izquierdo
 * y otra al hijo derecho. Si no hay hijo, la referencia queda en null.
 */
public class NodoArbol<T> {

    // El dato no cambia una vez creado el nodo, por eso es final
    private final T dato;
    private NodoArbol<T> izquierdo;
    private NodoArbol<T> derecho;

    // Constructor: el nodo nace sin hijos
    public NodoArbol(T dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }

    // ---------- getters ----------

    public T getDato() {
        return dato;
    }

    public NodoArbol<T> getIzquierdo() {
        return izquierdo;
    }

    public NodoArbol<T> getDerecho() {
        return derecho;
    }

    // ---------- setters ----------

    public void setIzquierdo(NodoArbol<T> nodo) {
        this.izquierdo = nodo;
    }

    public void setDerecho(NodoArbol<T> nodo) {
        this.derecho = nodo;
    }

    // ---------- metodos basicos ----------

    // Un nodo hoja si existe, solo que no tiene hijos
    public boolean esHoja() {
        return izquierdo == null && derecho == null;
    }

    // Cuenta cuantos hijos reales tiene (0, 1 o 2)
    public int grado() {
        int total = 0;
        if (izquierdo != null) total++;
        if (derecho != null) total++;
        return total;
    }

    // Para que al imprimir el nodo salga el dato y no la direccion de memoria
    @Override
    public String toString() {
        return String.valueOf(dato);
    }
}
