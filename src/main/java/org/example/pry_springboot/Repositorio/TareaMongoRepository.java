package org.example.pry_springboot.Repositorio;

import org.example.pry_springboot.Tarea;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TareaMongoRepository extends MongoRepository<Tarea, String> {

}
