import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Objects;

public class Usuario {
    private String nombre;
    private int edad;
    private ArrayList<Entrada> entradasCompradas = new ArrayList<>();
    private HashSet<Concierto> conciertosAsistidos = new HashSet<>();
    private HashMap<Concierto, Integer> valoraciones = new HashMap<>();

    public Usuario(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Usuario() {
    }

    public void comprarEntrada(Concierto concierto, Entrada.Tipo tipo) {
        if (!concierto.isActivo()) {
            System.out.println("Error: El concierto no está activo.");
            return;
        }
        if (conciertosAsistidos.contains(concierto)) {
            System.out.println("Error: Ya has asistido a este concierto.");
            return;
        }
        if (!concierto.entradasDisponibles()) {
            System.out.println("Error: No hay entradas disponibles.");
            return;
        }
        Entrada nuevaEntrada = new Entrada(concierto, tipo);
        concierto.getEntradasVendidas().add(nuevaEntrada);
        this.entradasCompradas.add(nuevaEntrada);
        this.conciertosAsistidos.add(concierto);
    }

    public void valorar(Concierto concierto, int valoracion) {
        if (!conciertosAsistidos.contains(concierto)) {
            System.out.println("Error: No has asistido a este concierto.");
            return;
        }
        if (valoracion < 0 || valoracion > 10) {
            System.out.println("Error: La valoración debe ser entre 0 y 10.");
            return;
        }
        valoraciones.put(concierto, valoracion);
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
        return getEdad() == usuario.getEdad() && Objects.equals(getNombre(), usuario.getNombre()) &&
                Objects.equals(getEntradasCompradas(), usuario.getEntradasCompradas()) && Objects.equals(getConciertosAsistidos(),
                usuario.getConciertosAsistidos()) && Objects.equals(getValoraciones(), usuario.getValoraciones());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getEdad(), getEntradasCompradas(), getConciertosAsistidos(), getValoraciones());
    }

    @Override
    public String toString() {
        return getNombre() + " (ha asistido a " + getConciertosAsistidos().size() + ")";
    }
}