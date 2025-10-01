package practica4.ej2;

public class TestVet {
    public static void main(String[] args) {
        //Veterinaria<? extends Animal> vet = new Veterinaria<Gato>();
        //Veterinaria<Gato> vet = new Veterinaria<Animal>();
        //Veterinaria<?> vet = new Veterinaria<Gato>();
        //vet.setAnimal(new Gato());
        //Veterinaria vet = new Veterinaria(); // RAW type
        //vet.setAnimal(new Perro());
        //Veterinaria vet = new Veterinaria<?>();
        Veterinaria <? extends Animal> vet = new Veterinaria<Gato>();
        Gato gato = new Gato();
        Perro perro = new Perro();
        vet.setAnimal(null);

        Veterinaria<? super Animal> vet2 = new Veterinaria<>();
        vet2.setAnimal(gato);

        Veterinaria<? super Gato> vet3 = new Veterinaria<Animal>();
        vet3.setAnimal(gato);
    }
}
