package practica.demo.repositorys;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import practica.demo.models.PeliculaSerie;
import practica.demo.models.Personaje;
import practica.demo.models.reports.ReportePelicula;
import practica.demo.models.reports.ReportePeliculaFechaCreacion;
import practica.demo.models.reports.ReportePeliculaSerie;
import practica.demo.models.reports.ReportePersonaje;

import java.util.Collection;
import java.util.List;

public interface PeliculaSerieRepository extends CrudRepository<PeliculaSerie,Integer> {

    @Query(value="select ps.titulo,ps.imagen, ps.fecha_creacion from pelicula_serie as ps",nativeQuery = true)
    List<ReportePelicula> getMovie();

    @Query(value="select ps.id,ps.imagen,ps.titulo,ps.fecha_creacion,ps.calificacion, p.nombre as personaje from personaje as p, pelicula_serie as ps where p.pelicula_serie_id=ps.id",nativeQuery = true)
    List<ReportePeliculaSerie> getMovie2();

    @Query(value = "select ps.titulo, ps.fecha_creacion from pelicula_serie as ps where ps.titulo like %:name% order by fecha_creacion desc",nativeQuery = true)
    Collection<ReportePeliculaFechaCreacion> getPeliculaFechaByName(@Param("name") String nombre);

    @Query(value="select * from pelicula_serie as ps where ps.titulo like %:name% order by ps.fecha_creacion",nativeQuery = true)
    List<PeliculaSerie> getMovieDate(@Param("name") String name);
}
