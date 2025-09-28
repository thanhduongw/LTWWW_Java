package iuh.fit.se.withoutdi;

public class Car {
    private ICEngine engine;
    public Car() {
        engine = new ICEngine();
    }

    public void start() {
        engine.start();
    }
}
