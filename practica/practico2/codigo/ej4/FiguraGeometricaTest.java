package practica2.ej4;

import java.io.*;

public class FiguraGeometricaTest {
    public static void main(String[] args) {
        Rectangulo r1 = new Rectangulo(10, 5);

        //Serializar un archivo
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("prueba.txt"))){
            oos.writeObject(r1);
            System.out.println("Objeto serializado: "+ r1);
        } catch (IOException e){
            e.printStackTrace();
        }

        //Deserializar desde un archivo
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("prueba.txt"))){
            Rectangulo r2 = (Rectangulo) ois.readObject();
            System.out.println("Objeto deserializado: "+ r2);
            r2.dibujar();
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
