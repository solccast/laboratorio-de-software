package practica3.ej2;

public class InnerClassTest {
    public static void main(String[] args) {

        /*
        Punto 2b
         */
        InnerStatic.Circulo.setRadio(6);
        System.out.println("--------Main-------");
        System.out.println("Main: "+ InnerStatic.Circulo.getArea());
        System.out.println("Main: "+ InnerStatic.Circulo.getLongitudCircunferencia());

        InnerStatic.Circulo.setRadio(10);
        System.out.println("Main - Radio: 10: "+ InnerStatic.Circulo.getArea());
        System.out.println("Main - Radio: 10: "+ InnerStatic.Circulo.getLongitudCircunferencia());

        InnerStatic.Circulo.setRadio(15);
        System.out.println("Main - Radio: 15: "+ InnerStatic.Circulo.getArea());
        System.out.println("Main - Radio: 15: "+ InnerStatic.Circulo.getLongitudCircunferencia());
    }
}
