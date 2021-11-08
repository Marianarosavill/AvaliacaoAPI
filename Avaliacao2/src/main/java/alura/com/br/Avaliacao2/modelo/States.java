package alura.com.br.Avaliacao2.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;



@Entity @NotNull @Valid @NotEmpty@Length
public class States {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String region;
	private Long populacion;
	private String capital;
	private double area;
	

	
	@Override
	public int hashCode() {
		final int num = 35;
		int resultado = 1;
		resultado = num * resultado + ((id == null) ? 0 : id.hashCode());
		return resultado;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		States other = (States) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public States( String nombre, String region, Long populacion, String capital, double area) {
		super();
		this.nombre = nombre;
		this.region = region;
		this.populacion = populacion;
		this.capital = capital;
		this.area = area;
	}

	public States() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Long getPopulacion() {
		return populacion;
	}

	public void setPopulacion(Long populacion) {
		this.populacion = populacion;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
	
	
}



