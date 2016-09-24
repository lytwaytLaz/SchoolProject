package ctr;

import ejb.LectureEjb;
import jpa.Course;
import jpa.Lecture;

import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-08
 */
@Named
@SessionScoped
public class LectureBean implements Serializable
{
    private Date lectureDate;
    private Course lectureBeanCourse;
    private Course course;
    private Long course_id;
    private Long lecture_id;
    private List<Lecture> lectures;
    private List<Lecture> lecturesByCourse;


    @Inject
    private LectureEjb lecEjb;

    public String submit()
    {
        try {
            lecEjb.addLecture(new Lecture(new Course(getCourse_id()), getLectureDate()));
        }
        catch (EJBException ejbe)
        {
            return "lecture?faces-redirect=true";

        }
//        setLectureDate(null);
        return "lecture?faces-redirect=true";
    }

    public Date getLectureDate()
    {
        return lectureDate;
    }

    public void setLectureDate(Date lectureDate)
    {
        this.lectureDate = lectureDate;
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

    public Long getLecture_id()
    {
        return lecture_id;
    }

    public void setLecture_id(Long lecture_id)
    {
        this.lecture_id = lecture_id;
    }

    public List<Lecture> getLectures()
    {
        lectures = lecEjb.getLectures();
        return lectures;
    }
    //TODO This methods is correctly called from the web page,
    //TODO and creates a list with the correct number of lectures.
    //TODO: The list gets passed on to the dropdown list Pick Lecture Date
    public List<Lecture> getLecturesByCourse()
    {
        lecturesByCourse = lecEjb.getLecturesByCourse(getCourse_id());
        return lecturesByCourse;
    }

}
