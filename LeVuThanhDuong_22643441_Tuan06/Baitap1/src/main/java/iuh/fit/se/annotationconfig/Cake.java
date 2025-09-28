package iuh.fit.se.annotationconfig;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary  // Ưu tiên nếu ambiguity (trang 50)
public class Cake implements Dessert {
    @Override
    public void enjoy() {
        System.out.println("Enjoying Cake");
    }
}