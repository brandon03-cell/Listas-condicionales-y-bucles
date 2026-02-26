import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Concierto c1 = new Concierto("Benito", "Puerto Rico", 110, 60000, new ArrayList<>(), true);
        Concierto c2 = new Concierto("Michael Jackson", "Nueva Delhi", 90, 200000, new ArrayList<>(), false);
        Concierto c3 = new Concierto("Melendi", "Madrid", 40, 40000,  new ArrayList<>(), true);

        Usuario u1 = new Usuario();
        u1.setNombre("Brandon");
        u1.setEdad(22);
        Usuario u2 = new Usuario();
        u2.setNombre("Terry");
        u2.setEdad(15);
        Usuario u3 = new Usuario();
        u3.setNombre("Nerealba");
        u3.setEdad(93);

        u1.comprarEntrada(c2, Entrada.Tipo.VIP);
        u1.comprarEntrada(c1, Entrada.Tipo.GRADA);
        u2.comprarEntrada(c1, Entrada.Tipo.VIP);
        u2.comprarEntrada(c2, Entrada.Tipo.GRADA);
        u3.comprarEntrada(c1, Entrada.Tipo.PISTA);
        u3.comprarEntrada(c3, Entrada.Tipo.VIP);

        u1.valorar(c1, 10);
        u2.valorar(c1, 0);
        u3.valorar(c1, 8);

        int totalEntradas = 0;
        int totalPista = 0;
        int totalGrada = 0;
        int totalVip = 0;
        double recaudacionTotal = 0;
        Concierto menor = c1;
        Concierto mayor = c1;
        ArrayList<Concierto> cs = new ArrayList<>();
        cs.add(c1);
        cs.add(c2);
        cs.add(c3);
        for (Concierto concierto : cs) {
            totalEntradas += concierto.getEntradasVendidas().size();
            for (Entrada e :  concierto.getEntradasVendidas()) {
                if (e.getTipo() == Entrada.Tipo.PISTA) {
                    totalPista++;
                } else if (e.getTipo() == Entrada.Tipo.GRADA) {
                    totalGrada++;
                } else {
                    totalVip++;
                }
            }
            recaudacionTotal += concierto.calcularRecaudacion();
            if (concierto.getEntradasVendidas().size() > mayor.getEntradasVendidas().size()) {
                mayor = concierto;
            }
            if (concierto.getEntradasVendidas().size() < menor.getEntradasVendidas().size()) {
                menor = concierto;
            }
        }
        System.out.println("Total entradas: " + totalEntradas);
        System.out.println("Recaudación total: " + recaudacionTotal);
        System.out.println("Pista total: " + totalPista);
        System.out.println("Grada total: " + totalGrada);
        System.out.println("VIP total: " + totalVip);
        System.out.println("Precio medio: " + (recaudacionTotal / totalEntradas));
        System.out.println("Concierto con más entradas: " + mayor + " (" + mayor.getEntradasVendidas().size() + ")");
        System.out.println("Concierto con menos entradas: " + menor + " (" + menor.getEntradasVendidas().size() + ")");
    }
}