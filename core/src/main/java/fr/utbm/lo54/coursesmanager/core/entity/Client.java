package fr.utbm.lo54.coursesmanager.core.entity;

import java.util.Set;

public class Client {

    private Long id;
    private String lastName;
    private String firstName;
    private String address;
    private String phone;
    private String email;
    private CourseSession coursesession;
    private Set<CourseSession> coursesessions;

    // à utiliser si un client est présent une seule fois en base
    // private Set<CourseSession> coursesessions;
    public Client() {
    }

    public Client(String lastName, String firstName, String address, String phone, String email,
            CourseSession coursesession, Set<CourseSession> sess) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.coursesession = coursesession;
        this.coursesessions = sess;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CourseSession getCoursesession() {
        return coursesession;
    }

    public void setCoursesession(CourseSession coursesession) {
        this.coursesession = coursesession;
    }

    public Set<CourseSession> getCoursesessions() {
        return coursesessions;
    }

    public void setCoursesessions(Set<CourseSession> coursesessions) {
        this.coursesessions = coursesessions;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName="
                + lastName + ", address=" + address + ", phone=" + phone
                + ", eMail=" + email + "]";
    }
}
