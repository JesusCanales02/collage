package mx.edu.cetys.jesus.canales.code_collage.service;

import mx.edu.cetys.jesus.canales.code_collage.model.Dog;
import mx.edu.cetys.jesus.canales.code_collage.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//gestiona la lógica de negocio y puede ser inyectado en otros componentes
@Service
public class DogService {
    private final DogRepository dogRepository;
    // otro serviio para AI
    private final OpenAIService aiService;


    @Autowired
    public DogService(DogRepository dogRepository, OpenAIService aiService) {
        this.dogRepository = dogRepository;
        this.aiService = aiService;
    }
//Devuelve una lista de todos los objetos Dog almacenados en la base de datos
    public List<Dog> findAll() {
        return dogRepository.findAll();
    }

    public Optional<Dog> findById(Long id) {
        return dogRepository.findById(id);
    }

    public Dog save(Dog dog) {
        return dogRepository.save(dog);
    }

    public void deleteById(Long id) {
        dogRepository.deleteById(id);
    }
}
