package practica.demo.repositorys;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import practica.demo.models.Personaje;
import practica.demo.models.reports.ReportePersonaje;
import practica.demo.models.reports.ReportePersonajePelicula;

import java.util.Collection;
import java.util.List;

public interface PersonajeRepository extends CrudRepository<Personaje,Integer> {
    @Query(value="select p.nombre,p.imagen from personaje as p",nativeQuery = true)
    List<ReportePersonaje> getCharacter();

    @Query(value="select p.id, p.nombre as personaje,p.edad,p.peso,p.imagen,ps.titulo as pelicula from pelicula_serie as ps, personaje as p where p.pelicula_serie_id =ps.id",nativeQuery = true)
    List<ReportePersonajePelicula>getAllCharacters();

    @Query(value = "select * from personaje where nombre like %:name%",nativeQuery = true)
    Collection<Personaje> getPersonajeByName(@Param("name") String nombre);

    @Query(value = "select * from personaje where edad like %:age%",nativeQuery = true)
    Collection<Personaje> getPersonajeByAge(@Param("age") int edad);
}
