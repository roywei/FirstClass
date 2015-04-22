package com.cmu.firstclass.firstclass.entities;

import com.cmu.firstclass.firstclass.entities.exceptions.ContentNotLoadedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jialiangtan on 4/3/15.
 */
public class Instructor {
    private List<IDataChangeListener> dataChangeListenerList = new ArrayList<>();

    private String id;
    private String name;
    private Integer ranking;
    private String contact;
    private String avatarLink;
    private Department department;

    public Instructor(String id, String name, IDataChangeListener databaseListener) {
        this.id = id;
        this.name = name;
        this.dataChangeListenerList.add(databaseListener);
    }

    public void completeDetailedConstruction(
             Integer ranking,
             String contact,
             String avatarLink,
             Department department) {
        this.ranking = ranking;
        this.contact = contact;
        this.avatarLink = avatarLink;
        this.department = department;
    }

    // Getter

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getRanking() throws ContentNotLoadedException {
        if (this.ranking == null) {
            throw new ContentNotLoadedException("Error: Instructor class is not fully loaded.");
        }
        return ranking;
    }

    public String getContact() throws ContentNotLoadedException {
        if (this.contact == null) {
            throw new ContentNotLoadedException("Error: Instructor class is not fully loaded.");
        }
        return contact;
    }

    public String getAvatarLink() throws ContentNotLoadedException {
        if (this.avatarLink == null) {
            throw new ContentNotLoadedException("Error: Instructor class is not fully loaded.");
        }
        return avatarLink;
    }

    public Department getDepartment() throws ContentNotLoadedException {
        if (this.department == null) {
            throw new ContentNotLoadedException("Error: Instructor class is not fully loaded.");
        }
        return department;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnInstructorNameChanged(this);
        }
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnInstructorRankingChanged(this);
        }
    }

    public void setContact(String contact) {
        this.contact = contact;
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnInstructorContactChanged(this);
        }
    }

    public void setAvatarLink(String avatarLink) {
        this.avatarLink = avatarLink;
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnInstructorAvatarLinkChanged(this);
        }
    }

    public void setDepartment(Department department) {
        this.department = department;
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnInstructorDepartmentChanged(this);
        }
    }
}
