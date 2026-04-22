package test.java;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

class TresEnRaya {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    private TresEnRaya tresEnRaya;
    public final void before() {}

    // Requerimiento 1
    @Test
    public void cuandoPiezaFueraXLanzarExcepcion() {}

    @Test
    public void cuandoPiezaFueraYLanzarExcepcion() {}

    @Test
    public void cuandoPiezaLugarOcupadoLanzarExcepcion() {}

    // Requerimiento 2
    @Test
    public void cuandoPrimerTurnoSiempreJuegaX() {}

    @Test
    public void siUltimoTurnoXSiguienteTurnoCruz() {}

    @Test void siUltimoTurnoCruzSiguienteTurnoX() {}

    // Requerimiento 3
    @Test
    public void siNoCondicionVictoriaEntoncesNoGanador() {}

    @Test
    public void SiJugadorOcupaLineaHorizontalEntoncesGana() {}

    @Test
    public void SiJugadorOcupaLineaVerticalEntoncesGana() {}

    @Test
    public void SiJugadorOcupaLineaDiagonalEntoncesGana() {}

}