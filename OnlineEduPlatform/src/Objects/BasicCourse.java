package Objects;
import java.util.List;
import java.util.ArrayList;

public abstract class BasicCourse implements Objects.Course {
    private boolean isCompleted = false;
    private String courseName;
    private List<Integer> grades = new ArrayList<Integer>();

    @Override
    public void deliverContent(int grade) {
        if (grade >= 0 && grade <= 100) {
            if(!isCompleted){
                grades.add(grade);            
                if(grades.size() == 4){
                    isCompleted = true;
                }
            }

        }
        else{
            System.out.println("Grade must be between 0 and 100.");
        }
    }
    @Override 
    public boolean getCompletitionStatus() {
        return isCompleted;
    }
    @Override
    public String getCourseStatus() {
        if(getCompletitionStatus() == true){
            return getCourseName() + " is completed.";
        }
        else{
            return getCourseName() + " is not completed yet";
        }
    }
    @Override
    public String getCourseName() {
        return courseName;
    }
    @Override
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}
