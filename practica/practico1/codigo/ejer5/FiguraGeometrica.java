package practica1.ejer5;

public abstract class FiguraGeometrica {
    private String color;

    public FiguraGeometrica(){

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    abstract public void dibujar();
    abstract public int area();
}
