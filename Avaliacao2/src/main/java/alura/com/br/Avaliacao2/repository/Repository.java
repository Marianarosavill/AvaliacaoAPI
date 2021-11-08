package alura.com.br.Avaliacao2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import alura.com.br.Avaliacao2.modelo.States;



	public interface Repository extends JpaRepository<States, Long>{

		@Query("SELECT e FROM States e WHERE e.region = :regiao")
		List<States> cargarPorRegion(@Param ("regiao") String region);
		
		@Query("SELECT e FROM States e ORDER BY populacion DESC")
		List<States> cargarPorPopulacion();

		@Query("SELECT e FROM States e ORDER BY area DESC")
		List<States> cargarPorArea();
	}



