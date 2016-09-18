package ctr;

import jpa.Course;
import java.sql.Date;


/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-08
 */
public class LectureCtr

{
    private Long lecture_id;
    private Date lectureCtrDate;
    private Course course;
    private Long course_id;

    public LectureCtr(Date lectureCtrDate, Course course)
    {
        this.lectureCtrDate = lectureCtrDate;
        this.course = course;
    }

    public LectureCtr(Date lectureCtrDate, Long course_id)
    {
        this.lectureCtrDate = lectureCtrDate;
        this.course_id = course_id;
    }



    public LectureCtr(Long lecture_id, Date lectureCtrDate, Course course)
    {
        this.lecture_id = lecture_id;
        this.lectureCtrDate = lectureCtrDate;
        this.course = course;
    }

    public Long getLecture_id()
    {
        return lecture_id;
    }

    public void setLecture_id(Long lecture_id)
    {
        this.lecture_id = lecture_id;
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

    public Long getCourse_id()
    {
        return course_id;
    }

    public void setCourse_id(Long course_id)
    {
        this.course_id = course_id;
    }
}
