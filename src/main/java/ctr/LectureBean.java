package ctr;

import ejb.LectureEjb;
import jpa.Course;
import org.primefaces.context.RequestContext;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-08
 */
@Named
@RequestScoped
public class LectureBean
{
    private Date lectureBeanDate;
    private Course lectureBeanCourse;
    private Course course;
    private Long course_id;

    @Inject
    private LectureEjb lecEjb;

    public String submit()
    {
        System.out.println("Submitted lecture date and Id");
        lecEjb.addLecture(new LectureCtr(getLectureBeanDate(), getCourse_id()));
//        setLectureBeanDate(null);
        return "login?faces-redirect=true";
    }

    public Date getLectureBeanDate()
    {
        return lectureBeanDate;
    }

    public void setLectureBeanDate(Date lectureDate)
    {
        this.lectureBeanDate = lectureDate;
    }


    public Course getLectureBeanCourse()
    {
        return lectureBeanCourse;
    }

    public void setLectureBeanCourse(Course lectureBeanCourse)
    {
        this.lectureBeanCourse = lectureBeanCourse;
    }

    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
    }

    public Long getCourse_id()
    {
        return course_id;
    }

    public void setCourse_id(Long course_id)
    {
        this.course_id = course_id;
    }
}
