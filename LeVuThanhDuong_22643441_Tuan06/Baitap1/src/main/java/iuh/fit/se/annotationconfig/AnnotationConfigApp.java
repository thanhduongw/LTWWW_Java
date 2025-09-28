package iuh.fit.se.annotationconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationConfigApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Meal meal = context.getBean(Meal.class);
        meal.eat();
        // Output: Eating Special Meal \n Enjoying Cake \n Enjoying Cake \n Enjoying Ice Cream
    }
}