package practica.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import practica.demo.models.Personaje;
import practica.demo.models.reports.ReportePersonaje;
import practica.demo.models.reports.ReportePersonajePelicula;
import practica.demo.repositorys.PersonajeRepository;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/demoAlkemy")
public class MainControllerPersonaje {
    @Autowired
    private PersonajeRepository personajeRepository;

    // Buscar personajes por imagen y nombre
    @GetMapping(path = "characters")
    public @ResponseBody
    List<ReportePersonaje> getcharacter() {
        return personajeRepository.getCharacter();
    }


// punto 4- Buscar detalle de los personajes y peliculas-series asociadas
    @GetMapping(path = "characters/all")
    public @ResponseBody
    List<ReportePersonajePelicula> getAllCharacter() {
        return personajeRepository.getAllCharacters();
    }

    // punto 5- Buscar por nombre, edad y peso.
    @GetMapping(path = "get/characters/name/{nombre}")
    public @ResponseBody
    Collection<Personaje> getCharacterByName(@PathVariable("nombre") String name) {
        return personajeRepository.getPersonajeByName(name);}


    @GetMapping(path = "/characters/age/{edad}")
    public @ResponseBody
    Collection<Personaje> getCharacterByEdad(@PathVariable("edad") int age) {
        return personajeRepository.getPersonajeByAge(age);}

    // punto 2- crear nuevo personaje
    @PostMapping(path = "characters/create", consumes = "application/json", produces = "application/json")
    public Personaje createCharacter(@RequestBody Personaje newPersonaje) {
        return personajeRepository.save(newPersonaje);
    }

// actualizar personaje
    @PutMapping(path = "characters/put", consumes = "application/json", produces = "application/json")
    public Personaje updatePersonaje(@RequestBody Personaje updatePersonaje) {
        return personajeRepository.save(updatePersonaje);
    }
// eliminar personaje
    @DeleteMapping(path = "/character/delete/{id_personaje}")
    public @ResponseBody
    Iterable<Personaje> deletePersonaById(@PathVariable("id_persona") int id_p) {
        try {
            personajeRepository.deleteById(id_p);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return personajeRepository.findAll();

        }
    }
}
