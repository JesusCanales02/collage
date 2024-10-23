//package mx.edu.cetys.jesus.canales.code_collage.controller;
//
//import mx.edu.cetys.jesus.canales.code_collage.model.Dog;
//import mx.edu.cetys.jesus.canales.code_collage.service.DogService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/dogs")
//public class DogController {
//    private final DogService dogService;
//
//    @Autowired
//    public DogController(DogService dogService) {
//        this.dogService = dogService;
//    }
//
//    @GetMapping
//    public List<Dog> getAllDogs() {
//        return dogService.findAll();
//    }
//
//    @PostMapping
//    public ResponseEntity<Dog> createDog(@RequestBody Dog dog) {
//        Dog savedDog = dogService.save(dog);
//        return new ResponseEntity<>(savedDog, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteDog(@PathVariable Long id) {
//        dogService.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}
package mx.edu.cetys.jesus.canales.code_collage.controller;

import mx.edu.cetys.jesus.canales.code_collage.model.Dog;
import mx.edu.cetys.jesus.canales.code_collage.service.DogService;
import mx.edu.cetys.jesus.canales.code_collage.service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//manejará solicitudes HTTP y devolverá respuestas HTTP
//ruta base
@RestController
@RequestMapping("/dogs")
public class DogController {

    private final DogService dogService;
    private final OpenAIService openAIService; // Añade el servicio de OpenAI

    // inyección de dependencias
    @Autowired
    public DogController(DogService dogService, OpenAIService openAIService) {
        this.dogService = dogService;
        this.openAIService = openAIService; // Inyecta el servicio de OpenAI
    }

    @GetMapping
    public List<Dog> getAllDogs() {
        return dogService.findAll();
    }

    @PostMapping
    public ResponseEntity<Dog> createDog(@RequestBody Dog dog) {
        Dog savedDog = dogService.save(dog);
        return new ResponseEntity<>(savedDog, HttpStatus.CREATED);
    }
//En caso de que quieras eliminar un perro, es necesario poner el local host 8080 y poner el id de la base de datos y asi eliminarlo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDog(@PathVariable Long id) {
        dogService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Nuevo endpoint para obtener la descripción de un perro, es necesario poner el local host 8080 y /describe{y el id de la base de datos}
    @GetMapping("/describe/{id}")
    public ResponseEntity<String> describeDog(@PathVariable Long id) {
        Dog dog = dogService.findById(id).orElse(null);
        if (dog == null) {
            return new ResponseEntity<>("Perro no encontrado", HttpStatus.NOT_FOUND);
        }

        // Llamar al servicio de OpenAI para obtener la descripción del perro
        String description = openAIService.getDogDescription(dog);
        return new ResponseEntity<>(description, HttpStatus.OK);
    }
}

