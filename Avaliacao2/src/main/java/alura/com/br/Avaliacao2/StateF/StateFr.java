package alura.com.br.Avaliacao2.StateF;

import javax.validation.constraints.Pattern;

import alura.com.br.Avaliacao2.modelo.States;
import alura.com.br.Avaliacao2.repository.Repository;



public class StateFr {
	
	private String nombre;
	@Pattern(regexp = "Norte|Nordeste|Sul|Sudeste|Centro-Oeste" )
	private String region;
	private Long populacion;
	private String capital;
	private double area;
	
	
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
	public States converter() {
		return new States(nombre, region, populacion, capital, area);
	}
	public States atualizar(Long id, Repository Repository) {
        States state = Repository.getOne(id);
        state.setArea(this.area);
        state.setNombre(this.nombre);
        state.setRegion(this.region);
        state.setCapital(this.capital);
        state.setPopulacion(this.populacion);
        return state;
	}
}



