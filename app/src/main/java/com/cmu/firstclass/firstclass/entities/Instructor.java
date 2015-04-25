package com.cmu.firstclass.firstclass.entities;

import com.cmu.firstclass.firstclass.entities.exceptions.ContentNotLoadedException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class can be understood from 3 parts: identity, light weight info, heavy weight info.
 * identity is always loaded when the class is first constructed.<br/>
 * light weight info and heavy weight info can only be loaded when the user calls it.<br/>
 * the difference between light weight info and heavy weight info are:<br/>
 * 1. light weight info is updated using the whole object serialization method<br/>
 * 2. heavy weight info is updated with the database individually, they are transient and
 * cannot be serilized.
 */
public class Instructor implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -7112940386667939327L;
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
        if(databaseListener != null)
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
            listener.OnInstructorUpdate(this);
        }
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnInstructorUpdate(this);
        }
    }

    public void setContact(String contact) {
        this.contact = contact;
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnInstructorUpdate(this);
        }
    }

    public void setAvatarLink(String avatarLink) {
        this.avatarLink = avatarLink;
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnInstructorUpdate(this);
        }
    }

    public void setDepartment(Department department) {
        this.department = department;
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnInstructorUpdate(this);
        }
    }
}
