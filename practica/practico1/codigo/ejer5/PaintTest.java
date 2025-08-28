package practica1.ejer5;

import java.util.List;
import java.util.stream.Stream;

public class PaintTest {
    public static void main (String[] args){
        Paint paint = new Paint();
        paint.init();

        //Inicia recorrido del array
        List<FiguraGeometrica> paleta = paint.getPaleta();
        paleta.stream().forEach(
                figuraGeometrica -> {
                    System.out.println("Figura: " + figuraGeometrica.area());
                    if (figuraGeometrica instanceof Circulo) {
                        System.out.println("Circulo: " + ((Circulo) figuraGeometrica).getRadio());
                    }
                }
        );
    }
}
