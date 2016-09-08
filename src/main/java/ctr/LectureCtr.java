package ctr;

import jpa.Course;

import java.util.Date;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-08
 */
public class LectureCtr

{
    private Long lectureCtrId;
    private Date lectureCtrDate;
    private Course course;

    public LectureCtr(Date lectureCtrDate, Course course)
    {
        this.lectureCtrDate = lectureCtrDate;
        this.course = course;
    }

    public LectureCtr(Long lectureCtrId, Date lectureCtrDate, Course course)
    {
        this.lectureCtrId = lectureCtrId;
        this.lectureCtrDate = lectureCtrDate;
        this.course = course;
    }

    public Long getLectureCtrId()
    {
        return lectureCtrId;
    }

    public void setLectureCtrId(Long lectureCtrId)
    {
        this.lectureCtrId = lectureCtrId;
    }

    public Date getLectureCtrDate()
    {
        return lectureCtrDate;
    }

    public void setLectureCtrDate(Date lectureCtrDate)
    {
        this.lectureCtrDate = lectureCtrDate;
    }

    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
    }
}
