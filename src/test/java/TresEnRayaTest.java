import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TresEnRayaTest {

    private TresEnRaya tresEnRaya;

    @Test
    public void cuandoFueraXlanzarExcepcion() {
        tresEnRaya = new TresEnRaya();

        assertThrows(Exception.class, () -> {
            tresEnRaya.jugar(5, 2);
        });
    }

    @Test
    public void cuandoFueraYlanzarExcepcion() {
        tresEnRaya = new TresEnRaya();

        assertThrows(Exception.class, () -> {
            tresEnRaya.jugar(2, 5);
        });
    }

    @Test
    public void cuandoLugarOcupadoLanzarExcepcion() throws Exception {
        tresEnRaya = new TresEnRaya();

        tresEnRaya.jugar(1, 3);

        assertThrows(Exception.class, () -> {
            tresEnRaya.jugar(1, 3);
        });
    }

    @Test
    public void siPrimerTurnoEntoncesJuegaX() {
        tresEnRaya = new TresEnRaya();

        assertEquals('X', tresEnRaya.siguienteTurno());
    }

    @Test
    public void siPrimerTurnoXSiguienteMas() throws Exception {
        tresEnRaya = new TresEnRaya();

        // x
        tresEnRaya.jugar(2, 1);
        assertEquals('+', tresEnRaya.siguienteTurno());
        // +
        tresEnRaya.jugar(2, 2);
        assertEquals('X', tresEnRaya.siguienteTurno());
    }

    @Test
    public void cuandoNoHayGanador() throws Exception {
        tresEnRaya = new TresEnRaya();

        String resultado = tresEnRaya.jugar(2, 1);
        assertEquals("No hay ganador", resultado);
    }

    @Test
    public void siLlenaColumnaEntoncesGana() throws Exception {
        tresEnRaya = new TresEnRaya();

        tresEnRaya.jugar(1, 1); // x
        tresEnRaya.jugar(1, 2); // +
        tresEnRaya.jugar(2, 1); // x
        tresEnRaya.jugar(2, 2); // +
        String resultado = tresEnRaya.jugar(3, 1); // x

        assertEquals("X es el ganador", resultado);
    }

    @Test
    public void siLlenaFilaEntoncesGana() throws Exception {
        tresEnRaya = new TresEnRaya();

        tresEnRaya.jugar(2, 1); // x
        tresEnRaya.jugar(1, 1); // +
        tresEnRaya.jugar(3, 1); // x
        tresEnRaya.jugar(1, 2); // +
        tresEnRaya.jugar(2, 2); // x
        String resultado = tresEnRaya.jugar(1, 3); // x

        assertEquals("+ es el ganador", resultado);
    }

    @Test
    public void siLlenaDiagonalEntoncesGana() throws Exception {
        tresEnRaya = new TresEnRaya();

        tresEnRaya.jugar(1, 1); // x
        tresEnRaya.jugar(1, 2); // +
        tresEnRaya.jugar(2, 2); // x
        tresEnRaya.jugar(1, 3); // +
        String resultado = tresEnRaya.jugar(3, 3); // x

        assertEquals("X es el ganador", resultado);
    }

    @Test
    public void siLlenaDiagonalOpuestaEntoncesGana() throws Exception {
        tresEnRaya = new TresEnRaya();

        tresEnRaya.jugar(1, 2); // x
        tresEnRaya.jugar(1, 3); // +
        tresEnRaya.jugar(1, 1); // x
        tresEnRaya.jugar(2, 2); // +
        tresEnRaya.jugar(2, 3); // x
        String resultado = tresEnRaya.jugar(3, 1); // +

        assertEquals("+ es el ganador", resultado);
    }
}