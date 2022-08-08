package practica.demo.repositorys;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import practica.demo.models.Genero;
import practica.demo.models.reports.ReportePelicula;
import practica.demo.models.reports.ReportePeliculaFechaCreacion;

import java.util.List;

public interface GeneroRepository extends CrudRepository<Genero,Integer> {

}
