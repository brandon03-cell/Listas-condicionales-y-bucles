package tests;

import exceptions.*;
import clases.*; // O 'model.' dependiendo de cómo llamaras finalmente a la carpeta de las clases
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void valorar() throws ConciertoInactivoException, ConciertoYaAsistidoException, AforoCompletoException, ConciertoNoAsistidoException, ValoracionIncorrecta {
        // i. Test Caso Éxito: Comprar y valorar
        Concierto c1 = new Concierto("Benito", "Puerto Rico", 100.0, 1000, new ArrayList<>(), true);
        Usuario u = new Usuario();
        u.setNombre("Brandon");

        // IMPORTANTE: Primero compramos para que el usuario "asista"
        u.comprarEntrada(c1, Entrada.Tipo.PISTA);
        u.valorar(c1, 9);

        // Verificamos que se guardó correctamente
        assertTrue(u.getValoraciones().containsKey(c1), "El mapa debería tener el concierto");
        assertEquals(9, u.getValoraciones().get(c1), "La nota debería ser 9");

        // ii. Test Caso Error: Valorar sin haber asistido
        Concierto c2 = new Concierto("Duki", "Madrid", 80.0, 500, new ArrayList<>(), true);
        Usuario u2 = new Usuario();
        u2.setNombre("Terry");

        // Verificamos que salta la excepción ConciertoNoAsistidoException
        assertThrows(ConciertoNoAsistidoException.class, () -> {
            u2.valorar(c2, 10);
        }, "Debería lanzar ConciertoNoAsistidoException");
    }
}