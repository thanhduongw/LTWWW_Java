package iuh.fit.se.javaconfig;

public class ICEngine implements Engine {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void start() {
        System.out.println("IC Engine started with type: "+type);
    }
}
