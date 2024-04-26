package modification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Student {
    private String firstname;
    private String lastname;
    private int age;
    private List<Float> grades;

    public Student(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.grades = new ArrayList<>();
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public List<Float> getGrades() {
        return grades;
    }

    public void addGrade(float grade){
        grades.add(grade);
    }

    public void addGrades(float[] grades){
        for (float grade : grades){
            this.grades.add(grade);
        }
    }

    @Override
    public String toString() {
        return "{ " + firstname + " " + lastname + ", Age: " + age + ", Grades: " + grades + " }";
    }
}
