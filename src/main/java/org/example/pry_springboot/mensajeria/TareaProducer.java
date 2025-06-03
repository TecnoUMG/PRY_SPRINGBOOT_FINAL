package org.example.pry_springboot.mensajeria;

import org.example.pry_springboot.Tarea;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static org.example.pry_springboot.mensajeria.ConfiguracionRabbitMQ.NOMBRE_COLA_TAREAS;

@Component
public class TareaProducer {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviarTareaCreada(Tarea tarea) {
        rabbitTemplate.convertAndSend(NOMBRE_COLA_TAREAS, "Tarea creada: " + tarea.getDescripcion());
    }

    public void enviarTareaCompletada(Tarea tarea) {
        rabbitTemplate.convertAndSend(NOMBRE_COLA_TAREAS, "Tarea completada: " + tarea.getDescripcion());
    }
}
