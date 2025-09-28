package iuh.fit.se.annotationconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Meal {
    @Autowired  // Field injection (trang 45)
    private Dessert dessertField;

    private Dessert dessertSetter;

    private Dessert dessertConstructor;

    @Value("${meal.name:Default Meal}")  // Inject từ properties (trang 51), giả sử có file properties
    private String name;

    // Setter injection
    @Autowired
    public void setDessertSetter(Dessert dessertSetter) {
        this.dessertSetter = dessertSetter;
    }

    // Constructor injection với @Qualifier để disambiguate (trang 49)
    @Autowired
    public Meal(@Qualifier("iceCreamBean") Dessert dessertConstructor) {
        this.dessertConstructor = dessertConstructor;
    }

    public void eat() {
        System.out.println("Eating " + name);
        dessertField.enjoy();  // Sẽ dùng @Primary (Cake)
        dessertSetter.enjoy(); // Sẽ dùng @Primary (Cake)
        dessertConstructor.enjoy();  // IceCream nhờ @Qualifier
    }
}