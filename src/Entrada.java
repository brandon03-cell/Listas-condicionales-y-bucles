import java.util.Objects;

public class Entrada {
    private Concierto concierto;
    public enum Tipo {
        PISTA,
        GRADA,
        VIP};
    private Tipo tipo;

    public Entrada(Concierto concierto, Tipo tipo) {
        this.concierto = concierto;
        this.tipo = tipo;
    }

    public Entrada() {
    }

    public double getPrecioTotal() {
        double precioBase = concierto.getPrecioBase();

        switch (this.tipo) {
            case GRADA:
                return precioBase;
            case PISTA:
                return precioBase * 1.10;
            case VIP:
                return precioBase * 1.20;
            default:
                return 0;
        }
    }

    public Concierto getConcierto() {
        return concierto;
    }

    public void setConcierto(Concierto concierto) {
        this.concierto = concierto;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entrada entrada = (Entrada) o;
        return getTipo() == entrada.getTipo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTipo());
    }

    @Override
    public String toString() {
        return "Enrada de " + getPrecioTotal() + "€";
    }
}
