package Decorators;

public abstract class CourseDecorator implements Objects.Course {
    private Objects.Course decoratedCourse;
    public CourseDecorator(Objects.Course course){
        this.decoratedCourse = course;
    }
    @Override
    public String getCourseName() {
        return decoratedCourse.getCourseName();
    }
    @Override
    public boolean getCompletitionStatus() {
        return decoratedCourse.getCompletitionStatus();
    }
    @Override
    public void deliverContent(int grade) {
        decoratedCourse.deliverContent(grade);
    }
    @Override
    public String getCourseStatus() {
        return decoratedCourse.getCourseStatus();
    }
    @Override
    public void setCourseName(String courseName) {
        decoratedCourse.setCourseName(courseName);
    }
}
