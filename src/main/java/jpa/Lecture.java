package jpa;

import javax.persistence.*;
import java.util.Date;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-06
 */
@Entity
public class Lecture
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    private Course course;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
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
