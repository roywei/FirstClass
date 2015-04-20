package com.cmu.firstclass.firstclass.entities;

import com.cmu.firstclass.firstclass.entities.exceptions.ContentNotLoadedException;

import java.util.List;

/**
 * This class represents a user's profile
 */
public class NormalUser {
    private List<IDataChangeListener> dataChangeListenerList;

    private String userID;
    private String name;
    private String address;
    private String email;
    private Integer cellNumber;
    private University university;
    private Department department;
    private List<Course> courseWatchList;

    public NormalUser(String userID, String name, IDataChangeListener databaseUpdateListenser) {
        this.userID = userID;
        this.name = name;
        this.dataChangeListenerList.add(databaseUpdateListenser);
    }

    public List<Course> getCourseWatchList() throws ContentNotLoadedException {
        if (this.courseWatchList == null) {
            throw new ContentNotLoadedException("User is not detailed constructed, no course" +
                    " information can be found");
        }
        return courseWatchList;
    }

    public void setAndSyncCourseWatchList(List<Course> courseWatchList) {
        this.courseWatchList = courseWatchList;
        for (IDataChangeListener listener : this.dataChangeListenerList) {
            listener.OnUserUpdateWatchList(this, courseWatchList);
        }
    }

    public Department getDepartment() throws ContentNotLoadedException {
        if (this.department == null) {
            throw new ContentNotLoadedException("User is not detailed constructed, no course" +
                    " information can be found");
        }
        return this.department;
    }

    public void setAndSyncDepartment(Department department) {
        this.department = department;
        for (IDataChangeListener listener : this.dataChangeListenerList) {
            listener.OnUserUpdateDepartment(this);
        }
    }

    public University getUniversity() throws ContentNotLoadedException {
        if (this.university == null) {
            throw new ContentNotLoadedException("User is not detailed constructed, no course" +
                    " information can be found");
        }
        return this.university;
    }

    public void setAndSyncUniversity(University university) {
        this.university = university;
        for (IDataChangeListener listener : this.dataChangeListenerList) {
            listener.OnUserUpdateUniversity(this);
        }
    }

    public int getCellNumber() throws ContentNotLoadedException {
        if (this.cellNumber == null) {
            throw new ContentNotLoadedException("User is not detailed constructed, no course" +
                    " information can be found");
        }
        return cellNumber;
    }

    public void setAndSyncCellNumber(int cellNumber) {
        this.cellNumber = cellNumber;
        for (IDataChangeListener listener : this.dataChangeListenerList) {
            listener.OnUserUpdateCellNumber(this);
        }
    }

    public String getEmail() throws ContentNotLoadedException {
        if (this.email == null) {
            throw new ContentNotLoadedException("Department is not detailed constructed, no course" +
                    " information can be found");
        }
        return email;
    }

    public void setAndSyncEmail(String email) {
        this.email = email;
        for (IDataChangeListener listener : this.dataChangeListenerList) {
            listener.OnUserUpdateEmail(this);
        }
    }

    public String getAddress() throws ContentNotLoadedException {
        if (this.address == null) {
            throw new ContentNotLoadedException("Department is not detailed constructed, no course" +
                    " information can be found");
        }
        return address;
    }

    public void setAndSyncAddress(String address) {
        this.address = address;
        for (IDataChangeListener listener : this.dataChangeListenerList) {
            listener.OnUserUpdateAddress(this);
        }
    }

    public String getName() {
        return this.name;
    }

    public void setAndSyncName(String name) {
        this.name = name;
        for (IDataChangeListener listener : this.dataChangeListenerList) {
            listener.OnUserUpdateName(this);
        }
    }

    public String getUserID() {
        return this.userID;
    }

    /**
     * adds a course to the user's course watch list
     * @param courseID
     */
    public void addCourseToWatchList(int courseID) throws ContentNotLoadedException {
        if (this.courseWatchList == null) {
            throw new ContentNotLoadedException("NormalUser is not detailed constructed and " +
                    "watch list information cannot be found");
        }
        for (IDataChangeListener listener : this.dataChangeListenerList) {
            listener.OnUserAddCourseToWatchList(this, courseID);
        }
    }

    public void deleteCourseFromWatchList(int courseID) throws ContentNotLoadedException {
        if (this.courseWatchList == null) {
            throw new ContentNotLoadedException("NormalUser is not detailed constructed and " +
                    "watch list information cannot be found");
        }
        for (IDataChangeListener listener : this.dataChangeListenerList) {
            listener.OnUserDeleteCourseFromWatchList(this, courseID);
        }
    }

    /**
     * detailed construction for this object. {@link this.isWellConstructed()} method has to be called
     * before each call to check if the object is well constructed in order to guarantee the efficiency.
     */
    public void completeDetailedConstruction(String address,
                                             String email,
                                             Integer cellNumber,
                                             List<Course> courseWatchList,
                                             Department department,
                                             University university) {
        this.address = address;
        this.email = email;
        this.cellNumber = cellNumber;
        this.courseWatchList = courseWatchList;
        this.department = department;
        this.university = university;
    }

    /**
     * check if the construction of the object is complete.
     * @return
     */
    public boolean isWellConstructed() {
        if (this.address == null
                || this.cellNumber == null
                || this.courseWatchList == null
                || this.department == null
                || this.email == null
                || this.university == null
                ) {
            return false;
        }
        return true;
    }

    public void registerDataChangeListener(IDataChangeListener dataChangeListener) {
        this.dataChangeListenerList.add(dataChangeListener);
    }

    public void deregisterDataChangeListener(IDataChangeListener dataChangeListener) {
        this.dataChangeListenerList.remove(dataChangeListener);
    }
}
