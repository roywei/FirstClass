package com.cmu.firstclass.firstclass.entities;

import java.util.List;

/**
 * Created by jialiangtan on 4/20/15.
 */
public interface IDataChangeListener {

    void OnUserUpdate(NormalUser user);

    void OnDepartmentUpdate(Department department);

    void OnUniversityUpdate(University university);

    void OnDepartmentAddingCourse(Department department, Course course);

    void OnDepartmentDeletingCourse(Department department, Course course);

    void OnUserUpdateWatchList(NormalUser user, List<Course> watchList);

    void OnUserAddCourseToWatchList(NormalUser user, int courseID);

    void OnUserDeleteCourseFromWatchList(NormalUser user, int courseID);

    void OnCourseUpdate(Course course);

    void OnReviewUpdate(CourseReview courseReview);

    void OnInstructorUpdate(Instructor instructor);

    void OnAddCourseReviewToCourse(Course course, CourseReview review);

    void OnDeleteCourseReviewFromCourse(Course course, CourseReview review);
}
