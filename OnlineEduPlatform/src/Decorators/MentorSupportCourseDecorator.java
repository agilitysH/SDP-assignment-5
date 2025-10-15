package Decorators;

public class MentorSupportCourseDecorator extends CourseDecorator{
    public MentorSupportCourseDecorator(Objects.Course course){
        super(course);
    }
    @Override
    public String getCourseStatus() {
        return super.getCourseStatus() + "\n" + " This course has mentor support.";
    }
}
