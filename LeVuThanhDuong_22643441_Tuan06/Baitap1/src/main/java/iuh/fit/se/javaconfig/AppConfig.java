package iuh.fit.se.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Engine engine() {
        ICEngine engine = new ICEngine();
        engine.setType("Petrol");  // Inject literal thủ công
        return engine;
    }

    @Bean
    public Car car() {
        Car car = new Car();
        car.setEngine(engine());  // Inter-bean dependency (object injection)
        return car;
    }
}