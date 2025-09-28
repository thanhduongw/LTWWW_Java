package iuh.fit.se.xmlconfig;

import java.util.List;

public class CarWithList {
    private List<String> parts;

    public void setParts(List<String> parts) {
        this.parts = parts;
    }

    public void showParts() {
        System.out.println("Parts: " + parts);
    }
}
