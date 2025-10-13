package Objects.ConcreteClasses;

public class MathCourse implements Objects.Course {
    private int currentCourse = 1;
    private boolean isCompleted = false;
    private String courseName;

    @Override
    public void deliverContent() {
        if(currentCourse!=3){
            currentCourse += 1;
        }
        else{
            isCompleted = true;
        }
    }

}
