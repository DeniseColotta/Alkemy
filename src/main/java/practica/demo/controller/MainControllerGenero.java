package practica.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practica.demo.models.Genero;

import practica.demo.repositorys.GeneroRepository;



@RestController
@RequestMapping(path = "/demoAlkemy")
public class MainControllerGenero {
    @Autowired
    private GeneroRepository generoRepository;

    @PostMapping(path = "genero/create", consumes = "application/json", produces = "application/json")
    public Genero createGenero(@RequestBody Genero newGenero) {
        return generoRepository.save(newGenero);
    }

}
