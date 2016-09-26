package ctr;

import ejb.AttendanceEjb;
import ejb.LectureEjb;
import ejb.RoleEjb;
import jpa.Attendance;
import jpa.Lecture;
import jpa.Person;

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
    private boolean present; //Couldn't make it work with Boolean, resorted to primitive
    private List<Person> students;
    private String type = "Student";
    private Long course_id;
    private List<Person> studentsByCourse;
    private List<Person> studentsByLecture;

    @Inject
    private AttendanceEjb attEjb;

    @Inject
    private RoleEjb roleEjb;

    @Inject
    private LectureEjb lecEjb;

    public String submit()
    {
        //Injecting lecEjb to be able to get course_id through lecture_id
        setCourse_id(lecEjb.getCourse_id(lecture_id));
        try
            {

            for(Person student: getStudentsByLecture()) {
                Attendance attendance = new Attendance(student, new Lecture(lecture_id), present);
                attEjb.addAttendance(attendance);
            }
        }
        catch (EJBException ejbe)
        {
            return "admin_panel?faces-redirect=true";

        }
        return "admin_panel?faces-redirect=true";
    }

    public String setAttendance()
    {
        students = attEjb.getStudentsByLecture(10L, course_id, lecture_id);
        try
        {
            for (Person student : students)
                attEjb.markAttendance(new Attendance(student, new Lecture(lecture_id), present));
        } catch (EJBException ejbe)
        {
            return "admin_panel?faces-redirect=true";
        }
        return "admin_panel?faces-redirect=true";
    }

//    public List<Person> getStudentsByLecture()
//    {
//        return studentsByLecture;
//    }

    public void setStudentsByLecture(List<Person> studentsByLecture)
    {
        this.studentsByLecture = studentsByLecture;
    }

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
        students = attEjb.getStudents(roleEjb.getRoleIdByType(roleEjb.getRoles(), type));

        return students;
    }

    public boolean isPresent()
    {
        return present;
    }

    public void setPresent(boolean present)
    {
        this.present = present;
    }

    public List<Person> getStudentsByCourse()
    {
            studentsByCourse = attEjb.getStudentsByCourse(course_id, lecture_id);
            return studentsByCourse;

    }

    public List<Person> getStudentsByLecture()
    {

        studentsByLecture = attEjb.getStudentsByLecture(10L, course_id, lecture_id);
        return studentsByLecture;
    }

    public String refresh()
    {
        return "attendance?faces-redirect=true";
    }

}
