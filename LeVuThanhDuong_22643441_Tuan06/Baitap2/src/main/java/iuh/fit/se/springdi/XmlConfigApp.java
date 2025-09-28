package iuh.fit.se.springdi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfigApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Test Setter Injection
        Employee employeeSetter = (Employee) context.getBean("employeeSetter");
        System.out.println("Setter Injection: " + employeeSetter);

        // Test Constructor Injection
        Employee employeeConstructor = (Employee) context.getBean("employeeConstructor");
        System.out.println("Constructor Injection: " + employeeConstructor);
    }
}