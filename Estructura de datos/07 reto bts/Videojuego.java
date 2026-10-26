// Esta clase es el producto del catalogo: un videojuego.
// Cada videojuego tiene un codigo que no se repite, un titulo y un precio.
public class Videojuego {
    private final int codigo;
    private final String titulo;
    private final double precio;

    // Constructor: guarda los datos que le pasamos
    public Videojuego(int codigo, String titulo, double precio) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.precio = precio;
    }

    public int getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public double getPrecio() { return precio; }

    // Para que al imprimir el objeto se vea bonito
    @Override
    public String toString() {
        return String.format("[VJ-%05d] %s - $%.2f", codigo, titulo, precio);
    }
}
