package org.example.learner;

public abstract class Learner {

    private Long learnerId;

    private String firstName;

    private String lastName;

    public Learner(Long learnerId, String firstName, String lastName) {
        this.learnerId = learnerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getLearnerId() {
        return learnerId;
    }

    public void setLearnerId(Long learnerId) {
        this.learnerId = learnerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public abstract void displayLearnerDetails();

}
