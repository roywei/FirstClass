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

    void OnDepartmentNameUpdate(Department department);

    void OnDepartmentDeletingCourse(Department department, Course course);

    void OnUniversityNameUpdate(University university);

    void OnUserUpdateWatchList(NormalUser user, List<Course> watchList);

    void OnUserUpdateDepartment(NormalUser user);

    void OnUserUpdateUniversity(NormalUser user);

    void OnUserUpdateCellNumber(NormalUser user);

    void OnUserUpdateEmail(NormalUser user);

    void OnUserUpdateAddress(NormalUser user);

    void OnUserUpdateName(NormalUser user);

    void OnUserAddCourseToWatchList(NormalUser user, int courseID);

    void OnUserDeleteCourseFromWatchList(NormalUser user, int courseID);
}
