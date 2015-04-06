package fr.utbm.lo54.coursesmanager.core.entity;

public class Client {
    private Integer id;
    private String  lastName;
    private String  firstName;
    private String  address;
    private String  phone;
    private String  email;
    // private Set<CourseSession> coursesessions;
    private Integer sessionId;

    public Client() {
    }

    public Client( Integer id, String lastName, String firstName, String address, String phone, String email,
            Integer session_Id ) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.sessionId = session_Id;
    }

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress( String address ) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone( String phone ) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public Integer getSession_Id() {
        return sessionId;
    }

    public void setSession_Id( Integer session_Id ) {
        this.sessionId = session_Id;
    }

    // public Set<CourseSession> getCoursesessions() {
    // return coursesessions;
    // }
    // public void setCoursesessions(Set<CourseSession> coursesessions) {
    // this.coursesessions = coursesessions;
    // }
}
