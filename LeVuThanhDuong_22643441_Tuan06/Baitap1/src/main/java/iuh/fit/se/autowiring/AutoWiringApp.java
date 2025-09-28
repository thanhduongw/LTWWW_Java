package iuh.fit.se.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWiringApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Test byName
        Student studentByName = (Student) context.getBean("studentByName");
        studentByName.learn();  // Output: Faculty is teaching \n Student is learning

        // Test byType
        Student studentByType = (Student) context.getBean("studentByType");
        studentByType.learn();

        // Test constructor
        Student studentConstructor = (Student) context.getBean("studentConstructor");
        studentConstructor.learn();
    }
}