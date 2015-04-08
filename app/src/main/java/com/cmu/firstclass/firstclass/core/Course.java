package com.cmu.firstclass.firstclass.core;

import com.cmu.firstclass.firstclass.core.exceptions.ContentNotLoadedException;

import java.util.List;

/**
 * Created by jialiangtan on 4/3/15.
 */
public class Course {

    private int courseID;
    private String courseName;
    private float rating = -1;
    private List<Instructor> instructorList;
    private List<CourseReview> reviewList;

    /**
     * construct the course object
     * @param courseID
     * @param isDetailedConstruction if it is set true, only course name will be retrieved, otherwise
     *                               all detailed information will be retrieved from the database.
     */
    public Course(int courseID, boolean isDetailedConstruction) {
        if (isDetailedConstruction) {

            // TODO detailed constructing the Course from database
        }
        else {
            // TODO non detailed construction (name and rating)
        }

    }

    /**
     * complete the detailed construction if the {@link com.cmu.firstclass.firstclass.core.Course} is not detailed constructed
     */
    public void completeDetailedConstruction() {
        if (instructorList == null) {
            // TODO complete the detailed construction
        }
        else {
            return;
        }
    }

    public int getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public float getRating() throws ContentNotLoadedException {
        if (this.rating + 1 < 0.000001) {
            throw new ContentNotLoadedException("Course is not detailed constructed, no rating " +
                    "information can be found");
        }
        return rating;
    }

    public List<CourseReview> getReviewList() throws ContentNotLoadedException {
        if (this.reviewList == null) {
            throw new ContentNotLoadedException("Course is not detailed constructed, no reviews " +
                    "information can be found");
        }
        return reviewList;
    }

    public void setReviewList(List<CourseReview> reviewList) {
        this.reviewList = reviewList;
        // TODO sync with database
    }

    public List<Instructor> getInstructorList() throws ContentNotLoadedException {
        if (this.reviewList == null) {
            throw new ContentNotLoadedException("Course is not detailed constructed, no instructors " +
                    "information can be found");
        }
        return instructorList;
    }

    public void setInstructorList(List<Instructor> instructorList) {
        this.instructorList = instructorList;
        // TODO sync with database
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
        // TODO sync with database
    }

    /**
     * called when any rating in any review changes
     */
    private void updateReviewScore() {
        // TODO update review score
    }

}
