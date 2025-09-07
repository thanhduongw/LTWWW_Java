package iuh.fit.se;

import java.io.Serializable;
import java.time.LocalDate;

public class Student implements Serializable {
    private String firstName;
    private String lastName;

    private LocalDate dob;
    private String email;
    private String phone;
    private String gender;
    private String address;
    private String city;
    private String pinCode;
    private String state;
    private String country;
    private String hobbies;
    private String course;

    public Student() {
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getHobbies() {
        return hobbies;
    }

    public String getCourse() {
        return course;
    }
}
