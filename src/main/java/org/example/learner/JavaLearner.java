package org.example.learner;

public class JavaLearner extends Learner{

    private boolean doesKnowMultiThreading;

    public JavaLearner(Long learnerId, String firstName, String lastName, boolean doesKnowMultiThreading) {
        super(learnerId, firstName, lastName);
        this.doesKnowMultiThreading = doesKnowMultiThreading;
    }

    public boolean isDoesKnowMultiThreading() {
        return doesKnowMultiThreading;
    }

    public void setDoesKnowMultiThreading(boolean doesKnowMultiThreading) {
        this.doesKnowMultiThreading = doesKnowMultiThreading;
    }

    @Override
    public void displayLearnerDetails() {
        System.out.println("Learner ID: " + getLearnerId());
        System.out.println("First Name: " + getFirstName());
        System.out.println("Last Name: " + getLastName());
        System.out.println("Knows Multi-threading: " + this.doesKnowMultiThreading);
    }
}
