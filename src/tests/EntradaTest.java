package tests;

import clases.Concierto;
import clases.Entrada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntradaTest {

    @Test
    void getPrecioTotal() {
        Concierto c1 = new Concierto("Benito", "Puerto Rico", 100.0, 1000, new java.util.ArrayList<>(), true);
        Entrada e1 = new Entrada(c1, Entrada.Tipo.GRADA);
        assertEquals(100.0, e1.getPrecioTotal(), "El precio de Grada debe ser igual al precio base");

        Entrada e2 = new Entrada(c1, Entrada.Tipo.VIP);
        assertEquals(120.0, e2.getPrecioTotal(), "El precio VIP debe tener un recargo del 20%");
    }
}