package com.cmu.firstclass.firstclass.entities;

import com.cmu.firstclass.firstclass.entities.exceptions.ContentNotLoadedException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jialiangtan on 4/3/15.
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
