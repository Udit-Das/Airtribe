package org.example.course;

import org.example.cohort.Cohort;

import java.util.List;

public class Oflline  extends Course{
    private String location;

    public Oflline(Long courseId, String courseName, String courseDescription, CourseLanguage courseLanguage,
                  String location) {
        super(courseId, courseName, courseDescription, courseLanguage);
        this.location = location;
    }


    @Override
    public void displayCourseDetails() {
        System.out.println("Course ID: " + getCourseId());
        System.out.println("Course Name: " + getCourseName());
        System.out.println("Course Description: " + getCourseDescription());
        System.out.println("Course Language: " + getCourseLanguage().toString());
        System.out.println("Location: " + this.location);
        for (Cohort cohort : getCohorts()) {
            cohort.displayCohortDetails();

        }

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
