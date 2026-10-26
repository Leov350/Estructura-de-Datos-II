/*
  ArbolBST.java
  Arbol Binario de Busqueda (Guia 4 y Guia 5)
  - insertar() recursivo
  - buscar() recursivo (con contador de comparaciones y camino)
  - minValor() para hallar el sucesor inorden
  - eliminar() con los tres casos: hoja, un hijo, dos hijos
  Convencion: menores a la izquierda, mayores o iguales a la derecha.
*/
public class ArbolBST {

    private NodoArbol<Integer> raiz;

    // contador de comparaciones de la ultima busqueda
    private int comparaciones;

    public ArbolBST() {
        raiz = null;
        comparaciones = 0;
    }

    /* ============================
       INSERTAR (recursivo)
       ============================ */
    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private NodoArbol<Integer> insertarRec(NodoArbol<Integer> nodo, int valor) {
        // caso base: posicion vacia, se crea el nodo
        if (nodo == null) return new NodoArbol<>(valor);

        if (valor < nodo.getDato()) {
            nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(), valor));
        } else {
            nodo.setDerecho(insertarRec(nodo.getDerecho(), valor));
        }
        return nodo;
    }

    /* ============================
       BUSCAR (recursivo)
       ============================ */
    public boolean buscar(int valor) {
        comparaciones = 0;
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(NodoArbol<Integer> nodo, int valor) {
        if (nodo == null) return false;
        comparaciones++; // cada nodo visitado cuenta como una comparacion
        if (valor == nodo.getDato()) return true;
        return valor < nodo.getDato()
                ? buscarRec(nodo.getIzquierdo(), valor)
                : buscarRec(nodo.getDerecho(), valor);
    }

    public int getComparaciones() {
        return comparaciones;
    }

    // Devuelve el camino recorrido durante la busqueda, por ejemplo: 50 -> 30 -> 40
    public String buscarConCamino(int valor) {
        StringBuilder camino = new StringBuilder();
        NodoArbol<Integer> actual = raiz;
        while (actual != null) {
            if (camino.length() > 0) camino.append(" -> ");
            camino.append(actual.getDato());
            if (valor == actual.getDato()) {
                return camino + "  (ENCONTRADO)";
            }
            actual = (valor < actual.getDato()) ? actual.getIzquierdo() : actual.getDerecho();
        }
        if (camino.length() > 0) camino.append(" -> ");
        camino.append("null");
        return camino + "  (NO ENCONTRADO)";
    }

    /* ============================
       MIN VALOR
       Minimo de un subarbol: se baja siempre por la izquierda.
       Se usa para obtener el sucesor inorden.
       ============================ */
    public int minValor(NodoArbol<Integer> nodo) {
        int min = nodo.getDato();
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
            min = nodo.getDato();
        }
        return min;
    }

    /* ============================
       ELIMINAR (recursivo)
       Caso 1: hoja        -> se retorna null
       Caso 2: un hijo     -> se retorna el hijo que existe
       Caso 3: dos hijos   -> se copia el sucesor inorden y se elimina
                              el duplicado del subarbol derecho
       ============================ */
    public void eliminar(int valor) {
        raiz = eliminarRec(raiz, valor);
    }

    private NodoArbol<Integer> eliminarRec(NodoArbol<Integer> nodo, int valor) {
        if (nodo == null) return null;

        if (valor < nodo.getDato()) {
            nodo.setIzquierdo(eliminarRec(nodo.getIzquierdo(), valor));
        } else if (valor > nodo.getDato()) {
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), valor));
        } else {
            // se encontro el nodo a eliminar

            // caso 1 y 2: sin hijo izquierdo (incluye hoja)
            if (nodo.getIzquierdo() == null) return nodo.getDerecho();
            // caso 2: sin hijo derecho
            if (nodo.getDerecho() == null) return nodo.getIzquierdo();

            // caso 3: dos hijos
            int sucesor = minValor(nodo.getDerecho());
            nodo.setDato(sucesor);
            // se elimina el valor duplicado del subarbol derecho
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), sucesor));
        }
        return nodo;
    }

    /* ============================
       UTILIDADES
       ============================ */
    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(NodoArbol<Integer> nodo) {
        if (nodo == null) return 0;
        return 1 + Math.max(alturaRec(nodo.getIzquierdo()), alturaRec(nodo.getDerecho()));
    }

    // Recorrido inorden: en un BST valido siempre sale ordenado
    public String inorden() {
        StringBuilder sb = new StringBuilder();
        inordenRec(raiz, sb);
        return sb.toString().trim();
    }

    private void inordenRec(NodoArbol<Integer> nodo, StringBuilder sb) {
        if (nodo == null) return;
        inordenRec(nodo.getIzquierdo(), sb);
        sb.append(nodo.getDato()).append(" ");
        inordenRec(nodo.getDerecho(), sb);
    }

    // Verifica que el arbol cumpla la propiedad BST
    public boolean esBST() {
        return esBSTRec(raiz, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean esBSTRec(NodoArbol<Integer> nodo, long min, long max) {
        if (nodo == null) return true;
        int d = nodo.getDato();
        // izquierda: estrictamente menor; derecha: mayor o igual
        if (d < min || d >= max) return false;
        return esBSTRec(nodo.getIzquierdo(), min, d)
            && esBSTRec(nodo.getDerecho(), d, max);
    }

    // Dibuja el arbol de lado: la raiz queda a la izquierda,
    // el subarbol derecho arriba y el izquierdo abajo.
    public void imprimirArbol() {
        if (raiz == null) {
            System.out.println("(arbol vacio)");
            return;
        }
        imprimirRec(raiz, 0);
    }

    private void imprimirRec(NodoArbol<Integer> nodo, int nivel) {
        if (nodo == null) return;
        imprimirRec(nodo.getDerecho(), nivel + 1);
        System.out.println("    ".repeat(nivel) + nodo.getDato());
        imprimirRec(nodo.getIzquierdo(), nivel + 1);
    }
}
