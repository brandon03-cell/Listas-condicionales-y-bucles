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
        return Objects.equals(getConcierto(), entrada.getConcierto()) && getTipo() == entrada.getTipo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getConcierto(), getTipo());
    }

}
