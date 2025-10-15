package Facade;
import Objects.Course;
public class App {
    private Facade facade;
    public App(Facade facade) {
        this.facade = facade;
    }

    public void start() {
        menu();
    }



    private void menu(){
        System.out.println("1. Learn Course\n2. Instant Course Finish\n3. Check your courses\n4. Exit\n5. Enroll in a new course");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int choice = scanner.nextInt();
        int courseChoice;
        switch (choice) {
            case 1: 
                facade.showCourses();
                courseChoice = scanner.nextInt();
                if (courseChoice < 1 || courseChoice > facade.getCourses().size()) {
                    System.out.println("Invalid course choice. Please try again.");
                    menu();
                    return;
                }

                facade.learnCourse(facade.getCourses().get(courseChoice - 1));
                menu();
                break;
            case 2:
                facade.showCourses();
                courseChoice = scanner.nextInt();
                if (courseChoice < 1 || courseChoice > facade.getCourses().size()) {
                    System.out.println("Invalid course choice. Please try again.");
                    menu();
                    return;
                }
                facade.instantCourseFinish(facade.getCourses().get(courseChoice - 1));
                menu();
                break;
            case 3:
                System.out.println("Your courses: ");
                for (Course course : facade.getCourses()) {
                    System.out.println(course.getCourseName() + "\n" + course.getCourseStatus() + "\n");
                }
                menu();
                break;
            case 4:
                System.out.println("Exiting...");
                break;
            case 5:
                System.out.println("Which course would you like to enroll in?\n");
                System.out.println("1. Math course\n2. Programming course\n");
                int enrollChoice = scanner.nextInt();
                Course newCourse = facade.createCourse(enrollChoice);
                if (newCourse != null) {
                    System.out.println("Enrolled in " + newCourse.getCourseName());
                }
                menu();
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                menu();
                break;
        }
    }



}
