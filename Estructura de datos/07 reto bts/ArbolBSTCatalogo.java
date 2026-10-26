// Arbol binario de busqueda (BST) para guardar los videojuegos.
// La regla es sencilla: lo menor va a la izquierda y lo mayor va a la derecha.
// Se ordena usando el codigo del videojuego.
public class ArbolBSTCatalogo {

    // Cada nodo guarda un videojuego y apunta a sus dos hijos
    private class Nodo {
        Videojuego dato;
        Nodo izq, der;

        Nodo(Videojuego dato) {
            this.dato = dato;
        }
    }

    private Nodo raiz;   // el nodo de arriba del todo
    private int tamano;  // cuantos videojuegos hay guardados

    // ---------- INSERTAR (recursivo) ----------
    // Devuelve true si se inserto y false si el codigo ya estaba
    public boolean insertar(Videojuego v) {
        int antes = tamano;
        raiz = insertar(raiz, v);
        return tamano > antes;
    }

    // Metodo de ayuda que hace el trabajo recursivo
    private Nodo insertar(Nodo actual, Videojuego v) {
        // Si llegamos a un hueco vacio, aqui va el nuevo nodo
        if (actual == null) {
            tamano++;
            return new Nodo(v);
        }
        // Si el codigo es menor, bajamos por la izquierda
        if (v.getCodigo() < actual.dato.getCodigo()) {
            actual.izq = insertar(actual.izq, v);
        }
        // Si es mayor, bajamos por la derecha
        else if (v.getCodigo() > actual.dato.getCodigo()) {
            actual.der = insertar(actual.der, v);
        }
        // Si es igual no hacemos nada porque ya existe
        return actual;
    }

    // ---------- BUSCAR (recursivo) ----------
    // Devuelve el videojuego o null si no esta
    public Videojuego buscar(int codigo) {
        return buscar(raiz, codigo);
    }

    private Videojuego buscar(Nodo actual, int codigo) {
        // Llegamos al final y no estaba
        if (actual == null) return null;

        // Lo encontramos
        if (codigo == actual.dato.getCodigo()) return actual.dato;

        // Si no, seguimos por el lado que corresponda
        if (codigo < actual.dato.getCodigo()) {
            return buscar(actual.izq, codigo);
        } else {
            return buscar(actual.der, codigo);
        }
    }

    // ---------- ALTURA ----------
    // Cuenta cuantos niveles tiene el arbol (camino mas largo)
    public int altura() {
        return altura(raiz);
    }

    private int altura(Nodo n) {
        // Un arbol vacio tiene altura 0
        if (n == null) return 0;
        // Es 1 (este nodo) mas la altura del lado mas profundo
        return 1 + Math.max(altura(n.izq), altura(n.der));
    }

    public int tamano() {
        return tamano;
    }

    // ---------- RECORRIDO INORDEN ----------
    // Imprime todo ordenado de menor a mayor codigo
    public void imprimirInorden() {
        inorden(raiz);
    }

    private void inorden(Nodo n) {
        if (n == null) return;
        inorden(n.izq);              // primero lo menor
        System.out.println(n.dato);  // luego el nodo actual
        inorden(n.der);              // al final lo mayor
    }
}
