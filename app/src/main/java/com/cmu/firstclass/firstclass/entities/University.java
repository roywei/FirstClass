package com.cmu.firstclass.firstclass.entities;

import com.cmu.firstclass.firstclass.entities.exceptions.ContentNotLoadedException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jialiangtan on 4/3/15.
 */
public class University implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -4536935647009974228L;
    private List<IDataChangeListener> dataChangeListenerList = new ArrayList<>();

    private Integer universityID;
    private String name;
    private HashMap<Integer, Department> departmentHashMap;

    /**
     * constructs the {@link com.cmu.firstclass.firstclass.entities.University} using university id. The information about the university
     * is retrieved from the database there needs to be a server connection going on.
     * @param universityID
     *
     */
    public University(int universityID, IDataChangeListener databaseUpdateListener) {
        this.universityID = universityID;
        this.dataChangeListenerList.add(databaseUpdateListener);
    }

    public int getUniversityID() {
        return this.universityID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnUniversityUpdate(this);
        }
    }

    public Department getDepartment(Integer departmentID) throws ContentNotLoadedException {
        if (departmentHashMap == null) {
            throw new ContentNotLoadedException("Department is not detailed constructed and " +
                    "course information cannot be found");
        }
        return departmentHashMap.get(departmentID);
    }

    /**
     * detailed construction for this object. {@link this.isWellConstructed()} method has to be called
     * before each call to check if the object is well constructed in order to guarantee the efficiency.
     */
    public void completeDetailedConstruction(HashMap<Integer, Department> departmentHashMap) {
        if (departmentHashMap == null) {
            this.departmentHashMap = departmentHashMap;
        }
        else {
            return;
        }
    }

    public boolean isWellConstructed() {
        if (this.departmentHashMap == null) {
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
