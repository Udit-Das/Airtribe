package org.example.learner;

public class NodeLearner extends Learner {

    private Long numberOfYearOfNodeExperience;

    public NodeLearner(Long learnerId, String firstName, String lastName, Long numberOfYearOfNodeExperience) {
        super(learnerId, firstName, lastName);
        this.numberOfYearOfNodeExperience = numberOfYearOfNodeExperience;
    }


    @Override
    public void displayLearnerDetails() {
        System.out.println("Learner ID: " + getLearnerId());
        System.out.println("First Name: " + getFirstName());
        System.out.println("Last Name: " + getLastName());
        System.out.println("Years of Node.js Experience: " + this.numberOfYearOfNodeExperience);
    }
}
