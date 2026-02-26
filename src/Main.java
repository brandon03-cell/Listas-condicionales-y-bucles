import java.util.ArrayList;
import exceptions.*;

public class Main {
    public static void main(String[] args) {
        Concierto c1 = new Concierto("Benito", "Puerto Rico", 110, 2, new ArrayList<>(), true); // Aforo pequeño para forzar error
        Concierto c2 = new Concierto("Michael Jackson", "Nueva Delhi", 90, 200000, new ArrayList<>(), false); // Inactivo
        Concierto c3 = new Concierto("Melendi", "Madrid", 40, 40000, new ArrayList<>(), true);

        Usuario u1 = new Usuario();
        u1.setNombre("Brandon");

        System.out.println("--- Iniciando pruebas de excepciones ---");

        try {
            u1.comprarEntrada(c2, Entrada.Tipo.VIP);
        } catch (ConciertoInactivoException e) {
            System.out.println("Aviso: " + e.getMessage());
        } catch (Exception e) { System.out.println("Error inesperado"); }

        try {
            u1.comprarEntrada(c1, Entrada.Tipo.PISTA);
            u1.comprarEntrada(c1, Entrada.Tipo.PISTA);
        } catch (ConciertoYaAsistidoException e) {
            System.out.println("Aviso: " + e.getMessage());
        } catch (Exception e) { e.printStackTrace(); }

        try {
            Usuario u2 = new Usuario();
            u2.comprarEntrada(c1, Entrada.Tipo.GRADA);
        } catch (AforoCompletoException e) {
            System.out.println("Aviso: " + e.getMessage());
        } catch (Exception e) { e.printStackTrace(); }

        try {
            u1.valorar(c3, 10);
        } catch (ConciertoNoAsistidoException e) {
            System.out.println("Aviso: " + e.getMessage());
        } catch (Exception e) { e.printStackTrace(); }

        try {
            u1.valorar(c1, 50);
        } catch (ValoracionIncorrecta e) {
            System.out.println("Aviso: " + e.getMessage());
        } catch (Exception e) { e.printStackTrace(); }

        try {
            System.out.println("Precio medio c3: " + c3.calcularPrecioMedio());
        } catch (CeroEntradasException e) {
            System.out.println("Aviso: " + e.getMessage());
        }

        System.out.println("--- Pruebas finalizadas con éxito ---");
    }
}