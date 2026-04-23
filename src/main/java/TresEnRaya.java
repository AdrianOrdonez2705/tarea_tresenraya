public class TresEnRaya {

    private static final int LIMITE = 3;
    private static final char VACIO = '0';

    private final Character[][] tablero = {
            {VACIO, VACIO, VACIO},
            {VACIO, VACIO, VACIO},
            {VACIO, VACIO, VACIO}
    };

    private char ultimoJugador = '+';

    public String jugar(int x, int y) throws Exception {
        validarEje(x);
        validarEje(y);

        ultimoJugador = siguienteTurno();
        asignarPosicion(x, y);

        return hayGanador()
                ? ultimoJugador + " es el ganador"
                : "No hay ganador";
    }

    private boolean hayGanador() {
        int acumulado = ultimoJugador * LIMITE;

        for (int i = 0; i < LIMITE; i++) {
            if (suma(tablero[0][i], tablero[1][i], tablero[2][i]) == acumulado) return true;
            if (suma(tablero[i][0], tablero[i][1], tablero[i][2]) == acumulado) return true;
        }

        if (suma(tablero[0][0], tablero[1][1], tablero[2][2]) == acumulado) return true;
        if (suma(tablero[2][0], tablero[1][1], tablero[0][2]) == acumulado) return true;

        return false;
    }

    private int suma(char a, char b, char c) {
        return a + b + c;
    }

    private void asignarPosicion(int x, int y) throws Exception {
        if (tablero[x - 1][y - 1] != VACIO) {
            throw new Exception("La posicion ya esta ocupada");
        }
        tablero[x - 1][y - 1] = ultimoJugador;
        System.out.println("Ocupando posicion: " + x + ", " + y);
    }

    private void validarEje(int eje) throws Exception {
        if (eje < 1 || eje > LIMITE) {
            throw new Exception("La coordenada " + eje + " esta fuera de lugar");
        }
    }

    public char siguienteTurno() {
        return (ultimoJugador == 'X') ? '+' : 'X';
    }
}