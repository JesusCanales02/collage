package mx.edu.cetys.jesus.canales.code_collage.model;

import jakarta.persistence.*;

//será mapeada a una tabla en la base de datos
@Entity
//@Table(schema = "dog")
public class Dog {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String breed;
        private int age;
//permiten acceder y modificar los valores de los atributos de la clase.
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBreed() {
            return breed;
        }

        public void setBreed(String breed) {
            this.breed = breed;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }





