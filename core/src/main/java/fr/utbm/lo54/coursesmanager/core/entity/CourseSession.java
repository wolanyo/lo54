package fr.utbm.lo54.coursesmanager.core.entity;

import java.util.Date;

public class CourseSession {

    private Long     id;
    private Date     startdate;
    private Date     enddate;
    private Course   course;
    private Location location;
    private String   courseCode;
    private Integer  locationId;

    public CourseSession() {
    }

    public CourseSession( Date startdate, Date enddate, Course course, Location location ) {
        this.startdate = startdate;
        this.enddate = enddate;
        this.location = location;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
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

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate( Date startdate ) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate( Date enddate ) {
        this.enddate = enddate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse( Course course ) {
        this.course = course;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation( Location location ) {
        this.location = location;
    }

}
