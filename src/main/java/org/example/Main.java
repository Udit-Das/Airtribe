package org.example;

import org.example.cohort.Cohort;
import org.example.course.Course;
import org.example.course.CourseLanguage;
import org.example.course.Oflline;
import org.example.instructor.Instructor;
import org.example.learner.Learner;
import org.example.learner.NodeLearner;

import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Course nodeOfflineCourse = new Oflline(1L,
                "NodeJS Offline Course",
                "An offline course for NodeJS",
                CourseLanguage.NODEJS,
                "Bangalore");


        Cohort c1 = new Cohort(1L, new Date(), new Date(), "Cohort 1", "Node Cohort");
        Cohort c2 = new Cohort(1L, new Date(), new Date(), "Cohort 2", "Node Cohort");
        Cohort c3 = new Cohort(1L, new Date(), new Date(), "Cohort 3", "Node Cohort");
        Cohort c4 = new Cohort(1L, new Date(), new Date(), "Cohort 4", "Node Cohort");
        Cohort c5 = new Cohort(1L, new Date(), new Date(), "Cohort 5", "Node Cohort");

        nodeOfflineCourse.addCohortToCourse(c1);
        nodeOfflineCourse.addCohortToCourse(c2);
        nodeOfflineCourse.addCohortToCourse(c3);
        nodeOfflineCourse.addCohortToCourse(c4);
        nodeOfflineCourse.addCohortToCourse(c5);

        Learner nodeLearner1 = new NodeLearner(1L, "first", "last", 10L);
        Learner nodeLearner2 = new NodeLearner(2L, "first", "last", 10L);
        Learner nodeLearner3 = new NodeLearner(3L, "first", "last", 10L);

        c1.addLearnerToCohort(nodeLearner1);
        c2.addLearnerToCohort(nodeLearner2);
        c3.addLearnerToCohort(nodeLearner3);

        Instructor instructor1 = new Instructor("First", "Last", 5L);
        Instructor instructor2 = new Instructor("First", "Last", 6L);
        Instructor instructor3 = new Instructor("First", "Last", 7L);

        c1.addInstructorToCohort(instructor1);

        nodeOfflineCourse.displayCourseDetails();




    }
}