package practica1;

public class VacunaPatogenoIntegro extends Vacuna{
    private String nombreVirus;

    public VacunaPatogenoIntegro(String nombreVirus) {
        this.nombreVirus = nombreVirus;
    }

    public String getNombreVirus() {
        return nombreVirus;
    }

    public void setNombreVirus(String nombreVirus) {
        this.nombreVirus = nombreVirus;
    }
}
