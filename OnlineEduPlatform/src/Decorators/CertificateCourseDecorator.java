package Decorators;
import Enums.CertificationStatus;
public class CertificateCourseDecorator extends CourseDecorator {
    private CertificationStatus certificationStatus = CertificationStatus.None;
    public CertificateCourseDecorator(Objects.Course course) {
        super(course);
        setCertificationStatus(certificationStatus.InProgress);
    }
    @Override
    public String getCourseStatus() {
        return super.getCourseStatus() + "\n" + " Certification Status: " + certificationStatus;
    }
    @Override
    public void deliverContent(int grade) {
        super.deliverContent(grade);
        if (super.getCompletitionStatus() == true) {
            if (certificationStatus != CertificationStatus.None) {
                certificationStatus = CertificationStatus.Certified;
            }
        }
    }
    public void setCertificationStatus(CertificationStatus status) {
        this.certificationStatus = status;
    }
}
