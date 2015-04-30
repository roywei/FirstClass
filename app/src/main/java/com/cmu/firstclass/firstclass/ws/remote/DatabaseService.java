package com.cmu.firstclass.firstclass.ws.remote;

import android.util.Log;

import com.cmu.firstclass.firstclass.entities.Course;
import com.cmu.firstclass.firstclass.entities.CourseReview;
import com.cmu.firstclass.firstclass.entities.Department;
import com.cmu.firstclass.firstclass.entities.IDataChangeListener;
import com.cmu.firstclass.firstclass.entities.Instructor;
import com.cmu.firstclass.firstclass.entities.NormalUser;
import com.cmu.firstclass.firstclass.entities.University;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by Roy on 4/15/15.
 */
public class DatabaseService implements IDataChangeListener, IDatabaseService{

    @Override
    public void OnUserUpdate(NormalUser user) {

    }

    @Override
    public void OnDepartmentUpdate(Department department) {

    }

    @Override
    public void OnUniversityUpdate(University university) {

    }

    @Override
    public void OnDepartmentAddingCourse(Department department, Course course) {

    }



    @Override
    public void OnDepartmentDeletingCourse(Department department, Course course) {

    }



    @Override
    public void OnUserUpdateWatchList(NormalUser user, List<Course> watchList) {

    }




    @Override
    public void OnUserAddCourseToWatchList(NormalUser user, int courseID) {

    }

    @Override
    public void OnUserDeleteCourseFromWatchList(NormalUser user, int courseID) {

    }

    @Override
    public void OnCourseUpdate(Course course) {

    }

    @Override
    public void OnReviewUpdate(CourseReview courseReview) {

    }

    @Override
    public void OnInstructorUpdate(Instructor instructor) {

    }

    @Override
    public void OnAddCourseReviewToCourse(Course course, CourseReview review) {

    }

    @Override
    public void OnDeleteCourseReviewFromCourse(Course course, CourseReview review) {

    }
/*
    @Override
    public void OnCourseReviewListUpdate(Course course) {

    }

    @Override
    public void OnCourseInstructorListUpdate(Course course) {

    }

    @Override
    public void OnCourseNameChanged(Course course) {

    }

    @Override
    public void OnCourseInstructionChanged(Course course) {

    }

    @Override
    public void OnCourseAvgGPAChanged(Course course) {

    }

    @Override
    public void OnCourseAvgRatingChanged(Course course) {

    }

    @Override
    public void OnCourseAvgWorkloadChanged(Course course) {

    }

    @Override
    public void OnCourseRankingChanged(Course course) {

    }

    @Override
    public void OnCourseNumberChanged(Course course) {

    }

    @Override
    public void OnCourseCourseNameChanged(Course course) {

    }

    @Override
    public void OnInstructorNameChanged(Instructor instructor) {

    }

    @Override
    public void OnInstructorRankingChanged(Instructor instructor) {

    }

    @Override
    public void OnInstructorContactChanged(Instructor instructor) {

    }

    @Override
    public void OnInstructorAvatarLinkChanged(Instructor instructor) {

    }

    @Override
    public void OnInstructorDepartmentChanged(Instructor instructor) {

    }

    @Override
    public void OnReviewUserChanged(CourseReview courseReview) {

    }

    @Override
    public void OnReviewCourseChanged(CourseReview courseReview) {

    }

    @Override
    public void OnReviewGPAChanged(CourseReview courseReview) {

    }

    @Override
    public void OnReviewCourseRatingChanged(CourseReview courseReview) {

    }

    @Override
    public void OnReviewWorkloadChanged(CourseReview courseReview) {

    }

    @Override
    public void OnReviewCommentChanged(CourseReview courseReview) {

    }*/

    @Override
    public List<University> getListOfUniversities() {
        return null;
    }

    @Override
    public NormalUser getUser(int id) {
        return null;
    }

    @Override
    public Department getDepartment(int id) {
        return null;
    }

    @Override
    public Course getCourse(int id) {
        return null;
    }

    @Override
    public CourseReview getCourseReview(int id) {
        return null;
    }

    @Override
    public Instructor getInstructor(int id) {
        return null;
    }

    @Override
    public boolean loginAuthenticate(String account, String password) {
        final String userId = account;
        final String userPassword = password;


        new Thread(new Runnable() {
            public void run() {
                try {
                    String loginAddress = "http://128.237.207.22:8080/FirstClassServer/Login";
                    URL url = new URL(loginAddress);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    Log.i("xxx", "inside http service try");
                    httpURLConnection.setRequestProperty("account", userId);
                    httpURLConnection.setRequestProperty("password", userPassword);


                    if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                        Log.i("xxxx","http ok");
                        String key = httpURLConnection.getHeaderField("key");
                        if(key.equals("abc")){
                            Log.i("xxxx","key equals");
                        }
                    }


                }catch (MalformedURLException e){
                    Log.i("xxx", "mail url exception");

                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                    Log.i("xxx", "ioexception");

                }

            }
        }).start();


        return false;
    }

    @Override
    public void loadUniversity(University university) {

    }

    @Override
    public void loadUser(NormalUser user) {

    }

    @Override
    public void loadDepartment(Department department) {

    }

    @Override
    public void loadCourse(Course course) {

    }

    @Override
    public void loadCourseReview(CourseReview courseReview) {

    }

    @Override
    public void loadInstructor(Instructor instructor) {

    }
}
