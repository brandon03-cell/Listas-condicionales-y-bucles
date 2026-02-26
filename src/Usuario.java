import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Usuario {
    private String nombre;
    private int edad;
    private ArrayList<Entrada> entradasCompradas;
    private HashSet<Concierto> conciertosAsistidos;
    private HashMap<Concierto, Integer> valoraciones;

    public Usuario() {
        entradasCompradas = new ArrayList<>();
        conciertosAsistidos = new HashSet<>();
        valoraciones = new HashMap<>();
    }

    public Usuario(String nombre, int edad, ArrayList<Entrada> entradasCompradas, HashSet<Concierto> conciertosAsistidos, HashMap<Concierto, Integer> valoraciones) {
        this.nombre = nombre;
        this.edad = edad;
        this.entradasCompradas = entradasCompradas;
        this.conciertosAsistidos = conciertosAsistidos;
        this.valoraciones = valoraciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Entrada> getEntradasCompradas() {
        return entradasCompradas;
    }

    public void setEntradasCompradas(ArrayList<Entrada> entradasCompradas) {
        this.entradasCompradas = entradasCompradas;
    }

    public HashSet<Concierto> getConciertosAsistidos() {
        return conciertosAsistidos;
    }

    public void setConciertosAsistidos(HashSet<Concierto> conciertosAsistidos) {
        this.conciertosAsistidos = conciertosAsistidos;
    }

    public HashMap<Concierto, Integer> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(HashMap<Concierto, Integer> valoraciones) {
        this.valoraciones = valoraciones;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return edad == usuario.edad && Objects.equals(nombre, usuario.nombre) && Objects.equals(entradasCompradas, usuario.entradasCompradas) && Objects.equals(conciertosAsistidos, usuario.conciertosAsistidos) && Objects.equals(valoraciones, usuario.valoraciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad, entradasCompradas, conciertosAsistidos, valoraciones);
    }

    @Override
    public String toString() {
        return nombre + " (ha asistido a " + conciertosAsistidos.size() + " conciertos)";
    }

    public void comprarEntrada(Concierto concierto, Entrada.Tipo tipo) {
        if (!concierto.isActivo()) {
            System.out.println("El concierto no está activo");
        } else if (conciertosAsistidos.contains(concierto)) {
            System.out.println("Ya has asistido a este concierto");
        } else if (!concierto.entradasDisponibles()) {
            System.out.println("No hay entradas disponibles");
        } else {
            Entrada entrada = new Entrada(concierto, tipo);
            concierto.getEntradasVendidas().add(entrada);
            entradasCompradas.add(entrada);
            conciertosAsistidos.add(concierto);
        }
    }

    public void valorar(Concierto concierto, Integer valoracion) {
        if (!conciertosAsistidos.contains(concierto)) {
            System.out.println("No has asistido a este concierto");
        } else if (valoracion < 0 || valoracion > 10) {
            System.out.println("Valoración inválida");
        } else {
            valoraciones.put(concierto, valoracion);
        }
    }
}