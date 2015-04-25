package com.cmu.firstclass.firstclass.entities;

import com.cmu.firstclass.firstclass.entities.exceptions.ContentNotLoadedException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

/**
 * Created by jialiangtan on 4/3/15.
 */
public class Department implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 8753777172572978152L;
    private List<IDataChangeListener> dataChangeListenerList = new ArrayList<>();

    private Integer departmentID;
    private String name;
    private SortedMap<Integer, Course> courseSortedMap;

    public Department(int departmentID, String name, IDataChangeListener databaseUpdateListener) {
        this.departmentID = departmentID;
        this.name = name;
        this.dataChangeListenerList.add(databaseUpdateListener);
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
        if (this.courseSortedMap == null) {
            throw new ContentNotLoadedException("Department is not detailed constructed, no course" +
                    " information can be found");
        }
        Course course = this.courseSortedMap.get(courseID);
        return course;
    }

    /**
     * @return all courses as a list, sorted by the course code
     */
    public SortedMap<Integer, Course> getAllCourses() throws ContentNotLoadedException {
        if (this.courseSortedMap == null) {
            throw new ContentNotLoadedException("Department is not detailed constructed, no course" +
                    " information can be found");
        }
        return this.courseSortedMap;
    }

    public void addCourseToDepartment(Course course){
        if (this.isWellConstructed()) {
            this.courseSortedMap.put(course.getCourseID(), course);
        }
        for (IDataChangeListener dataChangeListener : dataChangeListenerList) {
            dataChangeListener.OnDepartmentAddingCourse(this, course);
        }
    }

    public void deleteCourseFromDepartment(Course course) {
        if (this.isWellConstructed()) {
            this.courseSortedMap.remove(course.getCourseID());
        }
        for (IDataChangeListener dataChangeListener : dataChangeListenerList) {
            dataChangeListener.OnDepartmentDeletingCourse(this, course);
        }
    }

    public void setName(String name) {
        this.name = name;
        for (IDataChangeListener dataChangeListener : dataChangeListenerList) {
            dataChangeListener.OnDepartmentUpdate(this);
        }
    }
    /**
     * detailed construction for this object. {@link this.isWellConstructed()} method has to be called
     * before each call to check if the object is well constructed in order to guarantee the efficiency.
     */
    public void completeDetailedConstruction(SortedMap<Integer, Course> courseSortedMap) {
        this.courseSortedMap = courseSortedMap;
    }

    /**
     * check if the construction of the object is complete.
     * @return
     */
    public boolean isWellConstructed() {
        if(this.courseSortedMap == null)
            return false;
        return true;
    }

    public void registerDataChangeListener(IDataChangeListener dataChangeListener) {
        this.dataChangeListenerList.add(dataChangeListener);
    }

    public void deregisterDataChangeListener(IDataChangeListener dataChangeListener) {
        this.dataChangeListenerList.remove(dataChangeListener);
    }
}
