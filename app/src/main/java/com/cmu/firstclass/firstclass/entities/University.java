package com.cmu.firstclass.firstclass.entities;

import com.cmu.firstclass.firstclass.entities.exceptions.ContentNotLoadedException;

import java.util.HashMap;

/**
 * Created by jialiangtan on 4/3/15.
 */
public class University {
    private Integer universityID;
    private String name;
    private HashMap<Integer, Department> departmentHashMap;

    /**
     * constructs the {@link com.cmu.firstclass.firstclass.entities.University} using university id. The information about the university
     * is retrieved from the database there needs to be a server connection going on.
     * @param universityID
     * @param isDetailedConstruction construct the name only if true, else construct fully functional
     *                               object.
     */
    public University(int universityID, boolean isDetailedConstruction) {
        this.universityID = universityID;
        if (isDetailedConstruction) {
            // TODO load information from database about department
        }
        else {
            // TODO load only university name
        }
    }

    public void completeConstruction() {
        if (departmentHashMap == null) {
            // TODO complete the construction of the university if the university is not detailed constructed
        }
        else {
            return;
        }
    }

    public int getUniversityID() {
        return this.universityID;
    }

    public String getName() {
        return this.name;
    }

    public Department getDepartment(Integer departmentID) throws ContentNotLoadedException {
        if (departmentHashMap == null) {
            throw new ContentNotLoadedException("Department is not detailed constructed and " +
                    "course information cannot be found");
        }
        return departmentHashMap.get(departmentID);
    }
}
