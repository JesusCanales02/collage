package mx.edu.cetys.jesus.canales.code_collage.repository;
import mx.edu.cetys.jesus.canales.code_collage.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {

}