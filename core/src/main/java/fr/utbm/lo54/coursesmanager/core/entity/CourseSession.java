package fr.utbm.lo54.coursesmanager.core.entity;

public class CourseSession {

    private Integer id;
    private String  startdate;
    private String  enddate;
    // private Course course;
    // private Location location;
    private String  courseCode;
    private Integer locationId;

    public CourseSession() {
    }

    // public CourseSession( Integer id, String startdate, String enddate,
    // Course course, Location location )
    public CourseSession( Integer id, String startdate, String enddate, String courseCode, Integer locationId ) {
        this.id = id;
        this.startdate = startdate;
        this.enddate = enddate;
        this.courseCode = courseCode;
        this.locationId = locationId;
        // this.location = location;
        // this.courseCode = = course;
    }

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode( String courseCode ) {
        this.courseCode = courseCode;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId( Integer locationId ) {
        this.locationId = locationId;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate( String startdate ) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate( String enddate ) {
        this.enddate = enddate;
    }

    // public Course getCourse() {
    // return course;
    // }
    //
    // public void setCourse( Course course ) {
    // this.course = course;
    // }

    // public Location getLocation() {
    // return location;
    // }
    //
    // public void setLocation( Location location ) {
    // this.location = location;
    // }

}
