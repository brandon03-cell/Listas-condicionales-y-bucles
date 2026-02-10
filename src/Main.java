import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Concierto c1 = new Concierto("Fe ciega", "Madrid", 69.0, 100, true);
        Concierto c2 = new Concierto("Imagine Commits", "Barcelona", 49.0, 50, true);
        Concierto c3 = new Concierto("Adolf Rizzler", "Sevilla", 199.0, 80, true);

        Usuario u1 = new Usuario("Nacho", 15);
        Usuario u2 = new Usuario("Godzilla", 30);
        Usuario u3 = new Usuario("King kong", 20);

        u1.comprarEntrada(c1, Entrada.Tipo.PISTA);
        u1.comprarEntrada(c2, Entrada.Tipo.VIP);
        u2.comprarEntrada(c1, Entrada.Tipo.GRADA);
        u2.comprarEntrada(c3, Entrada.Tipo.PISTA);
        u3.comprarEntrada(c2, Entrada.Tipo.GRADA);
        u3.comprarEntrada(c3, Entrada.Tipo.VIP);

        u1.valorar(c1, 1);
        u2.valorar(c1, 5);
        u3.valorar(c2, 10);

        ArrayList<Concierto> listaConciertos = new ArrayList<>();
        listaConciertos.add(c1);
        listaConciertos.add(c2);
        listaConciertos.add(c3);

        /**
         * Actividades opcionales
         */

        //Opcional 1
        int totalEntradasVendidas = 0;
        for (Concierto c : listaConciertos) {
            totalEntradasVendidas += c.getEntradasVendidas().size();
        }
        System.out.println("Total de entradas vendidas: " + totalEntradasVendidas);

        //Opcional 2
        int totalPista = 0;
        int totalGrada = 0;
        int totalVip = 0;
        for (Concierto c : listaConciertos) {
            for (Entrada e : c.getEntradasVendidas()) {
                if (e.getTipo() == Entrada.Tipo.PISTA) {
                    totalPista++;
                } else if (e.getTipo() == Entrada.Tipo.GRADA) {
                    totalGrada++;
                }  else if (e.getTipo() == Entrada.Tipo.VIP) {
                    totalVip++;
                }
            }
        }
        System.out.println("Total de pistas: " + totalPista + ", Total de gradas: " + totalGrada +
                ", Total de vips: " + totalVip);

        //Opcional 3
        double recaudacionTotal = 0;
        for (Concierto c : listaConciertos) {
            recaudacionTotal += c.calcularRecaudacion();
        }
        System.out.println("Han recaudado en total: " + recaudacionTotal + "€");

        //Opcional 4
        double precioMedioTotal = 0;
        if (totalEntradasVendidas > 0) {
            precioMedioTotal = recaudacionTotal / totalEntradasVendidas;
        }
        System.out.println("Precio medio total: " + precioMedioTotal + "€");

        //Opcional5
        Concierto masVendido = c1;
        if (c2.getEntradasVendidas().size() > masVendido.getEntradasVendidas().size()) {
            masVendido = c2;
        }
        if (c3.getEntradasVendidas().size() > masVendido.getEntradasVendidas().size()) {
            masVendido = c3;
        }
        System.out.println("El concierto con entradas más vendidas es el de " + masVendido.getArtista() +
                " con " + masVendido.getEntradasVendidas().size());

        //Opcional6
        Concierto menosVendido = c1;
        if (c2.getEntradasVendidas().size() < menosVendido.getEntradasVendidas().size()) {
            menosVendido = c2;
        }
        if (c3.getEntradasVendidas().size() < menosVendido.getEntradasVendidas().size()) {
            menosVendido = c3;
        }
        System.out.println("El concierto con menos entradas vendidas es la de " + menosVendido.getArtista() +
                " con " + menosVendido.getEntradasVendidas().size());
    }
}