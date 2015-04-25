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
public class CourseReview implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -5100130235763853991L;
    private List<IDataChangeListener> dataChangeListenerList = new ArrayList<>();

    private int id;

    private NormalUser user;
    private Course course;
    private Double GPA;
    private Double courseRating;
    private Double workload;
    private String comment;

    public CourseReview(int id, IDataChangeListener databaseListener) {
        this.id = id;
        if(databaseListener != null)
            this.dataChangeListenerList.add(databaseListener);
    }

    public void completeDetailedConstruction(
            NormalUser user,
            Course course,
            Double GPA,
            Double rating,
            Double workload,
            String comment) {
        this.user = user;
        this.course = course;
        this.GPA = GPA;
        this.courseRating = rating;
        this.workload = workload;
        this.comment = comment;
    }

    // Getters

    public int getId() {
        return this.id;
    }

    public NormalUser getUser() throws ContentNotLoadedException {
        if (this.user == null) {
            throw new ContentNotLoadedException("Error : Course review not fully loaded.");
        }
        return this.user;
    }

    public Course getCourse() throws ContentNotLoadedException {
        if (this.course == null) {
            throw new ContentNotLoadedException("Error : Course review not fully loaded.");
        }
        return this.course;
    }

    public Double getGPA() throws ContentNotLoadedException {
        if (this.GPA == null) {
            throw new ContentNotLoadedException("Error : Course review not fully loaded.");
        }
        return this.GPA;
    }

    public Double getCourseRating() throws ContentNotLoadedException {
        if (this.courseRating == null) {
            throw new ContentNotLoadedException("Error : Course review not fully loaded.");
        }
        return this.courseRating;
    }

    public Double getWorkload() throws ContentNotLoadedException {
        if (this.workload == null) {
            throw new ContentNotLoadedException("Error : Course review not fully loaded.");
        }
        return this.workload;
    }

    public String getComment() throws ContentNotLoadedException {
        if (this.comment == null) {
            throw new ContentNotLoadedException("Error : Course review not fully loaded.");
        }
        return this.comment;
    }

    // Setters

    public void setUser(NormalUser user) {
        this.user = user;
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnReviewUpdate(this);
        }
    }

    public void setCourse(Course course) {
        this.course = course;
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnReviewUpdate(this);
        }
    }

    public void setGPA(Double GPA) {
        this.GPA = GPA;
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnReviewUpdate(this);
        }
    }

    public void setCourseRating(Double rating) {
        this.courseRating = rating;
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnReviewUpdate(this);
        }
    }

    public void setWorkload(Double workload) {
        this.workload = workload;
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnReviewUpdate(this);
        }
    }

    public void setComment(String comment) {
        this.comment = comment;
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnReviewUpdate(this);
        }
    }
}
