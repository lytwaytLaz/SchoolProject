package ctr;

import ejb.LectureEjb;
import jpa.Course;
import jpa.Lecture;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Date;
import java.util.List;


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
    private List<Lecture> lectures;

    @Inject
    private LectureEjb lecEjb;

    public String submit()
    {
        System.out.println("Submitted lecture date and Id");

        lecEjb.addLecture(new LectureCtr(getLectureBeanDate(), getCourse_id()));
        setLectureBeanDate(null);
        return "lecture?faces-redirect=true";
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

    public List<Lecture> getLectures()
    {
        lectures = lecEjb.getLectures();
        return lectures;
    }
}
