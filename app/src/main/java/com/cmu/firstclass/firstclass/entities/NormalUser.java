package com.cmu.firstclass.firstclass.entities;

import com.cmu.firstclass.firstclass.entities.exceptions.ContentNotLoadedException;

import java.util.List;

/**
 * This class represents a user's profile
 */
public class NormalUser {
    private String userID;
    private String name;
    private String address;
    private String email;
    private int cellNumber;
    private University university;
    private Department department;
    private List<Course> courseWatchList;

    public NormalUser(String userID, boolean isDetailedConstruction) {
        this.userID = userID;
        if (isDetailedConstruction) {
            // TODO database retrieve for detailed construction
        }
        else {
            // TODO database retrieve for user information, detailed information shall not be initialized at this time
        }
    }

    public void completeDetailedConstruction() {
        if (courseWatchList == null) {
            // TODO database retrieve for detailed construction
        }
        else {
            return;
        }
    }
    public List<Course> getCourseWatchList() {
        return courseWatchList;
    }

    public void setCourseWatchList(List<Course> courseWatchList) {
        this.courseWatchList = courseWatchList;
        // TODO sync with database
    }

    public String getDepartmentName() {
        return department.getName();
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getUniversityName() {
        return university.getName();
    }

    public void setUniversity(University university) {
        this.university = university;
        // TODO sync with database
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(int cellNumber) {
        this.cellNumber = cellNumber;
        // TODO sync with database
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        // TODO sync with database

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        // TODO sync with database

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
        // TODO sync with database

    }

    public String getUserID() {
        return this.userID;
    }

    /**
     * adds a course to the user's course watch list
     * @param CourseID
     */
    public void addCourseToWatchList(int CourseID) throws ContentNotLoadedException {
        if (this.courseWatchList == null) {
            throw new ContentNotLoadedException("NormalUser is not detailed constructed and " +
                    "watch list information cannot be found");
        }
        // TODO find course from courseID from database, adding to watch list, synchronize with database
    }
}
