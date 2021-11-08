package alura.com.br.Avaliacao2.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import alura.com.br.Avaliacao2.modelo.States;


public class StateDto {
	
		
		private Long id;
		private String nombre;
		private String region;
		private Long populacion;
		private String capital;
		private double area;
		
		public StateDto(States state) {
			this.id = state.getId();
			this.nombre = state.getNombre();
			this.region = state.getRegion();
			this.populacion = state.getPopulacion();
			this.capital = state.getCapital();
			this.area = state.getArea();
		}
		
		
		


		public Long getId() {
			return id;
		}
		public String getNombre() {
			return nombre;
		}
		public String getRegion() {
			return region;
		}
		public Long getPopulacion() {
			return populacion;
		}
		public String getCapital() {
			return capital;
		}
		public double getArea() {
			return area;
		}


		public static List<StateDto> converter(List<States> state) {
			return state.stream().map(StateDto::new).collect(Collectors.toList());
		}
		
		

	

}
