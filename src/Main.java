import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Concierto c1 = new Concierto("Fe ciega", "Madrid", 30.0, 100, true);
        Concierto c2 = new Concierto("Imagine Commits", "Barcelona", 40.0, 50, true);
        Concierto c3 = new Concierto("Adolf Rizzler", "Sevilla", 25.0, 80, true);

        Usuario u1 = new Usuario("Nacho", 25);
        Usuario u2 = new Usuario("Godzilla", 30);
        Usuario u3 = new Usuario("King kong", 20);

        u1.comprarEntrada(c1, Entrada.Tipo.PISTA);
        u1.comprarEntrada(c2, Entrada.Tipo.VIP);
        u2.comprarEntrada(c1, Entrada.Tipo.GRADA);
        u2.comprarEntrada(c3, Entrada.Tipo.PISTA);
        u3.comprarEntrada(c2, Entrada.Tipo.GRADA);
        u3.comprarEntrada(c3, Entrada.Tipo.VIP);

        u1.valorar(c1, 9);
        u2.valorar(c1, 8);
        u3.valorar(c2, 10);

        ArrayList<Concierto> listaConciertos = new ArrayList<>();
        listaConciertos.add(c1);
        listaConciertos.add(c2);
        listaConciertos.add(c3);

        int totalEntradasVendidas = 0;
        int totalPista = 0;
        int totalGrada = 0;
        int totalVip = 0;
        double recaudacionTotal = 0;

        for (Concierto c : listaConciertos) {
            totalEntradasVendidas += c.getEntradasVendidas().size();
            recaudacionTotal += c.calcularRecaudacion();

            for (Entrada e : c.getEntradasVendidas()) {
                if (e.getTipo() == Entrada.Tipo.PISTA) {
                    totalPista++;
                } else if (e.getTipo() == Entrada.Tipo.GRADA) {
                    totalGrada++;
                } else if (e.getTipo() == Entrada.Tipo.VIP) {
                    totalVip++;
                }
            }
        }

        double precioMedioTotal = 0;
        if (totalEntradasVendidas > 0) {
            precioMedioTotal = recaudacionTotal / totalEntradasVendidas;
        }

        Concierto masVendido = c1;
        if (c2.getEntradasVendidas().size() > masVendido.getEntradasVendidas().size()) {
            masVendido = c2;
        }
        if (c3.getEntradasVendidas().size() > masVendido.getEntradasVendidas().size()) {
            masVendido = c3;
        }

        Concierto menosVendido = c1;
        if (c2.getEntradasVendidas().size() < menosVendido.getEntradasVendidas().size()) {
            menosVendido = c2;
        }
        if (c3.getEntradasVendidas().size() < menosVendido.getEntradasVendidas().size()) {
            menosVendido = c3;
        }

        System.out.println("1. Entradas totales vendidas: " + totalEntradasVendidas);
        System.out.println("2. Por tipo - Pista: " + totalPista + ", Grada: " + totalGrada + ", VIP: " + totalVip);
        System.out.println("3. Recaudación total: " + recaudacionTotal + " €");
        System.out.println("4. Precio medio de todas las entradas: " + precioMedioTotal + " €");
        System.out.println("5. Más vendido: " + masVendido.getArtista() + " con " + masVendido.getEntradasVendidas().size());
        System.out.println("6. Menos vendido: " + menosVendido.getArtista() + " con " + menosVendido.getEntradasVendidas().size());
    }
}