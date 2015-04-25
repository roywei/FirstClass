package com.cmu.firstclass.firstclass.entities;

import com.cmu.firstclass.firstclass.entities.exceptions.ContentNotLoadedException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jialiangtan on 4/3/15.
 */
public class Course implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 2334261593687006984L;
    private List<IDataChangeListener> dataChangeListenerList = new ArrayList<>();

    private int courseID;
    private String courseName;
    private Integer courseNumber;
    private String introduction;
    private Double avgGPA;
    private Double avgRating;
    private Double avgWorkload;
    private Integer ranking;
    private List<Instructor> instructorList;
    private List<CourseReview> reviewList;

    /**
     * construct the course object, partially
     * @param courseID
     */
    public Course(int courseID, Integer courseNumber, String courseName, IDataChangeListener databaseListener) {
        this.courseID = courseID;
        dataChangeListenerList.add(databaseListener);
    }

    /**
     * complete the detailed construction if the {@link com.cmu.firstclass.firstclass.entities.Course} is not detailed constructed
     */
    public void completeDetailedConstruction(
            String introduction,
            Double avgGPA,
            Double avgRating,
            Double avgWorkload,
            Integer ranking,
            List<Instructor> instructorList,
            List<CourseReview> reviewList) {
        this.introduction = introduction;
        this.avgGPA = avgGPA;
        this.avgRating = avgRating;
        this.avgWorkload = avgWorkload;
        this.ranking = ranking;
        this.instructorList = instructorList;
        this.reviewList = reviewList;
    }

    // Getters

    public int getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public Integer getCourseNumber() {
        return this.courseNumber;
    }

    public List<CourseReview> getReviewList() throws ContentNotLoadedException {
        if (this.reviewList == null) {
            throw new ContentNotLoadedException("Course is not detailed constructed, no reviews " +
                    "information can be found");
        }
        return reviewList;
    }

    public List<Instructor> getInstructorList() throws ContentNotLoadedException {
        if (this.reviewList == null) {
            throw new ContentNotLoadedException("Course is not detailed constructed, no instructors " +
                    "information can be found");
        }
        return instructorList;
    }

    public String getIntroduction() throws ContentNotLoadedException {
        if (this.introduction == null) {
            throw new ContentNotLoadedException("Course is not detailed constructed, no reviews " +
                    "information can be found");
        }
        return introduction;
    }

    public Double getAvgGPA() throws ContentNotLoadedException {
        if (this.avgGPA == null) {
            throw new ContentNotLoadedException("Course is not detailed constructed, no reviews " +
                    "information can be found");
        }
        return avgGPA;
    }

    public Double getAvgRating() throws ContentNotLoadedException {
        if (this.avgRating == null) {
            throw new ContentNotLoadedException("Course is not detailed constructed, no reviews " +
                    "information can be found");
        }
        return avgRating;
    }

    public Double getAvgWorkload() throws ContentNotLoadedException {
        if (this.avgWorkload == null) {
            throw new ContentNotLoadedException("Course is not detailed constructed, no reviews " +
                    "information can be found");
        }
        return avgWorkload;
    }

    public Integer getRanking() throws ContentNotLoadedException {
        if (this.ranking == null) {
            throw new ContentNotLoadedException("Course is not detailed constructed, no reviews " +
                    "information can be found");
        }
        return ranking;
    }

    // Setters

    public void setCourseNumber(Integer courseNumber) {
        this.courseNumber = courseNumber;
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnCourseUpdate(this);
        }
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnCourseUpdate(this);
        }
    }

    public void setAvgGPA(Double avgGPA) {
        this.avgGPA = avgGPA;
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnCourseUpdate(this);
        }
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnCourseUpdate(this);
        }
    }

    public void setAvgWorkload(Double avgWorkload) {
        this.avgWorkload = avgWorkload;
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnCourseUpdate(this);
        }
    }

    public void addToReviewList(CourseReview review) {
        this.reviewList.add(review);
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnAddCourseReviewToCourse(this, review);
        }
    }

    public void removeFromReviewList(CourseReview review) {
        this.reviewList.remove(review);
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnDeleteCourseReviewFromCourse(this, review);
        }
    }

    public void setInstructorList(List<Instructor> instructorList) {
        this.instructorList = instructorList;
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnCourseUpdate(this);
        }
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnCourseUpdate(this);
        }
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
        for (IDataChangeListener listener : dataChangeListenerList) {
            listener.OnCourseUpdate(this);
        }
    }

}
