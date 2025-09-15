package practica3.ej8;

public interface InstrumentoMusical {
    public void hacerSonar();
    public String queEs();
    default void afinar() {}
    public void hacerSonar(Notas n, int duracion);
    public void afinar(FrecuenciasDeLA f);
}
