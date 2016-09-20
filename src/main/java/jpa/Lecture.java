package jpa;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-06
 */
@Entity
@Table(
        name="Lecture",
        uniqueConstraints = @UniqueConstraint(columnNames ={ "course_course_id", "date"})
)
@NamedQuery(
        name = "selectAllLectures",
        query = "SELECT le from Lecture le ORDER BY le.date")
public class Lecture
{
    @OneToMany(mappedBy = "lecture", orphanRemoval=true)
    private List<Attendance> attendance;

    @ManyToOne
    private Course course;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lecture_id;

    @Temporal(TemporalType.DATE)
    private Date date;

    public Long getLecture_id()
    {
        return lecture_id;
    }

    public void setLecture_id(Long id)
    {
        this.lecture_id = id;
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
