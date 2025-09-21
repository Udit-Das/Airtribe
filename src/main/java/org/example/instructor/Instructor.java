package org.example.instructor;

public class Instructor {

    private String firstName;

    private String lastName;

    private Long instructorId;

    public Instructor(String firstName, String lastName, Long instructorId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.instructorId = instructorId;
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

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }
}
