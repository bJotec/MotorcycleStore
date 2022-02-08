package pl.camp.it.motorcycle.rent.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.camp.it.motorcycle.rent.database.*;

@Configuration
@ComponentScan(basePackages = {
        "pl.camp.it.motorcycle.rent.controlers",
        "pl.camp.it.motorcycle.rent.services",
        "pl.camp.it.motorcycle.rent.sesion"
})
public class TestConfiguration {

    @Bean
    public IMotorcycleDAO motorcycleDAO() {
            return new MotorcycleDAOStub();
    }

    @Bean
    public IUserDAO userDAO() {

        return new UserDAOStub();
    }

    @Bean
    public IOrderDAO orderDAO() {

        return new OrderDAOStub();
    }

}
