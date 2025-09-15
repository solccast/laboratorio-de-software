package practica3.ej8;

public enum FrecuenciasDeLA {
    _440HZ("440 HZ","Organización Internacional de Estandarización ISO 16"),
    _444HZ("444 HZ", "Afinación de cámara"),
    _446HZ("446 HZ", "Renacimiento"),
    _480HZ("480 HZ", "Órganos alemanes que tocaba Bach");

    private String estandar;
    private String frecuencia;
    FrecuenciasDeLA(String frecuencia, String estandar){
    }

    @Override
    public String toString(){
        return estandar;
    }
}
