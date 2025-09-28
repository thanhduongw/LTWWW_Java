package iuh.fit.se.withoutdi;

public class ICEngine {
    private float cylinderCapacity;
    private String type;

    public ICEngine() {
        super();
    }

    public float getCylinderCapacity() {
        return cylinderCapacity;
    }

    public void setCylinderCapacity(float cylinderCapacity) {
        this.cylinderCapacity = cylinderCapacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void start() {
        System.out.println("Engine is started");
    }
}
