package org.example.pry_springboot.mensajeria;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionRabbitMQ {
    public static final String NOMBRE_COLA_TAREAS = "cola-tareas";

    @Bean
    public Queue colaTareas() {
        return new Queue(NOMBRE_COLA_TAREAS, false);
    }
}
