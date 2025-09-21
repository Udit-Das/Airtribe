package org.example.cohort;

import org.example.instructor.Instructor;
import org.example.learner.Learner;

import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cohort {
    private Long cohortId;

    private Date startDate;

    private Date endDate;

    private String cohortName;

    private String cohortDescription;

    private List<Learner> learners;

    private List<Instructor> instructor;

    public Cohort(Long cohortId, Date startDate, Date endDate, String cohortName, String cohortDescription) {
        this.cohortId = cohortId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cohortName = cohortName;
        this.cohortDescription = cohortDescription;
        this.learners = new ArrayList<>();
        this.instructor = new ArrayList<>();
    }

    public Cohort(Long cohortId, Date startDate, Date endDate, String cohortName, String cohortDescription, List<Learner> learners, List<Instructor> instructor) {
        this(cohortId, startDate, endDate, cohortName, cohortDescription);
        this.learners = learners;
        this.instructor = instructor;
    }

    public void addLearnerToCohort(Learner learner) {
        this.learners.add(learner);
    }

    public void addInstructorToCohort(Instructor instructor) {
        this.instructor.add(instructor);
    }
    public void displayCohortDetails() {
        System.out.println("Cohort ID: " + this.cohortId);
        System.out.println("Cohort Name: " + this.cohortName);
        System.out.println("Cohort Description: " + this.cohortDescription);
        System.out.println("Start Date: " + this.startDate);
        System.out.println("End Date: " + this.endDate);
        System.out.println("Instructors:");
        for (Instructor instructor : this.instructor) {
            System.out.println(" - " + instructor.getFirstName() + " " + instructor.getLastName());
        }
        System.out.println("Learners:");
        for (Learner learner : this.learners) {
            System.out.println(" - " + learner.getFirstName() + " " + learner.getLastName());
        }
    }
}
