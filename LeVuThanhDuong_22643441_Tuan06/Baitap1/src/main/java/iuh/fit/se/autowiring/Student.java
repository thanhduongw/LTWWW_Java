package iuh.fit.se.autowiring;

public class Student {
    private Faculty faculty;  // Property để auto-wire

    // Constructor mặc định (yêu cầu cho byName/byType)
    public Student() {
        // Không cần logic, chỉ cần có constructor
    }

    // Constructor cho auto-wire constructor
    public Student(Faculty faculty) {
        this.faculty = faculty;
    }

    // Setter cho byName/byType
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void learn() {
        if (faculty != null) {
            faculty.teach();
            System.out.println("Student is learning");
        } else {
            System.out.println("No faculty injected!");
        }
    }
}