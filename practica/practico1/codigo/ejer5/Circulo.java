package practica1.ejer5;

public class Circulo extends FiguraGeometrica{
    private int radio;

    public Circulo(){

    }

    public void dibujar(){
        System.out.println("Circulo: radio "+ this.radio + ", color " + this.getColor());
    }

    public int area() {
        return (int)Math.PI * this.radio * this.radio;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }
}
