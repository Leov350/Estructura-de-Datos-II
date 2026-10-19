# Guia 3 - Arbol binario y modelado en Java

**Asignatura:** Estructura de Datos II
**Programa:** Ingenieria de Software - Semestre IV
**Ecosistema:** Java / GitHub

## Objetivo

Disenar e implementar de forma nativa un arbol binario usando referencias
izquierda y derecha en Java (sin usar colecciones de la libreria).

## Arbol principal (Main)

```text
               Java
             /      \
        Python        C++
        /   \        /   \
      Go   Rust    PHP   Swift
```

Tiene 7 nodos, 4 hojas y altura 2. Es **lleno** (cada nodo tiene 0 o 2 hijos),
**completo** (los niveles se llenan de izquierda a derecha) y **perfecto**
(todas las hojas estan en el mismo nivel). Los diagramas estan en
`diagramas_arboles.pdf`.

## Archivos

| Archivo | Que hace |
|---|---|
| `NodoArbol.java` | Nodo generico con dato y referencias izquierda/derecha |
| `ArbolBinario.java` | Guarda la raiz; imprime y cuenta nodos, hojas y altura |
| `Main.java` | Construye el arbol de 7 nodos y hace las pruebas |
| `EjemploArbolExpresion.java` | Ejercicio del arbol de expresiones |
| `salida_esperada.txt` | Salida real de `Main` |
| `salida_arbol_expresion.txt` | Salida real del ejemplo de expresiones |
| `diagramas_arboles.pdf` | Diagramas de los dos arboles (Main y expresion) |
| `clasificacion_arboles.pdf` | Lleno, completo, perfecto y degenerado con lenguajes |

## Compilar y ejecutar

```bash
javac NodoArbol.java ArbolBinario.java Main.java EjemploArbolExpresion.java
java Main
java EjemploArbolExpresion
```

## Modelo en memoria

Cada `NodoArbol` es un objeto en el heap con tres campos: el dato y dos
referencias. Una referencia guarda la direccion de otro nodo, o `null` si no
hay nada ahi. El arbol completo se recorre desde la raiz siguiendo esas
referencias.

```text
 raiz ---> [ Java | izq | der ]
                    |       \
                    v        v
          [ Python | .. | .. ]   [ C++ | .. | .. ]
                 ...                ...
```

## Null vs. nodo hoja

- Una referencia `null` significa que **no existe ningun objeto** en esa posicion.
- Un nodo hoja **si existe** (es un objeto), pero sus dos referencias son `null`.

Por eso `go.esHoja()` da `true`, mientras que `go.getIzquierdo()` es `null`
y no se le puede pedir el dato.

## Como se evita NullPointerException

Antes de usar un hijo se revisa que no sea null:

```java
if (nodo.getIzquierdo() != null) {
    System.out.println(nodo.getIzquierdo().getDato());
}
```

Ademas, `imprimirRaizYHijos()` revisa primero si el arbol esta vacio, y
los metodos recursivos tienen como caso base `nodo == null`.

## Clasificacion del arbol de 7 nodos

Lleno, completo y perfecto a la vez (ver diagrama).

## Reto

Comentar la linea `cpp.setDerecho(swift);` en `Main`, volver a ejecutar y responder:

1. Cuantos nodos quedan enlazados al arbol?
2. Cuantas hojas tiene?
3. Sigue siendo lleno?
4. Sigue siendo completo?
5. Sigue siendo perfecto?
6. Que referencia quedo en `null`?
