package practica6.ej5;

public class Suma {
    public static void main(String[] args) {
        int suma=0;
        for(int i = 0; i< args.length; i++){
            try{
                suma += Integer.parseInt(args[i]);
            } catch (NumberFormatException e){
                //System.out.println(e.getMessage());
                System.out.println("Argumento inválido: "+args[i]);
            }

        }

        System.out.println("La suma es: "+suma);
    }
}