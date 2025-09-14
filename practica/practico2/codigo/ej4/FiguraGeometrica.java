package practica2.ej4;

public abstract class FiguraGeometrica implements Comparable<FiguraGeometrica>, java.io.Serializable{
    static final long serialVersionUID = 1L;

    private String color;

    public FiguraGeometrica(){}

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    abstract public void dibujar();
    abstract public int area();

    public int compareTo(FiguraGeometrica otraFigura){
        return Integer.compare(this.area(), otraFigura.area());
    }

}
