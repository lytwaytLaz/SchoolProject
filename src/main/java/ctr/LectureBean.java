package ctr;

import ejb.LectureEjb;
import jpa.Course;
import jpa.Lecture;

import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
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
    private Date lectureDate;
    private Course lectureBeanCourse;
    private Course course;
    private Long course_id;
    private List<Lecture> lectures;

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
        setLectureDate(null);
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

    public List<Lecture> getLectures()
    {
        lectures = lecEjb.getLectures();
        return lectures;
    }
}
