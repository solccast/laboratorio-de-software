package practica1.ejer5;

public class Rectangulo extends FiguraGeometrica{
    public int alto;
    public int ancho;

    public Rectangulo(){

    }

    public Rectangulo(int alto, int ancho){
        this.alto = alto;
        this.ancho = ancho;
    }

    public void dibujar(){
        System.out.println("Rectangle de alto " + this.alto + ", ancho " + this.ancho + ", color " + this.getColor());
    }

    public int area(){
        return alto * ancho;
    }
}
