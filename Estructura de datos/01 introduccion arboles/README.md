# Guía 2. Anatomía y propiedades de un árbol

**Asignatura:** Estructura de Datos II  
**Programa:** Ingeniería de Software / Ingeniería de Sistemas  
**Semestre:** IV  
**Ecosistema:** Java / GitHub

## 1. Qué se hizo

Se construyó un árbol general de 12 nodos (A a L) y cuatro niveles. El programa calcula e imprime la cantidad de nodos, la raíz, el grado del árbol, la altura, el padre, el grado, la profundidad, la altura y el tipo de cada nodo. También muestra la profundidad de cada hoja, dos caminos distintos y una prueba donde se agrega un nuevo nivel.

El código tiene comentarios explicativos en español para que se entienda el propósito de cada línea importante.

## 2. Conceptos usados

- **Raíz:** A, porque no tiene padre.
- **Hoja:** nodo que no tiene hijos. En el árbol original son F, G, I, J, K y L.
- **Nodo interno:** nodo que tiene al menos un hijo y no es una hoja. En este árbol son A, B, C, D, E y H. La raíz también tiene hijos, por eso su grado es 3.
- **Grado de un nodo:** cantidad de hijos directos.
- **Grado del árbol:** mayor grado entre sus nodos; en este caso es 3.
- **Profundidad:** número de aristas desde la raíz. La raíz tiene profundidad 0.
- **Altura de un nodo:** número de aristas del camino más largo desde ese nodo hasta una hoja.
- **Altura del árbol:** altura de la raíz. En el árbol inicial es 3.
- **Camino:** secuencia de nodos conectados por aristas. Su longitud se cuenta en aristas.

## 3. Diagrama del árbol

```text
                 A (raíz)
              /     |     \
             B      C      D
           /   \   / \     \
          E     F G   H     I
         / \          \
        J   K           L
```

Este árbol tiene 12 nodos y cuatro niveles si se cuentan desde el nivel 1: A está en el nivel 1 y J, K y L están en el nivel 4. En términos de profundidad, esos últimos nodos tienen profundidad 3.

## 4. Tabla de métricas del árbol original

| Nodo | Padre | Grado | Profundidad | Altura | Tipo |
|---|---|---:|---:|---:|---|
| A | Ninguno | 3 | 0 | 3 | Raíz |
| B | A | 2 | 1 | 2 | Interno |
| C | A | 2 | 1 | 2 | Interno |
| D | A | 1 | 1 | 1 | Interno |
| E | B | 2 | 2 | 1 | Interno |
| F | B | 0 | 2 | 0 | Hoja |
| G | C | 0 | 2 | 0 | Hoja |
| H | C | 1 | 2 | 1 | Interno |
| I | D | 0 | 2 | 0 | Hoja |
| J | E | 0 | 3 | 0 | Hoja |
| K | E | 0 | 3 | 0 | Hoja |
| L | H | 0 | 3 | 0 | Hoja |

## 5. Ejercicios resueltos

### Profundidad de cada hoja
F = 2, G = 2, I = 2, J = 3, K = 3 y L = 3.

### Dos caminos distintos
- A → B → E → J: longitud de 3 aristas.
- A → C → H → L: longitud de 3 aristas.

### Agregar un nuevo nivel
El programa crea el nodo M y lo conecta debajo de L. El camino A → C → H → L → M tiene 4 aristas, por eso la altura del árbol cambia de 3 a 4.

## 6. Cómo ejecutar el programa

Necesitas tener instalado el JDK de Java.

1. Descomprime el ZIP.
2. Abre la carpeta `02-propiedades-arboles` en Visual Studio Code.
3. Abre una terminal dentro de esa carpeta.
4. Ejecuta estos comandos:

```bash
javac src/Main.java
java -cp src Main
```

Si usas una terminal de Windows, los comandos son iguales si Java está agregado al PATH.

## 7. Evidencias para Moodle / GitHub

La carpeta incluye el código Java y este documento explicativo. Después de ejecutar el programa, toma una captura de la terminal donde se vean los resultados. Para GitHub, crea un repositorio llamado `EstructuraDatosII-Apellido` y sube la carpeta del proyecto; cambia `Apellido` por tu apellido.

## 8. Nota sobre la altura

Se usa la convención habitual en la que la altura de una hoja es 0 y la altura se mide en aristas, no en cantidad de nodos. Por eso un árbol con cuatro niveles tiene altura 3.
