package iuh.fit.se.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfigApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Car car = (Car) context.getBean("car");
        car.start(); // Output: IC Engine started (giả sử ICEngine in ra vậy)

        CarWithList carWithList = (CarWithList) context.getBean("carWithList");
        carWithList.showParts(); // Output: Parts: [Wheel, Engine]
    }
}
