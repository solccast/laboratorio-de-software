package practica1;

import java.util.Objects;

public class Vacuna {
	private String marca; 
	private String paisOrigen;
	private String enfermedadPreviene;
	private int cantDosis;
	
	public Vacuna(String marca, String paisOrigen, String enfermedadPreviene, int cantDosis) {
		this.marca = marca;
		this.paisOrigen = paisOrigen;
		this.enfermedadPreviene = enfermedadPreviene;
		this.cantDosis = cantDosis;
	}

    public Vacuna(){
        this.marca = null;
        this.paisOrigen = null;
        this.enfermedadPreviene = null;
    }

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public String getEnfermedadPreviene() {
		return enfermedadPreviene;
	}

	public void setEnfermedadPreviene(String enfermedadPreviene) {
		this.enfermedadPreviene = enfermedadPreviene;
	}

	public int getCantDosis() {
		return cantDosis;
	}

	public void setCantDosis(int cantDosis) {
		this.cantDosis = cantDosis;
	}
	
	
	/*
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.getMarca());
		buffer.append(this.getPaisOrigen());
		buffer.append(this.getEnfermedadPreviene());
		buffer.append(this.getCantDosis());
		
		return buffer.toString();
		
	}
	*/

    @Override
    public boolean equals(Object obj){
        // Comparación por referencia
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Vacuna v = (Vacuna) obj;

        // Comparación de los datos
        if (this.cantDosis != v.getCantDosis()) return false;
        return Objects.equals(this.getEnfermedadPreviene(), v.getEnfermedadPreviene())
            && Objects.equals(this.getPaisOrigen(), v.getPaisOrigen())
            && Objects.equals(this.getMarca(), v.getMarca());

    }

}
