package practica1;

public class TestVacuna {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vacuna vacuna1 = new Vacuna("Sputnik", "Rusia", "Covid", 3);
		Vacuna vacuna2 = new Vacuna("HBFarma", "Argentina", "Enfermedad2", 4);
		Vacuna vacuna3 = new Vacuna("Laboratorio3", "India", "Covid", 2);
		
		
		Vacuna[] vacunas = new Vacuna[3];
		vacunas[0] = vacuna1;
		vacunas[1] = vacuna2;
		vacunas[2] = vacuna3;
		
		for (int i = 0; i < 3; i++) {
			System.out.println(vacunas[i].toString());
		}
		
		Vacuna vacuna4 = new Vacuna("Laboratorio3", "India", "Covid", 2);
		System.out.println(vacuna4.toString().equals(vacuna3.toString()));

        System.out.println("Punto c con método equals sobreescrito: "+ vacuna4.equals(vacuna1));
        System.out.println("Punto c con método equals sobreescrito: "+ vacuna4.equals(vacuna3));

        //-------- Ejercicio 3.1
        VacunaPatogenoIntegro vacunaPatogeno = new VacunaPatogenoIntegro("Leptospirosis");

    }

}
