package practica3.ej8;

public class PianoTest {
    public static void main(String[] args) {
        Notas[] notas = {
                Notas.MI,
                Notas.RE,
                Notas.SOL
        };

        int[] duracion = {1, 6, 2};
        FitoPaez.PIANO.tocarCancion(notas, duracion);
    }
}
