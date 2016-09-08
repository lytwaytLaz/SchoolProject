package ctr;

import ejb.LectureEjb;
import jpa.Course;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
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

    @Inject
    private LectureEjb lecEjb;

    public String submit()
    {
        lecEjb.addLecture(new LectureCtr(getLectureBeanDate(), getLectureBeanCourse()));
        return "lecture?faces-redirect=true";
    }

    public Date getLectureBeanDate()
    {
        return lectureBeanDate;
    }

    public void setLectureBeanDate(Date lectureBeanDate)
    {
        this.lectureBeanDate = lectureBeanDate;
    }

    public Course getLectureBeanCourse()
    {
        return lectureBeanCourse;
    }

    public void setLectureBeanCourse(Course lectureBeanCourse)
    {
        this.lectureBeanCourse = lectureBeanCourse;
    }
}
