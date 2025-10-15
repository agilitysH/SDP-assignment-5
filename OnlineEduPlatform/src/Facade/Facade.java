package Facade;
import Objects.Course;
import Objects.ConcreteClasses.MathCourse;
import Objects.ConcreteClasses.ProgrammingCourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Decorators.CertificateCourseDecorator;
import Decorators.GamificationCourseDecorator;
import Decorators.MentorSupportCourseDecorator;
public class Facade {
    private Random random = new Random();
    private List<Course> courses = new ArrayList<>();
    public List<Course> getCourses() {
        return courses;
    }
    private void enrollInCourse(Course course) {
        courses.add(course);
    }
    public Facade() {
    }
    public void learnCourse(Course course) {
        if (course.getCompletitionStatus() == false) {
            int grade = random.nextInt(101);
            course.deliverContent(grade);
            System.out.println("Completed " + course.getCourseName() + " with grade: " + grade);
            System.out.println(course.getCourseStatus());
        } else {
            System.out.println("No course started.");
        }
    }
    public void instantCourseFinish(Course course) {
        if (course.getCompletitionStatus() == false) {
            while (!course.getCompletitionStatus()) {
                int grade = random.nextInt(101);
                course.deliverContent(grade);
            }
            System.out.println("Instantly completed " + course.getCourseName());
            System.out.println(course.getCourseStatus());
        } else {
            System.out.println("No course started.");
        }
    }
    public void showCourses() {
        System.out.println("Available Courses:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getCourseName() + "\n");
        }
    }
    public Course createCourse(int enrollChoice) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Course newCourse;
        switch (enrollChoice) {
            case 1:
                newCourse = new MathCourse() {};
                decoratorChoices(newCourse, scanner);

                break;
            case 2:
                newCourse = new ProgrammingCourse() {};
                decoratorChoices(newCourse, scanner);
                break;
                
            default:
                System.out.println("Invalid choice. Please try again.");
                return null;
        }
        return newCourse;
    }
    public void decoratorChoices(Course newCourse, java.util.Scanner scanner) {
        System.out.println("Would you like to add gamification to this course? (yes/no)");
        String gamificationChoice = scanner.nextLine();
        if (gamificationChoice.equalsIgnoreCase("yes")) {
            newCourse = new GamificationCourseDecorator(newCourse);
        }
        System.out.println("Would you like to add certification to this course? (yes/no)");
        String certificationChoice = scanner.nextLine();
        if (certificationChoice.equalsIgnoreCase("yes")) {
            newCourse = new CertificateCourseDecorator(newCourse);
        }
        System.out.println("Would you like to add mentor help to this course? (yes/no)");
        String mentorChoice = scanner.nextLine();
        if (mentorChoice.equalsIgnoreCase("yes")) {
            newCourse = new MentorSupportCourseDecorator(newCourse);
        }
        enrollInCourse(newCourse);

    }
    void test(){
        int test = 1 + 1;
    }
}
