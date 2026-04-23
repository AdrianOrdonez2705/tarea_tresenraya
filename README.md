# Prompt a ChatGPT para generación de pruebas unitarias para `TresEnRaya`

Necesito que generes pruebas unitarias profesionales para una clase Java llamada `TresEnRaya`.

## Contexto

La clase implementa la lógica de un juego de Tres en Raya (Tic-Tac-Toe), incluyendo:

- Validación de coordenadas (rango 1–3)
- Control de turnos entre jugadores ('X' y '+')
- Registro de jugadas en un tablero
- Detección de ganador (filas, columnas y diagonales)
- Manejo de errores (coordenadas inválidas o posiciones ocupadas)

## Requisitos obligatorios

1. Usa **JUnit 5 (Jupiter)**.
2. **NO modifiques la clase original (`TresEnRaya.java`)**.
3. Cubre exactamente estos escenarios:
   - Coordenadas fuera de rango (X e Y)
   - Posición ya ocupada
   - Turno inicial correcto
   - Alternancia de turnos
   - Caso sin ganador
   - Victoria por:
     - columna
     - fila
     - diagonal principal
     - diagonal inversa

## Nivel de calidad esperado (muy importante)

Las pruebas deben ser **lo más profesionales posibles**, incluyendo:

- Uso de `@BeforeEach` para setup
- Uso de `@Nested` para agrupar pruebas por contexto
- Uso de `@DisplayName` para documentación clara
- Nombres de métodos siguiendo convención **Given_When_Then**
- Uso de `assertAll` cuando tenga sentido
- Validación no solo de excepciones, sino también de sus mensajes
- Código limpio, sin duplicación innecesaria
- Sin `System.out.println`

## Objetivo

El resultado debe ser un archivo de pruebas:

- Más mantenible
- Más legible
- Más escalable
- A nivel de estándares de industria (clean testing)

**Devuelve únicamente el archivo completo listo para usar.**
