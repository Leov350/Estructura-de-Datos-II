# Guía 1: De lo lineal a lo jerárquico

**Repositorio sugerido:** `EstructuraDatosII-PasosCastilla`  
**Asignatura:** Estructura de Datos II — Ingeniería de Software, IV semestre  
**Lenguaje:** Java

## Clasificación de los cuatro escenarios

| Escenario | Clasificación | Justificación |
|---|---|---|
| Sistema de archivos | Jerárquico | Las carpetas contienen subcarpetas y archivos. |
| Organigrama empresarial | Jerárquico | Las áreas contienen departamentos o unidades subordinadas. |
| Menú de una aplicación | Jerárquico | Las opciones pueden tener subopciones. |
| Árbol genealógico | Jerárquico | Representa generaciones y relaciones familiares. |

## Modelo elegido
La raíz es Empresa. Sus áreas son Tecnología, Finanzas y Recursos Humanos, y cada una contiene tres unidades. El código construye y muestra el árbol en consola.

## Reflexión (150–200 palabras)
Un árbol es útil cuando los elementos tienen relaciones de dependencia organizadas por niveles. En el organigrama empresarial, la empresa funciona como raíz; debajo se encuentran Tecnología, Finanzas y Recursos Humanos, y cada área contiene unidades específicas. Esta representación permite reconocer qué unidades pertenecen a cada departamento. En cambio, una lista presenta los elementos en una secuencia y no muestra directamente las relaciones entre padres e hijos.\n\nLos cuatro escenarios analizados pueden representarse como estructuras jerárquicas: el sistema de archivos organiza carpetas, subcarpetas y archivos; el organigrama agrupa áreas y departamentos; el menú de una aplicación contiene opciones y subopciones; y el árbol genealógico organiza personas por generaciones y vínculos familiares. En estos casos, la jerarquía facilita la lectura de relaciones y la navegación entre niveles.\n\nLa clase NodoGeneral almacena un dato y una lista de hijos, por lo que cada nodo puede tener varios descendientes. Si un nodo pudiera tener más de un padre, ya no cumpliría la regla habitual de un árbol tradicional y el modelo se acercaría a un grafo, donde un elemento puede relacionarse con varios nodos. Por eso se debe elegir la estructura de datos según las relaciones del problema.

## Compilar y ejecutar
```bash
javac Main.java
java Main
```

## Evidencias
- `Main.java`: código Java.
- `arbol-organigrama.drawio`: diagrama editable.
- `Diagrama_Organigrama.pdf`: diagrama exportado.
- `Explicacion_una_pagina.pdf`: explicación resumida.

Crea el repositorio `EstructuraDatosII-PasosCastilla`, sube estos archivos y copia el enlace en Moodle. Ajusta el nombre si el docente pide otro formato de apellido.
