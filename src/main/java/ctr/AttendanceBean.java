package ctr;

import ejb.AttendanceEjb;
import ejb.RoleEjb;
import jpa.Attendance;
import jpa.Course;
import jpa.Person;
import jpa.Registration;

import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-14
 */
@Named
@SessionScoped
public class AttendanceBean implements Serializable
{
    private Long person_id;
    private Long lecture_id;
    private Boolean present;
    private List<Person> students;
    private String type = "Student";
    private Long course_id;

    @Inject
    private AttendanceEjb att;

    @Inject
    private RoleEjb roleEjb;

//    public String submit()
//    {
//        try
//        {
//            att.addAttendance(new Attendance(new Person(new Registration(getCourse_id())), new Course(getCourse_id())));
//        }
//        catch (EJBException ejbe)
//        {
//
//        }
//    }

    public Long getCourse_id()
    {
        return course_id;
    }

    public void setCourse_id(Long course_id)
    {
        System.out.println("Set Course ID: " + course_id);
        this.course_id = course_id;
    }

    public Long getLecture_id()
    {
        return lecture_id;
    }

    public void setLecture_id(Long lecture_id)
    {
        this.lecture_id = lecture_id;
    }

    public List<Person> getStudents()
    {
        students = att.getStudents(roleEjb.getRoleIdByType(roleEjb.getRoles(), type));

        return students;
    }

    public List<Person> getStudentsByCourse()
    {
        System.out.println("StudentsBy Course ID: " + course_id);

        if (course_id != null) {


            students = att.getStudentsByCourse(roleEjb.getRoleIdByType(roleEjb.getRoles(), type), course_id);
            return students;
        }
        else
            return null;
    }

//    public List<Person> getStudentsByCourseAndLecture()
//    {
//        students = att.getStudentsByCourseAndLecture();
//        return students;
//    }

    public String refresh()
    {
        return "attendance?faces-redirect=true";
    }

}
