package App;
import Objects.Course;
import Objects.ConcreteClasses.*;
import Decorators.*;;
public class App {
    private Facade facade;
    public App(Facade facade) {
        this.facade = facade;
    }

    public void start() {
        menu();
    }

    public void showCourses() {
        System.out.println("Available Courses:");
        for (int i = 0; i < facade.getCourses().size(); i++) {
            System.out.println((i + 1) + ". " + facade.getCourses().get(i).getCourseName() + "\n");
        }
    } 

    public void menu(){
        System.out.println("1. Learn Course\n2. Instant Course Finish\n3. Check your courses\n4. Exit\n5. Enroll in a new course");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int choice = scanner.nextInt();
        int courseChoice;
        switch (choice) {
            case 1: 
                showCourses();
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
                showCourses();
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
                Course newCourse = createCourse(enrollChoice);
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

    private Course createCourse(int enrollChoice) {
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
    private void decoratorChoices(Course newCourse, java.util.Scanner scanner) {
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
        facade.enrollInCourse(newCourse);
        
    }

}
