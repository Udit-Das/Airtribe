package org.example.course;

import org.example.cohort.Cohort;

import java.util.List;

public class Online extends Course{
    private String zoomUrl;

    public Online(Long courseId, String courseName, String courseDescription, CourseLanguage courseLanguage,
                  String zoomUrl) {
        super(courseId, courseName, courseDescription, courseLanguage);
        this.zoomUrl = zoomUrl;
    }

    @Override
    public void displayCourseDetails() {
        System.out.println("Course ID: " + getCourseId());
        System.out.println("Course Name: " + getCourseName());
        System.out.println("Course Description: " + getCourseDescription());
        System.out.println("Course Language: " + getCourseLanguage().toString());
        System.out.println("Zoom URL: " + this.zoomUrl);
        for (Cohort cohort : getCohorts()) {
            cohort.displayCohortDetails();

        }
    }
    public String getZoomUrl() {
        return zoomUrl;
    }
    public void setZoomUrl(String zoomUrl) {
        this.zoomUrl = zoomUrl;
    }
}
