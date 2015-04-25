package com.cmu.firstclass.firstclass.ws.remote;

import com.cmu.firstclass.firstclass.entities.Course;
import com.cmu.firstclass.firstclass.entities.CourseReview;
import com.cmu.firstclass.firstclass.entities.Department;
import com.cmu.firstclass.firstclass.entities.Instructor;
import com.cmu.firstclass.firstclass.entities.NormalUser;
import com.cmu.firstclass.firstclass.entities.University;

import java.util.List;

/**
 * Created by Roy on 4/15/15.
 */
public interface IDatabaseService {

    /**
     * @return partially retrieved university list, only names are included inside university
     */
    List<University> getListOfUniversities();

    NormalUser getUser(int id);

    Department getDepartment(int id);

    Course getCourse(int id);

    CourseReview getCourseReview(int id);

    Instructor getInstructor(int id);

    /**
     * loads the complete object content from database
     * @param university
     */
    boolean loginAuthenticate(String userID, String password);
    void loadUniversity(University university);

    void loadUser(NormalUser user);

    void loadDepartment(Department department);

    void loadCourse(Course course);

    void loadCourseReview(CourseReview courseReview);

    void loadInstructor(Instructor instructor);
}
