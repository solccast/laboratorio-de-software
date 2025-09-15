package practica3.ej8;

public enum FitoPaez {
    PIANO(new Piano());
    private Piano piano;

    FitoPaez(Piano piano) {
        this.piano = piano;
    }

    public void tocarCancion(Notas[] notas, int[] tiempos){
        for(int i = 0; i < notas.length; i++){
            piano.hacerSonar(notas[i], tiempos[i]);
        }
    }
}
