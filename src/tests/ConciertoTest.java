package tests;

import clases.Concierto;
import clases.Entrada;
import exceptions.CeroEntradasException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ConciertoTest {

    @Test
    void calcularPrecioMedio() throws CeroEntradasException {
        Concierto c1 = new Concierto("Melendi", "Madrid", 100.0, 40000, new ArrayList<>(), true);

        c1.getEntradasVendidas().add(new Entrada(c1, Entrada.Tipo.GRADA));
        c1.getEntradasVendidas().add(new Entrada(c1, Entrada.Tipo.VIP));

        assertEquals(110.0, c1.calcularPrecioMedio(), "La media de una entrada de 100 y otra de 120 debe ser 110");

        Concierto cVacio = new Concierto("Vacio", "Desierto", 50.0, 100, new ArrayList<>(), true);

        assertThrows(CeroEntradasException.class, () -> {
            cVacio.calcularPrecioMedio();
        }, "Debería haber lanzado CeroEntradasException porque la lista de entradas está vacía");
    }
}