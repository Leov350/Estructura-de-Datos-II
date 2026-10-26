import java.util.*;

public class Main {

    // Tipos de juego para inventar titulos
    static final String[] TITULOS = {"Aventura", "Carreras", "Estrategia", "Plataformas",
            "Deportes", "Terror", "Puzzle", "RPG", "Simulador", "Arcade"};

    // Crea un videojuego de prueba a partir de un codigo
    static Videojuego crear(int codigo) {
        String titulo = TITULOS[codigo % TITULOS.length] + " #" + codigo;
        double precio = 10 + (codigo % 60);
        return new Videojuego(codigo, titulo, precio);
    }

    // Mete todos los codigos de la lista en un arbol nuevo, en ese orden
    static ArbolBSTCatalogo construir(List<Integer> codigos) {
        ArbolBSTCatalogo bst = new ArbolBSTCatalogo();
        for (int c : codigos) {
            bst.insertar(crear(c));
        }
        return bst;
    }

    public static void main(String[] args) {

        // ---------- 1. Prueba con pocos datos ----------
        System.out.println("=== PRUEBA FUNCIONAL ===");
        // El 30 esta repetido a proposito para ver que se ignora
        ArbolBSTCatalogo demo = construir(Arrays.asList(50, 30, 70, 20, 40, 60, 80, 30));
        System.out.println("Insertados (el 30 repetido no cuenta): " + demo.tamano());
        System.out.println("Inorden (debe salir ordenado por codigo):");
        demo.imprimirInorden();
        System.out.println("Buscar 60 -> " + demo.buscar(60));
        System.out.println("Buscar 99 -> " + demo.buscar(99));
        System.out.println("Altura: " + demo.altura());

        // ---------- 2. Comparacion ordenado vs aleatorio ----------
        System.out.println("\n=== COMPARACION DE ALTURAS ===");
        int[] tamanos = {10, 100, 500, 1000, 5000};
        int repeticiones = 10;     // el caso aleatorio se repite y se saca el promedio
        Random rnd = new Random(42);

        System.out.printf("%-8s | %-16s | %-18s | %-14s | %-10s%n",
                "n", "Altura ordenado", "Altura aleatorio*", "Altura ideal", "Ord/Aleat");
        System.out.println("-".repeat(80));

        for (int n : tamanos) {
            // Datos ordenados: 1, 2, 3, ... n
            List<Integer> ordenados = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                ordenados.add(i);
            }
            int hOrd = construir(ordenados).altura();

            // Datos aleatorios: revolvemos la lista varias veces y promediamos
            double suma = 0;
            for (int r = 0; r < repeticiones; r++) {
                List<Integer> mezcla = new ArrayList<>(ordenados);
                Collections.shuffle(mezcla, rnd);
                suma += construir(mezcla).altura();
            }
            double hAle = suma / repeticiones;

            // Altura minima posible para n nodos (arbol perfectamente balanceado)
            int hIdeal = (int) Math.ceil(Math.log(n + 1) / Math.log(2));

            System.out.printf("%-8d | %-16d | %-18.1f | %-14d | %.1fx%n",
                    n, hOrd, hAle, hIdeal, hOrd / hAle);
        }
        System.out.println("* promedio de " + repeticiones + " corridas con orden aleatorio");
    }
}
