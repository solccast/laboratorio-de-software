package practica3.ej8;

public class Piano implements InstrumentoMusical{
    @Override
    public void hacerSonar() {

    }

    @Override
    public String queEs() {
        return "";
    }

    @Override
    public void hacerSonar(Notas n, int duracion) {
        if (duracion > 0){
            for (int i = 0; i<duracion; i++){
                System.out.print(" "+ n.name()+ " ");
            }
        }
    }

    @Override
    public void afinar(FrecuenciasDeLA f) {
        System.out.println("Afinando piano: " + f.toString());
    }
}
