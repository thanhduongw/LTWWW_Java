package iuh.fit.se;

import jakarta.inject.Inject;

public class Hello {
    @Inject
    private World world;
    public String helloWorld() {
        return "Hello " + world.world();
    }
}
