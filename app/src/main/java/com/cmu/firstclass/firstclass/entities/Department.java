package com.cmu.firstclass.firstclass.entities;

import com.cmu.firstclass.firstclass.entities.exceptions.ContentNotLoadedException;

import java.util.HashMap;

/**
 * Created by jialiangtan on 4/3/15.
 */
public class Department {
    private Integer departmentID;
    private String name;
    private HashMap<Integer, Course> courseHashMap;

    public Department(int departmentID, boolean isDetailedConstruction) {
        if (isDetailedConstruction) {
            // TODO retrieve all detailed information from the server
        }
        else {
            // TODO retrieve only department name from server
        }
    }

    public void completeDetailedConstruction() {
        if (this.courseHashMap == null) {
            // TODO database retrieve for detailed construction
        }
        else {
            return;
        }
    }

    public String getName() {
        return this.name;
    }

    /**
     * gets course by course id
     * @param courseID
     * @return {@link Course} if course exists, null if the course does not exist
     * @exception com.cmu.firstclass.firstclass.entities.exceptions.ContentNotLoadedException thrown
     * when there the department is not detailed constructed.
     */
    public Course getCourse(int courseID) throws ContentNotLoadedException {
        if (courseHashMap == null) {
            throw new ContentNotLoadedException("Department is not detailed constructed, no course" +
                    " information can be found");
        }
        Course course = this.courseHashMap.get(courseID);
        return course;
    }
}
