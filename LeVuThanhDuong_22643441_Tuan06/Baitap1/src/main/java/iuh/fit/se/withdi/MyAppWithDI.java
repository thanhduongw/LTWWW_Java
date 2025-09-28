package iuh.fit.se.withdi;

public class MyAppWithDI {
    public static void main(String[] args) {
        Engine engine = new HybridEngine();
//        Engine engine = new ICEngine(); // Inject thủ công
        Car car = new Car(engine);
        car.start();
    }
}
