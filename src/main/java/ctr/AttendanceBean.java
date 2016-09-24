package ctr;

import ejb.AttendanceEjb;
import ejb.RoleEjb;
import jpa.*;

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
    private Boolean present = false;
    private List<Person> students;
    private String type = "Student";
    private Long course_id;
    private List<Person> studentsByCourse;
    private List<Person> studentsByLecture;

    @Inject
    private AttendanceEjb attEjb;

    @Inject
    private RoleEjb roleEjb;

    public String submit()
    {
        try
            {
//                students = attEjb.getStudentsByLecture(course_id, lecture_id);

            for(Person student: getStudentsByLecture()) {
                Attendance attendance = new Attendance(student, getPresent());
                attEjb.addAttendance(attendance);
            }
        }
        catch (EJBException ejbe)
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

    //TODO This method gets called and the right lecture_id is set
    public void setLecture_id(Long lecture_id)
    {
        this.lecture_id = lecture_id;
    }

    public List<Person> getStudents()
    {
        students = attEjb.getStudents(roleEjb.getRoleIdByType(roleEjb.getRoles(), type));

        return students;
    }

    public Boolean getPresent()
    {
        return present;
    }

    public void setPresent(Boolean present)
    {
        this.present = present;
    }

    public List<Person> getStudentsByCourse()
    {
            studentsByCourse = attEjb.getStudentsByCourse(course_id, lecture_id);
            return studentsByCourse;

    }


    //TODO: When submit is called it runs but the course_id is null
    //TODO: Only lecture_id is set in AttendanceBean
    //TODO: Get course_id from Lecture instance
    //TODO: Sounds easy but I'm a bit stuck
    //TODO: Either send it directly to AttendanceBean from the web page,
    //TODO: or extract it from the Lecture instance in the submit function
    public List<Person> getStudentsByLecture()
    {
        studentsByLecture = attEjb.getStudentsByLecture(course_id, lecture_id);
        return studentsByLecture;
    }

    public String refresh()
    {
        return "attendance?faces-redirect=true";
    }

}
