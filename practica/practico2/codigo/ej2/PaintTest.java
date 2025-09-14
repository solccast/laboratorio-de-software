package practica2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Arrays;

public class PaintTest {
    public static void main (String[] args){
        Paint paint = new Paint();
        paint.init();

        //Inicia recorrido del array
        List<FiguraGeometrica> paleta = paint.getPaleta();

        List<FiguraGeometrica> prueba2 =  paleta.stream()
                .sorted((figuraA, figuraB) ->
                        figuraA.compareTo(figuraB))
                .toList();

        System.out.println("-------------------- Lista original");
        paleta.forEach(figuraGeometrica -> {System.out.print(figuraGeometrica.area()); figuraGeometrica.dibujar();});

        System.out.println("------------------ Lista ordenada -------");
        prueba2.forEach(
                FiguraGeometrica::dibujar
        );


    }
}
