/**
 * 
 */
package fr.utbm.lo54.coursesmanager.core.service;

import java.util.List;

import fr.utbm.lo54.coursesmanager.core.entity.Course;
import fr.utbm.lo54.coursesmanager.core.repository.CourseDao;

/**
 * @author kemour
 *
 */
public class CourseService {
	
	//service pour enregistrer un course
	public void registerCourse(Course course){
		CourseDao courseDao = new CourseDao();
                courseDao.save(course);
	}
	
	//get a Course by ID
	public Course getCourse(Integer id){
		
		return null ; //replace null by a Client object
	}
	
	//get a list of Course
	public List<Course> getListCOurse(){
		
		return null ; //replace null by a List of Course
	}
}
