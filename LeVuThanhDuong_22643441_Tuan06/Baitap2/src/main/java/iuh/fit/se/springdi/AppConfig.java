package iuh.fit.se.springdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Address addressAnnotation() {
        Address address = new Address();
        address.setCity("Da Nang");
        address.setState("Da Nang");
        address.setCountry("Vietnam");
        return address;
    }

    @Bean
    public Employee employeeAnnotation() {
        Employee employee = new Employee();
        employee.setId(3);
        employee.setName("Le Van C");
        employee.setAddress(addressAnnotation());
        return employee;
    }
}