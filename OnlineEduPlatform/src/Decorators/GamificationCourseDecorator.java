package Decorators;
import java.util.Random;
public class GamificationCourseDecorator extends CourseDecorator{
    private int points = 0;
    private int placeInLeaderboard;
    private static final Random random = new Random();
    public GamificationCourseDecorator(Objects.Course course){
        super(course);
    }
    @Override
    public String getCourseStatus() {
        return super.getCourseStatus() + "\n" + " This course includes gamification elements." + "\n" + " Points: " + points + "\n" + " Place in leaderboard: " + placeInLeaderboard;
    }
    @Override 
    public void deliverContent(int grade) {
        super.deliverContent(grade);
        points += grade;
        if (points < 50) {
            placeInLeaderboard = random.nextInt(100 - 50) + 50;
        }
        else if (points >= 50 && points < 150) {
            placeInLeaderboard = random.nextInt(50 - 20) + 20;
        }
        else if (points >= 150 && points < 300) {
            placeInLeaderboard = random.nextInt(20 - 10) + 10;
        }
        else if (points >= 300) {
            placeInLeaderboard = random.nextInt(10) + 1;
        }
        else if (points == 400) {
            placeInLeaderboard = 1;
        }
    }
    


}
