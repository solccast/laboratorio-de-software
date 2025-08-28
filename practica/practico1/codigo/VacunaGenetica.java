package practica1;

public class VacunaGenetica extends Vacuna {
    private double temperaturaMinimaAlmacenamiento;
    private double temperaturaMaximaAlmacenamiento;

    public VacunaGenetica(double temperaturaMinimaAlmacenamiento, double temperaturaMaximaAlmacenamiento) {
        this.temperaturaMinimaAlmacenamiento = temperaturaMinimaAlmacenamiento;
        this.temperaturaMaximaAlmacenamiento = temperaturaMaximaAlmacenamiento;
    }

    public double getTemperaturaMinimaAlmacenamiento() {
        return temperaturaMinimaAlmacenamiento;
    }

    public void setTemperaturaMinimaAlmacenamiento(double temperaturaMinimaAlmacenamiento) {
        this.temperaturaMinimaAlmacenamiento = temperaturaMinimaAlmacenamiento;
    }

    public double getTemperaturaMaximaAlmacenamiento() {
        return temperaturaMaximaAlmacenamiento;
    }

    public void setTemperaturaMaximaAlmacenamiento(double temperaturaMaximaAlmacenamiento) {
        this.temperaturaMaximaAlmacenamiento = temperaturaMaximaAlmacenamiento;
    }
}
