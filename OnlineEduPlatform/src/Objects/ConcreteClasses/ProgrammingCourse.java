package Objects.ConcreteClasses;

public class ProgrammingCourse implements Objects.Course {
    private int currentCourse = 1;
    private boolean isCompleted = false;
    private String courseName;

    @Override
    public void deliverContent() {
        if(getCurrentCourse()!=4){
            currentCourse += 1;
        }
        else{
            isCompleted = true;
        }
    }
    @Override 
    public boolean getCompletitionStatus() {
        return isCompleted;
    }
    @Override
    public int getCurrentCourse() {
        return currentCourse;
    }
    
}
