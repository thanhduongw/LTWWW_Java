package iuh.fit.se.annotationconfig;

import org.springframework.stereotype.Component;

@Component("iceCreamBean")  // Custom name cho @Qualifier
public class IceCream implements Dessert {
    @Override
    public void enjoy() {
        System.out.println("Enjoying Ice Cream");
    }
}