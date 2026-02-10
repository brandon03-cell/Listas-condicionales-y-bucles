import java.util.ArrayList;
import java.util.Objects;

public class Concierto {
    private String artista;
    private String ciudad;
    private double precioBase;
    private int aforoMaximo;
    private ArrayList<Entrada> entradasVendidas = new ArrayList();
    private boolean activo;

    public Concierto(String artista, String ciudad, double precioBase, int aforoMaximo, ArrayList<Entrada> entradasVendidas, boolean activo) {
        this.artista = artista;
        this.ciudad = ciudad;
        this.precioBase = precioBase;
        this.aforoMaximo = aforoMaximo;
        this.entradasVendidas = entradasVendidas;
        this.activo = activo;
    }

    public Concierto() {
    }

    public double calcularRecaudacion() {
        double totalRecaudado = 0;
        for (Entrada e : entradasVendidas) {
            totalRecaudado += e.getPrecioTotal();
        }
        return totalRecaudado;
    }

    public double calcularPrecioMedio() {
        int totalEntradas = entradasVendidas.size();
        if (totalEntradas == 0) {
            return 0;
        }
        double recaudacionTotal = calcularRecaudacion();
        return recaudacionTotal / totalEntradas;
    }

    public boolean entradasDisponibles() {
        if (entradasVendidas.size() < aforoMaximo) {
            return true;
        } else {
            return false;
        }
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getAforoMaximo() {
        return aforoMaximo;
    }

    public void setAforoMaximo(int aforoMaximo) {
        this.aforoMaximo = aforoMaximo;
    }

    public ArrayList<Entrada> getEntradasVendidas() {
        return entradasVendidas;
    }

    public void setEntradasVendidas(ArrayList<Entrada> entradasVendidas) {
        this.entradasVendidas = entradasVendidas;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Concierto concierto = (Concierto) o;
        return Double.compare(getPrecioBase(), concierto.getPrecioBase()) == 0 && getAforoMaximo() == concierto.getAforoMaximo() && isActivo() == concierto.isActivo() &&
                Objects.equals(getArtista(), concierto.getArtista()) && Objects.equals(getCiudad(), concierto.getCiudad()) && Objects.equals(getEntradasVendidas(), concierto.getEntradasVendidas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArtista(), getCiudad(), getPrecioBase(), getAforoMaximo(), getEntradasVendidas(), isActivo());
    }

    @Override
    public String toString() {
        return "Concierto de " + getArtista() + " en " + getCiudad();
    }
}
