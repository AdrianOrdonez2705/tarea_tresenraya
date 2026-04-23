import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas avanzadas de TresEnRaya")
public class TresEnRayaIATest {

    private TresEnRaya juego;

    @BeforeEach
    void setUp() {
        juego = new TresEnRaya();
    }

    // =========================
    // VALIDACIONES DE ENTRADA
    // =========================
    @Nested
    @DisplayName("Validación de coordenadas")
    class ValidacionCoordenadasTest {

        @Test
        @DisplayName("Given coordenada X fuera de rango When jugar Then lanza excepción")
        void givenCoordenadaXFueraDeRango_whenJugar_thenLanzaExcepcion() {
            Exception ex = assertThrows(Exception.class, () -> juego.jugar(5, 2));

            assertAll(
                    () -> assertNotNull(ex),
                    () -> assertTrue(ex.getMessage().contains("fuera de lugar"))
            );
        }

        @Test
        @DisplayName("Given coordenada Y fuera de rango When jugar Then lanza excepción")
        void givenCoordenadaYFueraDeRango_whenJugar_thenLanzaExcepcion() {
            Exception ex = assertThrows(Exception.class, () -> juego.jugar(2, 5));

            assertAll(
                    () -> assertNotNull(ex),
                    () -> assertTrue(ex.getMessage().contains("fuera de lugar"))
            );
        }
    }

    // =========================
    // VALIDACIÓN DE REGLAS
    // =========================
    @Nested
    @DisplayName("Reglas del juego")
    class ReglasJuegoTest {

        @Test
        @DisplayName("Given posición ocupada When jugar Then lanza excepción")
        void givenPosicionOcupada_whenJugar_thenLanzaExcepcion() throws Exception {
            juego.jugar(1, 3);

            Exception ex = assertThrows(Exception.class, () -> juego.jugar(1, 3));

            assertAll(
                    () -> assertNotNull(ex),
                    () -> assertTrue(ex.getMessage().contains("ocupada"))
            );
        }
    }

    // =========================
    // TURNOS
    // =========================
    @Nested
    @DisplayName("Control de turnos")
    class TurnosTest {

        @Test
        @DisplayName("Given juego nuevo When consultar turno Then inicia con X")
        void givenJuegoNuevo_whenConsultarTurno_thenIniciaConX() {
            assertEquals('X', juego.siguienteTurno());
        }

        @Test
        @DisplayName("Given múltiples jugadas When alternar turnos Then secuencia correcta")
        void givenMultiplesJugadas_whenAlternarTurnos_thenSecuenciaCorrecta() throws Exception {

            juego.jugar(2, 1); // X
            char turno1 = juego.siguienteTurno();

            juego.jugar(2, 2); // +
            char turno2 = juego.siguienteTurno();

            assertAll(
                    () -> assertEquals('+', turno1),
                    () -> assertEquals('X', turno2)
            );
        }
    }

    // =========================
    // RESULTADOS DEL JUEGO
    // =========================
    @Nested
    @DisplayName("Determinación de ganador")
    class ResultadoJuegoTest {

        @Test
        @DisplayName("Given una jugada inicial When no hay línea completa Then no hay ganador")
        void givenJugadaInicial_whenNoHayLineaCompleta_thenNoHayGanador() throws Exception {
            String resultado = juego.jugar(2, 1);

            assertEquals("No hay ganador", resultado);
        }

        @Test
        @DisplayName("Given columna completa When jugador gana Then retorna ganador correcto")
        void givenColumnaCompleta_whenJugadorGana_thenRetornaGanador() throws Exception {

            juego.jugar(1, 1); // X
            juego.jugar(1, 2); // +
            juego.jugar(2, 1); // X
            juego.jugar(2, 2); // +
            String resultado = juego.jugar(3, 1); // X

            assertEquals("X es el ganador", resultado);
        }

        @Test
        @DisplayName("Given fila completa When jugador gana Then retorna ganador correcto")
        void givenFilaCompleta_whenJugadorGana_thenRetornaGanador() throws Exception {

            juego.jugar(2, 1); // X
            juego.jugar(1, 1); // +
            juego.jugar(3, 1); // X
            juego.jugar(1, 2); // +
            juego.jugar(2, 2); // X
            String resultado = juego.jugar(1, 3); // +

            assertEquals("+ es el ganador", resultado);
        }

        @Test
        @DisplayName("Given diagonal principal completa When jugador gana Then retorna ganador correcto")
        void givenDiagonalPrincipalCompleta_whenJugadorGana_thenRetornaGanador() throws Exception {

            juego.jugar(1, 1); // X
            juego.jugar(1, 2); // +
            juego.jugar(2, 2); // X
            juego.jugar(1, 3); // +
            String resultado = juego.jugar(3, 3); // X

            assertEquals("X es el ganador", resultado);
        }

        @Test
        @DisplayName("Given diagonal inversa completa When jugador gana Then retorna ganador correcto")
        void givenDiagonalInversaCompleta_whenJugadorGana_thenRetornaGanador() throws Exception {

            juego.jugar(1, 2); // X
            juego.jugar(1, 3); // +
            juego.jugar(1, 1); // X
            juego.jugar(2, 2); // +
            juego.jugar(2, 3); // X
            String resultado = juego.jugar(3, 1); // +

            assertEquals("+ es el ganador", resultado);
        }
    }
}