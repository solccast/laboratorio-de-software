package practica1;

public class VacunaSubunidadAntigenica extends Vacuna{
    private int cantidadAntigenos;
    private String tipoDeProceso;

    public VacunaSubunidadAntigenica(String tipoDeProceso, int cantidadAntigenos) {
        super();
        this.tipoDeProceso = tipoDeProceso;
        this.cantidadAntigenos = cantidadAntigenos;
    }

    public int getCantidadAntigenos() {
        return cantidadAntigenos;
    }

    public void setCantidadAntigenos(int cantidadAntigenos) {
        this.cantidadAntigenos = cantidadAntigenos;
    }

    public String getTipoDeProceso() {
        return tipoDeProceso;
    }

    public void setTipoDeProceso(String tipoDeProceso) {
        this.tipoDeProceso = tipoDeProceso;
    }
}
