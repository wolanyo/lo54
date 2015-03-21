/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.coursesmanager.core.entity;

/**
 *
 * @author Eric
 */
public class CourseSession {
    
    private Integer id;
    private String start;
    private String end;
    private String courseCode;
    private Integer locationId;

    public CourseSession(Integer id, String start, String end, String courseCode, Integer locationId) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.courseCode = courseCode;
        this.locationId = locationId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

}
