package practica1.ejer5;

import java.util.ArrayList;
import java.util.List;

public class Paint {
    private List<FiguraGeometrica> paleta;

    public Paint(){

    }

    public List<FiguraGeometrica> getPaleta() {
        return paleta;
    }

    public void setPaleta(List<FiguraGeometrica> paleta) {
        this.paleta = paleta;
    }

    public void init(){
        Circulo circulo1 = new Circulo();
        circulo1.setRadio(2);
        circulo1.setColor("azul");
        Circulo circulo2 = new Circulo();
        circulo2.setColor("amarillo");
        circulo2.setRadio(3);

        Rectangulo rectangulo1 = new Rectangulo(2, 3);
        rectangulo1.setColor("verde");
        Rectangulo rectangulo2 = new Rectangulo(4, 10);
        rectangulo2.setColor("rojo");

        List<FiguraGeometrica> paleta = new ArrayList<>();
        paleta.add(circulo1);
        paleta.add(circulo2);
        paleta.add(rectangulo1);
        paleta.add(rectangulo2);

        this.setPaleta(paleta);


    }
}
