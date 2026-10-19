import java.util.ArrayList;
import java.util.List;

class NodoGeneral<T> {
    private T dato;
    private List<NodoGeneral<T>> hijos = new ArrayList<>();
    public NodoGeneral(T dato) { this.dato = dato; }
    public void agregarHijo(NodoGeneral<T> hijo) { hijos.add(hijo); }
    public T getDato() { return dato; }
    public List<NodoGeneral<T>> getHijos() { return hijos; }
}

public class Main {
    public static void mostrarArbol(NodoGeneral<String> n, String espacio) {
        System.out.println(espacio + "- " + n.getDato());
        for (NodoGeneral<String> hijo : n.getHijos()) mostrarArbol(hijo, espacio + "  ");
    }
    public static void main(String[] args) {
        NodoGeneral<String> empresa = new NodoGeneral<>("Empresa");
        NodoGeneral<String> tec = new NodoGeneral<>("Tecnología");
        NodoGeneral<String> fin = new NodoGeneral<>("Finanzas");
        NodoGeneral<String> rh = new NodoGeneral<>("Recursos Humanos");
        empresa.agregarHijo(tec); empresa.agregarHijo(fin); empresa.agregarHijo(rh);
        tec.agregarHijo(new NodoGeneral<>("Desarrollo"));
        tec.agregarHijo(new NodoGeneral<>("Infraestructura"));
        tec.agregarHijo(new NodoGeneral<>("Soporte Técnico"));
        fin.agregarHijo(new NodoGeneral<>("Contabilidad"));
        fin.agregarHijo(new NodoGeneral<>("Tesorería"));
        fin.agregarHijo(new NodoGeneral<>("Análisis Financiero"));
        rh.agregarHijo(new NodoGeneral<>("Selección"));
        rh.agregarHijo(new NodoGeneral<>("Capacitación"));
        rh.agregarHijo(new NodoGeneral<>("Bienestar"));
        System.out.println("ÁRBOL JERÁRQUICO DE LA EMPRESA");
        mostrarArbol(empresa, "");
    }
}
