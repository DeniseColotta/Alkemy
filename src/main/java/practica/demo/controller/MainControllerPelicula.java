package practica.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practica.demo.models.PeliculaSerie;
import practica.demo.models.Personaje;
import practica.demo.models.reports.ReportePelicula;

import practica.demo.models.reports.ReportePeliculaFechaCreacion;
import practica.demo.models.reports.ReportePeliculaSerie;
import practica.demo.repositorys.PeliculaSerieRepository;


import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/demoAlkemy")
public class MainControllerPelicula {
    @Autowired
    private PeliculaSerieRepository peliculaRepository;

    @GetMapping(path = "movies")
    public @ResponseBody
    List<ReportePelicula> getMovies() {
        return peliculaRepository.getMovie();
    }

// punto 6- Detalle de la película y personajes asociados
    @GetMapping(path = "movies/all")
    public @ResponseBody
    List<ReportePeliculaSerie> getAllMovies() {
        return peliculaRepository.getMovie2();

    }
    //buscar pelicula por nombre
    @GetMapping(path = "get/movies/name/{nombre}")
    public @ResponseBody
    Collection<ReportePeliculaFechaCreacion> getMoviesByName(@PathVariable("nombre") String nombre) {
        return peliculaRepository.getPeliculaFechaByName(nombre);}

// buscar por película ordenada por fecha de creación
    @GetMapping(path = "get/movies/order/Asc/{nombre}")
    public @ResponseBody
    List<PeliculaSerie> getMoviesByDate(@PathVariable("nombre") String name) {
        return peliculaRepository.getMovieDate(name);}

// punto 7-crud de peliculas
    @PostMapping(path = "movies/create", consumes = "application/json", produces = "application/json")
    public PeliculaSerie createMovie(@RequestBody PeliculaSerie newMovie) {
        return peliculaRepository.save(newMovie);
    }


    @PutMapping(path = "movies/put", consumes = "application/json", produces = "application/json")
    public PeliculaSerie updatePelicula(@RequestBody PeliculaSerie updateMovie) {
        return peliculaRepository.save(updateMovie);
    }

    @DeleteMapping(path = "/movies/delete/{id_movie}")
    public @ResponseBody
    Iterable<PeliculaSerie> deleteMovieById(@PathVariable("id_movie") int id_m) {
        try {
            peliculaRepository.deleteById(id_m);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return peliculaRepository.findAll();

        }
    }
}
