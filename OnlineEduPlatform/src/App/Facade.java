package App;
import Objects.BasicCourse;
import Objects.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Facade {
    private Random random = new Random();
    private List<Course> courses = new ArrayList<>();
    public List<Course> getCourses() {
        return courses;
    }
    public void enrollInCourse(Course course) {
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
}
